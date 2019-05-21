package odysseusAT;

import com.codeborne.selenide.Selectors;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PredictionStepDefs {

    private String generatedString;
    private String newGeneratedString;
    private String targetCohort;

    @Then("^can see Prediction page$")
    public void canSeePredictionPage() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).waitUntil(visible, 4000);
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).shouldHave(text("Patient Level Prediction"));
    }

    @When("^click to New Patient Level Prediction$")
    public void clickToNewPatientLevelPrediction() {
        $(By.xpath("//*[@class='prediction-browser__new-btn pull-right btn btn-sm btn-primary']")).click();
    }

    @Then("^can see creation page of Prediction$")
    public void canSeeCreationPageOfPrediction(){
        $(By.xpath("//*[@class='heading-title heading-title--dark']")).waitUntil(visible, 4000);
        $(By.xpath("//*[@class='heading-title heading-title--dark']")).shouldHave(text("New Patient Level Prediction"));
        $$(By.xpath("//*[@class='panel-heading']")).get(0).shouldHave(text("Prediction Problem Settings"));
    }

    @When("^enter name on new Prediction$")
    public void enterNameOnNewPrediction() {
        generatedString = RandomStringUtils.randomAlphanumeric(10);
        generatedString = "Test_"+ generatedString;
        $$(By.xpath("//*[@type='text']")).get(0).clear();
        $$(By.xpath("//*[@type='text']")).get(0).setValue(generatedString);

    }

    @When("^click to save Prediction Button$")
    public void clickToSavePredictionButton() {
        $(By.xpath("//*[@class='fa fa-save']")).click();
    }

    @Then("^can see new buttons in Prediction field$")
    public void canSeeNewButtonsInPredictionField() throws InterruptedException {
        Thread.sleep(2000);
        $(By.xpath("//*[@title='Close']")).waitUntil(visible,1000);
        $(By.xpath("//*[@title='Copy']")).waitUntil(visible,1000);
        $(By.xpath("//*[@title='Delete']")).waitUntil(visible,1000);
    }

    @When("^click to cancel button in Prediction$")
    public void clickToCancelButtonInPrediction() {
        $(By.xpath("//*[@title='Close']")).waitUntil(visible,5500);
        $(By.xpath("//*[@title='Close']")).click();
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
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).waitUntil(visible,4000);
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).shouldHave(text("Patient Level Prediction #"));
    }

    @When("^enter new name of Prediction$")
    public void enterNewNameOfPrediction() {
        newGeneratedString = RandomStringUtils.randomAlphanumeric(10);
        newGeneratedString = "Test_"+ newGeneratedString;
        $(By.xpath("//*[@type='text']")).clear();
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
        $(By.xpath("//table/tbody/tr/td[2]")).shouldNotHave(text(newGeneratedString));
    }

    @When("^click to Prediction Problem Settings tab$")
    public void clickToPredictionProblemSettingsTab() {
        $(By.xpath("//*[@class='pull-left']/ul/li[2]")).click();
    }

    @Then("^can see Prediction Problem Settings page$")
    public void canSeePredictionProblemSettingsPage() {
        $$(By.xpath("//*[@class='panel panel-primary']")).get(1).shouldNotBe(visible);
    }

    @When("^click to Analysis Setting tab in Prediction$")
    public void clickToAnalysisSettingTabInPrediction() {
        $(By.xpath("//*[@class='pull-left']/ul/li[3]")).click();
    }

    @Then("^can see Analysis Setting page in Prediction$")
    public void canSeeAnalysisSettingPageInPrediction() {
        $$(By.xpath("//*[@class='panel panel-primary']")).get(0).shouldNotBe(visible);
    }

    @When("^click to Execution Setting tab in Prediction$")
    public void clickToExecutionSettingTabInPrediction() {
        $(By.xpath("//*[@class='pull-left']/ul/li[4]")).click();
    }

    @Then("^can see Execution Setting page in Prediction$")
    public void canSeeExecutionSettingPageInPrediction() {
        $$(By.xpath("//*[@class='panel panel-primary']")).get(0).shouldNotBe(visible);
        $$(By.xpath("//*[@class='panel panel-primary']")).get(1).shouldNotBe(visible);
    }

    @When("^click to Training Settings tab in Prediction$")
    public void clickToTrainingSettingsTabInPrediction() {
        $(By.xpath("//*[@class='pull-left']/ul/li[5]")).click();
    }

    @Then("^can see Training Settings page in Prediction$")
    public void canSeeTrainingSettingsPageInPrediction() {
        $$(By.xpath("//*[@class='panel panel-primary']")).get(0).shouldNotBe(visible);
        $$(By.xpath("//*[@class='panel panel-primary']")).get(1).shouldNotBe(visible);
        $$(By.xpath("//*[@class='panel panel-primary']")).get(2).shouldNotBe(visible);
    }

    @When("^click to Executions tab in Prediction$")
    public void clickToExecutionsTabInPrediction() {
        $(By.xpath("//*[@class='tabs__header']/span[2]")).click();
    }

    @Then("^can see Execution page in Prediction$")
    public void canSeeExecutionPageInPrediction() {
        $(By.xpath("//*[@class='prediction-executions__title']")).waitUntil(visible,4000);
        $(By.xpath("//*[@class='prediction-executions__title']")).shouldHave(text("Generations"));
    }

    @When("^click to Utilities page in Prediction$")
    public void clickToUtilitiesPageInPrediction() {
        $(By.xpath("//*[@class='tabs__header']/span[3]")).click();
    }

    @Then("^can see Utilities page in Prediction$")
    public void canSeeUtilitiesPageInPrediction() {
        $$(By.xpath("//*[@class='active']/a")).get(1).waitUntil(visible,3000);
        $$(By.xpath("//*[@class='active']/a")).get(1).shouldHave(text("Review & Download"));
    }

    @When("^click to add Target Cohort in Predictions$")
    public void clickToAddTargetCohortInPredictions() {
        $$(By.xpath("//*[@class='btn btn-primary btn-sm pull-right']")).get(0).click();
    }

    @Then("^can see cohort definition window in Predictions$")
    public void canSeeCohortDefinitionWindowInPredictions() {
        $(By.xpath("//*[@class='linkish']")).waitUntil(visible,4000);
    }

    @When("^enter \"([^\"]*)\" in filter in cohort definition window in Predictions$")
    public void enterInFilterInCohortDefinitionWindowInPredictions(String arg0) throws Throwable {
        $$(By.xpath("//*[@type='search']")).get(5).setValue(arg0);
    }

    @When("^click to result in cohort in Predictions$")
    public void clickToResultInCohortInPredictions() {
        targetCohort = $(By.xpath("//table/tbody/tr/td[2]/span")).getText();
        $(By.xpath("//table/tbody/tr/td[2]/span")).click();
    }

    @Then("^can see choosed cohort in Prediction Target table$")
    public void canSeeChoosedCohortInPredictionTargetTable() {
        Assert.assertEquals(targetCohort, $(By.xpath("//table/tbody/tr/td[2]")).getText());
    }

    @When("^click to add Outcome  Cohort in Predictions$")
    public void clickToAddOutcomeCohortInPredictions() {
        $$(By.xpath("//*[@class='btn btn-primary btn-sm pull-right']")).get(1).click();
    }

    @Then("^can see choosed cohort in Prediction Outcome table$")
    public void canSeeChoosedCohortInPredictionOutcomeTable() {
        Assert.assertEquals(targetCohort, $$(By.xpath("//table/tbody/tr/td[2]")).get(1).getText());
    }

    @When("^click to Add Model Settings button$")
    public void clickToAddModelSettingsButton() {
        $(By.xpath("//*[@class='btn btn-primary btn-sm dropdown-toggle']")).click();
        $(By.xpath("//*[@class='dropdown-menu']/li/a")).click();
    }

    @Then("^can see Model Settings Page$")
    public void canSeeModelSettingsPage() {
        $(By.xpath("//*[@class='editor-heading']")).shouldHave(text("Lasso Logistic Regression Model Settings"));
    }

    @When("^click to return back button$")
    public void clickToReturnBackButton() {
        $(By.xpath("//*[@class='editor-back-icon']")).click();
    }

    @Then("^can see Row in Analysis Setting table$")
    public void canSeeRowInAnalysisSettingTable() {
        $$(By.xpath("//table/tbody/tr/td[2]")).get(2).shouldHave(text("LassoLogisticRegressionSettings"));
    }

    @When("^click to Add Covariate button$")
    public void clickToAddCovariateButton() {
        $$(By.xpath("//*[@class='btn btn-primary btn-sm pull-right']")).get(2).click();
    }

    @Then("^can see Covariate Page$")
    public void canSeeCovariatePage() {
        $(By.xpath("//*[@class='editor-heading']")).shouldHave(text("Covariate Settings"));
    }

    @Then("^can see Row in Covariate table$")
    public void canSeeRowInCovariateTable() {
        $$(By.xpath("//table/tbody/tr/td[2]")).get(3).shouldHave(text("DemographicsGender, DemographicsAgeGroup, DemographicsRace, DemographicsEthnicity, DemographicsIndexMonth, ConditionGroupEraLongTerm"));
    }

    @When("^click to Add Population button$")
    public void clickToAddPopulationButton() {
        $$(By.xpath("//*[@class='btn btn-primary btn-sm pull-right']")).get(3).click();

    }

    @Then("^can see Population Page$")
    public void canSeePopulationPage() {
        $(By.xpath("//*[@class='editor-heading']")).shouldHave(text("Population Settings"));
    }

    @Then("^can see Row in Population table$")
    public void canSeeRowInPopulationTable() {
        $$(By.xpath("//table/tbody/tr/td[2]")).get(4).shouldHave(text("1d from"));
    }
}
