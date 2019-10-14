package atlastests;

import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static atlastests.MyStepdefs.closeLicenseAgreement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.xpath;

public class LoginQT extends testDefs {

    @Before
    public void chromeDriver() {
    }

    @When("^login to ATLAS as QA QT$")
    public void loginToATLASAsQAQT() throws Throwable {
        openProjectPage();
        clickToLogInLink();
        clickTopQAArachne();
        loginWithCorrectCredentionasAsQA();
        seeSuccessMessage();
        checkAuthoriseUserAs(getDataProperties("login"));
        closeLoginWindow();

    }

    public static void openProjectPage() throws Exception {
        open(getDataProperties("link_dev"));
        closeLicenseAgreement();
    }


    public static void closeLoginWindow() {
        $(By.xpath("//*[@class='close']")).waitUntil(visible, 5000).click();
    }


    public static void seeSuccessMessage() {
        try {
            $(By.xpath("//*[@class='fa fa-sign-out']")).waitUntil(visible, 300000);
        } catch (Exception e) {
            loginButtonPress();
            $(By.xpath("//*[@class='fa fa-sign-out']")).waitUntil(visible, 30000);
        }
    }

    public static void checkAuthoriseUserAs(String arg0) {
        $(By.xpath("//*[@class='paddedWrapper']/div/div/div/div")).waitUntil(visible, 60000).
                shouldHave(text(arg0));
    }

    private void clickTopQAArachne() {
        $(By.xpath("//*[@class='paddedWrapper']/div/span")).shouldHave(text("QA Arachne"));
        $(By.xpath("//*[@class='paddedWrapper']/div/span")).click();
        $(By.xpath("//*[@id='lg_username']")).waitUntil(visible, 30000);
    }

    public static void loginButtonPress() {
        $(By.xpath("//*[@type='submit']")).click();
    }

    private void loginWithCorrectCredentionasAsQA() throws Exception {
        $(By.xpath("//*[@id='lg_username']")).waitUntil(visible, 2000).
                setValue(getDataProperties("login"));
        $(By.xpath("//*[@id='lg_password']")).setValue(getDataProperties("password"));
        loginButtonPress();
    }

    public static void clickToLogInLink() {
        $(xpath("//*[@title='Sign In']")).waitUntil(visible, 4000).shouldHave(text("Sign In")).click();
    }

    @When("^just open home page$")
    public void justOpenHomePage() throws Exception {
        open(getDataProperties("link_dev"));
        $(xpath("//*[@id='wrapperLogo']/a")).waitUntil(visible, 10000);
    }
}
