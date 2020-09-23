package atlastests;

import atlastests.components.ModalControl;
import atlastests.components.TablesControl;
import atlastests.components.FormControl;
import atlastests.components.PageControl;
import com.codeborne.selenide.*;
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

public class CohortDefinitionStepDefs implements PageControl, FormControl, TablesControl, ModalControl {

    private final ElementsCollection tabs = $$(".nav-tabs a");
    private final SelenideElement cohortLinkInTable = $("tbody .linkish");
    private final ElementsCollection conceptSetsInTableForChoosing = $$("#repositoryConceptSetTable_wrapper .linkish");
    private final ElementsCollection conceptSetsInDataTable = $$(".conceptSetTable span");
    private final ElementsCollection exportTabs = $$(".nav-pills.nav a");
    private final ElementsCollection dataSources = $$(".cohort-generate-sources tr");
    private final SelenideElement closeConceptSetButton = $(withText("Close Concept Set"));
    private final SelenideElement jsonInputField = $("#cohortExpressionJSON");
    private String nameCohort;
    private String newGeneratedString;

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
        tabs.find(matchesText("Concept Sets")).click();
    }

    @Then("^can see row with name of Concept Set in the table$")
    public void canSeeRowWithNameOfConceptSetInTheTable() {
        conceptSetsInDataTable.first().shouldHave(matchesText("Angioedema"));
    }

    @When("^click on the row in table concept set in cohort definitions$")
    public void clickOnTheRowInTableConceptSetInCohortDefinitions() {
        conceptSetsInDataTable.first().hover().click();
    }

    @Then("^can see table of concept set with concept: \"([^\"]*)\"$")
    public void canSeeTableOfConceptSetWithConcepts(String conceptName) {
        $(".active.tab-pane .divtext").shouldHave(text(conceptName));
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
        tabs.find(matchesText("Generation")).click();
    }

    @Then("^can see Generation page$")
    public void canSeeGenerationSourcesPage() {
        $(".cohort-generate-sources").shouldBe(visible);
    }

    @When("^click to Reporting tab$")
    public void clickToReportingTab() {
        tabs.find(matchesText("Reporting")).click();
    }

    @Then("^can see reporting page$")
    public void canSeeReportingPage() {
        $("select.form-control.invalid").shouldBe(visible);
    }

    @When("^click to Export tab in Cohort Definitions$")
    public void clickToExportTabInCohortDefinitions() {
        tabs.find(matchesText("Export")).click();
    }

    @Then("^can see Export page$")
    public void canSeeExportPage() {
        $("cohort-expression-viewer").shouldHave(text("Initial Event Cohort"));
    }

    @When("^click to Messages Tab$")
    public void clickToMessagesTab() {
        tabs.find(matchesText("Messages")).click();
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

    @When("^add Inclusion criteria with group: \"([^\"]*)\"$")
    public void addInclusionCriteriaWithGroup(String criteriaGroup) {
        addInclusionCriteria();
        $(withText("Add criteria to group...")).click();
        $$("[data-bind='html:$component.formatOption($data), click:action']").
                find(Condition.matchesText(criteriaGroup)).click();
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
        checkModalTitle("Choose a Cohort definition");
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
        $(".id-column.sorting").waitUntil(visible, 5000).click();
    }

    @Then("^can see that first value less then second$")
    public void canSeeThatFirstValueLessThenSecond() {
        String a = $(By.xpath("//table/tbody/tr/td[1]")).getText();
        String b = $(By.xpath("//table/tbody/tr[2]/td[1]")).getText();
        Assert.assertTrue(Integer.parseInt(a) < Integer.parseInt(b));
    }

    @Then("^can see paging$")
    public void canSeePaging() {
        $$(".next.paginate_button").forEach(e -> e.shouldBe(visible));
    }

    @When("^enter \"([^\"]*)\" in filter in cohort definition$")
    public void enterInFilterInCohortDefinition(String arg0) {
       search(arg0);
    }

    @Then("^click to founded result$")
    public void clickToFoundedResult() {
        cohortLinkInTable.click();
    }

    @When("^click to JSON tab in Cohort Definitions$")
    public void clickToJSONTabInCohortDefinitions() {
        exportTabs.filter(visible).find(matchesText("JSON")).click();
    }

    @When("^click to Copy to clipboard button$")
    public void clickToCopyToClipboardButton() {
        $("#btnCopyExpressionJSONClipboard").click();
    }

    @When("^clear json input$")
    public void clearJsonInput() {
        jsonInputField.clear();
    }

    @When("^past json from clipboard$")
    public void pastJsonFromClipboard() {
        jsonInputField.sendKeys(Keys.SHIFT, Keys.INSERT);
    }


    @When("^click to Reload button$")
    public void clickToReloadButton() {
        $(withText("Reload")).click();
    }

    @When("^click to Definition tab$")
    public void clickToDefinitionTab() {
        tabs.find(matchesText("Definition")).click();
    }

    @Then("^can see name \"([^\"]*)\" of concept set at the button$")
    public void canSeeNameOfConceptSetAtTheButton(String arg0) {
        $(".btn-group-sm .btn-primary").shouldHave(text(arg0));
    }

    @When("^click to Generate Impala button$")
    public void clickToGenerateImpalaButton() {
        generateByDataSource("IMPALA");
    }

    @When("^click to Generate first data source button$")
    public void clickToGenerateFirstDataSourceButton() {
        $$(".cohort-generate-sources button").first().click();
    }

    @Then("^can see Complete in IMPALA status in (\\d+) seconds$")
    public void canSeeCompleteStatusInSeconds(int arg0) {
        checkStatus("IMPALA", arg0);
    }

    @Then("^can see Complete in first data source status in (\\d+) seconds$")
    public void canSeeCompleteFirstDSStatusInSeconds(int arg0) {
        $$(".statusIndicator.text-right").first().waitUntil(text("COMPLETE"), arg0 * 1000);
    }

    @When("^click to Reporting tab tab$")
    public void clickToReportingTabTab() {
        tabs.find(matchesText("Reporting")).click();
    }

    @When("^select \"([^\"]*)\" source$")
    public void selectSource(String arg0) {
        $$("select.form-control").filter(visible).first().selectOptionContainingText(arg0);
    }

    @When("^select first data source$")
    public void selectFirstDataSource() {
        $(By.xpath("//*[@class='form-control invalid']")).selectOption(1);
    }

    @When("^click to quick analysis button$")
    public void clickToQuickAnalysisButton() {
        $(".btn-group .btn-success").click();
    }

    @When("^accept an alert about time$")
    public void acceptAnAlertAboutTime() {
        switchTo().alert().accept();
    }

    @Then("^can see a row with status Started$")
    public void canSeeARowWithStatusStarted() {
        $("[data-bind='html: status']").waitUntil(text("STARTED"), 10000);
    }

    @Then("^can see only one field with text \"([^\"]*)\"$")
    public void canSeeOnlyOneFieldWithText(String arg0) {
        conceptSetsInTableForChoosing.filter(visible).forEach(e -> e.shouldHave(text(arg0)));
    }

    @When("^click to Generate SynPUF (\\d+)K Cost&Util button$")
    public void clickToGenerateSynPUFKCostUtilButton(int arg0) {
        generateByDataSource("SynPUF 110K Cost&Util");
    }

    @Then("^can see Complete in SynPUF (\\d+)K Cost&Util status in (\\d+) seconds$")
    public void canSeeCompleteInSynPUFKCostUtilStatusInSeconds(int arg0, int arg1) {
        checkStatus("SynPUF 110K Cost&Util", arg0);
    }

    @When("^click to utilisation button$")
    public void clickToUtilisationButton() {
        $(".btn-group .btn-info.btn-sm").waitUntil(enabled, 5000).click();

    }

    @Then("^configure of reports to run window opens$")
    public void configureOfReportsToRunWindowOpens() {
        $$(".modal-pick-options__header").shouldHave(CollectionCondition.texts("Reports", "Periods",
                "Rollups"));
    }

    @When("^choose reports and press Run$")
    public void chooseReportsAndPressRun() {
        $(By.xpath("//*[@value='rollupUtilizationVisit']")).click();
        $(By.xpath("//*[@value='rollupUtilizationDrug']")).click();
        $$(By.xpath("//*[@class='btn btn-info btn-sm']")).get(1).click();
    }


    @When("^click to Generate: \"([^\"]*)\"$")
    public void clickToGenerateSynPUFKCDM(String sourceName) {
        generateByDataSource(sourceName);
    }

    @Then("^can see Complete in \"([^\"]*)\" status in (\\d+) seconds$")
    public void canSeeCompleteInSynPUFKCDMStatusInSeconds(String sourceName, int arg0) {
        checkStatus(sourceName, arg0);
    }

    @When("^click to Full analysis button$")
    public void clickToFullAnalysisButton() {
        $(withText("Full Analysis")).click();
    }

    @Then("^can see \"([^\"]*)\" in Initial Event Cohort$")
    public void canSeeInInitialEventCohort(String arg0) {
        $("[data-bind='text: codesetName']").shouldHave(text(arg0));
    }

    @When("^click to Graphical View$")
    public void clickToGraphicalView() {
        exportTabs.filter(visible).find(matchesText("Graphical View")).click();
    }

    @Then("^can see \"([^\"]*)\" in Primary Criteria$")
    public void canSeeInPrimaryCriteria(String arg0) {
        $(".name").shouldHave(text(arg0));
    }

    @When("^click to SQL tab$")
    public void clickToSQLTab() {
        exportTabs.filter(visible).find(matchesText("SQL")).click();
    }

    @Then("^can see sql query$")
    public void canSeeSqlQuery() {
        $("#sqlText").shouldHave(text("CREATE TABLE"));
    }

    @When("^click to close cohort button$")
    public void closeCurrentCohort() {
       closeAction();
    }

    private void generateByDataSource(String dataSourceName) {
        dataSources.find(Condition.text(dataSourceName)).
                find(withText("Generate")).click();
    }

    private void checkStatus(String dataSourceName, int seconds) {
        dataSources.find(Condition.text(dataSourceName)).
                find(".statusIndicator.text-right").waitUntil(text("COMPLETE"), seconds * 1000);
    }
}
