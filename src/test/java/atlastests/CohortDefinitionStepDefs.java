package atlastests;

import atlastests.components.FilterControl;
import atlastests.components.FormControl;
import atlastests.components.PageControl;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CohortDefinitionStepDefs implements PageControl, FormControl, FilterControl {

    private String nameCohort;
    private String newGeneratedString;
    private SelenideElement cohortLinkInTable = $("tbody .linkish");
    private ElementsCollection conceptSetsInTableForChoosing = $$("#repositoryConceptSetTable_wrapper .repositoryConceptSetItem");
    private ElementsCollection conceptSetsInDataTable = $$(".conceptSetTable span");
    private SelenideElement closeConceptSetButton = $(withText("Close Concept Set"));

    @Then("^can see Cohort Definition page$")
    public void canSeeCohortDefinitionPage() {
        checkPageHeader("Cohort definitions");
    }

    @When("^click New Cohort button$")
    public void clickNewCohortButton() {
        $(".btn-primary").waitUntil(enabled, 5000).click();
    }

    @Then("^can see new cohort page creation$")
    public void canSeeNewCohortPageCreation() {
        checkPageHeader("New Cohort Definition");
    }

    @When("^enter name of New Cohort Definition and save it$")
    public void enterNameOfNewCohortDefinitionAndSaveIt() {
        nameCohort = "Test_" + RandomStringUtils.randomAlphanumeric(10);
        setTitle(nameCohort);
        saveAction();
        $(".fa-trash-o").waitUntil(enabled, 5000); //cz need to wait saving of cohort
    }

    @Then("^filtered Cohort Definition$")
    public void filteredCohortDefinition() {
        search(nameCohort);
    }

    @Then("^Cohort Definition should be found$")
    public void cohortDefinitionShouldBeFound() {
        cohortLinkInTable.shouldHave(text(nameCohort));
    }

    @When("^click to our Cohort Definition$")
    public void clickToOurCohortDefinition() {
        cohortLinkInTable.click();
    }

    @Then("^can see our Cohort Definition$")
    public void canSeeOurCohortDefinition() {
        $$(".cohort-definition-panel").forEach(e -> e.shouldBe(visible));
    }

    @When("^click to delete our Cohort Definition$")
    public void clickToDeleteOurCohortDefinition() {
        deleteAction();
    }

    @When("^accept delete Cohort Definition alert$")
    public void acceptDeleteCohortDefinitionAlert() {
        Selenide.confirm();
    }

    @Then("^Cohort Definition should be not found$")
    public void cohortDefinitionShouldBeNotFound() {
        $(".dataTables_empty").shouldHave(text("No matching records found"));

    }

    @When("^press Add Initial Event$")
    public void pressAddInitialEvent() {
        $(withText("Add Initial Event")).waitUntil(visible, 5000).click();
        $$("[data-bind='foreach:$component.primaryCriteriaOptions'] .optionText").
                forEach(e -> e.hover().shouldHave(visible));
    }

    @When("^press Add Condition Occurrence$")
    public void pressAddConditionOcurrence() {
        $(withText("Add Condition Occurrence")).waitUntil(visible, 5000).click();
    }

    @When("^click to Any Condition menu$")
    public void clickToAnyConditionMenu() {
        $("[data-bind='with: Criteria'] conceptset-selector [type='button'][data-toggle='dropdown']").click();
    }

    @When("^choose Import Concept Set$")
    public void chooseImportConceptSet() {
        $(withText("Import Concept Set")).click();
    }

    @Then("^Import Concept Set window shown$")
    public void importConceptSetWindowShown() {
        $(".modal.fade.in .modal-header").shouldHave(text("Import Concept Set From Repository..."));
    }


    @When("^enter \"([^\"]*)\" to Filter of Concept Set from Repository$")
    public void enterToFilterOfConceptSetFromRepository(String arg0) {
        search(arg0);
    }


    @When("^click to chosen concept set from repository$")
    public void clickToChosenConceptSetFromRepository() {
        conceptSetsInTableForChoosing.first().click();
        $("#repositoryConceptSetTable .circle").waitUntil(hidden, 10000);
    }

    @Then("^can see name of concept set at the button ")
    public void canSeeNameOfConceptSetAtTheButton() {
        $(By.xpath("//*[@class='btn btn-primary conceptset_edit']")).waitUntil(visible, 5000).
                shouldHave(text("Angioedema"));
    }

    @When("^click to Concept Sets tab$")
    public void clickToConceptSetsTab() {
        $$(".nav-tabs a").find(matchesText("Concept Sets")).click();
    }

    @Then("^can see row with name of Concept Set in the table$")
    public void canSeeRowWithNameOfConceptSetInTheTable() {
        conceptSetsInDataTable.first().shouldHave(matchesText("Angioedema"));
    }

    @When("^click on the row in table concept set in cohort definitions$")
    public void clickOnTheRowInTableConceptSetInCohortDefinitions() {
        conceptSetsInDataTable.first().hover().click();
    }

    @Then("^can see table of concept set with concepts$")
    public void canSeeTableOfConceptSetWithConcepts() {
        $(".active.tab-pane .divtext").shouldHave(text("Angioedema"));
    }

    @When("^click to Close concept set$")
    public void clickToCloseConceptSet() {
        closeConceptSetButton.click();
    }

    @Then("^table of concept sets close$")
    public void tableOfConceptSetsClose() {
        closeConceptSetButton.shouldNotBe(visible);
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
    public void canSeeMessagesPage() {
        $(By.xpath("//*[@aria-label='Severity: activate to sort column ascending']")).waitUntil(visible, 4000).
                shouldHave(text("Severity"));
    }

    @When("^click to Run diagnostic Button$")
    public void clickToRunDiagnosticButton() {
        $(By.xpath("//*[@class='warnings-button-pane pull-right']/button")).click();
    }

    @When("^add Inclusion criteria$")
    public void addInclusionCriteria() {
        $(".inclusion-criteria__block .btn[data-bind='click: addInclusionRule']").
                waitUntil(visible, 5000).click();
        $(".inclusion-rule-header input").setValue("TEST INCLUSION");
        $("inclusion-rule-editor [placeholder='enter an inclusion rule description']").
                setValue("TEST INCLUSION DESCRIPTION");
    }

    @Then("^can see block with inclusion criterias$")
    public void canSeeBlockWithInclusionCriterias() {
        $$(".inclusionRuleItem div").shouldHave(CollectionCondition.texts("TEST INCLUSION",
                "TEST INCLUSION DESCRIPTION"));
    }

    @Then("^can see window with cohort definition$")
    public void canSeeWindowWithCohortDefinition() {
        $(byText("Choose a Cohort definition")).shouldBe(visible);
    }

    @When("^click to Id to sort$")
    public void clickToIdToSort() {
        $("[aria-label='Id: activate to sort column ascending']").click();
    }

    @When("^enter new name of cohort definition$")
    public void enterNewNameOfCohortDefinition() {
        newGeneratedString = "Test_" + RandomStringUtils.randomAlphanumeric(10);
        setTitle(newGeneratedString);
    }

    @When("^save new name of cohort definition$")
    public void saveNewNameOfCohortDefinition() {
        saveAction();
    }

    @Then("^filtered new Cohort Definition$")
    public void filteredNewCohortDefinition() {
        search(newGeneratedString);
    }

    @Then("^new Cohort Definition should be found$")
    public void newCohortDefinitionShouldBeFound() {
        cohortLinkInTable.shouldHave(text(newGeneratedString));
    }

    @When("^enter the same name of New Cohort Definition and save it$")
    public void enterTheSameNameOfNewCohortDefinitionAndSaveIt() {
        setTitle(nameCohort);
        saveAction();
    }

    @Then("^condition occurrence block shown$")
    public void conditionOccurrenceBlockShown() {
        $$(".criteria-content .criteriaTable").find(matchesText("a condition occurrence of")).
                shouldBe(visible);
    }

    @When("^click to save button in Cohort Definition$")
    public void clickToSaveButtonInCohortDefinition() {
        saveAction();
    }

    @When("^click to Id column$")
    public void clickToIdColumn() {
        $(By.xpath("//*[@class='id-column sorting']")).waitUntil(visible, 3000).click();
    }

    @Then("^can see that first value less then second$")
    public void canSeeThatFirstValueLessThenSecond() {
        String a = $(By.xpath("//table/tbody/tr/td[1]")).getText();
        String b = $(By.xpath("//table/tbody/tr[2]/td[1]")).getText();
        Assert.assertTrue(Integer.parseInt(a) < Integer.parseInt(b));
    }

    @Then("^can see paging$")
    public void canSeePaging() {
        $(By.xpath("//*[@class= 'paginate_button next']")).shouldBe(visible);
    }

    @When("^enter \"([^\"]*)\" in filter in cohort definition$")
    public void enterInFilterInCohortDefinition(String arg0) {
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
    public void pastJsonFromClipboard() {
        $(By.xpath("//*[@id='cohortExpressionJSON']")).sendKeys(Keys.CONTROL, "v");
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
    public void canSeeNameOfConceptSetAtTheButton(String arg0) {
        $(".btn-group-sm .btn-primary").shouldHave(text(arg0));
    }

    @When("^click to Generate Impala button$")
    public void clickToGenerateImpalaButton() {
        $(By.xpath("//*[@class='cohort-generate-sources']/tbody/tr/td/span/span/button")).click();
    }

    @When("^click to Generate first data source button$")
    public void clickToGenerateFirstDataSourceButton() {
        $(By.xpath("//*[@class='cohort-generate-sources']/tbody/tr/td/span/span/button")).click();
    }

    @Then("^can see Complete in IMPALA status in (\\d+) seconds$")
    public void canSeeCompleteStatusInSeconds(int arg0) {
        $(By.xpath("//*[@class='cohort-generate-sources']/tbody/tr/td[3]")).waitUntil(text("COMPLETE"), arg0 * 1000);
    }

    @Then("^can see Complete in first data source status in (\\d+) seconds$")
    public void canSeeCompleteFirstDSStatusInSeconds(int arg0) {
        $(By.xpath("//*[@class='cohort-generate-sources']/tbody/tr/td[3]")).waitUntil(text("COMPLETE"), arg0 * 1000);
    }

    @When("^click to Reporting tab tab$")
    public void clickToReportingTabTab() {
        $(By.xpath("//*[@class='nav nav-tabs']/li[4]")).click();
    }

    @When("^select \"([^\"]*)\" source$")
    public void selectSource(String arg0) {
        $(By.xpath("//*[@class='form-control invalid']")).click();
        $(By.xpath("//*[@class='form-control invalid']")).selectOptionByValue(arg0);
    }

    @When("^select first data source$")
    public void selectFirstDataSource() {
        $(By.xpath("//*[@class='form-control invalid']")).click();
        $(By.xpath("//*[@class='form-control invalid']")).selectOption(1);
    }

    @When("^click to quick analysis button$")
    public void clickToQuickAnalysisButton() {
        $(By.xpath("//*[@class='btn btn-success btn-sm']")).click();
    }

    @When("^accept an alert about time$")
    public void acceptAnAlertAboutTime() {
        switchTo().alert().accept();
    }

    @Then("^can see a row with status Started$")
    public void canSeeARowWithStatusStarted() {
        $(By.xpath("//*[@class='panel panel-info']/div/table/tbody/tr/td[3]")).waitUntil(text("STARTED"), 10000);
    }

    @Then("^can see only one field with text \"([^\"]*)\"$")
    public void canSeeOnlyOneFieldWithText(String arg0) {
        conceptSetsInTableForChoosing.forEach(e -> e.shouldHave(matchesText(arg0)));
    }

    @When("^click to Generate SynPUF (\\d+)K Cost&Util button$")
    public void clickToGenerateSynPUFKCostUtilButton(int arg0) {
        $(By.xpath("//*[@class='cohort-generate-sources']/tbody/tr[4]/td/span/span/button")).click();
    }

    @Then("^can see Complete in SynPUF (\\d+)K Cost&Util status in (\\d+) seconds$")
    public void canSeeCompleteInSynPUFKCostUtilStatusInSeconds(int arg0, int arg1) {
        $(By.xpath("//*[@class='cohort-generate-sources']/tbody/tr[4]/td[3]")).waitUntil(text("COMPLETE"), arg0 * 1000);

    }

    @When("^click to utilisation button$")
    public void clickToUtilisationButton() {
        $(By.xpath("//*[@class='btn btn-info btn-sm']")).waitUntil(enabled, 5000).click();

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
    public void canSeeInInitialEventCohort(String arg0) {
        $(By.xpath("//*[@id='cohortTextView']/cohort-expression-viewer/ul/li/div/conceptset-reference/span")).shouldHave(text(arg0));
    }

    @When("^click to Graphical View$")
    public void clickToGraphicalView() {
        $(By.xpath("//*[@class='nav nav-pills']/li[2]")).click();

    }

    @Then("^can see \"([^\"]*)\" in Primary Criteria$")
    public void canSeeInPrimaryCriteria(String arg0) {
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
