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
import org.openqa.selenium.By;

import java.time.Duration;

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


    @Step ("Then can see Characterization page")
    @Then("^can see Characterization page$")
    public void canSeeCharaterizationPage() {
        checkPageHeader("Cohort Characterizations");
    }

    @Step ("When click to New characterization button")
    @When("^click to New characterization button$")
    public void clickToNewCharacterizationButton() {
        $(byText("New Characterization")).click();
        checkPageHeader("New Characterization");
    }

    @Step ("enter Characterization name save it")
    @When("^enter Characterization name and save it$")
    public void enterCharacterizationNameAndSaveIt() {
        characterizationName = "Test_" + RandomStringUtils.randomAlphanumeric(10);
        setTitle(characterizationName);
        saveAction();
    }

    @Step ("return to Characterization table")
    @When("^return to Characterization table$")
    public void returnToCharacterizationTable() {
        closeAction();
    }

    @Step ("enter created characterization name in filter")
    @When("^enter created characterization name in filter$")
    public void enterCreatedCharacterizationNameInFilter() {
        search(characterizationName);
    }

    @Step ("can see new characterization in table")
    @Then("^can see new characterization in table$")
    public void canSeeNewCharacterizationInTable() {
        cohortTableName.shouldHave(text(characterizationName));
    }

    @Step ("click to our characterization")
    @When("^click to our characterization$")
    public void clickToOurCharacterization() {
        cohortTableName.click();
    }

    @Step ("click to delete characterization button")
    @When("^click to delete characterization button$")
    public void clickToDeleteCharacterizationButton() {
        deleteAction();
    }

    @Step ("accept delete characterization")
    @When("^accept delete characterization$")
    public void acceptDeleteCharacterization() {
        Selenide.confirm();
    }

    @Step ("cant find characterization in the table ")
    @Then("^cant find characterization in the table$")
    public void cantFindCharacterizationInTheTable() {
        search(characterizationName);
        EMPTY_TABLE.shouldHave(text("No matching records found"));
    }

    @Step ("click to Import Cohort Definition")
    @When("^click to Import Cohort Definition$")
    public void clickToImportCohortDefinition() {
        $$(byText("Import")).get(0).shouldBe(visible, Duration.ofMillis(5000)).click();
    }

    @Step ("click to Feature Analyses tab")
    @When("^click to Feature Analyses tab$")
    public void clickToFeatureAnalysesTab() {
        $$("[role='presentation']").find(Condition.matchText("Feature analyses")).click();
        $(".btn-primary").shouldHave(text("New Feature analysis"), Duration.ofMillis(5000));
    }

    @Step ("can see Feature Analyses table")
    @Then("^can see Feature Analyses table$")
    public void canSeeFeatureAnalysesTable() {
        $(".facetedDataTable tbody").shouldBe(visible, Duration.ofMillis(10000));
    }

    @Step ("click to New Feature analyses")
    @When("^click to New Feature analyses$")
    public void clickToNewFeatureAnalyses() {
        $(byText("New Feature analysis")).click();
    }

    @Step ("can see page of cretion New Feature Analyses")
    @Then("^can see page of creation New Feature Analyse$")
    public void canSeePageOfCreationNewFeatureAnalyse() {
        checkPageHeader("New Feature Analysis");
    }

    @Step ("enter description to Analyse")
    @When("^enter description$")
    public void enterDescription() {
        $(".feature-analysis-design__descr").setValue("TEST DESCRIPTION");
    }

    @Step ("choose Criteria design ")
    @When("^choose Criteria design$")
    public void chooseCriteriaDesign() {
        $$(".feature-analysis-design__type-selector li").find(text("Criteria")).click();
    }

    @Step ("enter name of New Feature Analyse")
    @When("^enter name of New Feature Analyse$")
    public void enterNameOfNewFeatureAnalyse() {
        featureName = "Test_" + RandomStringUtils.randomAlphanumeric(10);
        setTitle(featureName);
    }

    @Step ("click to save feature analyse button")
    @When("^click to save feature analyse button$")
    public void clickToSaveFeatureAnalyseButton() {
        saveAction();
    }

    @Step ("go to feature analyses table by pressing close button")
    @Then("^go to feature analyses table by pressing close button$")
    public void goToFeatureAnalysesTableByPressingCloseButton() {
        closeAction();
    }

    @Step ("enter name of our feature to filter")
    @When("^enter name of our feature to filter$")
    public void enterNameOfOurFeatureToFilter() {
        search(featureName);
    }

    @Step ("can see our feature in table of feature analyses")
    @Then("^can see our feature in table of feature analyses$")
    public void canSeeOurFeatureInTableOfFeatureAnalyses() {
        featureAnalysisTableName.shouldHave(text(featureName));
    }

    @Step ("click to our feature analyse")
    @When("^click to our feature analyse$")
    public void clickToOurFeatureAnalyse() {
        featureAnalysisTableName.shouldBe(visible, Duration.ofMillis(5000)).click();
    }

    @Step ("can see page of our Feature Analyse")
    @Then("^can see page of our Feature Analyse$")
    public void canSeePageOfOurFeatureAnalyse() {
        checkPageHeader("Feature Analysis #");
    }


    @Step ("click to delete feature analyse")
    @When("^click to delete feature analyse$")
    public void clickToDeleteFeatureAnalyse() {
        deleteAction();
    }

    @Step ("accept delete feature analyse")
    @When("^accept delete feature analyse$")
    public void acceptDeleteFeatureAnalyse() throws InterruptedException {
        switchTo().alert().accept();
    }

    @Step ("cant find feature analyse in the table")
    @Then("^cant find feature analyse in the table$")
    public void cantFindFeatureAnalyseInTheTable() {
        search(featureName);
        EMPTY_TABLE.shouldHave(text("No matching records found"));
    }

    @Step ("click to Import Feature analyses")
    @When("^click to Import Feature analyses$")
    public void clickToImportFeatureAnalyses() {
        $$(byText("Import")).get(1).click();
    }

    @Step ("can see Feature analyses window")
    @Then("^can see Feature analyses window$")
    public void canSeeFeatureAnalysesWindow() {
       checkModalTitle("Choose a Feature analyses");
    }

    @Step ("Feature analyse table is visible ")
    @Then("^Feature analyse table is visible$")
    public void featureAnalyseTableIsVisible() {
        featureAnalysisTableRows.first().shouldBe(visible, Duration.ofMillis(5000));
    }

    @Step ("click to Import Feature analyse")
    @When("^click to Import Feature analyse$")
    public void clickToImportFeatureAnalyse() {
        importButtonClick();
    }

    @Step ("enter the same Characterization name and save it")
    @When("^enter the same Characterization name and save it$")
    public void enterTheSameCharacterizationNameAndSaveIt() {
        setTitle(characterizationName);
        saveAction();
    }

    @Step ("can see alert message about uniqueness")
    @Then("^can see alert message about uniqueness$")
    public void canSeeAlertMessageAboutUniqueness() {
        switchTo().alert().accept();
    }

    @Step ("choose cohort definition")
    @When("^choose cohort definition \"([^\"]*)\" from the table in characterization$")
    public void chooseCohortDefinitionFromTheTableInCharacterization(String arg0) {
        facetedTableSearch(arg0);
        selectInTableResults(arg0);
        importButtonClick();
    }

    @Step ("Can see cohort definition in characterization list")
    @Then("^can see cohort definition in characterization list with text \"([^\"]*)\"$")
    public void canSeeCohortDefinitionInCharacterizationListWithText(String arg0) {
        $("tbody .linked-cohort-list__col-cohort-name").shouldBe(visible, Duration.ofMillis(5000)).
                shouldHave(matchText(arg0));
    }

    @Step ("click to feature checkbox with text")
    @When("^click to feature checkbox with text \"([^\"]*)\" from Feature analyses$")
    public void clickToFeatureCheckboxWithTextFromFeatureAnalyses(String arg0) {
        facetedTableSearch(arg0);
        selectInTableResults(arg0);
    }

    @Step ("can see result of our search")
    @Then("^can see result of our search \"([^\"]*)\" and \"([^\"]*)\"$")
    public void canSeeResultOfOurSearchAnd(String arg0, String arg1) {
        featureAnalysisTableRows.shouldHave(CollectionCondition.textsInAnyOrder(arg0, arg1));
    }

    @Step ("click to save Characterization")
    @When("^click to save Chacterization$")
    public void clickToSaveChacterization() {
        saveAction();
    }

    @Step ("click Remove first analyse from table")
    @When("^click Remove first Feature Analyse from the table$")
    public void clickRemoveFirstFeatureAnalyseFromTheTable() {
        $(By.xpath("//*[@class=' characterization-design__col-feature-remove ']/a")).click();
    }

    @Step ("Click to Execution tab")
    @When("^click to Executions tab in Characterizations$")
    public void clickToExecutionsTabInCharacterizations() {
        $$(".tabs__header-title").find(text("Executions")).click();
    }

    @Step ("click Generate report on first data source")
    @When("^click Generate report button on first data source$")
    public void clickToGenerateReportButtonOnFirstDataSource() {
        EXECUTION_ACTION_BUTTONS.get(0).click();
    }

    @Step ("first data source generate button has to have Cancel text")
    @Then("^first data source generate button has to be with Cancel text$")
    public void firstGenerateButtonHasToBeWithCancelText() {
        EXECUTION_ACTION_BUTTONS.get(0).shouldHave(text("Cancel"), Duration.ofMillis(5000));
    }

    @Step ("cilck to Netezza Generate report button")
    @When("^click to Netezza Generate report button$")
    public void clickToNetezzaGenerateReportButton() {
        generateByDataSource("Netezza");
    }

    @Step ("NEtezza generate button has to have Cancel text")
    @Then("^Netezza generate button has to be with Cancel text$")
    public void netezzaGenerateButtonHasToBeWithCancelText() {
        checkRunning("Netezza");
    }

    @Step ("Click to Generate report button")
    @When("^click to \"([^\"]*)\" Generate report button$")
    public void clickToSynPUFKGenerateReportButton(String arg0) {
        generateByDataSource(arg0);
    }

    @Step ("generate button text should change to Cancel")
    @Then("\"([^\"]*)\" generate button has to be with Cancel text$")
    public void synpufKGenerateButtonHasToBeWithCancelText(String arg0) {
        checkRunning(arg0);
    }

    @Step ("click to oracle Gene")
    @When("^click to oracle Generate report button$")
    public void clickToOracleGenerateReportButton() {
        generateByDataSource("oracle");
    }

    @Step ("oracle generate button has to be with Cancel text")
    @Then("^oracle generate button has to be with Cancel text$")
    public void oracleGenerateButtonHasToBeWithCancelText() {
        checkRunning("oracle");
    }

    @Step ("click to copy characterization")
    @When("^click to copy characterization$")
    public void clickToCopyCharacterization() {
        copyAction();
    }

    @Step ("enter name of our characterization ")
    @When("^enter \"([^\"]*)\" and name of our characterization$")
    public void enterAndNameOfOurCharacterization(String arg0) {
        search(arg0 + characterizationName);
    }

    @Step ("can see copy of our characterization")
    @Then("^can see copy of our characterization$")
    public void canSeeCopyOfOurCharacterization() {
        cohortTableName.shouldHave(text("COPY OF " + characterizationName));
    }

    @Step ("click to add subgroup analyses")
    @When("^click to Add Subgroup analyses$")
    public void clickToAddSubgroupAnalyses() {
        $(withText("New subgroup")).click();
    }

    @Step ("enter Stratified by text")
    @When("^enter Stratified by text \"([^\"]*)\"$")
    public void enterStratifiedByText(String arg0) {
        $("input.characterization-design__stratified-by").setValue(arg0);
    }

    @Step ("click to add criteria to group button")
    @When("^click to add criteria to group button$")
    public void clickToAddCriteriaToGroupButton() {
        $(".criteriaGroup button").click();
    }

    @Step ("click to Add Demographic point")
    @When("^click to Add Demographic point$")
    public void clickToAddDemographicPoint() {
        $(withText("Add Demographic")).click();
    }

    @Step ("can see Add attribute button")
    @Then("^can see Add attribute button$")
    public void canSeeAddAttributeButton() {
        $(".criteriaTable .btn-primary").shouldBe(visible);
    }

    @Step ("click to New parameter button")
    @When("^click to New parameter button$")
    public void clickToNewParameterButton() {
        $$(".linked-entity-list__actions button").find(Condition.text("New parameter")).click();
    }

    @Step ("enter name of parameter")
    @When("^enter name of parameter \"([^\"]*)\" and value \"([^\"]*)\" and click Submit button$")
    public void enterNameOfParameterAndValueAndClickSubmitButton(String arg0, String arg1) {
        $(".characterization-params-create-modal__modal-body input[placeholder='Name']").setValue(arg0);
        $(".characterization-params-create-modal__modal-body input[placeholder='Value']").setValue(arg1);
        $(".characterization-params-create-modal__modal-body button").click();
    }

    @Step ("can see our parameter and value in table")
    @Then("^can see our parameter \"([^\"]*)\" and value \"([^\"]*)\" in the table$")
    public void canSeeOurParameterAndValueInTheTable(String arg0, String arg1) {
        $("tbody .characterization-design__col-param-name").shouldHave(text(arg0));
        $("tbody .characterization-design__col-param-value").shouldHave(text(arg1));
    }

    private void generateByDataSource(String dataSourceName) {
        ANALYSIS_EXECUTION_LIST.find(Condition.matchText(dataSourceName)).
                find(withText("Generate")).click();
    }

    private void checkRunning(String dataSourceName) {
        ANALYSIS_EXECUTION_LIST.find(Condition.text(dataSourceName)).
                find(withText("Cancel")).shouldBe(visible, Duration.ofMillis(10000));
    }
}
