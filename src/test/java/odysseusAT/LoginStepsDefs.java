package odysseusAT;

import com.codeborne.selenide.Configuration;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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

public class LoginStepsDefs {

    public static String getDataProperties (String param) throws Exception {
        Properties props=new Properties();
        props.load(new InputStreamReader(new FileInputStream("src/application.properties"), "UTF-8"));
        return props.getProperty(param);
    }

    @Before
    public void closeOnFail() {
        String testmode, browserURL;
        try {
            Configuration.timeout = 30000;

            testmode = getDataProperties("test.mode");

            switch(testmode) {
                case "local":
                    browserURL = getDataProperties("test.browser");
                    if (!browserURL.equals("") && !browserURL.isEmpty()) {
                        System.setProperty("webdriver.chrome.driver", browserURL);
                    } else {
                        throw new Exception("Error local browser property");
                    }
                    break;
                case "remote":
                    Configuration.browser = "chrome";
                    browserURL = getDataProperties("test.browser");
                    if (!browserURL.equals("") && !browserURL.isEmpty()) {

                        Configuration.remote = browserURL;

                        // Разрешаем VNC
                        ChromeOptions capabilities = new ChromeOptions();
                        capabilities.setCapability("enableVNC", true);
                    } else {
                        throw new Exception("Error remote browser property");
                    }
                    break;
                default:
                    throw new Exception("Error test mode");
            }
        } catch (Exception e) {
            throw new AssertionError("Error settings", e);
        }
        /*
        try {
            //closeBrowser();
        } catch (Exception e) {
            throw new AssertionError("A clear description of the failure", e);
        }
        */
    }

    @When("^click to LogIn link$")
    public void clickToLogInLink() throws InterruptedException {
        $(xpath("//*[@title='Sign In']")).waitUntil(visible,4000);
        $(xpath("//*[@title='Sign In']")).shouldHave(text("Sign In"));

        Thread.sleep(1000);
        $(By.xpath("//*[@title='Sign In']")).click();

    }

    @When("^click QA Arachne$")
    public void clickTopQAArachne() {
        $(By.xpath("//*[@class='paddedWrapper']/div/span")).shouldHave(text("QA Arachne"));
        $(By.xpath("//*[@class='paddedWrapper']/div/span")).click();
        $(By.xpath("//*[@id='lg_username']")).waitUntil(visible, 30000);
    }


    @Then("^see message \"([^\"]*)\"$")
    public void seeMessage(String errorLogin) {
        $(By.xpath("//*[@class='paddedWrapper']/div/div/div/div[3]/span")).waitUntil(visible, 60000);
        $(By.xpath("//*[@class='paddedWrapper']/div/div/div/div[3]/span")).shouldHave(text(errorLogin));

    }


    @Then("^see success message$")
    public void seeSuccessMessage() {
        try {
            $(By.xpath("//*[@class='fa fa-sign-out']")).waitUntil(visible, 300000);
        } catch (Exception e) {
            loginButtonPress();
            $(By.xpath("//*[@class='fa fa-sign-out']")).waitUntil(visible, 30000);
        }

    }

    @When("^login \"([^\"]*)\" and password \"([^\"]*)\" Entered and submitted$")
    public void loginAndPasswordEnteredAndSubmitted(String login, String password) throws InterruptedException {
        $(By.xpath("//*[@id='lg_username']")).waitUntil(visible,2000);
        $(By.xpath("//*[@id='lg_username']")).setValue(login);
        $(By.xpath("//*[@id='lg_password']")).setValue(password);
        Thread.sleep(2000);
        loginButtonPress();
    }

    public void loginButtonPress(){
        $(By.xpath("//*[@type='submit']")).click();
    }

    @Then("^close login window$")
    public void closeLoginWindow() throws InterruptedException {
        Thread.sleep(1000);
        $(By.xpath("//*[@id='wrapperMainWindowContainer']/user-bar/atlas-modal[1]/div/div/div/div[1]/button")).click();
        Thread.sleep(1000);
    }

    @Then("^check authorise user as QA$")
    public void checkAuthoriseUserAs(String arg0) throws Throwable {

        $(By.xpath("//*[@id='wrapperMainWindowContainer']/user-bar/div/div/div/div[2]/a/strong")).waitUntil(visible, 60000);
        $(By.xpath("//*[@id='wrapperMainWindowContainer']/user-bar/div/div/div/div[2]/a/strong")).shouldHave(text(arg0));
    }


    @When("^login with correct credentionas as QA$")
    public void loginWithCorrectCredentionasAsQA() throws Exception {
        $(By.xpath("//*[@id='lg_username']")).waitUntil(visible,2000);
        $(By.xpath("//*[@id='lg_username']")).setValue(getDataProperties("login"));
        $(By.xpath("//*[@id='lg_password']")).setValue(getDataProperties("password"));
        Thread.sleep(2000);
        loginButtonPress();
    }

    @When("^login to ATLAS as QA$")
    public void loginToATLASAsQA() throws Throwable  {
        openProjectPage();
        clickToLogInLink();
        clickTopQAArachne();
        loginWithCorrectCredentionasAsQA();
        seeSuccessMessage();
        checkAuthoriseUserAs(getDataProperties("login"));
        closeLoginWindow();
    }
}

//*[@id="myModal"]/div/div/div[2]/welcome/div/div/div/div[1]/div[3]/span
//*[@id="myModal"]/div/div/div[2]/welcome/div/div/div/div[1]/form/div[2]/button
//*[@id="myModal"]/div/div/div[2]/welcome/div/div/div/div[2]/div
