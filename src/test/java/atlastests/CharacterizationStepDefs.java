package atlastests;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CharacterizationStepDefs {

    private String characterizationName;
    private String featureName;


    @Then("^can see Characterization page$")
    public void canSeeCharaterizationPage() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).shouldHave(text("Cohort Characterizations"));
    }

    @When("^click to New characterization button$")
    public void clickToNewCharacterizationButton() {
        $(byText("New Characterization")).click();
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).shouldHave(text("New Characterization"));

    }

    @When("^enter Characterization name and save it$")
    public void enterCharacterizationNameAndSaveIt() {
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        characterizationName = "Test_" + generatedString;
        $(By.xpath("//*[@class='input-group']/input")).setValue(characterizationName);
        $(By.xpath("//*[@class='fa fa-save']")).click();
    }

    @When("^return to Characterization table$")
    public void returnToCharacterizationTable() {
        $$(By.xpath("//*[@class='btn btn-primary']")).get(0).click();
    }

    @When("^enter created characterization name in filter$")
    public void enterCreatedCharacterizationNameInFilter() {
        $(By.xpath("//*[@type='search']")).waitUntil(visible, 3000).setValue(characterizationName);
    }

    @Then("^can see new characterization in table$")
    public void canSeeNewCharacterizationInTable() {
        $(By.xpath("//*[@class=' characterizations-list__tbl-col characterizations-list__tbl-col--name ']/a")).
                shouldHave(text(characterizationName));
    }

    @When("^click to our characterization$")
    public void clickToOurCharacterization() {
        $(By.xpath("//*[@class=' characterizations-list__tbl-col characterizations-list__tbl-col--name ']/a")).click();

    }

    @When("^click to delete characterization button$")
    public void clickToDeleteCharacterizationButton() {
        $(By.xpath("//*[@class='btn btn-danger']")).waitUntil(visible, 3000).click();
     }

    @When("^accept delete characterization$")
    public void acceptDeleteCharacterization() {
        switchTo().alert().accept();
    }

    @Then("^cant find characterization in the table$")
    public void cantFindCharacterizationInTheTable() {
        $(By.xpath("//*[@type='search']")).waitUntil(visible, 3000).setValue(characterizationName);
        $(By.xpath("//*[@class=' characterizations-list__tbl-col characterizations-list__tbl-col--name ']/a")).
                shouldNotHave(text(characterizationName));
    }

    @When("^click to Import Cohort Definition$")
    public void clickToImportCohortDefinition() {
        $$(byText("Import")).get(0).waitUntil(visible, 3000).click();
    }

    @When("^choose cohort definition from the table in characterization$")
    public void chooseCohortDefinitionFromTheTableInCharacterization() {
        $(By.xpath("//*[@class='col-xs-6 search']/div/label/input")).setValue("test");
        $(By.xpath("//table/tbody/tr/td[2]/span")).shouldHave(text("test")).click();
    }


    @When("^click to Feature Analyses tab$")
    public void clickToFeatureAnalysesTab() {
        $(By.xpath("//*[@class='characterizations-tabbed-grid__toolbar-nav nav nav-tabs']/li[2]/a")).click();
        $(By.xpath("//*[@class='characterizations-tabbed-grid__new-entity-btn btn btn-primary btn-sm']")).waitUntil(visible, 4000);
    }

    @Then("^can see Feature Analyses table$")
    public void canSeeFeatureAnalysesTable() {
        $(By.xpath("//table/tbody/tr")).waitUntil(visible, 5000);
    }

    @When("^click to New Feature analyses$")
    public void clickToNewFeatureAnalyses() {
        $(By.xpath("//*[@class='characterizations-tabbed-grid__new-entity-btn btn btn-primary btn-sm']")).click();
    }

    @Then("^can see page of creation New Feature Analyse$")
    public void canSeePageOfCreationNewFeatureAnalyse() {
        $(By.xpath("//*[@class='panel-heading']")).waitUntil(visible, 4000);
    }

    @When("^enter description$")
    public void enterDescription() {
        $(By.xpath("//*[@class='feature-analysis-view-edit__descr form-control']")).setValue("TEST DESCRIPTION");
    }

    @When("^choose Criteria design$")
    public void chooseCriteriaDesign() {
        $(By.xpath("//*[@class='feature-analysis-view-edit__type-selector']/ul/li[1]")).click();
        $(By.xpath("//*[@class='feature-analysis-view-edit__criteria-name form-control']")).waitUntil(visible, 3000);
    }

    @When("^enter name of New Feature Analyse$")
    public void enterNameOfNewFeatureAnalyse() {
        String generatedStringFeature = RandomStringUtils.randomAlphanumeric(10);
        featureName = "Test_" + generatedStringFeature;
        $(By.xpath("//*[@class='input-group']/input")).setValue(featureName);
    }

    @When("^click to save feature analyse button$")
    public void clickToSaveFeatureAnalyseButton() {
        $(By.xpath("//*[@class='btn btn-success']")).click();
    }

    @Then("^go to feature analyses table by pressing close button$")
    public void goToFeatureAnalysesTableByPressingCloseButton() {
        $(By.xpath("//*[@class='fa fa-times']")).waitUntil(visible, 5000).click();;
    }

    @When("^enter name of our feature to filter$")
    public void enterNameOfOurFeatureToFilter() {
        $(By.xpath("//*[@type='search']")).setValue(featureName);
    }

    @Then("^can see our feature in table of feature analyses$")
    public void canSeeOurFeatureInTableOfFeatureAnalyses() {
        $(By.xpath("//*[@class=' feature-analyses-list__tbl-col feature-analyses-list__tbl-col--name ']")).shouldHave(text(featureName));
    }

    @When("^click to our feature analyse$")
    public void clickToOurFeatureAnalyse() {
        $(By.xpath("//*[@class=' feature-analyses-list__tbl-col feature-analyses-list__tbl-col--name ']/a")).click();
    }

    @Then("^can see page of our Feature Analyse$")
    public void canSeePageOfOurFeatureAnalyse() {
        $(By.xpath("//*[@data-bind='text: title'][1]")).waitUntil(visible, 3000).
                shouldHave(text("Feature Analysis #"));
    }


    @When("^click to delete feature analyse$")
    public void clickToDeleteFeatureAnalyse() {
        $(By.xpath("//*[@class='btn btn-danger']")).click();
    }

    @When("^accept delete feature analyse$")
    public void acceptDeleteFeatureAnalyse() {
        switchTo().alert().accept();
    }

    @Then("^cant find feature analyse in the table$")
    public void cantFindFeatureAnalyseInTheTable() {
        $(By.xpath("//*[@type='search']")).setValue(featureName);
        $(By.xpath("//*[@class=' feature-analyses-list__tbl-col feature-analyses-list__tbl-col--name ']")).
                shouldNotHave(text(featureName));
    }

    @When("^click to Import Feature analyses$")
    public void clickToImportFeatureAnalyses() {
        $$(byText("Import")).get(1).click();
    }

    @Then("^can see Feature analyses window$")
    public void canSeeFeatureAnalysesWindow() {
        $(By.xpath("//*[@class='atlas-modal__modal-dialog modal-dialog characterization-design__feature-" +
                "analyses-modal']/div/div[1]/div")).waitUntil(visible, 4000).shouldHave(text("Choose a Feature analyses"));
    }

    @Then("^Feature analyse table is visible$")
    public void featureAnalyseTableIsVisible() {
        $(By.xpath("//*[@class='characterization-design__col-feature-id sorting_asc']")).waitUntil(visible, 3000);


    }


    @When("^click to Import Feature analyse$")
    public void clickToImportFeatureAnalyse() {
        $(By.xpath("//*[@class='characterization-design__button-panel']/button[1]")).click();

    }

    @When("^enter the same Characterization name and save it$")
    public void enterTheSameCharacterizationNameAndSaveIt() {
        $(By.xpath("//*[@class='input-group']/input")).setValue(characterizationName);
        $(By.xpath("//*[@class='fa fa-save']")).click();
    }

    @Then("^can see alert message about uniqueness$")
    public void canSeeAlertMessageAboutUniqueness() {
        switchTo().alert().accept();
    }

    @When("^choose cohort definition \"([^\"]*)\" from the table in characterization$")
    public void chooseCohortDefinitionFromTheTableInCharacterization(String arg0) {
        $(By.xpath("//*[@class='col-xs-6 search']/div/label/input")).setValue(arg0);
        $(By.xpath("//table/tbody/tr/td[2]/span")).shouldHave(text(arg0)).click();
    }

    @Then("^can see cohort definition in characterization list with text \"([^\"]*)\"$")
    public void canSeeCohortDefinitionInCharacterizationListWithText(String arg0) {
        $(By.xpath("//table/tbody/tr/td[2]")).waitUntil(visible, 2000).shouldHave(text(arg0));
    }

    @When("^click to feature checkbox with text \"([^\"]*)\" from Feature analyses$")
    public void clickToFeatureCheckboxWithTextFromFeatureAnalyses(String arg0) {
        $(By.xpath("//*[@class='facetedDataTable']/div/div[2]/label/input")).setValue(arg0);
        $(By.xpath("//*[@class='fa fa-check'][1]")).click();
    }

    @Then("^can see result of our search \"([^\"]*)\" and \"([^\"]*)\"$")
    public void canSeeResultOfOurSearchAnd(String arg0, String arg1) {
        $$(By.xpath("//*[@class=' characterization-design__col-feature-name ']")).get(0).shouldHave(text(arg0));
        $$(By.xpath("//*[@class=' characterization-design__col-feature-name ']")).get(1).shouldHave(text(arg1));
    }

    @When("^click to save Chacterization$")
    public void clickToSaveChacterization() {
        $(By.xpath("//*[@class='fa fa-save']")).click();
    }

    @When("^click Remove first Feature Analyse from the table$")
    public void clickRemoveFirstFeatureAnalyseFromTheTable() {
        $(By.xpath("//*[@class=' characterization-design__col-feature-remove ']/a")).click();
    }

    @When("^click to Executions tab in Characterizations$")
    public void clickToExecutionsTabInCharacterizations() {
        $(By.xpath("//*[@class='tabs__header']/span[2]")).click();
    }

    @When("^click Generate report button on first data source$")
    public void clickToGenerateReportButtonOnFirstDataSource() {
        $$(By.xpath("//*[@class='characterization-view-edit-executions__action-text']")).get(0).click();
    }

    @Then("^first data source generate button has to be with Cancel text$")
    public void firstGenerateButtonHasToBeWithCancelText() {
        $$(By.xpath("//*[@class='btn btn-sm btn-danger']")).get(0).waitUntil(text("Cancel"), 4000);
    }

    @When("^click to Netezza Generate report button$")
    public void clickToNetezzaGenerateReportButton() {
        $$(By.xpath("//*[@class='characterization-view-edit-executions__action-text']")).get(1).click();
    }

    @Then("^Netezza generate button has to be with Cancel text$")
    public void netezzaGenerateButtonHasToBeWithCancelText() {
        $$(By.xpath("//*[@class='btn btn-sm btn-danger']")).get(0).waitUntil(text("Cancel"), 4000);
    }

    @When("^click to SynPUF(\\d+)k Generate report button$")
    public void clickToSynPUFKGenerateReportButton(int arg0) {
        $$(By.xpath("//*[@class='characterization-view-edit-executions__action-text']")).get(5).click();
    }

    @Then("^SynPUF(\\d+)k generate button has to be with Cancel text$")
    public void synpufKGenerateButtonHasToBeWithCancelText(int arg0) {
        $$(By.xpath("//*[@class='btn btn-sm btn-danger']")).get(0).waitUntil(text("Cancel"), 15000);
    }

    @When("^click to oracle Generate report button$")
    public void clickToOracleGenerateReportButton() {
        $$(By.xpath("//*[@class='characterization-view-edit-executions__action-text']")).get(9).click();
    }

    @Then("^oracle generate button has to be with Cancel text$")
    public void oracleGenerateButtonHasToBeWithCancelText() {
        $$(By.xpath("//*[@class='btn btn-sm btn-danger']")).get(0).waitUntil(text("Cancel"), 15000);
    }

    @When("^click to copy characterization$")
    public void clickToCopyCharacterization() {
        $(By.xpath("//*[@class='btn btn-primary'][2]")).click();
    }

    @When("^enter \"([^\"]*)\" and name of our characterization$")
    public void enterAndNameOfOurCharacterization(String arg0) {
        $(By.xpath("//*[@type='search']")).setValue(arg0 + characterizationName);
    }

    @Then("^can see copy of our characterization$")
    public void canSeeCopyOfOurCharacterization() {
        $(By.xpath("//*[@class=' characterizations-list__tbl-col characterizations-list__tbl-col--name ']/a")).
                shouldHave(text("COPY OF: " + characterizationName));

    }

    @When("^click to Add Subgroup analyses$")
    public void clickToAddSubgroupAnalyses() {
        $(By.xpath("//*[@class='characterization-design btn btn-sm btn-primary']")).click();
    }

    @Then("^can see Stratified input and subgroup table$")
    public void canSeeStratifiedInputAndSubgroupTable() {
        $(By.xpath("//*[@class='characterization-design__stratified-by form-control']")).shouldBe(visible);
    }

    @When("^enter Stratified by text \"([^\"]*)\"$")
    public void enterStratifiedByText(String arg0) throws Throwable {
        $(By.xpath("//*[@class='characterization-design__stratified-by form-control']")).setValue(arg0);
    }

    @When("^click to add criteria to group button$")
    public void clickToAddCriteriaToGroupButton() {
        $(By.xpath("//*[@class='drop-down-menu btn btn-primary btn-sm dropdown-toggle']/span[2]")).click();

    }

    @When("^click to Add Demographic point$")
    public void clickToAddDemographicPoint() {
        $(By.xpath("//*[@class='drop-down-menu dropdown-menu']/li/a/div[1]")).click();
    }

    @Then("^can see Add attribute button$")
    public void canSeeAddAttributeButton() {
        $(By.xpath("//*[@class='btn btn-primary btn-sm dropdown-toggle']")).shouldBe(visible);
    }

    @When("^click to New parameter button$")
    public void clickToNewParameterButton() {
        $$(By.xpath("//*[@class='linked-entity-list__btn btn btn-primary btn-sm']")).get(2).click();
    }

    @When("^enter name of parameter \"([^\"]*)\" and value \"([^\"]*)\" and click Submit button$")
    public void enterNameOfParameterAndValueAndClickSubmitButton(String arg0, String arg1) {
        $$(By.xpath("//*[@class='form-control']")).get(1).setValue(arg0);
        $$(By.xpath("//*[@class='form-control']")).get(2).setValue(arg1);
        $(By.xpath("//*[@class='btn btn-default']")).click();
    }

    @Then("^can see our parameter \"([^\"]*)\" and value \"([^\"]*)\" in the table$")
    public void canSeeOurParameterAndValueInTheTable(String arg0, String arg1) {
        $(By.xpath("//*[@class='characterization-design__col-param-name sorting_1']")).shouldHave(text(arg0));
        $(By.xpath("//*[@class=' characterization-design__col-param-value ']")).shouldHave(text(arg1));

    }
}
