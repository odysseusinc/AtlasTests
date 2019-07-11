package odysseusAT;

import com.codeborne.selenide.Configuration;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static odysseusAT.MyStepdefs.openProjectPage;
import static org.openqa.selenium.By.xpath;

import static odysseusAT.MyStepdefs.closeBrowser;

public class LoginStepsDefs extends testDefs{

    @Before
    public void chromeDriver() {
    }

    @When("^click to LogIn link$")
    public static void clickToLogInLink() throws InterruptedException {
        $(xpath("//*[@title='Sign In']")).waitUntil(visible, 4000);
        $(xpath("//*[@title='Sign In']")).shouldHave(text("Sign In"));

        Thread.sleep(1000);
        $(By.xpath("//*[@title='Sign In']")).click();

    }

    @When("^click QA Arachne$")
    public static void clickTopQAArachne() {
        $(By.xpath("//*[@class='paddedWrapper']/div/span")).shouldHave(text("ARACHNE"));
        $(By.xpath("//*[@class='paddedWrapper']/div/span")).click();
        $(By.xpath("//*[@id='lg_username']")).waitUntil(visible, 30000);
    }


    @Then("^see message \"([^\"]*)\"$")
    public void seeMessage(String errorLogin) {
        $(By.xpath("//*[@class = 'error text-center']/span")).waitUntil(visible, 300000);
        $(By.xpath("//*[@class = 'error text-center']/span")).shouldHave(text(errorLogin));

    }


    @Then("^see success message$")
    public static void seeSuccessMessage() {
        try {
            $(By.xpath("//*[@class='fa fa-sign-out']")).waitUntil(visible, 300000);
        } catch (Exception e) {
            loginButtonPress();
            $(By.xpath("//*[@class='fa fa-sign-out']")).waitUntil(visible, 30000);
        }

    }

    @When("^login \"([^\"]*)\" and password \"([^\"]*)\" Entered and submitted$")
    public void loginAndPasswordEnteredAndSubmitted(String login, String password) throws InterruptedException {
        $(By.xpath("//*[@id='lg_username']")).waitUntil(visible, 2000);
        $(By.xpath("//*[@id='lg_username']")).setValue(login);
        $(By.xpath("//*[@id='lg_password']")).setValue(password);
        Thread.sleep(2000);
        loginButtonPress();
    }

    public static void loginButtonPress() {
        $(By.xpath("//*[@type='submit']")).click();
    }

    @Then("^close login window$")
    public static void closeLoginWindow() throws InterruptedException {
        Thread.sleep(1000);
        $(By.xpath("//*[@class='close']")).click();

    }

    @Then("^check authorise user as QA$")
    public static void checkAuthoriseUserAs(String arg0) throws Throwable {

        $(By.xpath("//*[@class='paddedWrapper']/div/div/div[2]/div")).waitUntil(visible, 60000);
        $(By.xpath("//*[@class='paddedWrapper']/div/div/div[2]/div")).shouldHave(text("Logged in as '" + arg0));
    }


    @When("^login with correct credentionas as QA$")
    public static void loginWithCorrectCredentionasAsQA() throws Exception {
        $(By.xpath("//*[@id='lg_username']")).waitUntil(visible, 2000);
        $(By.xpath("//*[@id='lg_username']")).setValue(getDataProperties("login"));
        $(By.xpath("//*[@id='lg_password']")).setValue(getDataProperties("password"));
        Thread.sleep(2000);
        loginButtonPress();
    }

    @When("^login to ATLAS as QA$")
    public void loginToATLASAsQA() throws Throwable {
        openProjectPage();
        clickToLogInLink();
        clickTopQAArachne();
        loginWithCorrectCredentionasAsQA();
        seeSuccessMessage();
        checkAuthoriseUserAs(getDataProperties("login"));
        closeLoginWindow();
    }


}
