package atlastests;

import atlastests.components.ModalControl;
import atlastests.components.TablesControl;
import atlastests.components.FormControl;
import atlastests.components.PageControl;
import com.codeborne.selenide.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static atlastests.TestDefs.getDataProperties;
import static atlastests.components.StaticElements.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CohortDefinitionStepDefs implements PageControl, FormControl, TablesControl, ModalControl {

    private final ElementsCollection conceptSetsInTableForChoosing = $$("#repositoryConceptSetTable_wrapper .linkish");
    private final ElementsCollection conceptSetsInDataTable = $$(".conceptSetTable span");
    private final ElementsCollection dataSources = $$(".cohort-generate-sources tr");
    private final SelenideElement closeConceptSetButton = $(withText("Close Concept Set"));
    private final SelenideElement jsonInputField = $("#cohortExpressionJSON");
    private String nameCohort;
    private String newGeneratedString;

    @Step ("can see Cohort Definition page")
    @Then("^can see Cohort Definition page$")
    public void canSeeCohortDefinitionPage() {
        checkPageHeader("Cohort definitions");
    }

    @Step ("click New Cohort button")
    @When("^click New Cohort button$")
    public void clickNewCohortButton() {
        $(".btn-primary").shouldBe(enabled, Duration.ofMillis(5000)).click();
    }

    @Step ("can see new cohort page creation")
    @Then("^can see new cohort page creation$")
    public void canSeeNewCohortPageCreation() {
        checkPageHeader("New Cohort Definition");
    }

    @Step ("enter name of New Cohort Definition and save it")
    @When("^enter name of New Cohort Definition and save it$")
    public void enterNameOfNewCohortDefinitionAndSaveIt() {
        nameCohort = "Test_" + RandomStringUtils.randomAlphanumeric(10);
        setTitle(nameCohort);
        saveAction();
        $(".fa-trash-alt").shouldBe(enabled, Duration.ofMillis(5000)); //cz need to wait saving of cohort
    }

    @Step ("filtere Cohort Definition")
    @Then("^filtered Cohort Definition$")
    public void filteredCohortDefinition() {
        search(nameCohort);
    }

    @Step ("cohort Definition should be found")
    @Then("^Cohort Definition should be found$")
    public void cohortDefinitionShouldBeFound() {
        COHORT_LINK_IN_TABLE.shouldHave(text(nameCohort));
    }

    @Step ("click to our Cohort Definitions")
    @When("^click to our Cohort Definition$")
    public void clickToOurCohortDefinition() {
        COHORT_LINK_IN_TABLE.click();
    }

    @Step ("can see our Cohort Definition")
    @Then("^can see our Cohort Definition$")
    public void canSeeOurCohortDefinition() {
        $$(".cohort-definition-panel").forEach(e -> e.shouldBe(visible));
    }

    @Step ("click to delete our Cohort Definition")
    @When("^click to delete our Cohort Definition$")
    public void clickToDeleteOurCohortDefinition() {
        deleteAction();
    }

    @Step ("accept delete Cohort Definition alert")
    @When("^accept delete Cohort Definition alert$")
    public void acceptDeleteCohortDefinitionAlert() {
        Selenide.confirm();
    }

    @Step ("Cohort Definition should be not found")
    @Then("^Cohort Definition should be not found$")
    public void cohortDefinitionShouldBeNotFound() {
        EMPTY_TABLE.shouldHave(text("No matching records found"));

    }

    @Step ("press Add Initial Event")
    @When("^press Add Initial Event$")
    public void pressAddInitialEvent() {
        $(withText("Add Initial Event")).shouldBe(visible, Duration.ofMillis(5000)).click();
        $$("[data-bind='foreach:$component.primaryCriteriaOptions'] .optionText").
                forEach(e -> e.hover().shouldHave(visible));
    }

    @Step ("press Add Condition Occurrence")
    @When("^press Add Condition Occurrence$")
    public void pressAddConditionOcurrence() {
        $(withText("Add Condition Occurrence")).shouldBe(visible, Duration.ofMillis(5000)).click();
    }

    @Step ("press Add")
    @When("^press Add \"([^\"]*)\"$")
    public void pressAddInitialEvent(String initialEvent) {
        $(withText("Add " + initialEvent)).shouldBe(visible, Duration.ofMillis(5000)).click();
    }

    @Step ("click to Any Contion menu")
    @When("^click to Any Condition menu$")
    public void clickToAnyConditionMenu() {
        $("[data-bind='with: Criteria'] conceptset-selector [type='button'][data-toggle='dropdown']").click();
    }

    @Step ("Click to Any menu")
    @When("^click to Any ... menu$")
    public void clickToAnyMenu() {
        $(".criteriaTable .thumb-dropdown .dropdown-toggle").click();
    }

    @Step ("choose Import Concept Set")
    @When("^choose Import Concept Set$")
    public void chooseImportConceptSet() {
        $(withText("Import Concept Set")).click();
    }

    @Step ("Import Concept Set window shown")
    @Then("^Import Concept Set window shown$")
    public void importConceptSetWindowShown() {
        $(".modal.fade.in .modal-header").shouldHave(text("Import Concept Set From Repository..."));
    }

    @Step ("enter to Filter of concept set from repository")
    @When("^enter \"([^\"]*)\" to Filter of Concept Set from Repository$")
    public void enterToFilterOfConceptSetFromRepository(String arg0) {
        search(arg0);
    }

    @Step ("click to chosen concept set from repository")
    @When("^click to chosen concept set from repository$")
    public void clickToChosenConceptSetFromRepository() {
        conceptSetsInTableForChoosing.first().click();
        $("#repositoryConceptSetTable .circle").shouldBe(hidden, Duration.ofMillis(10000));
    }

    @Step ("can see name of consept set at the button")
    @Then("^can see name of concept set at the button ")
    public void canSeeNameOfConceptSetAtTheButton() {
        $(By.xpath("//*[@class='btn btn-primary conceptset_edit']")).shouldBe(visible, Duration.ofMillis(5000)).
                shouldHave(text("Angioedema"));
    }

    @Step ("click to Samples tab")
    @When("^click to Samples tab$")
    public void clickToSamplesTab() {
        NAV_TABS.find(matchText("Samples")).click();
    }

    @Step ("can see a select element with data sources")
    @Then("^can see a select element with data sources$")
    public void canSeeSelectWithDataSources() {
        $(".active .panel-primary .panel-heading").shouldHave(text("Sample Selections"));
    }

    @Step ("click to Concept Sets tab")
    @When("^click to Concept Sets tab$")
    public void clickToConceptSetsTab() {
        NAV_TABS.find(matchText("Concept Sets")).click();
    }

    @Step ("can see row with name of Concept Set in the table")
    @Then("^can see row with name of Concept Set in the table$")
    public void canSeeRowWithNameOfConceptSetInTheTable() {
        conceptSetsInDataTable.first().shouldHave(matchText("Angioedema"));
    }

    @Step ("click on the row in table concept set in cohort definitions")
    @When("^click on the row in table concept set in cohort definitions$")
    public void clickOnTheRowInTableConceptSetInCohortDefinitions() {
        conceptSetsInDataTable.first().hover().click();
    }

    @Step ("can see table of concept set with concept")
    @Then("^can see table of concept set with concept: \"([^\"]*)\"$")
    public void canSeeTableOfConceptSetWithConcepts(String conceptName) {
        $(".active.tab-pane .divtext").shouldHave(text(conceptName));
    }

    @Step ("click to Close concept set")
    @When("^click to Close concept set$")
    public void clickToCloseConceptSet() {
        closeConceptSetButton.click();
    }

    @Step ("table of concept sets close")
    @Then("^table of concept sets close$")
    public void tableOfConceptSetsClose() {
        closeConceptSetButton.shouldNotBe(visible);
    }

    @Step ("click to Generation tab")
    @When("^click to Generation tab$")
    public void clickToGenerationTab() {
        NAV_TABS.find(matchText("Generation")).click();
    }

    @Step ("can see Generation page")
    @Then("^can see Generation page$")
    public void canSeeGenerationSourcesPage() {
        $(".cohort-generate-sources").shouldBe(visible);
    }

    @Step ("click to Reporting tab")
    @When("^click to Reporting tab$")
    public void clickToReportingTab() {
        NAV_TABS.find(matchText("Reporting")).click();
    }

    @Step ("can see reporting page")
    @Then("^can see reporting page$")
    public void canSeeReportingPage() {
        $("select.form-control.invalid").shouldBe(visible);
    }

    @Step ("click to Export tab in Cohort Definitions")
    @When("^click to Export tab in Cohort Definitions$")
    public void clickToExportTabInCohortDefinitions() {
        NAV_TABS.find(matchText("Export")).click();
    }

    @Step ("can see Export page")
    @Then("^can see Export page$")
    public void canSeeExportPage() {
        $("#cohortTextView").shouldBe(visible);
    }

    @Step ("click to Messages tab")
    @When("^click to Messages Tab$")
    public void clickToMessagesTab() {
        NAV_TABS.find(matchText("Messages")).click();
    }

    @Step ("can see Messages page")
    @Then("^can see Messages page$")
    public void canSeeMessagesPage() {
        $("[aria-label='Severity: activate to sort column ascending']").shouldBe(visible, Duration.ofMillis(4000)).
                shouldHave(text("Severity"));
    }

    @Step ("click to Run diagnistic Button")
    @When("^click to Run diagnostic Button$")
    public void clickToRunDiagnosticButton() {
        $(By.xpath("//*[@class='warnings-button-pane pull-right']/button")).click();
    }

    @Step ("add Inclusion criteria with group")
    @When("^add Inclusion criteria with group: \"([^\"]*)\"$")
    public void addInclusionCriteriaWithGroup(String criteriaGroup) {
        addInclusionCriteria();
        $(withText("Add criteria to group...")).click();
        $$(".criteriaHeading [data-bind='foreach:$component.addActions'] .optionText").
                find(Condition.matchText(criteriaGroup)).click();
    }

    @Step ("add Inclusion criteria")
    @When("^add Inclusion criteria$")
    public void addInclusionCriteria() {
        $(".inclusion-criteria__block .btn-success").
                shouldBe(visible, Duration.ofMillis(5000)).click();
        $(".inclusion-rule-header input").setValue("TEST INCLUSION");
        $("inclusion-rule-editor [placeholder='enter an inclusion rule description']").
                setValue("TEST INCLUSION DESCRIPTION");
    }

    @Step ("can see block with inclusion criterias")
    @Then("^can see block with inclusion criterias$")
    public void canSeeBlockWithInclusionCriterias() {
        $$(".inclusionRuleItem div").shouldHave(CollectionCondition.texts("TEST INCLUSION",
                "TEST INCLUSION DESCRIPTION"));
    }

    @Step ("can see window with cohort definition")
    @Then("^can see window with cohort definition$")
    public void canSeeWindowWithCohortDefinition() {
        checkModalTitle("Choose a Cohort definition");
    }

    @Step ("click to Id to sort")
    @When("^click to Id to sort$")
    public void clickToIdToSort() {
        $("[aria-label='Id: activate to sort column ascending']").click();
    }

    @Step ("enter new name of cohort definition")
    @When("^enter new name of cohort definition$")
    public void enterNewNameOfCohortDefinition() {
        newGeneratedString = "Test_" + RandomStringUtils.randomAlphanumeric(10);
        setTitle(newGeneratedString);
    }

    @Step ("save new name of cohort definition")
    @When("^save new name of cohort definition$")
    public void saveNewNameOfCohortDefinition() {
        saveAction();
    }

    @Step ("filtered new Cohort Definition")
    @Then("^filtered new Cohort Definition$")
    public void filteredNewCohortDefinition() {
        search(newGeneratedString);
    }

    @Step ("new Cohort Definition should be found")
    @Then("^new Cohort Definition should be found$")
    public void newCohortDefinitionShouldBeFound() {
        COHORT_LINK_IN_TABLE.shouldHave(text(newGeneratedString));
    }

    @Step ("enter the same name of New Cohort Definition and save")
    @When("^enter the same name of New Cohort Definition and save it$")
    public void enterTheSameNameOfNewCohortDefinitionAndSaveIt() {
        setTitle(nameCohort);
        saveAction();
    }

    @Step ("condition occurrence block shown")
    @Then("^condition occurrence block shown$")
    public void conditionOccurrenceBlockShown() {
        $$(".criteria-content .criteriaTable").find(matchText("a condition occurrence of")).
                shouldBe(visible);
    }

    @Step ("click to save button in Cohort definition")
    @When("^click to save button in Cohort Definition$")
    public void clickToSaveButtonInCohortDefinition() {
        saveAction();
    }

    @Step ("click to Id column")
    @When("^click to Id column$")
    public void clickToIdColumn() {
        $(".id-column.sorting").shouldBe(visible, Duration.ofMillis(5000)).click();
    }

    @Step ("can see that first value less then second")
    @Then("^can see that first value less then second$")
    public void canSeeThatFirstValueLessThenSecond() {
        String a = $(By.xpath("//table/tbody/tr/td[1]")).getText();
        String b = $(By.xpath("//table/tbody/tr[2]/td[1]")).getText();
        Assert.assertTrue(Integer.parseInt(a) < Integer.parseInt(b));
    }

    @Step("can see paging")
    @Then("^can see paging$")
    public void canSeePaging() {
        $$(".next.paginate_button").forEach(e -> e.shouldBe(visible));
    }

    @Step ("enter value in filter in cohort definition")
    @When("^enter \"([^\"]*)\" in filter in cohort definition$")
    public void enterInFilterInCohortDefinition(String arg0) {
        search(arg0);
    }

    @Step ("click to founded result")
    @Then("^click to founded result$")
    public void clickToFoundedResult() {
        COHORT_LINK_IN_TABLE.click();
    }

    @Step ("click to JSON tab in Cohord Definition")
    @When("^click to JSON tab in Cohort Definitions$")
    public void clickToJSONTabInCohortDefinitions() {
        NAV_PILLS.filter(visible).find(matchText("JSON")).click();
    }

    @Step ("click to Copy to clipboard button")
    @When("^click to Copy to clipboard button$")
    public void clickToCopyToClipboardButton() {
        $("#btnCopyExpressionJSONClipboard").click();
    }

    @Step ("clear json input")
    @When("^clear json input$")
    public void clearJsonInput() {
        jsonInputField.clear();
    }

    @Step ("past json from clipboard")
    @When("^past json from clipboard$")
    public void pastJsonFromClipboard() {
        jsonInputField.sendKeys(Keys.SHIFT, Keys.INSERT);
    }

    @Step ("click to Reload button")
    @When("^click to Reload button$")
    public void clickToReloadButton() {
        $(withText("Reload")).click();
    }

    @Step ("click to Definition tab")
    @When("^click to Definition tab$")
    public void clickToDefinitionTab() {
        NAV_TABS.find(matchText("Definition")).click();
    }

    @Step ("can see name of concept set at button")
    @Then("^can see name \"([^\"]*)\" of concept set at the button$")
    public void canSeeNameOfConceptSetAtTheButton(String arg0) {
        $(".btn-group-sm .btn-primary").shouldHave(text(arg0));
    }

    @Step ("click to Generate Impala button")
    @When("^click to Generate Impala button$")
    public void clickToGenerateImpalaButton() {
        generateByDataSource("IMPALA");
    }

    @Step ("click to Generate first data source button")
    @When("^click to Generate first data source button$")
    public void clickToGenerateFirstDataSourceButton() {
        $$(".cohort-generate-sources button").first().click();
    }

    @Step ("can see Complete in IMPALA status in seconds")
    @Then("^can see Complete in IMPALA status in (\\d+) seconds$")
    public void canSeeCompleteStatusInSeconds(int arg0) {
        checkStatus("IMPALA", arg0);
    }

    @Step ("can see Complete in first data source status")
    @Then("^can see Complete in first data source status in (\\d+) seconds$")
    public void canSeeCompleteFirstDSStatusInSeconds(int arg0) {
        $$(".statusIndicator.text-right").first().shouldHave(text("COMPLETED"), Duration.ofMillis(arg0 * 1000L));
    }
    @Step ("click to Reporting tab")
    @When("^click to Reporting tab tab$")
    public void clickToReportingTabTab() {
        NAV_TABS.find(matchText("Reporting")).click();
    }

    @Step ("select source")
    @When("^select \"([^\"]*)\" source$")
    public void selectSource(String arg0) {
        $$("select.form-control").filter(visible).first().selectOptionContainingText(arg0);
    }

    @Step ("select first data source")
    @When("^select first data source$")
    public void selectFirstDataSource() {
        $(By.xpath("//*[@class='form-control invalid']")).selectOption(1);
    }

    @Step ("click to quick analysis button")
    @When("^click to quick analysis button$")
    public void clickToQuickAnalysisButton() {
        $(".btn-group .btn-success").click();
    }

    @Step ("accept an alert about time")
    @When("^accept an alert about time$")
    public void acceptAnAlertAboutTime() {
        switchTo().alert().accept();
    }

    @Step ("can see a row with status Started")
    @Then("^can see a row with status Started$")
    public void canSeeARowWithStatusStarted() {
        $("[data-bind='html: status']").shouldHave(text("STARTED"), Duration.ofMillis(10000));
    }

    @Step ("can see only one field with text")
    @Then("^can see only one field with text \"([^\"]*)\"$")
    public void canSeeOnlyOneFieldWithText(String arg0) {
        conceptSetsInTableForChoosing.filter(visible).forEach(e -> e.shouldHave(text(arg0)));
    }

    @Step ("click to Generate SynPUF Cost&Util button")
    @When("^click to Generate SynPUF (\\d+)K Cost&Util button$")
    public void clickToGenerateSynPUFKCostUtilButton(int arg0) {
        generateByDataSource("SynPUF 110K Cost&Util");
    }

    @Step ("can see Complet in SynPUF cost&Util status")
    @Then("^can see Complete in SynPUF (\\d+)K Cost&Util status in (\\d+) seconds$")
    public void canSeeCompleteInSynPUFKCostUtilStatusInSeconds(int arg0, int arg1) {
        checkStatus("SynPUF 110K Cost&Util", arg0);
    }

    @Step ("click to utilisation button")
    @When("^click to utilisation button$")
    public void clickToUtilisationButton() {
        $(".btn-group .btn-info.btn-sm").shouldBe(enabled, Duration.ofMillis(5000)).click();

    }

    @Step ("configure of reports to run window opens")
    @Then("^configure of reports to run window opens$")
    public void configureOfReportsToRunWindowOpens() {
        $$(".modal-pick-options__header").shouldHave(CollectionCondition.texts("Reports", "Periods",
                "Rollups"));
    }

    @Step ("choose reports and press Run")
    @When("^choose reports and press Run$")
    public void chooseReportsAndPressRun() {
        $(By.xpath("//*[@value='rollupUtilizationVisit']")).click();
        $(By.xpath("//*[@value='rollupUtilizationDrug']")).click();
        $$(By.xpath("//*[@class='btn btn-info btn-sm']")).get(1).click();
    }

    @Step ("click to Generate")
    @When("^click to Generate: \"([^\"]*)\"$")
    public void clickToGenerateSynPUFKCDM(String sourceName) {
        generateByDataSource(sourceName);
    }

    @Step ("click to Generate from properties")
    @When("^click to Generate on \"([^\"]*)\" from properties$")
    public void clickToGenerateFromProperties(String propertyName) throws Exception {
        generateByDataSource(getDataProperties(propertyName));
    }

    @Step ("can see Complete in status")
    @Then("^can see Complete in \"([^\"]*)\" status in (\\d+) seconds$")
    public void canSeeCompleteInSynPUFKCDMStatusInSeconds(String sourceName, int timeout) {
        checkStatus(sourceName, timeout);
    }

    @Step ("can see complete dataset from properties status")
    @Then("^can see Complete on \"([^\"]*)\" dataset from properties status in (\\d+) seconds$")
    public void canSeeCompleteInSynPUFKCDMStatusInSecondsProperties(String propertyName, int timeout) throws Exception {
        checkStatus(getDataProperties(propertyName), timeout);
    }

    @Step ("click to Full analysis button")
    @When("^click to Full analysis button$")
    public void clickToFullAnalysisButton() {
        $(withText("Full Analysis")).click();
    }

    @Step ("can see in Initial Event Cohort")
    @Then("^can see \"([^\"]*)\" in Initial Event Cohort$")
    public void canSeeInInitialEventCohort(String arg0) {
        $("[data-bind='text: codesetName']").shouldHave(text(arg0));
    }

    @Step ("click to Graphical View")
    @When("^click to Graphical View$")
    public void clickToGraphicalView() {
        NAV_PILLS.filter(visible).find(matchText("Graphical View")).click();
    }

    @Step ("can see in Primary Criteria")
    @Then("^can see \"([^\"]*)\" in Primary Criteria$")
    public void canSeeInPrimaryCriteria(String arg0) {
        $(".name").shouldHave(text(arg0));
    }

    @Step ("click to SQL tab")
    @When("^click to SQL tab$")
    public void clickToSQLTab() {
        NAV_PILLS.filter(visible).find(matchText("SQL")).click();
    }

    @Step ("can see sql query")
    @Then("^can see sql query$")
    public void canSeeSqlQuery() {
        $("#sqlText").shouldHave(text("CREATE TABLE"));
    }

    @Step ("click to close cohort button")
    @When("^click to close cohort button$")
    public void closeCurrentCohort() {
        closeAction();
    }

    @Step ("click to Samples tab")
    @When("^click to Samples tab tab$")
    public void clickToSamplesTabTab() {
        NAV_TABS.find(matchText("Samples")).click();
    }

    @Step ("Samples tab is open")
    @Then("^Samples tab is opened$")
    public void canSeeSamplesTabOpened() {
        $(".active.tab-pane .panel-body select").shouldBe(visible);
    }

    private void generateByDataSource(String dataSourceName) {
        dataSources.find(Condition.matchText(dataSourceName)).
                find(withText("Generate")).click();
    }

    private void checkStatus(String dataSourceName, int seconds) {
        dataSources.find(Condition.matchText(dataSourceName)).
                find(".statusIndicator.text-right").shouldHave(text("COMPLETED"), Duration.ofMillis(seconds * 1000L));
    }
}
