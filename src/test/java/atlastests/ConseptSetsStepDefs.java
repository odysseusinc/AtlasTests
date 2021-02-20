package atlastests;

import atlastests.components.ModalControl;
import atlastests.components.TablesControl;
import atlastests.components.TabsControl;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;

import static atlastests.components.StaticElements.CONCEPT_SET_IN_TABLE;
import static atlastests.components.StaticElements.EMPTY_TABLE;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class ConseptSetsStepDefs implements TabsControl, TablesControl, ModalControl {

    private String generatedString;
    private String idValue;
    private String idValueCP;
    private String includedConceptsBefore;
    private String includedConceptsAfter;
    private String conceptIdIC;
    private String newGeneratedString;
    private File conceptSetsZip;


    @Then("^Concept Sets page opens$")
    public void conceptSetsPageOpens() {
        $(By.xpath("//*[@id='currentComponent']/heading-title/div/span")).waitUntil(visible, 5000).
                shouldHave(text("Concept Sets"));
    }

    @When("^click to New Concept Set$")
    public void clickToNewConceptSet() {
        $(By.xpath("//*[@class='btn btn-sm btn-primary new-concept-set']")).click();
    }

    @Then("^can see Concept Set creation form$")
    public void canSeeConceptSetCreationForm() {
        $(By.xpath("//*[@data-bind='text: title']")).shouldHave(text("New Concept Set"));
    }

    @When("^enter random name of Concept set and save it$")
    public void enterRandomNameOfConceptSetAndSaveIt() {
        generatedString = RandomStringUtils.randomAlphanumeric(10);
        $(By.xpath("//*[@id='txtConceptSetName']")).setValue("Test_" + generatedString);
        $(By.xpath("//*[@class='fa fa-save']")).click();
    }

    @Then("^show new buttons in Concept Set$")
    public void showNewButtonsInConceptSet() {
        $(withText("Optimize")).waitUntil(visible, 5000);
    }

    @Then("^new concept set shown in table$")
    public void newConceptSetShownInTable() {
        CONCEPT_SET_IN_TABLE.shouldHave(text(generatedString));
    }

    @When("^click to new concept set row$")
    public void clickToNewConceptSetRow() {
        CONCEPT_SET_IN_TABLE.click();
    }

    @When("^click to delete concept set$")
    public void clickToDeleteConceptSet() {
        $(By.xpath("//*[@class='fa fa-trash-o']")).click();
        switchTo().alert().accept();

    }

    @Then("^new concept set removed from table$")
    public void newConceptSetRemovedFromTable() {
        search(newGeneratedString);
        EMPTY_TABLE.shouldBe(visible);
    }

    @When("^select first concept$")
    public void selectFirstConcept() {
        $(".fa-check").waitUntil(visible,
                120000).click();
        idValue = $(By.xpath("//*[@class='conceptTable stripe compact hover dataTable no-footer']/tbody/tr[1]/td[2]")).
                getText();
    }

    @When("^return to concept set by the link at the head of table$")
    public void returnToConceptSetByTheLinkAtTheHeadOfTable() {
        $(".app__menu-item--.unsaved").click();
    }

    @When("^click to add to concept set button$")
    public void addToConceptSet() {
        $("[data-bind='tooltip: buttonTooltipText'] .btn-success").click();
    }

    @Then("^can see item in the concept set table$")
    public void canSeeItemInTheConceptSetTable() {
        $(By.xpath("//*[@class='conceptSetTable stripe compact hover dataTable no-footer']/./tbody/tr/td[2]")).waitUntil(visible, 4000);
        idValueCP = $(By.xpath("//*[@class='conceptSetTable stripe compact hover dataTable no-footer']/./tbody/tr/td[2]")).getText();
        Assert.assertEquals(idValue, idValueCP);
    }

    @When("^save value of Included Concepts$")
    public void saveValueOfIncludedConcepts() {
        includedConceptsBefore = $("[data-bind='text:inclusionCount()']").getText();
    }

    @When("^set checkbox in Descendants$")
    public void setCheckboxInDescendants() {
        $(By.xpath("//table/tbody/tr/td[8]/span")).click();
    }

    @Then("^can see other value of Included Concepts$")
    public void canSeeOtherValueOfIncludedConcepts() {
        includedConceptsAfter = $("[data-bind='text:inclusionCount()']").
                waitUntil(not(Condition.exactText("1")), 5000).getText();
        Assert.assertNotEquals(includedConceptsAfter, includedConceptsBefore);
    }

    @When("^click to Included Concepts tab$")
    public void clickToIncludedConceptsTab() {
        $$(".tabs__header span").get(1).shouldHave(text("Included Concepts")).click();
    }

    @Then("^can see table of Included Concepts$")
    public void canSeeTableOfIncludedConcepts() {
        $(By.xpath("//*[@class='conceptTable stripe compact hover dataTable no-footer']/tbody/tr/td[2]")).waitUntil(visible, 5000);

        conceptIdIC = $(By.xpath("//*[@class='conceptTable stripe compact hover dataTable no-footer']/./tbody/tr/td[2]")).getText();
        Assert.assertEquals(idValueCP, conceptIdIC);
    }

    @When("^click to Included Source Codes tab$")
    public void clickToIncludedSourceCodesTab() {
        $(By.xpath("//*[@class='tabs__header-title'][2]")).shouldHave(text("Included Source Codes")).click();
    }

    @Then("^can see table of Included Source codes$")
    public void canSeeTableOfIncludedSourceCodes() {
        $(By.xpath("//*[@class='conceptTable stripe compact hover dataTable no-footer']/tbody/tr/td[2]")).
                waitUntil(visible, 5000);
    }

    @When("^click to Explore Evidence$")
    public void clickToExploreEvidence() {
        $(By.xpath("//*[@class='tabs__header-title'][3]")).shouldHave(text("Explore Evidence")).click();
    }

    @Then("^can see explore evidence text$")
    public void canSeeExploreEvidenceText() {
        $(By.xpath("//*[@class='heading']/b")).shouldHave(text("Explore Evidence:"));
        $(By.xpath("//*[@class='heading']/strong")).shouldHave(text("Additional Information:"));
    }

    @When("^remove all concepts$")
    public void removeAllConcepts() {
        $$(".conceptset-expression__checkmark").first().click();//to select all
        $(withText("Remove selected concept")).waitUntil(enabled, 5000).click();
    }

    @Then("^can see message in Concept Set table \"([^\"]*)\"$")
    public void canSeeMessageInConceptSetTable(String arg0) {
        $(By.xpath("//*[@class='dataTables_empty']")).shouldHave(text(arg0));
    }

    @When("^click to Export tab in Concept set$")
    public void clickToExportTabInConceptSet() {
        $$(".tabs__header-title").find(matchesText("Export")).click();
    }

    @Then("^can see Concept Set JSON$")
    public void canSeeConceptSetJSON() {
        $(By.xpath("//*[@class='heading']")).waitUntil(visible, 3000).
                shouldHave(text("Concept Set Expression JSON"));
    }

    @When("^click to export button$")
    public void clickToExportButton() throws Exception {
        conceptSetsZip = $(withText("Export To CSV")).download();
    }

    @Then("^csv file is downloaded$")
    public void csvFileDownload() {
        Assert.assertEquals("Test_" + generatedString + ".zip", conceptSetsZip.getName());
    }

    @When("^press SAVE button$")
    public void pressSAVEButton() {
        SelenideElement saveButton = $(".input-group-btn .btn-success");
        saveButton.waitUntil(enabled, 5000).click();
        $(".fa-trash-o").waitUntil(enabled, 5000);
    }

    @When("^click to Compare tab in Concept Set$")
    public void clickToCompareTabInConceptSet() {
        chooseTab("Compare");
    }

    @Then("^can see text \"([^\"]*)\"$")
    public void canSeeText(String arg0) {
        $(By.xpath("//*[@class='heading']")).waitUntil(visible, 3000).shouldHave(text(arg0));
    }

    @When("^enter new name of Concept Set$")
    public void enterNewNameOfConceptSet() {
        newGeneratedString = RandomStringUtils.randomAlphanumeric(10);
        $(By.xpath("//*[@id='txtConceptSetName']")).setValue("Test_" + newGeneratedString);
    }

    @Then("^click to save button in Concept Set$")
    public void clickToSaveButtonInConceptSet() {
        $(".input-group-btn .btn-success").waitUntil(enabled, 5000).click();
        Selenide.sleep(2000);//only one way to wait frontend scenarios
    }

    @Then("^click to cancel button in Concept Set$")
    public void clickToCancelButtonInConceptSet() {
        $(By.xpath("//*[@class='fa fa-times']")).waitUntil(visible, 5000).click();
    }

    @When("^enter new concept set name in filter$")
    public void enterNewConceptSetNameInFilter() {
        search(newGeneratedString);
    }

    @Then("^can see row with new name of concept set$")
    public void canSeeRowWithNewNameOfConceptSet() {
        $(By.xpath("//table/tbody/tr/td[2]")).waitUntil(visible, 3000).shouldHave(text(newGeneratedString));
    }

    @When("^click to row with new name of concept set$")
    public void clickToRowWithNewNameOfConceptSet() {
        $(By.xpath("//table/tbody/tr/td[2]")).click();
    }

    @When("^enter name of concept set in filter$")
    public void enterNameOfConceptSetInFilter() {
        search(newGeneratedString);
    }

    @Then("^can see our Concept Set creation form$")
    public void canSeeOurConceptSetCreationForm() {
        $(By.xpath("//*[@data-bind='text: title']")).shouldHave(text("Concept Set #"));
    }

    @When("^enter \"([^\"]*)\" of concept set in filter$")
    public void enterOfConceptSetInFilter(String arg0) {
        search(arg0);
    }

    @When("^click concept set result$")
    public void clickConceptSetResult() {
        $$(By.xpath("//table/tbody/tr/td[2]")).get(0).click();
    }

    @Then("^can see our concept set page$")
    public void canSeeOurConceptSetPage() {
        $$(By.xpath("//table/tbody/tr/td[4]")).get(0).shouldHave(text("Hydrocarbons"));

    }

    @When("^click to select compare set(\\d+) button$")
    public void clickToSelectCompareSetButton(int arg0) {
        $$(By.xpath("//*[@class='fa fa-folder-open']")).get(1).click();

    }

    @When("^enter \"([^\"]*)\" of concept set window in filter$")
    public void enterOfConceptSetWindowInFilter(String arg0) {
        facetedTableSearch(arg0);
    }

    @Then("^click to first link in list in concept set window$")
    public void clickToFirstLinkInListInConceptSetWindow() {
        $("#csCompareConceptSets_wrapper .linkish").click();
    }

    @When("^click to Compare Concept Sets button$")
    public void clickToCompareConceptSetsButton() {
        $(By.xpath("//*[@class='btn btn-sm btn-primary']")).click();
    }

    @Then("^can see compare table$")
    public void canSeeCompareTable() {
        $(By.xpath("//*[@class='heading compare-results']/b")).shouldHave(text("Comparison Results"));
    }

    @Then("^can see results of comparison$")
    public void canSeeResultsOfComparison() {
        $$("td:nth-child(1)").filter(visible).filter(not(empty)).
                shouldHave(CollectionCondition.textsInAnyOrder("Both", "1 Only", "2 Only"));
    }

    @When("^click to Optimize button$")
    public void clickToOptimizeButton() {
        $$(By.xpath("//*[@class='btn btn-primary']")).get(2).click();
    }

    @Then("^can see Concept Set Optimization window$")
    public void canSeeConceptSetOptimizationWindow() {
        checkModalTitle("Concept Set Optimization");
    }

    @When("^click to Save Options button$")
    public void clickToSaveOptionsButton() {
        $(By.xpath("//*[@class='btn btn-sm btn-primary dropdown-toggle']")).click();
    }

    @When("^choose Overwrite Current Concept Set point$")
    public void chooseOverwriteCurrentConceptSetPoint() {
        $(By.xpath("//*[@class='dropdown-item']")).click();
    }

    @Then("^can see only one concept in table of concept sets$")
    public void canSeeOnlyOneConceptInTableOfConceptSets() {
        $(By.xpath("//table/tbody/tr[2]")).shouldNotBe(visible);
    }

    @When("^open Export tab$")
    public void openExportTab() {
        $(By.xpath("//*[@class='tabs__header']/span[2]")).click();
    }

    @When("^select (\\d+) first elements from list of concepts$")
    public void selectFirstElementsFromListOfConcepts(int arg0) {
        for (int i = 1; i <= arg0; i++) {
            $$(By.xpath("//table/tbody/tr[" + i + "]/td[2]")).get(1).click();
        }
    }

    @When("^click Export Concept set button$")
    public void clickExportConceptSetButton() throws FileNotFoundException {
        conceptSetsZip = $(".conceptsets-export .new-concept-set").download();
    }

    @Then("^file with archive downloaded$")
    public void fileWithArchiveDownloaded() {
        Assert.assertEquals("exportedConceptSets.zip", conceptSetsZip.getName());
    }

    @Then("^can see search result table after conceptSet$")
    public void canSeeSearchResultTableAfterConceptSet() {
        $(By.xpath("//table/tbody/tr/td[2]")).shouldBe(visible);
    }
}
