package atlastests;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static atlastests.TestDefs.getDataProperties;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginStepsDefs {

    @When("^login to ATLAS as QA$")
    public void loginToATLASAsQA() throws Throwable {
        logIn("login", "password");
    }

    @When("^login to ATLAS as admin$")
    public void loginToATLASAsAdmin() throws Throwable {
        logIn("adminlogin", "adminpassword");
    }

    public void logIn(String loginPropertyPath, String passPropertyPath) throws Exception {
        new MyStepdefs().openProjectPage();
        clickToLogInLink();
        clickToEnvironment();
        loginAndPasswordEnteredAndSubmitted(getDataProperties(loginPropertyPath), getDataProperties(passPropertyPath));
        seeSuccessMessage(getDataProperties(loginPropertyPath));
        closeLoginWindow();
    }

    @When("^click to LogIn link$")
    public static void clickToLogInLink() {
        $("[title='Sign In'] a").waitUntil(visible, 5000).shouldHave(text("Sign In")).click();
    }

    @When("^click Environment$")
    public static void clickToEnvironment() throws Exception {
        $$("[data-bind='text:name']").
                find(matchesText((getDataProperties("environmentname")))).click();
    }


    @Then("^see message \"([^\"]*)\"$")
    public void seeMessage(String errorLogin) {
        $("[data-bind='text: errorMsg']").waitUntil(visible, 5000).
                shouldHave(text(errorLogin));
    }


    @Then("^see success message$")
    public static void seeSuccessMessage(String login) {
        $("[data-bind='text: fullName']").waitUntil(text(login), 10000);
        $("welcome .paddedWrapper [data-bind='text: $component.status']").waitUntil(visible, 10000).
                shouldHave(Condition.matchesText("Logged in as '" + login + "'"));
    }

    @When("^login \"([^\"]*)\" and password \"([^\"]*)\" Entered and submitted$")
    public static void loginAndPasswordEnteredAndSubmitted(String login, String password) {
        $("input#lg_password").setValue(password);//password firstly to optimise authorization speed and stability
        $("input#lg_username").setValue(login);
        loginButtonPress();
    }

    public static void loginButtonPress() {
        $(".form-group [type='submit']").click();
    }

    @Then("^close login window$")
    public static void closeLoginWindow() {
        $(".modal-header .close").click();
    }



}
