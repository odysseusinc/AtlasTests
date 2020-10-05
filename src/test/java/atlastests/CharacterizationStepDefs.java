package atlastests;

import atlastests.components.ModalControl;
import atlastests.components.TablesControl;
import atlastests.components.FormControl;
import atlastests.components.PageControl;
import com.codeborne.selenide.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static atlastests.components.StaticElements.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CharacterizationStepDefs implements FormControl, TablesControl, PageControl, ModalControl {

    private final SelenideElement cohortTableName = $("tbody .characterizations-list__tbl-col--name a");
    private final SelenideElement featureAnalysisTableName = $("tbody .feature-analyses-list__tbl-col--name");
    private final ElementsCollection featureAnalysisTableRows = $$("tbody .characterization-design__col-feature-name");
    private String characterizationName;
    private String featureName;


    @Then("^can see Characterization page$")
    public void canSeeCharaterizationPage() {
        checkPageHeader("Cohort Characterizations");
    }

    @When("^click to New characterization button$")
    public void clickToNewCharacterizationButton() {
        $(byText("New Characterization")).click();
        checkPageHeader("New Characterization");
    }

    @When("^enter Characterization name and save it$")
    public void enterCharacterizationNameAndSaveIt() {
        characterizationName = "Test_" + RandomStringUtils.randomAlphanumeric(10);
        setTitle(characterizationName);
        saveAction();
    }

    @When("^return to Characterization table$")
    public void returnToCharacterizationTable() {
        closeAction();
    }

    @When("^enter created characterization name in filter$")
    public void enterCreatedCharacterizationNameInFilter() {
        search(characterizationName);
    }

    @Then("^can see new characterization in table$")
    public void canSeeNewCharacterizationInTable() {
        cohortTableName.shouldHave(text(characterizationName));
    }

    @When("^click to our characterization$")
    public void clickToOurCharacterization() {
        cohortTableName.click();
    }

    @When("^click to delete characterization button$")
    public void clickToDeleteCharacterizationButton() {
        deleteAction();
    }

    @When("^accept delete characterization$")
    public void acceptDeleteCharacterization() {
        Selenide.confirm();
    }

    @Then("^cant find characterization in the table$")
    public void cantFindCharacterizationInTheTable() {
        search(characterizationName);
        EMPTY_TABLE.shouldHave(text("No matching records found"));
    }

    @When("^click to Import Cohort Definition$")
    public void clickToImportCohortDefinition() {
        $$(byText("Import")).get(0).waitUntil(visible, 5000).click();
    }

    @When("^click to Feature Analyses tab$")
    public void clickToFeatureAnalysesTab() {
        $$("[role='presentation']").find(Condition.matchesText("Feature analyses")).click();
        $(".btn-primary").waitUntil(Condition.matchesText("New Feature analysis"), 5000);
    }

    @Then("^can see Feature Analyses table$")
    public void canSeeFeatureAnalysesTable() {
        $(".facetedDataTable tbody").waitUntil(visible, 10000);
    }

    @When("^click to New Feature analyses$")
    public void clickToNewFeatureAnalyses() {
        $(byText("New Feature analysis")).click();
    }

    @Then("^can see page of creation New Feature Analyse$")
    public void canSeePageOfCreationNewFeatureAnalyse() {
        checkPageHeader("New Feature Analysis");
    }

    @When("^enter description$")
    public void enterDescription() {
        $(".feature-analysis-design__descr").setValue("TEST DESCRIPTION");
    }

    @When("^choose Criteria design$")
    public void chooseCriteriaDesign() {
        $$(".feature-analysis-design__type-selector li").find(text("Criteria")).click();
    }

    @When("^enter name of New Feature Analyse$")
    public void enterNameOfNewFeatureAnalyse() {
        featureName = "Test_" + RandomStringUtils.randomAlphanumeric(10);
        setTitle(featureName);
    }

    @When("^click to save feature analyse button$")
    public void clickToSaveFeatureAnalyseButton() {
        saveAction();
    }

    @Then("^go to feature analyses table by pressing close button$")
    public void goToFeatureAnalysesTableByPressingCloseButton() {
        closeAction();
    }

    @When("^enter name of our feature to filter$")
    public void enterNameOfOurFeatureToFilter() {
        search(featureName);
    }

    @Then("^can see our feature in table of feature analyses$")
    public void canSeeOurFeatureInTableOfFeatureAnalyses() {
        featureAnalysisTableName.shouldHave(text(featureName));
    }

    @When("^click to our feature analyse$")
    public void clickToOurFeatureAnalyse() {
        featureAnalysisTableName.waitUntil(visible, 5000).click();
    }

    @Then("^can see page of our Feature Analyse$")
    public void canSeePageOfOurFeatureAnalyse() {
        checkPageHeader("Feature Analysis #");
    }


    @When("^click to delete feature analyse$")
    public void clickToDeleteFeatureAnalyse() {
        deleteAction();
    }

    @When("^accept delete feature analyse$")
    public void acceptDeleteFeatureAnalyse() {
        switchTo().alert().accept();
    }

    @Then("^cant find feature analyse in the table$")
    public void cantFindFeatureAnalyseInTheTable() {
        search(featureName);
        EMPTY_TABLE.shouldHave(text("No matching records found"));
    }

    @When("^click to Import Feature analyses$")
    public void clickToImportFeatureAnalyses() {
        $$(byText("Import")).get(1).click();
    }

    @Then("^can see Feature analyses window$")
    public void canSeeFeatureAnalysesWindow() {
       checkModalTitle("Choose a Feature analyses");
    }

    @Then("^Feature analyse table is visible$")
    public void featureAnalyseTableIsVisible() {
        featureAnalysisTableRows.first().waitUntil(visible, 5000);
    }

    @When("^click to Import Feature analyse$")
    public void clickToImportFeatureAnalyse() {
        importButtonClick();
    }

    @When("^enter the same Characterization name and save it$")
    public void enterTheSameCharacterizationNameAndSaveIt() {
        setTitle(characterizationName);
        saveAction();
    }

    @Then("^can see alert message about uniqueness$")
    public void canSeeAlertMessageAboutUniqueness() {
        switchTo().alert().accept();
    }

    @When("^choose cohort definition \"([^\"]*)\" from the table in characterization$")
    public void chooseCohortDefinitionFromTheTableInCharacterization(String arg0) {
        facetedTableSearch(arg0);
        selectInTableResults(arg0);
        importButtonClick();
    }

    @Then("^can see cohort definition in characterization list with text \"([^\"]*)\"$")
    public void canSeeCohortDefinitionInCharacterizationListWithText(String arg0) {
        $("tbody .linked-cohort-list__col-cohort-name").waitUntil(visible, 5000).
                shouldHave(matchesText(arg0));
    }

    @When("^click to feature checkbox with text \"([^\"]*)\" from Feature analyses$")
    public void clickToFeatureCheckboxWithTextFromFeatureAnalyses(String arg0) {
        facetedTableSearch(arg0);
        selectInTableResults(arg0);
    }

    @Then("^can see result of our search \"([^\"]*)\" and \"([^\"]*)\"$")
    public void canSeeResultOfOurSearchAnd(String arg0, String arg1) {
        featureAnalysisTableRows.shouldHave(CollectionCondition.textsInAnyOrder(arg0, arg1));
    }

    @When("^click to save Chacterization$")
    public void clickToSaveChacterization() {
        saveAction();
    }

    @When("^click Remove first Feature Analyse from the table$")
    public void clickRemoveFirstFeatureAnalyseFromTheTable() {
        $(By.xpath("//*[@class=' characterization-design__col-feature-remove ']/a")).click();
    }

    @When("^click to Executions tab in Characterizations$")
    public void clickToExecutionsTabInCharacterizations() {
        $$(".tabs__header-title").find(text("Executions")).click();
    }

    @When("^click Generate report button on first data source$")
    public void clickToGenerateReportButtonOnFirstDataSource() {
        EXECUTION_ACTION_BUTTONS.get(0).click();
    }

    @Then("^first data source generate button has to be with Cancel text$")
    public void firstGenerateButtonHasToBeWithCancelText() {
        EXECUTION_ACTION_BUTTONS.get(0).waitUntil(matchesText("Cancel"), 5000);
    }

    @When("^click to Netezza Generate report button$")
    public void clickToNetezzaGenerateReportButton() {
        generateByDataSource("Netezza");
    }

    @Then("^Netezza generate button has to be with Cancel text$")
    public void netezzaGenerateButtonHasToBeWithCancelText() {
        checkRunning("Netezza");
    }

    @When("^click to \"([^\"]*)\" Generate report button$")
    public void clickToSynPUFKGenerateReportButton(String arg0) {
        generateByDataSource(arg0);
    }

    @Then("\"([^\"]*)\" generate button has to be with Cancel text$")
    public void synpufKGenerateButtonHasToBeWithCancelText(String arg0) {
        checkRunning(arg0);
    }

    @When("^click to oracle Generate report button$")
    public void clickToOracleGenerateReportButton() {
        generateByDataSource("oracle");
    }

    @Then("^oracle generate button has to be with Cancel text$")
    public void oracleGenerateButtonHasToBeWithCancelText() {
        checkRunning("oracle");
    }

    @When("^click to copy characterization$")
    public void clickToCopyCharacterization() {
        copyAction();
    }

    @When("^enter \"([^\"]*)\" and name of our characterization$")
    public void enterAndNameOfOurCharacterization(String arg0) {
        search(arg0 + characterizationName);
    }

    @Then("^can see copy of our characterization$")
    public void canSeeCopyOfOurCharacterization() {
        cohortTableName.shouldHave(text("COPY OF " + characterizationName));
    }

    @When("^click to Add Subgroup analyses$")
    public void clickToAddSubgroupAnalyses() {
        $(withText("New subgroup")).click();
    }

    @When("^enter Stratified by text \"([^\"]*)\"$")
    public void enterStratifiedByText(String arg0) {
        $("input.characterization-design__stratified-by").setValue(arg0);
    }

    @When("^click to add criteria to group button$")
    public void clickToAddCriteriaToGroupButton() {
        $(".criteriaGroup button").click();
    }

    @When("^click to Add Demographic point$")
    public void clickToAddDemographicPoint() {
        $(withText("Add Demographic")).click();
    }

    @Then("^can see Add attribute button$")
    public void canSeeAddAttributeButton() {
        $(".criteriaTable .btn-primary").shouldBe(visible);
    }

    @When("^click to New parameter button$")
    public void clickToNewParameterButton() {
        $$(".linked-entity-list__actions button").find(Condition.text("New parameter")).click();
    }

    @When("^enter name of parameter \"([^\"]*)\" and value \"([^\"]*)\" and click Submit button$")
    public void enterNameOfParameterAndValueAndClickSubmitButton(String arg0, String arg1) {
        $(".characterization-params-create-modal__modal-body input[placeholder='Name']").setValue(arg0);
        $(".characterization-params-create-modal__modal-body input[placeholder='Value']").setValue(arg1);
        $(".characterization-params-create-modal__modal-body button").click();
    }

    @Then("^can see our parameter \"([^\"]*)\" and value \"([^\"]*)\" in the table$")
    public void canSeeOurParameterAndValueInTheTable(String arg0, String arg1) {
        $("tbody .characterization-design__col-param-name").shouldHave(text(arg0));
        $("tbody .characterization-design__col-param-value").shouldHave(text(arg1));
    }

    private void generateByDataSource(String dataSourceName) {
        ANALYSIS_EXECUTION_LIST.find(Condition.matchesText(dataSourceName)).
                find(withText("Generate")).click();
    }

    private void checkRunning(String dataSourceName) {
        ANALYSIS_EXECUTION_LIST.find(Condition.text(dataSourceName)).
                find(withText("Cancel")).waitUntil(visible, 10000);
    }
}
