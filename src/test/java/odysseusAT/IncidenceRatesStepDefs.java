package odysseusAT;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class IncidenceRatesStepDefs {
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
}
