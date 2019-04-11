package odysseusAT;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.commands.PressEnter;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Se;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

import java.nio.charset.Charset;
import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ConseptSetsStepDefs {

    private String generatedString;
    private String idValue;
    private String idValueCP;
    private String includedConceptsBefore;
    private String conceptIdCS;
    private String includedConceptsAfter;
    private String conceptIdIC;

    @Then("^Concept Sets page opens$")
    public void conceptSetsPageOpens() {
        $(By.xpath("//*[@id='currentComponent']/heading-title/div/span")).waitUntil(visible, 5000);
        $(By.xpath("//*[@id='currentComponent']/heading-title/div/span")).shouldHave(text("Concept Sets"));


    }

    @When("^click to New Concept Set$")
    public void clickToNewConceptSet() throws InterruptedException {
        $(By.xpath("//*[@class='btn btn-sm btn-primary new-concept-set']")).click();
    }

    @Then("^can see Concept Set creation form$")
    public void canSeeConceptSetCreationForm() {
        $(By.xpath("//*[@data-bind='text: title']")).shouldHave(text("New Concept Set"));
    }

    @When("^enter random name of Concept set and save it$")
    public void enterRandomNameOfConceptSetAndSaveIt() throws InterruptedException {
        generatedString = RandomStringUtils.randomAlphanumeric(10);
        $(By.xpath("//*[@id='txtConceptSetName']")).clear();
        $(By.xpath("//*[@id='txtConceptSetName']")).setValue("Test_" + generatedString);
        $(By.xpath("//*[@class='fa fa-save']")).click();
        Thread.sleep(10000);
    }

    @Then("^show new buttons in Concept Set$")
    public void showNewButtonsInConceptSet() {
        $(By.xpath("//*[@data-bind='click: optimize, css: { disabled: !canOptimize() || isProcessing() }']")).waitUntil(visible, 2000);
        $(By.xpath("//*[@data-bind='click: optimize, css: { disabled: !canOptimize() || isProcessing() }']")).shouldHave(text("Optimize"));
    }

    @Then("^new concept set shown in table$")
    public void newConceptSetShownInTable() {
        $(By.xpath("//*[@class='stripe compact hover dataTable no-footer']/tbody/tr[1]/td[2]")).shouldHave(text(generatedString));
    }

    @When("^click to new concept set row$")
    public void clickToNewConceptSetRow() {
        $(By.xpath("//*[@class='stripe compact hover dataTable no-footer']/tbody/tr[1]/td[2]")).click();

    }

    @When("^click to delete concept set$")
    public void clickToDeleteConceptSet() {
        $(By.xpath("//*[@class='fa fa-trash-o']")).click();
        switchTo().alert().accept();

    }

    @Then("^new concept set removed from table$")
    public void newConceptSetRemovedFromTable() {
        $(By.xpath("//*[@class='stripe compact hover dataTable no-footer']/tbody/tr[1]/td[2]")).shouldNotHave(text(generatedString));
    }

    @When("^click to shop cart items first$")
    public void clickToShopCartItemsFirst() {
        $(By.xpath("//*[@class='conceptTable stripe compact hover dataTable no-footer']/tbody/tr[1]/td[1]/i")).waitUntil(visible, 10000);
        $(By.xpath("//*[@class='conceptTable stripe compact hover dataTable no-footer']/tbody/tr[1]/td[1]/i")).click();
        $(By.xpath("//*[@class='fa fa-shopping-cart selected']")).waitUntil(visible, 1000);
//        $(By.xpath("//*[@id='DataTables_Table_4']/tbody/tr[2]/td[1]/i")).click();
        idValue = $(By.xpath("//*[@class='conceptTable stripe compact hover dataTable no-footer']/tbody/tr[1]/td[2]")).getText();

    }

    @When("^return to concept set by the link at the head of table$")
    public void returnToConceptSetByTheLinkAtTheHeadOfTable() {
        $(By.xpath("//*[@class='breadcrumb-container']/a")).click();
    }

    @Then("^can see item in the concept set table$")
    public void canSeeItemInTheConceptSetTable() {
        $(By.xpath("//*[@class='conceptSetTable stripe compact hover dataTable no-footer']/./tbody/tr/td[2]")).waitUntil(visible,4000);
        idValueCP = $(By.xpath("//*[@class='conceptSetTable stripe compact hover dataTable no-footer']/./tbody/tr/td[2]")).getText();
        Assert.assertEquals(idValue, idValueCP);
    }

    @When("^save value of Included Concepts$")
    public void saveValueOfIncludedConcepts() {
        includedConceptsBefore = $(By.xpath("//*[@data-bind='text:inclusionCount()']")).getText();
    }

    @When("^set checkbox in Descendants$")
    public void setCheckboxInDescendants() throws InterruptedException {
        $(By.xpath("//table/tbody/tr/td[8]/span")).click();
        Thread.sleep(4000);
    }

    @Then("^can see other value of Included Concepts$")
    public void canSeeOtherValueOfIncludedConcepts() {
        includedConceptsAfter = $(By.xpath("//*[@data-bind='text:inclusionCount()']")).getText();
        Assert.assertNotEquals(includedConceptsAfter, includedConceptsBefore);
    }

    @When("^click to Included Concepts tab$")
    public void clickToIncludedConceptsTab() {
        $$(".tabs__header span").get(1).shouldHave(text("Included Concepts"));
        $$(".tabs__header span").get(1).click();
    }

    @Then("^can see table of Included Concepts$")
    public void canSeeTableOfIncludedConcepts() {
        $(By.xpath("//*[@class='conceptTable stripe compact hover dataTable no-footer']/tbody/tr/td[2]")).waitUntil(visible, 5000);

        conceptIdIC = $(By.xpath("//*[@class='conceptTable stripe compact hover dataTable no-footer']/./tbody/tr/td[2]")).getText();
        Assert.assertEquals(idValueCP, conceptIdIC);
    }

    @When("^click to Included Source Codes tab$")
    public void clickToIncludedSourceCodesTab() {
        $(By.xpath("//*[@class='tabs__header-title'][2]")).shouldHave(text("Included Source Codes"));
        $(By.xpath("//*[@class='tabs__header-title'][2]")).click();
    }

    @Then("^can see table of Included Source codes$")
    public void canSeeTableOfIncludedSourceCodes() {
        $(By.xpath("//*[@class='conceptTable stripe compact hover dataTable no-footer']/tbody/tr/td[2]")).waitUntil(visible, 5000);
    }

    @When("^click to Explore Evidence$")
    public void clickToExploreEvidence() {
        $(By.xpath("//*[@class='tabs__header-title'][3]")).shouldHave(text("Explore Evidence"));
        $(By.xpath("//*[@class='tabs__header-title'][3]")).click();
    }

    @Then("^can see explore evidence text$")
    public void canSeeExploreEvidenceText() {
        $(By.xpath("//*[@class='heading']/b")).shouldHave(text("Explore Evidence:"));
        $(By.xpath("//*[@class='heading']/strong")).shouldHave(text("Additional Information:"));
    }

    @When("^click to shop cart items in concept set table$")
    public void clickToShopCartItemsInConceptSetTable() {
        $(By.xpath("//*[@class='fa fa-shopping-cart selected']")).click();
    }

    @Then("^can see message in Concept Set table \"([^\"]*)\"$")
    public void canSeeMessageInConceptSetTable(String arg0) throws Throwable {
        $(By.xpath("//*[@class='dataTables_empty']")).shouldHave(text(arg0));
    }

    @When("^click to Export tab in Concept set$")
    public void clickToExportTabInConceptSet() throws InterruptedException {
       $(By.xpath("//*[@class='tabs__header']/span[5]")).shouldHave(text("Export"));
       Thread.sleep(1000);
        $(By.xpath("//*[@class='tabs__header']/span[5]")).click();
    }

    @Then("^can see Concept Set JSON$")
    public void canSeeConceptSetJSON() {
        $(By.xpath("//*[@class='heading']")).waitUntil(visible, 3000);
        $(By.xpath("//*[@class='heading']")).shouldHave(text("Concept Set Expression JSON"));
    }

    @When("^click to export button$")
    public void clickToExportButton() throws Exception {
        $(By.xpath("//*[@class='btn btn-success']")).waitUntil(visible, 4000);
        $(By.xpath("//*[@class='btn btn-success']")).click();
        Thread.sleep(2000);
        String str = $(By.xpath("//*[@data-bind='text: title']")).getText();
        String d = str.substring(str.indexOf("#")+1);
        String filename = "conceptset-" + d + ".zip";
        Assert.assertTrue(SearchDefs.isFileDownloaded(LoginStepsDefs.getDataProperties("downloadpath"), filename));

    }

    @Then("^csv file download$")
    public void csvFileDownload() throws Exception {
        String str = $(By.xpath("//*[@data-bind='text: title']")).getText();
        String d = str.substring(str.indexOf("#")+1);
        String filename = "conceptset-" + d + ".zip";
        Assert.assertTrue(SearchDefs.isFileDownloaded(LoginStepsDefs.getDataProperties("downloadpath"), filename));

    }

    @When("^press SAVE button$")
    public void pressSAVEButton() {
        $(By.xpath("//*[@class='btn btn-success']")).click();

    }

    @When("^click to Compare tab in Concept Set$")
    public void clickToCompareTabInConceptSet() {
        $(By.xpath("//*[@class='tabs__header']/span[6]")).shouldHave(text("Compare"));
        $(By.xpath("//*[@class='tabs__header']/span[6]")).click();
    }

    @Then("^can see text \"([^\"]*)\"$")
    public void canSeeText(String arg0) throws Throwable {
        $(By.xpath("//*[@class='heading']")).waitUntil(visible,3000);
        $(By.xpath("//*[@class='heading']")).shouldHave(text(arg0));
    }
}
