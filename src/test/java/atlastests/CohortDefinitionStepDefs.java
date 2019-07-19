package atlastests;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CohortDefinitionStepDefs {

    String nameCohort;
    private String newGeneratedString;

    @Then("^can see Cohort Definition page$")
    public void canSeeCohortDefinitionPage() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).waitUntil(visible, 4000);
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).shouldHave(text("Cohort definitions"));
    }

    @When("^click New Cohort button$")
    public void clickNewCohortButton() {
        $(By.xpath("//*[@class='btn btn-sm btn-primary']")).click();


    }

    @Then("^can see new cohort page creation$")
    public void canSeeNewCohortPageCreation() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']")).waitUntil(visible, 3000);
        $(By.xpath("//*[@class='heading-title heading-title--dark']")).shouldHave(text("New Cohort Definition"));

    }

    @When("^enter name of New Cohort Definition and save it$")
    public void enterNameOfNewCohortDefinitionAndSaveIt() throws InterruptedException {
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        nameCohort = "Test_" + generatedString;
        $(By.xpath("//*[@class='form-control']")).clear();
        $(By.xpath("//*[@class='input-group']/input")).setValue(nameCohort);
        Thread.sleep(300);
        $(By.xpath("//*[@class='fa fa-save']")).click();

    }

    @Then("^filtered Cohort Definition$")
    public void filteredCohortDefinition() throws InterruptedException {
        $(By.xpath("//*[@type='search']")).waitUntil(visible, 4000);
        $(By.xpath("//*[@type='search']")).setValue(nameCohort);
        Thread.sleep(1500);

    }

    @Then("^Cohort Definition should be found$")
    public void cohortDefinitionShouldBeFound() {
        $(By.xpath("//table/tbody/tr/td[2]/span")).shouldHave(text(nameCohort));

    }

    @When("^click to our Cohort Definition$")
    public void clickToOurCohortDefinition() {
        $(By.xpath("//table/tbody/tr/td[2]/span")).click();
    }

    @Then("^can see our Cohort Definition$")
    public void canSeeOurCohortDefinition() {
//        $(By.xpath("//*[@id='cohortTextView']/div")).shouldHave(value(nameCohort));
        $(By.xpath("//*[@class='panel panel-primary cohort-definition-panel']")).waitUntil(visible, 2000);

    }

    @When("^click to delete our Cohort Definition$")
    public void clickToDeleteOurCohortDefinition() {
        $(By.xpath("//*[@class='fa fa-trash-o']")).click();

    }

    @When("^accept delete Cohort Definition alert$")
    public void acceptDeleteCohortDefinitionAlert() {
        switchTo().alert().accept();

    }

    @Then("^Cohort Definition should be not found$")
    public void cohortDefinitionShouldBeNotFound() {
        $(By.xpath("//table/tbody/tr/td")).shouldHave(text("No matching records found"));

    }

    @When("^press Add Initial Event$")
    public void pressAddInitialEvent() throws InterruptedException {
        Thread.sleep(1000);
        $$(By.xpath("//*[@class='btn btn-primary btn-sm dropdown-toggle']")).get(0).click();
    }

    @When("^press Add Condition Occurrence$")
    public void pressAddConditionOcurrence() throws InterruptedException {
        Thread.sleep(1000);
        $$(By.xpath("//*[@class='dropdown-menu']/li/a")).get(1).click();
    }

    @Then("^a condition era block shown$")
    public void aConditionEraBlockShown() throws InterruptedException {
        Thread.sleep(1000);
        $(By.xpath("//*[@class='criteriaTable'][1]/tbody/tr/td")).shouldHave(text("a condition occurrence of"));
    }

    @When("^click to Any Condition menu$")
    public void clickToAnyConditionMenu() {
        $(By.xpath("//*[@class='btn btn-primary dropdown-toggle']")).click();
    }

    @When("^choose Import Concept Set$")
    public void chooseImportConceptSet() {
        $(By.xpath("//*[@class='dropdown-menu dropdown-menu-right']/li[2]")).click();
    }

    @Then("^Import Concept Set window shown$")
    public void importConceptSetWindowShown() {
        $(By.xpath("//*[@class='modal fade in']/div/div/div")).shouldHave(text("Import Concept Set From Repository..."));
    }


    @When("^enter \"([^\"]*)\" to Filter of Concept Set from Repository$")
    public void enterToFilterOfConceptSetFromRepository(String arg0) throws Throwable {
        Thread.sleep(500);
        $(By.xpath("//*[@type='search']")).setValue(arg0);
    }


    @When("^click to chosen concept set from repository$")
    public void clickToChosenConceptSetFromRepository() throws InterruptedException {
        Thread.sleep(3500);
        $(By.xpath("//*[@class='stripe compact hover dataTable no-footer']/tbody/tr/td[2]")).click();
    }

    @Then("^can see name of concept set at the button$")
    public void canSeeNameOfConceptSetAtTheButton() throws InterruptedException {
        Thread.sleep(3500);
        $(By.xpath("//*[@class='btn btn-primary conceptset_edit']")).shouldHave(text("Angioedema"));
    }

    @When("^click to Concept Sets tab$")
    public void clickToConceptSetsTab() {
        $(By.xpath("//*[@class='nav nav-tabs']/li[2]")).click();
    }

    @Then("^can see row with name of Concept Set in the table$")
    public void canSeeRowWithNameOfConceptSetInTheTable() {
        $(By.xpath("//*[@class='conceptSetTable stripe compact hover dataTable no-footer']/tbody/tr/td")).shouldHave(text("0"));
        $(By.xpath("//*[@class='conceptSetTable stripe compact hover dataTable no-footer']/tbody/tr/td[2]")).shouldHave(text("Angioedema"));

    }

    @When("^click on the row in table concept set in cohort definitions$")
    public void clickOnTheRowInTableConceptSetInCohortDefinitions() {
        $$(By.xpath("//*[@class='conceptSetTable stripe compact hover dataTable no-footer']/tbody/tr/td[2]")).get(0).click();
    }

    @Then("^can see table of concept set with concepts$")
    public void canSeeTableOfConceptSetWithConcepts() {
//        $(By.xpath("//*[@class='standard']")).shouldHave(text("Aspirin"));
        $$(By.xpath("//table/tbody/tr/td[2]")).get(6).shouldHave(text("Angioedema"));
    }

    @When("^click to Close concept set$")
    public void clickToCloseConceptSet() {
        $(By.xpath("//*[@class='btn btn-sm btn-primary']")).click();
    }

    @Then("^table of concept sets close$")
    public void tableOfConceptSetsClose() {
        $(By.xpath("//*[@class='standard']")).shouldNotBe(visible);
    }

    @When("^click to Generation tab$")
    public void clickToGenerationTab() {
        $(By.xpath("//*[@class='nav nav-tabs']/li[3]")).click();
    }

    @Then("^can see Generation page$")
    public void canSeeGenerationSourcesPage() {
        $(By.xpath("//*[@class='cohort-generate-sources']/../div")).shouldHave(text("Available CDM Sources"));
    }

    @When("^click to Reporting tab$")
    public void clickToReportingTab() {
        $(By.xpath("//*[@class='nav nav-tabs']/li[4]")).click();
    }

    @Then("^can see reporting page$")
    public void canSeeReportingPage() {
        $(By.xpath("//*[@class='form-control invalid']")).shouldBe(visible);
    }

    @When("^click to Export tab in Cohort Definitions$")
    public void clickToExportTabInCohortDefinitions() {
        $(By.xpath("//*[@class='nav nav-tabs']/li[5]")).click();
    }

    @Then("^can see Export page$")
    public void canSeeExportPage() {
        $(By.xpath("//cohort-expression-viewer/div")).shouldHave(text("Initial Event Cohort"));
    }

    @When("^click to Messages Tab$")
    public void clickToMessagesTab() {
        $(By.xpath("//*[@class='nav nav-tabs']/li[6]")).click();
    }

    @Then("^can see Messages page$")
    public void canSeeMessagesPage() throws InterruptedException {
        Thread.sleep(500);
        $(By.xpath("//*[@aria-label='Severity: activate to sort column ascending']")).waitUntil(visible, 4000);
        $(By.xpath("//*[@aria-label='Severity: activate to sort column ascending']")).shouldHave(text("Severity"));

    }

    @When("^click to Run diagnostic Button$")
    public void clickToRunDiagnosticButton() {
        $(By.xpath("//*[@class='warnings-button-pane pull-right']/button")).click();
    }

    @When("^add Inclusion criteria$")
    public void addInclusionCriteria() throws InterruptedException {
        Thread.sleep(3000);
        $$(By.xpath("//*[@class='btn btn-sm btn-success']")).get(1).click();
        $(By.xpath("//*[@class='inclusion-rule-header']/div/input")).setValue("TEST INCLUSION");
        $(By.xpath("//*[@class='divtext']")).setValue("TEST INCLUSION DESCRIPTION");
    }

    @Then("^can see block with inclusion criterias$")
    public void canSeeBlockWithInclusionCriterias() {
        $(By.xpath("//*[@class='inclusionRules']/tbody/tr/td[2]/div[1]")).shouldHave(text("TEST INCLUSION"));
        $(By.xpath("//*[@class='inclusionRules']/tbody/tr/td[2]/div[2]")).shouldHave(text("TEST INCLUSION DESCRIPTION"));

    }

    @Then("^can see window with cohort definition$")
    public void canSeeWindowWithCohortDefinition() {
        $(byText("Choose a Cohort definition")).shouldBe(visible);
    }

    @When("^click to Id to sort$")
    public void clickToIdToSort() {
        $(By.xpath("//*[@aria-label='Id: activate to sort column ascending']")).click();
    }

    @When("^enter new name of cohort definition$")
    public void enterNewNameOfCohortDefinition() throws InterruptedException {
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        newGeneratedString = "Test_" + generatedString;
        $(By.xpath("//*[@class='form-control']")).clear();
        $(By.xpath("//*[@class='input-group']/input")).setValue(newGeneratedString);
        Thread.sleep(300);


    }

    @When("^save new name of cohort definition$")
    public void saveNewNameOfCohortDefinition() {
        $(By.xpath("//*[@class='fa fa-save']")).click();
    }

    @Then("^filtered new Cohort Definition$")
    public void filteredNewCohortDefinition() throws InterruptedException {
        $(By.xpath("//*[@type='search']")).waitUntil(visible, 4000);
        $(By.xpath("//*[@type='search']")).setValue(newGeneratedString);
        Thread.sleep(1500);
    }

    @Then("^new Cohort Definition should be found$")
    public void newCohortDefinitionShouldBeFound() {
        $(By.xpath("//table/tbody/tr/td[2]/span")).shouldHave(text(newGeneratedString));
    }

    @When("^enter the same name of New Cohort Definition and save it$")
    public void enterTheSameNameOfNewCohortDefinitionAndSaveIt() throws InterruptedException {
        Thread.sleep(1500);
        $(By.xpath("//*[@class='form-control']")).clear();
        $(By.xpath("//*[@class='input-group']/input")).setValue(nameCohort);
        Thread.sleep(300);
        $(By.xpath("//*[@class='fa fa-save']")).click();
    }

    @Then("^condition occurrence block shown$")
    public void conditionOccurrenceBlockShown() {
        $(By.xpath("//*[@class = 'criteriaTable']/tbody/tr/td")).shouldHave(text("a condition occurrence of"));
    }

    @When("^click to save button in Cohort Definition$")
    public void clickToSaveButtonInCohortDefinition() {
        $(By.xpath("//*[@class='fa fa-save']")).click();
    }

    @When("^click to Id column$")
    public void clickToIdColumn() {
        $(By.xpath("//*[@class='id-column sorting']")).waitUntil(visible, 3000);
        $(By.xpath("//*[@class='id-column sorting']")).click();
    }

    @Then("^can see that first value less then second$")
    public void canSeeThatFirstValueLessThenSecond() {
        String a, b;
        a = $(By.xpath("//table/tbody/tr/td[1]")).getText();
        b = $(By.xpath("//table/tbody/tr[2]/td[1]")).getText();
        Assert.assertTrue(Integer.parseInt(a) < Integer.parseInt(b));
    }

    @Then("^can see paging$")
    public void canSeePaging() {
        $(By.xpath("//*[@class= 'paginate_button ']")).shouldBe(visible);
    }

    @When("^enter \"([^\"]*)\" in filter in cohort definition$")
    public void enterInFilterInCohortDefinition(String arg0) throws Throwable {
        $(By.xpath("//*[@type='search']")).setValue(arg0);
    }

    @Then("^click to founded result$")
    public void clickToFoundedResult() {
        $(By.xpath("//table/tbody/tr/td[2]")).click();
    }

    @When("^click to JSON tab in Cohort Definitions$")
    public void clickToJSONTabInCohortDefinitions() {
        $(By.xpath("//*[@class='nav nav-pills']/li[3]")).click();
    }

    @When("^click to Copy to clipboard button$")
    public void clickToCopyToClipboardButton() {
        $(By.xpath("//*[@id='btnCopyExpressionJSONClipboard']")).click();
    }

    @When("^clear json input$")
    public void clearJsonInput() {
        $(By.xpath("//*[@id='cohortExpressionJSON']")).clear();
    }

    @When("^past json from clipboard$")
    public void pastJsonFromClipboard() throws InterruptedException {
        $(By.xpath("//*[@id='cohortExpressionJSON']")).sendKeys(Keys.CONTROL, "v");
        Thread.sleep(1000);
    }

    @When("^click to Reload button$")
    public void clickToReloadButton() {
        $(By.xpath("//*[@class='col-md-6'][2]/button")).click();
    }

    @When("^click to Definition tab$")
    public void clickToDefinitionTab() {
        $(By.xpath("//*[@class='nav nav-tabs']/li")).click();
    }

    @Then("^can see name \"([^\"]*)\" of concept set at the button$")
    public void canSeeNameOfConceptSetAtTheButton(String arg0) throws Throwable {
        $(By.xpath("//*[@class='btn btn-primary conceptset_edit']")).shouldHave(text(arg0));
    }

    @When("^click to Generate Impala button$")
    public void clickToGenerateImpalaButton() {
        $(By.xpath("//*[@class='cohort-generate-sources']/tbody/tr/td/span/span/button")).click();
    }

    @Then("^can see Complete in IMPALA status in (\\d+) seconds$")
    public void canSeeCompleteStatusInSeconds(int arg0) {
        $(By.xpath("//*[@class='cohort-generate-sources']/tbody/tr/td[3]")).waitUntil(text("COMPLETE"), arg0 * 1000);
    }

    @When("^click to Reporting tab tab$")
    public void clickToReportingTabTab() {
        $(By.xpath("//*[@class='nav nav-tabs']/li[4]")).click();
    }


    @When("^select \"([^\"]*)\" source$")
    public void selectSource(String arg0) throws Throwable {
        $(By.xpath("//*[@class='form-control invalid']")).click();
        $(By.xpath("//*[@class='form-control invalid']")).selectOptionByValue(arg0);
    }

    @When("^click to quick analysis button$")
    public void clickToQuickAnalysisButton() {
        $(By.xpath("//*[@class='btn btn-success btn-sm']")).click();
    }

    @When("^accept an alert about time$")
    public void acceptAnAlertAboutTime() throws InterruptedException {
        Thread.sleep(3000);
        switchTo().alert().accept();
    }

    @Then("^can see a row with status Started$")
    public void canSeeARowWithStatusStarted() {
        $(By.xpath("//*[@class='panel panel-info']/div/table/tbody/tr/td[3]")).waitUntil(text("STARTED"), 10000);
    }

    @Then("^can see only one field with text \"([^\"]*)\"$")
    public void canSeeOnlyOneFieldWithText(String arg0) throws Throwable {
        $(By.xpath("//*[@class='stripe compact hover dataTable no-footer']/tbody/tr/td[2]")).shouldHave(text(arg0));
    }

    @When("^click to Generate SynPUF (\\d+)K Cost&Util button$")
    public void clickToGenerateSynPUFKCostUtilButton(int arg0) {
        $(By.xpath("//*[@class='cohort-generate-sources']/tbody/tr[4]/td/span/span/button")).click();
    }

    @Then("^can see Complete in SynPUF (\\d+)K Cost&Util status in (\\d+) seconds$")
    public void canSeeCompleteInSynPUFKCostUtilStatusInSeconds(int arg0, int arg1) throws InterruptedException {
        Thread.sleep(500);
        $(By.xpath("//*[@class='cohort-generate-sources']/tbody/tr[4]/td[3]")).waitUntil(text("COMPLETE"), arg0 * 1000);

    }

    @When("^click to utilisation button$")
    public void clickToUtilisationButton() throws InterruptedException {
        Thread.sleep(500);
        $(By.xpath("//*[@class='btn btn-info btn-sm']")).click();

    }

    @Then("^configure of reports to run window opens$")
    public void configureOfReportsToRunWindowOpens() {
        $(By.xpath("//*[@class='modal-pick-options__header']")).waitUntil(text("Reports"), 3000);
    }

    @When("^choose reports and press Run$")
    public void chooseReportsAndPressRun() {
        $(By.xpath("//*[@value='rollupUtilizationVisit']")).click();
        $(By.xpath("//*[@value='rollupUtilizationDrug']")).click();
        $$(By.xpath("//*[@class='btn btn-info btn-sm']")).get(1).click();
    }



    @When("^click to Generate SynPUF (\\d+)k CDM(\\d+)$")
    public void clickToGenerateSynPUFKCDM(int arg0, int arg1) {
        $(By.xpath("//*[@class='cohort-generate-sources']/tbody/tr[6]/td/span/span/button")).click();
    }

    @Then("^can see Complete in SynPUF (\\d+)k CDM(\\d+) status in (\\d+) seconds$")
    public void canSeeCompleteInSynPUFKCDMStatusInSeconds(int arg0, int arg1, int arg2) {
        $(By.xpath("//*[@class='cohort-generate-sources']/tbody/tr[6]/td[3]")).waitUntil(text("COMPLETE"), arg0 * 1000);

    }

    @When("^click to Full analysis button$")
    public void clickToFullAnalysisButton() {
        $(By.xpath("//*[@class='btn btn-primary btn-sm']")).click();
    }

    @Then("^can see \"([^\"]*)\" in Initial Event Cohort$")
    public void canSeeInInitialEventCohort(String arg0){
        $(By.xpath("//*[@id='cohortTextView']/cohort-expression-viewer/ul/li/div/conceptset-reference/span")).shouldHave(text(arg0));
    }

    @When("^click to Graphical View$")
    public void clickToGraphicalView() {
        $(By.xpath("//*[@class='nav nav-pills']/li[2]")).click();

    }

    @Then("^can see \"([^\"]*)\" in Primary Criteria$")
    public void canSeeInPrimaryCriteria(String arg0) throws Throwable {
        $(By.xpath("//*[@class='name col-xs-2']")).shouldHave(text(arg0));
    }

    @When("^click to SQL tab$")
    public void clickToSQLTab() {
        $(By.xpath("//*[@class='nav nav-pills']/li[4]")).click();
    }

    @Then("^can see sql query$")
    public void canSeeSqlQuery() {
        $(By.xpath("//*[@id='cohortSQL']/div/pre")).shouldHave(text("CREATE TABLE"));
    }
}
