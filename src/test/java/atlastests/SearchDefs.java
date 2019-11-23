package atlastests;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.File;
import java.util.Objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SearchDefs {
    @When("^enter in search panel \"([^\"]*)\"$")
    public void enterInSearchPanel(String arg0) {
        $(By.xpath("//*[@placeholder='Type your search here']")).waitUntil(visible, 10000).setValue(arg0);
    }

    @When("^search activated$")
    public void searchActivated() {
        $(By.xpath("//*[@class='pull-right btn btn-primary']")).click();

    }

    @Then("^can see search result table$")
    public void canSeeSearchResultTable() {
        $(By.xpath("//*[@class='conceptTable stripe compact hover dataTable no-footer']")).waitUntil(visible, 120000);
        $(By.xpath("//*[@class='fa fa-shopping-cart']")).shouldBe(visible);
        $(By.xpath("//*[@data-bind='template: { name: $component.headersTemplateId }']/tr/th[2]")).shouldHave(text("Id"));
        $(By.xpath("//*[@data-bind='template: { name: $component.headersTemplateId }']/tr/th[3]")).shouldHave(text("Code"));
        $(By.xpath("//*[@data-bind='template: { name: $component.headersTemplateId }']/tr/th[4]")).shouldHave(text("Name"));
        $(By.xpath("//*[@data-bind='template: { name: $component.headersTemplateId }']/tr/th[5]")).shouldHave(text("Class"));
//        $(By.xpath("//*[@id='DataTables_Table_2']/thead/tr/th[6]")).shouldHave(text("Standard Concept Caption"));
        $(By.xpath("//*[@data-bind='template: { name: $component.headersTemplateId }']/tr/th[6]")).shouldHave(text("RC"));
        $(By.xpath("//*[@data-bind='template: { name: $component.headersTemplateId }']/tr/th[7]")).shouldHave(text("DRC"));
        $(By.xpath("//*[@data-bind='template: { name: $component.headersTemplateId }']/tr/th[8]")).shouldHave(text("Domain"));
        $(By.xpath("//*[@data-bind='template: { name: $component.headersTemplateId }']/tr/th[9]")).shouldHave(text("Vocabulary"));
        //check paganation
        $(By.xpath("//*[@data-dt-idx='2']")).shouldBe(text("2"));


    }//*[@id="DataTables_Table_8_wrapper"]/div/div[1]/div[1]/div[1]/div/div[2]/button[6]

    @When("^click to Column visibility$")
    public void clickToColumnVisibility() {
        $(By.xpath("//*[@class='dt-button buttons-collection buttons-colvis']")).click();
        $(By.xpath("//*[@class='dt-button-collection']")).waitUntil(visible, 3000);


    }

    @When("^click to button Standard Concept Caption$")
    public void clickToButtonStandardConceptCation() {
        $(By.xpath("//*[@data-cv-idx='5']")).waitUntil(visible, 3000).click();
        $(By.xpath("//*[@class='dt-button-background']")).click();


    }

    @Then("^Standard Concept Caption should be shown$")
    public void standardConceptCationShouldBeShown() {
        $(By.xpath("//*[@id='DataTables_Table_2']/thead/tr/th[6]")).waitUntil(visible, 4000).
                shouldHave(text("Standard Concept Caption"));
    }

    @When("^click to Id header$")
    public void clickToIdHeader() {
        $(By.xpath("//*[@id='DataTables_Table_2']/thead/tr/th[2]")).click();
    }

    @Then("^first value more then second$")
    public void firstValueMoreThenSecond() {

        String value1 = $(By.xpath("//*[@id='DataTables_Table_2']/tbody/tr[1]/td[2]")).getText();
        String value2 = $(By.xpath("//*[@id='DataTables_Table_2']/tbody/tr[2]/td[2]")).getText();

        Assert.assertTrue(Integer.parseInt(value1) <= Integer.parseInt(value2));

    }

    @Then("^second value more then first$")
    public void secondValueMoreThenFirst() {
        String value1 = $(By.xpath("//*[@id='DataTables_Table_2']/tbody/tr[1]/td[2]")).getText();
        String value2 = $(By.xpath("//*[@id='DataTables_Table_2']/tbody/tr[2]/td[2]")).getText();

        Assert.assertTrue(Integer.parseInt(value1) >= Integer.parseInt(value2));
    }

    @When("^enter in filtering search area \"([^\"]*)\"$")
    public void enterInFilteringSearchArea(String arg0) {
        $(By.xpath("//*[@type='search']")).setValue(arg0);

    }

    @Then("^can see search result only with \"([^\"]*)\"$")
    public void canSeeSearchResultOnlyWith(String arg0) {
        $(By.xpath("//*[@class='invalid non-standard']")).waitUntil(visible, 5000).shouldHave(text(arg0));

    }

    @When("^click to CSV button$")
    public void clickToCSVButton() {
        $(By.xpath("//*[@class='dt-button buttons-csv buttons-html5']")).click();
    }


    public static boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (File dir_content : Objects.requireNonNull(dir_contents)) {
            if (dir_content.getName().equals(fileName))
                return true;
        }
        return false;
    }

    @Then("^file download$")
    public void fileDownload() throws Exception {
	Thread.sleep(5000); // wait for file to download
        Assert.assertTrue(isFileDownloaded(LoginStepsDefs.getDataProperties("downloadpath"), "ATLAS Search.csv"));
    }

    @When("^click to first link in list$")
    public void clickToFirstLinkInList() {
        $(By.xpath("//*[@class='odd']/td[4]/a")).click();

    }

    @Then("^open page with first of four tabs for \"([^\"]*)\"$")
    public void openPageWithFourTabsFor(String arg0) {
        $(By.xpath("//*[@id='currentComponent']/div[1]/span[2]")).waitUntil(visible, 5000).shouldHave(text(arg0));
        $(By.xpath("//*[@class='nav nav-tabs']/li/a")).shouldHave(text("Details"));
        $(By.xpath("//*[@data-bind='with: $root.currentConcept']/tbody/tr[1]/td[1]")).shouldHave(text("Concept Name"));
        $(By.xpath("//*[@data-bind='with: $root.currentConcept']/tbody/tr[2]/td[1]")).shouldHave(text("Domain Id"));
        $(By.xpath("//*[@data-bind='with: $root.currentConcept']/tbody/tr[3]/td[1]")).shouldHave(text("Concept Class Id"));
        $(By.xpath("//*[@data-bind='with: $root.currentConcept']/tbody/tr[4]/td[1]")).shouldHave(text("Vocabulary Id"));
        $(By.xpath("//*[@data-bind='with: $root.currentConcept']/tbody/tr[5]/td[1]")).shouldHave(text("Concept Id"));
        $(By.xpath("//*[@data-bind='with: $root.currentConcept']/tbody/tr[6]/td[1]")).shouldHave(text("Concept Code"));
        $(By.xpath("//*[@data-bind='with: $root.currentConcept']/tbody/tr[7]/td[1]")).shouldHave(text("Invalid Reason"));
        $(By.xpath("//*[@data-bind='with: $root.currentConcept']/tbody/tr[8]/td[1]")).shouldHave(text("Standard Concept"));

    }

    @Then("^check second of four tabs$")
    public void checkSecondOfFourTabs() {
        $(By.xpath("//*[@class='nav nav-tabs']/li[2]/a")).shouldHave(text("Related Concepts")).click();
        $(By.xpath("//*[@id='DataTables_Table_4']/tbody/tr[1]/td[4]/a")).waitUntil(visible, 35000);
    }

    @Then("^check third of four tabs$")
    public void checkThirdOfFourTabs() {
        $(By.xpath("//*[@class='nav nav-tabs']/li[3]/a")).shouldHave(text("Hierarchy")).click();
        $(By.xpath("//*[@id='wrapperParents']/div[1]")).waitUntil(visible, 14000).shouldHave(text("Parents"));
    }

    @Then("^check fourth of four tabs$")
    public void checkFourthOfFourTabs() {
        $(By.xpath("//*[@class='nav nav-tabs']/li[4]/a")).waitUntil(visible, 5000).
                shouldHave(text("Record Counts")).click();
        $(By.xpath("//*[@class='panel-heading']")).waitUntil(visible, 180000).
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
        $(By.xpath("//*[@class='numeric sorting']")).waitUntil(Condition.enabled, 5000).click();
        $(By.xpath("//*[@class='numeric sorting_asc']")).waitUntil(Condition.enabled, 5000).click();
    }
}
