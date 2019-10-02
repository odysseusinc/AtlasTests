package atlastests;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FeedbackStepDefs {
    @Then("^can see Feedback page$")
    public void canSeeFeedbackPage() {
        $(By.xpath("//*[@class='feedback-text']")).shouldHave(text("For access or questions concerning the Atlas application please contact: "));
    }
}
