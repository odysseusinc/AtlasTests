package odysseusAT;

import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import static org.openqa.selenium.By.xpath;

public class LoginQT {

    public static String getDataProperties(String param) throws Exception {
        Properties props = new Properties();
        props.load(new InputStreamReader(new FileInputStream("src/application.properties"), "UTF-8"));
        return props.getProperty(param);
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

    public static void openProjectPage() throws InterruptedException {
        try{
            Thread.sleep(1000);
            open("https://qaatlas.arachnenetwork.com");
            Thread.sleep(3000);
            $(xpath("//*[@id='wrapperLogo']/a")).waitUntil(visible,10000);
            $(xpath("//*[@class='terms-and-conditions__btn btn btn-success']")).waitUntil(visible,10000);
            Thread.sleep(300);
            $(xpath("//*[@class='terms-and-conditions__btn btn btn-success']")).click();
        }catch (Exception k) {
            openProjectPage();
        }
    }


    public static void closeLoginWindow() throws InterruptedException {
        Thread.sleep(1000);
        $(By.xpath("//*[@class='close']")).click();
        Thread.sleep(1000);
    }


    public static void seeSuccessMessage() {
        try {
            $(By.xpath("//*[@class='fa fa-sign-out']")).waitUntil(visible, 300000);
        } catch (Exception e) {
            loginButtonPress();
            $(By.xpath("//*[@class='fa fa-sign-out']")).waitUntil(visible, 30000);
        }
    }

    public static void checkAuthoriseUserAs(String arg0) throws Throwable {

        $(By.xpath("//*[@data-bind='text: authLogin']")).waitUntil(visible, 60000);
        $(By.xpath("//*[@data-bind='text: authLogin']")).shouldHave(text(arg0));
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
        $(By.xpath("//*[@id='lg_username']")).waitUntil(visible, 2000);
        $(By.xpath("//*[@id='lg_username']")).setValue(getDataProperties("login"));
        $(By.xpath("//*[@id='lg_password']")).setValue(getDataProperties("password"));
        Thread.sleep(2000);
        loginButtonPress();
    }


    private void clickToLogInLink() throws InterruptedException {
        $(xpath("//*[@title='Sign In']")).waitUntil(visible, 4000);
        $(xpath("//*[@title='Sign In']")).shouldHave(text("Sign In"));

        Thread.sleep(1000);
        $(By.xpath("//*[@title='Sign In']")).click();
    }

    @When("^just open home page$")
    public void justOpenHomePage() throws InterruptedException {
        open("https://qaatlas.arachnenetwork.com");
        Thread.sleep(3000);
        $(xpath("//*[@id='wrapperLogo']/a")).waitUntil(visible, 10000);
        $(xpath("//*[@class='terms-and-conditions__btn btn btn-success']")).waitUntil(visible, 10000);
        Thread.sleep(300);
        $(xpath("//*[@class='terms-and-conditions__btn btn btn-success']")).click();
    }
}
