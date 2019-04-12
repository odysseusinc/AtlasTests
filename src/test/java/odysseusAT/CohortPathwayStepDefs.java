package odysseusAT;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CohortPathwayStepDefs {
    @Then("^can see Cohort Pathway page$")
    public void canSeeCohortPathwayPage() {
        $(By.xpath("//*[@class='heading-title heading-title--dark'")).waitUntil(visible,4000);
        $(By.xpath("//*[@class='heading-title heading-title--dark'")).shouldHave(text("Cohort Pathways"));


    }
}
