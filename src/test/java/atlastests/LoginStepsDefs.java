package atlastests;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static atlastests.MyStepdefs.openProjectPage;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginStepsDefs extends testDefs {

    @Before
    public void chromeDriver() {
    }

    @When("^click to LogIn link$")
    public static void clickToLogInLink() {
        LoginQT.clickToLogInLink();
    }

    @When("^click Environment$")
    public static void clickToEnvironment() throws Exception {
	$(By.xpath("//*[@class='paddedWrapper']/div/span")).shouldHave(text(getDataProperties("environmentname"))).click();
        $(By.xpath("//*[@id='lg_username']")).waitUntil(visible, 30000);
    }


    @Then("^see message \"([^\"]*)\"$")
    public void seeMessage(String errorLogin) {
        $(By.xpath("//*[@class = 'error text-center']/span")).waitUntil(visible, 5000).
                shouldHave(text(errorLogin));
    }


    @Then("^see success message$")
    public static void seeSuccessMessage() {
        try {
            $(By.xpath("//*[@class='fa fa-sign-out']")).waitUntil(visible, 10000);
        } catch (Exception e) {
            loginButtonPress();
            $(By.xpath("//*[@class='fa fa-sign-out']")).waitUntil(visible, 30000);
        }

    }

    @When("^login \"([^\"]*)\" and password \"([^\"]*)\" Entered and submitted$")
    public static void loginAndPasswordEnteredAndSubmitted(String login, String password) {
        $(By.xpath("//*[@id='lg_username']")).waitUntil(visible, 2000).setValue(login);
        $(By.xpath("//*[@id='lg_password']")).setValue(password);
        loginButtonPress();
    }

    public static void loginButtonPress() {
        $(By.xpath("//*[@type='submit']")).click();
    }

    @Then("^close login window$")
    public static void closeLoginWindow() {
        $(By.xpath("//*[@class='close']")).click();

    }

    @Then("^check authorise user as QA$")
    public static void checkAuthoriseUserAs(String arg0) {

        $(By.xpath("//*[@class='paddedWrapper']/div/div/div[2]/div")).waitUntil(visible, 60000).
                shouldHave(text("Logged in as '" + arg0));
    }


    @When("^login with correct credentionas as QA$")
    public static void loginWithCorrectCredentionasAsQA() throws Exception {
        loginAndPasswordEnteredAndSubmitted(getDataProperties("login"), getDataProperties("password"));
    }

    @When("^login to ATLAS as QA$")
    public void loginToATLASAsQA() throws Throwable {
        openProjectPage();
        clickToLogInLink();
        clickToEnvironment();
        loginWithCorrectCredentionasAsQA();
        seeSuccessMessage();
        checkAuthoriseUserAs(getDataProperties("login"));
        closeLoginWindow();
    }

    @When("^login with correct credentials as admin$")
    public static void loginWithCorrectCredentialsAsAdmin() throws Exception {
        loginAndPasswordEnteredAndSubmitted(getDataProperties("adminlogin"), getDataProperties("adminpassword"));
    }

    @When("^login to ATLAS as admin$")
    public void loginToATLASAsAdmin() throws Throwable {
        openProjectPage();
        clickToLogInLink();
        clickToEnvironment();
        loginWithCorrectCredentialsAsAdmin();
        seeSuccessMessage();
        checkAuthoriseUserAs(getDataProperties("adminlogin"));
        closeLoginWindow();
    }

}
