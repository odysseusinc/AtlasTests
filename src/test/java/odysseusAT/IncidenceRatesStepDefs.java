package odysseusAT;

import com.codeborne.selenide.Selectors;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class IncidenceRatesStepDefs {
    private String generatedString;
    private String newGeneratedString;
    @Then("^can see Incidence Rates page$")
    public void canSeeIncidenceRatesPage() {
        $(By.xpath("//*[@data-bind='text: title']")).waitUntil(visible, 4000);
        $(By.xpath("//*[@data-bind='text: title']")).shouldHave(text("Incidence Rate Analysis"));

    }

    @When("^click to New Analysis button in Incidence Rates$")
    public void clickToNewAnalysisButtonInIncidenceRates() {
        $(By.xpath("//*[@class='pull-right btn btn-sm btn-primary']")).click();
        
    }

    @Then("^can see Incidence Rates creation page$")
    public void canSeeIncidenceRatesCreationPage() {
        $(By.xpath("//*[@data-bind='text: title']")).shouldHave(text("New Incidence Rate Analysis"));
    }

    @When("^enter name on new Incidence Rates$")
    public void enterNameOnNewIncidenceRates() {
        generatedString = RandomStringUtils.randomAlphanumeric(10);
        generatedString = "Test_"+ generatedString;
        $(By.xpath("//*[@type='text']")).clear();
        $(By.xpath("//*[@type='text']")).setValue(generatedString);
    }

    @When("^click to save Incidence Rates Button$")
    public void clickToSaveIncidenceRatesButton() {
        $(By.xpath("//*[@class='fa fa-save']")).click();
    }

    @Then("^can see new buttons in incidence rates field$")
    public void canSeeNewButtonsInIncidenceRatesField() throws InterruptedException {
        Thread.sleep(1500);
        $(By.xpath("//*[@title='Close']")).shouldBe(visible);
        $(By.xpath("//*[@title='Create a copy']")).shouldBe(visible);
        $(By.xpath("//*[@title='Delete']")).shouldBe(visible);
    }

    @When("^click to cancel button in Incidence rates$")
    public void clickToCancelButtonInIncidenceRates() {
        $(By.xpath("//*[@title='Close']")).click();
    }

    @When("^enter name of our IR in filter$")
    public void enterNameOfOurIRInFilter() throws InterruptedException {
        Thread.sleep(1000);
        $(By.xpath("//*[@type='search']")).waitUntil(visible,3000);
        $(By.xpath("//*[@type='search']")).setValue(generatedString);
    }

    @Then("^can see our incidence rate in table$")
    public void canSeeOurIncidenceRateInTable() {
        $(By.xpath("//tbody/tr/td[2]")).shouldHave(text(generatedString));
    }

    @When("^click to our incidence rate$")
    public void clickToOurIncidenceRate() throws InterruptedException {
        $(By.xpath("//tbody/tr/td[2]/span")).waitUntil(visible,4000);
        $(By.xpath("//tbody/tr/td[2]/span")).click();
    }

    @Then("^can see our incidence rate$")
    public void canSeeOurIncidenceRate() throws InterruptedException {
        Thread.sleep(1500);
        $(By.xpath("//*[@data-bind='text: title']")).shouldHave(text("Incidence Rate Analysis #"));
    }

    @When("^enter new name of incidence rate$")
    public void enterNewNameOfIncidenceRate() {
        newGeneratedString = RandomStringUtils.randomAlphanumeric(10);
        newGeneratedString = "Test_"+ newGeneratedString;
        $(By.xpath("//*[@type='text']")).clear();
        $(By.xpath("//*[@type='text']")).setValue(newGeneratedString);

    }

    @When("^enter name of new IR in filter$")
    public void enterNameOfNewIRInFilter() {
        $(By.xpath("//*[@type='search']")).waitUntil(visible,3000);
        $(By.xpath("//*[@type='search']")).setValue(newGeneratedString);
    }

    @Then("^can see new incidence rate in table$")
    public void canSeeNewIncidenceRateInTable() {
        $(By.xpath("//tbody/tr/td[2]")).shouldHave(text(newGeneratedString));
    }

    @When("^click to new incidence rate$")
    public void clickToNewIncidenceRate() throws InterruptedException {
        Thread.sleep(2000);
        $(By.xpath("//tbody/tr/td[2]/span")).click();
    }

    @When("^click to delete IR button$")
    public void clickToDeleteIRButton() {
        $(By.xpath("//*[@title='Delete']")).waitUntil(visible,4000);
        $(By.xpath("//*[@title='Delete']")).click();
    }

    @When("^accept delete IR alert$")
    public void acceptDeleteIRAlert() {
        switchTo().alert().accept();
    }

    @Then("^cant find IR in table$")
    public void cantFindIRInTable() {
        $(By.xpath("//*[@type='search']")).waitUntil(visible,3000);
        $(By.xpath("//*[@type='search']")).setValue(newGeneratedString);
        $(By.xpath("//tbody/tr/td[2]")).shouldNotHave(text(newGeneratedString));
    }

    @Then("^can see concept set page in IR$")
    public void canSeeConceptSetPageInIR() {
        $(By.xpath("//*[@class='btn btn-primary btn-sm'][2]")).waitUntil(visible,3000);
        $(By.xpath("//*[@class='btn btn-primary btn-sm'][2]")).shouldHave(text("Load"));
        $(By.xpath("//*[@class='btn btn-primary btn-sm'][1]")).shouldHave(text("New Concept Set"));
    }

    @When("^click to Concept Sets tab in IR$")
    public void clickToConceptSetsTabInIR() {
        $(By.xpath("//*[@class='nav nav-tabs']/li[2]")).click();
    }

    @When("^click to Generation tab in IR$")
    public void clickToGenerationTabInIR() {
        $(By.xpath("//*[@class='nav nav-tabs']/li[3]")).click();
    }

    @Then("^can see Generation page in IR$")
    public void canSeeGenerationPageInIR() {
        $(By.xpath("//*[@class='select-sources-btn__label']")).waitUntil(visible,3000);
        $(By.xpath("//*[@class='ir-analysis-results__tbl-th ir-analysis-results__tbl-th--source']")).shouldHave(text("Source Name"));
    }


    @When("^click to Utilities page in IR$")
    public void clickToUtilitiesPageInIR() {
        $(By.xpath("//*[@class='nav nav-tabs']/li[4]")).click();

    }

    @Then("^can see Utilities page in IR$")
    public void canSeeUtilitiesPageInIR() {
        $(By.xpath("//*[@class='nav nav-pills']/li[1]/a")).shouldHave(text("Import"));
        $(By.xpath("//*[@class='nav nav-pills']/li[2]/a")).shouldHave(text("Export"));
    }

    @When("^click to add Target Cohort$")
    public void clickToAddTargetCohort() {
//        $("Add Target Cohort").click();
        $(byText("Add Target Cohort")).click();
    }

    @When("^enter \"([^\"]*)\" in filter of cohort$")
    public void enterInFilterOfCohort(String arg0) throws Throwable {
        Thread.sleep(500);
        $(By.xpath("//*[@class='dataTables_filter']/label/input")).setValue(arg0);
        Thread.sleep(500);
    }

    @When("^click to result in IR$")
    public void clickToResultInIR() {
        $(By.xpath("//*[@class='linkish']")).click();
    }

    @When("^close Cohort window in IR$")
    public void closeCohortWindowInIR() {
        $(By.xpath("//*[@class = 'modal-dialog']/div/div/button")).click();
    }


    @Then("^can see new rows under Target Cohorts$")
    public void canSeeNewRowsUnderTargetCohorts() {
        $(By.xpath("//table/tbody/tr[2]/td/table/tbody/tr/td[3]/span")).shouldHave(text("New users of phenytoin"));
        $(By.xpath("//table/tbody/tr[2]/td/table/tbody[2]/tr/td[3]/span")).shouldHave(text("New users of levetiracetam "));

    }

    @When("^click to Add Outcome Cohort$")
    public void clickToAddOutcomeCohort() {
        $(byText("Add Outcome Cohort")).click();
    }

    @Then("^can see new rows under Outcome Cohort$")
    public void canSeeNewRowsUnderOutcomeCohort() {
        $(By.xpath("//table[1]/tbody/tr[2]/td[2]/table/tbody/tr/td[3]/span")).shouldHave(text("Levetriacetam vs phenytoin outcome cohort"));
    }

    @When("^choose Time at risk starts with value (\\d+)$")
    public void chooseTimeAtRiskStartsWithValue(int arg0) {
        $$(By.xpath("//*[@class='numericInputField dropdown ui-autocomplete-input']")).get(0).setValue("14");
    }

    @When("^choose Time at risk ends with value (\\d+)$")
    public void chooseTimeAtRiskEndsWithValue(int arg0) {
        $$(By.xpath("//*[@class='numericInputField dropdown ui-autocomplete-input']")).get(1).setValue("14");
    }

    @When("^press Load Concept Set in IR$")
    public void pressLoadConceptSetInIR() {
        $(By.xpath("//*[@role='tabpanel']/concept-set-builder/button[2]")).waitUntil(visible,2000);
        $(By.xpath("//*[@role='tabpanel']/concept-set-builder/button[2]")).click();
    }

    @When("^enter \"([^\"]*)\" in filter Concept Set in IR$")
    public void enterInFilterConceptSetInIR(String arg0) throws Throwable {
        $(By.xpath("//*[@id='repositoryConceptSetTable_filter']/label/input")).setValue(arg0);
    }

    @When("^click to result in CS in IR$")
    public void clickToResultInCSInIR() {
        $(By.xpath("//*[@class='repositoryConceptSetItem']/td[2]")).shouldHave(text("Angioedema or Depression"));
        $(By.xpath("//*[@class='repositoryConceptSetItem']/td[2]")).click();
    }

    @Then("^can see chosen concept set in table$")
    public void canSeeChosenConceptSetInTable() {
        $(By.xpath("//*[@class=' select']/following-sibling::td[3]")).shouldHave(text("angioedema"));
    }
}
