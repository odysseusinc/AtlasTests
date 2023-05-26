package atlastests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

import java.time.Duration;

import static atlastests.TestDefs.getDataProperties;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginStepsDefs {

    @Step("Login to ATLAS as QA")
    @When("^login to ATLAS as QA$")
    public void loginToATLASAsQA() throws Throwable {
        logIn("login", "password");
    }

    @Step ("Login to Atlas as Admin")
    @When("^login to ATLAS as admin$")
    public void loginToATLASAsAdmin() throws Throwable {
        logIn("adminlogin", "adminpassword");
    }

    @Step("Logout from ATLAS")
    @When("^logout")
    public void logout()
    {
        $("[data-bind='text: fullName']").click();
        $(withText("Sign Out")).click();
        $$(".close").filter(visible).first().click();
    }

    public void logIn(String loginPropertyPath, String passPropertyPath) throws Exception {
        new MyStepdefs().openProjectPage();
        clickToLogInLink();
        clickToEnvironment();
        loginAndPasswordEnteredAndSubmitted(getDataProperties(loginPropertyPath), getDataProperties(passPropertyPath));
        seeSuccessMessage(getDataProperties(loginPropertyPath));
        closeLoginWindow();
    }
    @Step("Click to LogIn link")
    @When("^click to LogIn link$")
    public static void clickToLogInLink() {
        $("[title='Sign In'] a").shouldBe(visible, Duration.ofMillis(5000)).shouldHave(text("Sign In")).click();
    }
    @Step("Click to Environment")
    @When("^click Environment$")
    public static void clickToEnvironment() throws Exception {
        $$("[data-bind='text:name']").
                find(matchText((getDataProperties("environmentname")))).click();
    }

    @Step("See message {errorLogin}")
    @Then("^see message \"([^\"]*)\"$")
    public void seeMessage(String errorLogin) {
        $("[data-bind='text: errorMsg']").shouldBe(visible, Duration.ofMillis(5000)).
                shouldHave(text(errorLogin));
    }

    @Step("See success message")
    @Then("^see success message$")
    public static void seeSuccessMessage(String login) {
        $("[data-bind='text: fullName']").shouldHave(text(login), Duration.ofMillis(10000));
        $("welcome .paddedWrapper [data-bind='text: $component.status']").shouldBe(visible, Duration.ofMillis(10000)).
                shouldHave(Condition.matchText("Logged in as '" + login + "'"));
    }
    @Step("Entered {login} and {password}")
    @When("^login \"([^\"]*)\" and password \"([^\"]*)\" Entered and submitted$")
    public static void loginAndPasswordEnteredAndSubmitted(String login, String password) {
        SelenideElement loginInput = $("input#lg_username");
        loginInput.click();   //this action prevents empty login field issue during authorization
        loginInput.setValue(login);
        $("input#lg_password").setValue(password);
        loginButtonPress();
    }

    public static void loginButtonPress() {
        $(".form-group [type='submit']").click();
    }

    @Step("Close login window")
    @Then("^close login window$")
    public static void closeLoginWindow() throws InterruptedException {
        $(".modal-header .close").click();
        Thread.sleep(3000);
    }


}
