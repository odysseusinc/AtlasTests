package atlastests;

import com.codeborne.selenide.Selectors;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProfileStepDefs {
    @Then("^can see Profiles page$")
    public void canSeeProfilesPage() {
        $(By.xpath("//*[@data-bind='text: title']")).waitUntil(visible,3000);
        $(By.xpath("//*[@data-bind='text: title']")).shouldHave(text("Profiles"));

    }

    @When("^click to Select a Data Source$")
    public void clickToSelectADataSource() throws InterruptedException {
        Thread.sleep(2000);
        $$(By.xpath("//*[@class='input-group-btn']/button")).get(0).click();

    }

    @When("^choose \"([^\"]*)\" in Profile Source$")
    public void chooseInProfileSource(String arg0) throws Throwable {
        $(byText(arg0)).click();
    }

    @When("^enter (\\d+) in Profile Id and press Enter$")
    public void enterInProfileIdAndPressEnter(int arg0) {
        $(By.xpath("//*[@class='form-control']")).setValue(String.valueOf(arg0));
        $(By.xpath("//*[@class='form-control']")).pressEnter();
    }

    @Then("^can see overlay$")
    public void canSeeOverlay() {
        $(By.xpath("//*[@class='overlay']")).waitUntil(visible,60000);
    }

    @Then("^can see table$")
    public void canSeeTable() {
        $(By.xpath("//*[@class='sorting'][3]")).waitUntil(visible,10000);
    }
}
