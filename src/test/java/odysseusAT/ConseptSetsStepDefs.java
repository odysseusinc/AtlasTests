package odysseusAT;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ConseptSetsStepDefs {

    @Then("^Concept Sets page opens$")
    public void conceptSetsPageOpens() {
        $(By.xpath("//*[@id='currentComponent']/heading-title/div/span")).waitUntil(visible,5000);
        $(By.xpath("//*[@id='currentComponent']/heading-title/div/span")).shouldHave(text("Concept Sets"));


    }
}
