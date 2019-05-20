package odysseusAT;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PredictionStepDefs {

    private String generatedString;
    private String newGeneratedString;

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
    public void canSeeNewButtonsInPredictionField() {
        $(By.xpath("//*[@title='Close']")).waitUntil(visible,1000);
        $(By.xpath("//*[@title='Copy']")).waitUntil(visible,1000);
        $(By.xpath("//*[@title='Delete']")).waitUntil(visible,1000);
    }

    @When("^click to cancel button in Prediction$")
    public void clickToCancelButtonInPrediction() {
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
        $(By.xpath("//table/tbody/tr/td[2]")).click();
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
        $(By.xpath("//table/tbody/tr/td[2]")).click();
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

    }
}
