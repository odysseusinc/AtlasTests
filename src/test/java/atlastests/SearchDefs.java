package atlastests;

import atlastests.components.TablesControl;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;

import static atlastests.components.StaticElements.NAV_PILLS;
import static atlastests.components.StaticElements.TABS_HEADERS;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchDefs implements TablesControl {
    private static final ElementsCollection TABLE_HEADERS = $$("th");
    private static final ElementsCollection CONCEPT_IDS = $$("tbody td:nth-child(2)");
    private File search;

    @When("^enter in search panel \"([^\"]*)\"$")
    public void enterInSearchPanel(String arg0) {
        $("[placeholder='Type your search here']").waitUntil(visible, 10000).setValue(arg0);
    }

    @When("^search activated$")
    public void searchActivated() {
        $("[title='Search'] .fa-search").click();

    }

    @Then("^can see search result table$")
    public void canSeeSearchResultTable() {
        $(By.xpath("//*[@class='conceptTable stripe compact hover dataTable no-footer']")).waitUntil(visible, 120000);
        $(".fa-check").shouldBe(visible);
        $("[aria-label='Id: activate to sort column ascending']").shouldHave(text("Id"));
        $("[aria-label='Code: activate to sort column ascending']").shouldHave(text("Code"));
        $("[aria-label='Name: activate to sort column ascending']").shouldHave(text("Name"));
        $("[aria-label='Class: activate to sort column ascending']").shouldHave(text("Class"));
        $("[aria-label=' RC: activate to sort column ascending']").shouldHave(text(" RC"));
        $("[aria-label=' DRC: activate to sort column ascending']").shouldHave(text(" DRC"));
        $("[aria-label='Domain: activate to sort column ascending']").shouldHave(text("Domain"));
        $("[aria-label='Vocabulary: activate to sort column ascending']").shouldHave(text("Vocabulary"));
        //check paganation
        $(By.xpath("//*[@data-dt-idx='2']")).shouldBe(text("2"));
    }

    @When("^click to Column visibility$")
    public void clickToColumnVisibility() {
        $(".buttons-colvis").click();
    }

    @When("^click to button Standard Concept Caption$")
    public void clickToButtonStandardConceptCation() {
        $(withText("Standard Concept Caption")).waitUntil(visible, 3000).click();
    }

    @Then("^Standard Concept Caption should be shown$")
    public void standardConceptCationShouldBeShown() {
        TABLE_HEADERS.shouldHave(CollectionCondition.itemWithText("Standard Concept Caption"));
    }

    @When("^click to Id header$")
    public void clickToIdHeader() {
        TABLE_HEADERS.find(text("Id")).click();
    }

    @Then("^first value more then second$")
    public void firstValueMoreThenSecond() {
        Assert.assertTrue(Integer.parseInt(CONCEPT_IDS.get(0).getText()) <
                Integer.parseInt(CONCEPT_IDS.get(1).getText()));
    }

    @Then("^second value more then first$")
    public void secondValueMoreThenFirst() {
        Assert.assertTrue(Integer.parseInt(CONCEPT_IDS.get(0).getText()) >
                Integer.parseInt(CONCEPT_IDS.get(1).getText()));
    }

    @When("^enter in filtering search area \"([^\"]*)\"$")
    public void enterInFilteringSearchArea(String arg0) {
        search(arg0);
    }

    @Then("^can see search result only with \"([^\"]*)\"$")
    public void canSeeSearchResultOnlyWith(String arg0) {
        $(By.xpath("//*[@class='invalid non-standard']")).waitUntil(visible, 5000).shouldHave(text(arg0));
    }

    @When("^click to CSV button$")
    public void clickToCSVButton() throws FileNotFoundException {
        search = $(By.xpath("//*[@class='dt-button buttons-csv buttons-html5']")).download();
    }

    @Then("^file download$")
    public void fileDownload() {
        Assert.assertEquals("ATLAS Search.csv", search.getName());
    }

    @When("^click to first link in list$")
    public void clickToFirstLinkInList() {
        $$("a.classification").first().click();
    }

    @When("^click to the name of standard concept$")
    public void clickToStandardConcept() {
        $$("a.standard").first().click();
    }

    @Then("^page with concept fields is opened$")
    public void checkConceptPage() {
        $(".tabs__header-title--selected").waitUntil(visible, 5000).shouldHave(text("Details"));
        $$("#wrapperConceptDetails table td:nth-child(1)").
                shouldHave(CollectionCondition.texts("Concept Name", "Domain Id", "Concept Class Id",
                        "Vocabulary Id", "Concept Id", "Concept Code", "Invalid Reason", "Standard Concept"));
    }

    @Then("^check Related Concepts tab$")
    public void checkSecondOfFourTabs() {
        TABS_HEADERS.find(matchesText("Related Concepts")).click();
        $(".facetName").waitUntil(visible, 55000);
    }

    @Then("^check Hierarchy tab$")
    public void checkThirdOfFourTabs() {
        TABS_HEADERS.find(matchesText("Hierarchy")).click();
        NAV_PILLS.shouldHave(CollectionCondition.texts("Full Hierarchy", "Parents", "Current", "Children"),
                30000);
    }

    @Then("^check Record Counts tab$")
    public void checkFourthOfFourTabs() {
        TABS_HEADERS.find(matchesText("Record Counts")).click();
        $(".panel-primary .panel-heading").waitUntil(visible, 180000).
                shouldHave(text("Record Counts across Sources"));
    }

    @Then("^can see not null values at first row in DC or RDC$")
    public void canSeeNotNullValuesAtFirstRowInDCOrRDC() {
        String tempRC = $(By.xpath("//table/tbody/tr/td[6]")).getText().replaceAll(",", "");
        String tempDRC = $(By.xpath("//table/tbody/tr/td[7]")).getText().replaceAll(",", "");

        Assert.assertTrue(Integer.parseInt(tempRC) > 0);
        Assert.assertTrue(Integer.parseInt(tempDRC) > 0);
    }

    @When("^double click RC column$")
    public void doubleClickRCColumn() {
        $(".numeric.sorting").waitUntil(Condition.enabled, 5000).click();
        $(".numeric.sorting_asc").waitUntil(Condition.enabled, 5000).click();
    }
}
