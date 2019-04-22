package odysseusAT;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class IncidenceRatesStepDefs {
    private String generatedString;
    private String newGeneratedString;
    @Then("^can see Incidence Rates page$")
    public void canSeeIncidenceRatesPage() {
        $(By.xpath("//*[@data-bind='text: title']")).waitUntil(visible, 4000);
        $(By.xpath("//*[@data-bind='text: title']")).shouldHave(text("Incidence Rate Analysis"));

    }

    @When("^click to New Analysis button in Incidence Rates$")
    public void clickToNewAnalysisButtonInIncidenceRates() {
        $(By.xpath("//*[@class='pull-right btn btn-sm btn-primary']")).click();
        
    }

    @Then("^can see Incidence Rates creation page$")
    public void canSeeIncidenceRatesCreationPage() {
        $(By.xpath("//*[@data-bind='text: title']")).shouldHave(text("New Incidence Rate Analysis"));
    }

    @When("^enter name on new Incidence Rates$")
    public void enterNameOnNewIncidenceRates() {
        generatedString = RandomStringUtils.randomAlphanumeric(10);
        $(By.xpath("//*[@type='text']")).clear();
        $(By.xpath("//*[@type='text']")).setValue(generatedString);
    }

    @When("^click to save Incidence Rates Button$")
    public void clickToSaveIncidenceRatesButton() {
        $(By.xpath("//*[@class='fa fa-save']")).click();
    }

    @Then("^can see new buttons in incidence rates field$")
    public void canSeeNewButtonsInIncidenceRatesField() throws InterruptedException {
        Thread.sleep(1500);
        $(By.xpath("//*[@title='Close']")).shouldBe(visible);
        $(By.xpath("//*[@title='Create a copy']")).shouldBe(visible);
        $(By.xpath("//*[@title='Delete']")).shouldBe(visible);
    }

    @When("^click to cancel button in Incidence rates$")
    public void clickToCancelButtonInIncidenceRates() {
        $(By.xpath("//*[@title='Close']")).click();
    }

    @When("^enter name of our IR in filter$")
    public void enterNameOfOurIRInFilter() {
        $(By.xpath("//*[@type='search']")).waitUntil(visible,3000);
        $(By.xpath("//*[@type='search']")).setValue(generatedString);
    }

    @Then("^can see our incidence rate in table$")
    public void canSeeOurIncidenceRateInTable() {
        $(By.xpath("//tbody/tr/td[2]")).shouldHave(text(generatedString));
    }

    @When("^click to our incidence rate$")
    public void clickToOurIncidenceRate() {
        $(By.xpath("//tbody/tr/td[2]")).click();
    }

    @Then("^can see our incidence rate$")
    public void canSeeOurIncidenceRate() {
        $(By.xpath("//*[@data-bind='text: title']")).shouldHave(text("Incidence Rate Analysis #"));
    }

    @When("^enter new name of incidence rate$")
    public void enterNewNameOfIncidenceRate() {
        newGeneratedString = RandomStringUtils.randomAlphanumeric(10);
        $(By.xpath("//*[@type='text']")).clear();
        $(By.xpath("//*[@type='text']")).setValue(newGeneratedString);

    }

    @When("^enter name of new IR in filter$")
    public void enterNameOfNewIRInFilter() {
        $(By.xpath("//*[@type='search']")).waitUntil(visible,3000);
        $(By.xpath("//*[@type='search']")).setValue(newGeneratedString);
    }

    @Then("^can see new incidence rate in table$")
    public void canSeeNewIncidenceRateInTable() {
        $(By.xpath("//tbody/tr/td[2]")).shouldHave(text(newGeneratedString));
    }

    @When("^click to new incidence rate$")
    public void clickToNewIncidenceRate() {
        $(By.xpath("//tbody/tr/td[2]")).click();
    }

    @When("^click to delete IR button$")
    public void clickToDeleteIRButton() {
        $(By.xpath("//*[@title='Delete']")).waitUntil(visible,4000);
        $(By.xpath("//*[@title='Delete']")).click();
    }

    @When("^accept delete IR alert$")
    public void acceptDeleteIRAlert() {
        switchTo().alert().accept();
    }

    @Then("^cant find IR in table$")
    public void cantFindIRInTable() {
        $(By.xpath("//*[@type='search']")).waitUntil(visible,3000);
        $(By.xpath("//*[@type='search']")).setValue(newGeneratedString);
        $(By.xpath("//tbody/tr/td[2]")).shouldNotHave(text(newGeneratedString));
    }
}
