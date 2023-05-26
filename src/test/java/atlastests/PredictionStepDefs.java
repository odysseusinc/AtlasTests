package atlastests;

import atlastests.components.FormControl;
import atlastests.components.PageControl;
import atlastests.components.TablesControl;
import atlastests.components.TabsControl;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.time.Duration;

import static atlastests.components.StaticElements.EMPTY_TABLE;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class PredictionStepDefs implements TabsControl, PageControl, TablesControl, FormControl {
    private final ElementsCollection panelPrimary = $$(By.xpath("//*[@class='panel panel-primary']"));
    private String generatedString;
    private String newGeneratedString;
    private String targetCohort;

    @Then("^can see Prediction page$")
    public void canSeePredictionPage() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).shouldBe(visible, Duration.ofMillis(4000)).
                shouldHave(text("Patient Level Prediction"));
    }

    @When("^click to New Patient Level Prediction$")
    public void clickToNewPatientLevelPrediction() {
        $(By.xpath("//*[@class='prediction-browser__new-btn pull-right btn btn-sm btn-primary']")).click();
    }

    @Then("^can see creation page of Prediction$")
    public void canSeeCreationPageOfPrediction() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']")).shouldBe(visible, Duration.ofMillis(4000)).
                shouldHave(text("New Patient Level Prediction"));
        $$(By.xpath("//*[@class='panel-heading']")).get(0).shouldHave(text("Prediction Problem Settings"));
    }

    @When("^enter name on new Prediction$")
    public void enterNameOnNewPrediction() {
        generatedString = RandomStringUtils.randomAlphanumeric(10);
        generatedString = "Test_" + generatedString;
        $(".asset-heading input").setValue(generatedString);
    }

    @When("^click to save Prediction Button$")
    public void clickToSavePredictionButton() {
        saveAction();
    }

    @Then("^can see new buttons in Prediction field$")
    public void canSeeNewButtonsInPredictionField() {
        $(By.xpath("//*[@title='Close']")).shouldBe(visible, Duration.ofMillis(15000));
        $(By.xpath("//*[@title='Create a copy']")).shouldBe(visible, Duration.ofMillis(1000));
        $(By.xpath("//*[@title='Delete']")).shouldBe(visible, Duration.ofMillis(1000));
    }

    @When("^click to cancel button in Prediction$")
    public void clickToCancelButtonInPrediction() {
        $(By.xpath("//*[@title='Close']")).shouldBe(visible, Duration.ofMillis(5500)).click();
    }

    @When("^enter name of our Prediction in filter$")
    public void enterNameOfOurPredictionInFilter() {
        $(By.xpath("//*[@type='search']")).setValue(generatedString);
    }

    @Then("^can see our Prediction in table$")
    public void canSeeOurPredictionInTable() {
        $(By.xpath("//table/tbody/tr/td[2]")).shouldHave(text(generatedString));
    }

    @When("^click to our Prediction$")
    public void clickToOurPrediction() {
        $(By.xpath("//table/tbody/tr/td[2]/a")).click();
    }

    @Then("^can see our Prediction$")
    public void canSeeOurPrediction() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).shouldBe(visible, Duration.ofMillis(4000)).
                shouldHave(text("Patient Level Prediction #"));
    }

    @When("^enter new name of Prediction$")
    public void enterNewNameOfPrediction() {
        newGeneratedString = RandomStringUtils.randomAlphanumeric(10);
        newGeneratedString = "Test_" + newGeneratedString;
        $(By.xpath("//*[@type='text']")).setValue(newGeneratedString);
    }

    @When("^enter name of new Prediction in filter$")
    public void enterNameOfNewPredictionInFilter() {
        $(By.xpath("//*[@type='search']")).setValue(newGeneratedString);
    }

    @Then("^can see new Prediction in table$")
    public void canSeeNewPredictionInTable() {
        $(By.xpath("//table/tbody/tr/td[2]")).shouldHave(text(newGeneratedString));
    }

    @When("^click to new Prediction$")
    public void clickToNewPrediction() {
        $(By.xpath("//table/tbody/tr/td[2]/a")).click();
    }

    @When("^click to delete Prediction button$")
    public void clickToDeletePredictionButton() {
        $(By.xpath("//*[@title='Delete']")).click();
    }

    @When("^accept delete Prediction alert$")
    public void acceptDeletePredictionAlert() {
        switchTo().alert().accept();
    }

    @Then("^cant find Prediction in table$")
    public void cantFindPredictionInTable() {
        search(generatedString);
        EMPTY_TABLE.shouldHave(text("No matching records found"));
    }

    @When("^click to Prediction Problem Settings tab$")
    public void clickToPredictionProblemSettingsTab() {
        $("#filters").find(withText("Prediction Problem Settings")).click();
    }

    @When("^click to Prediction Problem Settings tab without ee$")
    public void clickToPredictionProblemSettingsTabWithoutEE() {
        $(By.xpath("//*[@id='filters']/div/div[2]/ul/li[2]/a")).click();
    }

    @Then("^can see Prediction Problem Settings page$")
    public void canSeePredictionProblemSettingsPage() {
        panelPrimary.get(1).shouldBe(Condition.enabled, Duration.ofMillis(5000)).shouldNotBe(visible);
    }

    @When("^click to Analysis Setting tab in Prediction$")
    public void clickToAnalysisSettingTabInPrediction() {
        $(By.xpath("//*[@class='pull-left']/ul/li[3]")).click();
    }

    @Then("^can see Analysis Setting page in Prediction$")
    public void canSeeAnalysisSettingPageInPrediction() {
        panelPrimary.get(0).shouldNotBe(visible);
    }

    @When("^click to Execution Setting tab in Prediction$")
    public void clickToExecutionSettingTabInPrediction() {
        $(By.xpath("//*[@class='pull-left']/ul/li[4]")).click();
    }

    @When("^click to Execution Setting tab in Prediction without ee$")
    public void clickToExecutionSettingTabInPredictionWithoutEE() {
        $$("#filters li").find(Condition.matchText("Execution Settings")).click();
    }

    @Then("^can see Execution Setting page in Prediction$")
    public void canSeeExecutionSettingPageInPrediction() {
        panelPrimary.get(0).shouldNotBe(visible);
        panelPrimary.get(1).shouldNotBe(visible);
    }

    @When("^click to Training Settings tab in Prediction$")
    public void clickToTrainingSettingsTabInPrediction() {
        $(By.xpath("//*[@class='pull-left']/ul/li[5]")).click();
    }

    @Then("^can see Training Settings page in Prediction$")
    public void canSeeTrainingSettingsPageInPrediction() {
        for (int i = 0; i < 3; i++) {
            panelPrimary.get(i).shouldNotBe(visible);
        }
    }

    @When("^click to Executions tab in Prediction$")
    public void clickToExecutionsTabInPrediction() {
        chooseTab("Executions");
    }

    @Then("^can see Execution page in Prediction$")
    public void canSeeExecutionPageInPrediction() {
       checkExecutionTitle();
    }

    @When("^click to Utilities tab in Prediction$")
    public void clickToUtilitiesPageInPrediction() {
        chooseTab("Utilities");
    }

    @Then("^can see Utilities page in Prediction$")
    public void canSeeUtilitiesPageInPrediction() {
       $(".prediction-utilities").shouldBe(visible);
    }

    @When("^click to add Target Cohort in Predictions$")
    public void clickToAddTargetCohortInPredictions() {
        $(withText("Add Target Cohort")).click();
    }

    @When("^enter \"([^\"]*)\" in filter in cohort definition window in Predictions$")
    public void enterInFilterInCohortDefinitionWindowInPredictions(String arg0) {
        facetedTableSearch(arg0);
        selectInTableResults(arg0);
        targetCohort = $$(".atlas-modal__modal-body cohort-definition-browser tr a").
                find(matchText(arg0)).getText();
    }

    @When("^click to result in cohort in Predictions$")
    public void clickToResultInCohortInPredictions() {
        importButtonClick();
    }

    @Then("^can see selected cohort in Prediction Target table$")
    public void canSeeChoosedCohortInPredictionTargetTable() {
        Assert.assertEquals(targetCohort, $(By.xpath("//table/tbody/tr/td[2]")).getText());
    }

    @When("^click to add Outcome Cohort in Predictions$")
    public void clickToAddOutcomeCohortInPredictions() {
        $(withText("Add Outcome Cohort")).click();
    }

    @Then("^can see selected cohort in Prediction Outcome table$")
    public void canSeeChoosedCohortInPredictionOutcomeTable() {
        Assert.assertEquals(targetCohort, $$(By.xpath("//table/tbody/tr/td[2]")).get(1).getText());
    }

    @When("^click to Add Model Settings button$")
    public void clickToAddModelSettingsButton() {
        $(withText("Add Model Settings")).click();
    }

    @When("^choose model: \"([^\"]*)\"$")
    public void chooseModel(String modelName) {
        $$(".dropdown-menu [href='#']").find(matchText(modelName)).click();
    }

    @Then("^can see header for: \"([^\"]*)\"$")
    public void checkEditorHeading(String modelName) {
        $(".editor-heading").shouldHave(matchText(modelName));
    }

    @When("^click to return back button$")
    public void clickToReturnBackButton() {
        $(".editor-back-icon").click();
    }

    @Then("^can see Row in Analysis Setting table$")
    public void canSeeRowInAnalysisSettingTable() {
        $$(By.xpath("//table/tbody/tr/td[2]")).get(2).shouldHave(text("LassoLogisticRegressionSettings"));
    }

    @When("^click to Add Covariate button$")
    public void clickToAddCovariateButton() {
       $(withText("Add Covariate Settings")).click();
    }

    @Then("^can see Row in Covariate table$")
    public void canSeeRowInCovariateTable() {
        $$(By.xpath("//table/tbody/tr/td[2]")).get(3).shouldHave(text("DemographicsGender, DemographicsAgeGroup, DemographicsRace, DemographicsEthnicity, DemographicsIndexMonth, ConditionGroupEraLongTerm"));
    }

    @When("^click to Add Population button$")
    public void clickToAddPopulationButton() {
        $(withText("Add Population Settings")).click();
    }

    @Then("^can see Row in Population table$")
    public void canSeeRowInPopulationTable() {
        $$(By.xpath("//table/tbody/tr/td[2]")).get(4).shouldHave(text("1d from"));
    }

    @Then("^can see Review and Download table with selected model: \"([^\"]*)\"$")
    public void canSeeReviewAndDownloadTableWithSelectedTargetCohort(String modelName) {
        $$(By.xpath("//table/tbody/tr/td[3]")).get(2).shouldHave(matchText(modelName.
                replaceAll( "\\s+","")));
    }
}
