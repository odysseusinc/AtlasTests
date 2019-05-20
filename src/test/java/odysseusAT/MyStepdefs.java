package odysseusAT;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.openqa.selenium.By.xpath;


public class MyStepdefs extends testDefs {

    @Before
    public void chromeDriver() {
    }

    @After
    public void closeOnFail(){
        try {
            closeBrowser();
        } catch(Exception e) {
            throw new AssertionError("A clear description of the failure", e);
        }
    }

    @When("^open project page$")
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

//        open("https://qaatlas.arachnenetwork.com");
//        $(xpath("//*[@id='wrapperLogo']/a")).waitUntil(visible, 60000);



        //        for (int i = 0; i < 2; i++ ){
//            String logo =  By.xpath("//*[@id='wrapperLogo']/a").toString()    ;
//            if (!logo.equals(visible)) {Thread.sleep(10000);
//            open("https://qaatlas.arachnenetwork.com");}
//        }
//        SelenideElement se = $(xpath("//*[@id='wrapperLogo']/a"));
//        for (int i = 0; i < 2; i++ ) {
//            if (se.isDisplayed()) {
//                Thread.sleep(10000);
//                open("https://qaatlas.arachnenetwork.com");
//            }
//        }
    }

    @Then("^check unauthorized user$")
    public void checkUnauthorizedUser() {
        $(xpath("//*[@data-bind='click: function () { $component.signInOpened(true) }']")).shouldHave(text("Sign In"));
    }

    @Then("^can see message \"([^\"]*)\"$")
    public void canSeeMessage(String warningAboutUnauthorized) throws Throwable {
        $(xpath("//*[@class='white-page flexed']")).waitUntil(visible,5000);
        $(xpath("//*[@class='white-page flexed']")).shouldHave(text(warningAboutUnauthorized));


    }

    @Then("^click to Data Sources menu$")
    public void clickToDataSourcesMenu() throws InterruptedException {

            $(xpath("//*[@class='app__menu']/a[2]")).shouldHave(text("Data Sources"));
            $(xpath("//*[@class='app__menu']/a[2]")).click();
            $(xpath("//*[@id='currentComponent']/div/unauthenticated")).waitUntil(visible,20000);
    }

    @Then("^close browser$")
    public static void closeBrowser() {
        close();
    }

    @Then("^can see message at home menu \"([^\"]*)\"$")
    public void canSeeMessageAtHomeMenu(String welcomeText) throws Throwable {
        $(xpath("//*[@class='home-welcome']/div")).shouldHave(text(welcomeText));
    }

    @When("^click to Concept Sets menu$")
    public void clickToConceptSetsMenu() throws InterruptedException {
        $(xpath("//*[@class='app__menu']/a[4]")).shouldHave(text("Concept Sets"));
        Thread.sleep(1000);
        $(xpath("//*[@class='app__menu']/a[4]/span")).click();
        $(xpath("//*[@id='currentComponent']/div/unauthenticated")).waitUntil(visible, 20000);
    }

    @When("^click to Cohort Definitions menu$")
    public void clickToCohortDefinitionsMenu() throws InterruptedException {
        $(xpath("//*[@class='app__menu']/a[5]")).shouldHave(text("Cohort Definitions"));
        Thread.sleep(1000);
        $(xpath("//*[@class='app__menu']/a[5]/span")).click();
        $(xpath("//*[@id='currentComponent']/div/unauthenticated")).waitUntil(visible, 20000);

    }

    @When("^click to Incidence Rates menu$")
    public void clickToIncidenceRatesMenu() throws InterruptedException {
        $(xpath("//*[@class='app__menu']/a[8]")).shouldHave(text("Incidence Rates"));
        Thread.sleep(1000);
        $(xpath("//*[@class='app__menu']/a[8]/span")).click();
        $(xpath("//*[@id='currentComponent']/div/unauthenticated")).waitUntil(visible, 20000);
    }

    @When("^click to Profiles menu$")
    public void clickToProfilesMenu() throws InterruptedException {
        $(xpath("//*[@class='app__menu']/a[9]")).shouldHave(text("Profiles"));
        Thread.sleep(1000);
        $(xpath("//*[@class='app__menu']/a[9]/span")).click();
        $(xpath("//*[@id='currentComponent']/div/unauthenticated")).waitUntil(visible, 20000);
    }

    @When("^click to Estimation menu$")
    public void clickToEstimationMenu() throws InterruptedException {
        $(xpath("//*[@class='app__menu']/a[10]")).shouldHave(text("Estimation"));
        Thread.sleep(1000);
        $(xpath("//*[@class='app__menu']/a[10]/span")).click();
        $(xpath("//*[@id='currentComponent']/div/unauthenticated")).waitUntil(visible, 20000);
    }

    @When("^click to Prediction menu$")
    public void clickToPredictionMenu() throws InterruptedException {
        $(xpath("//*[@class='app__menu']/a[11]")).shouldHave(text("Prediction"));
        Thread.sleep(1000);
        $(xpath("//*[@class='app__menu']/a[11]/span")).click();
        $(xpath("//*[@id='currentComponent']/div/unauthenticated")).waitUntil(visible, 20000);
    }

    @When("^click to Jobs menu$")
    public void clickToJobsMenu() throws InterruptedException {
        $(xpath("//*[@class='app__menu']/a[12]")).shouldHave(text("Jobs"));
        Thread.sleep(1000);
        $(xpath("//*[@class='app__menu']/a[12]/span")).click();
        $(xpath("//*[@id='currentComponent']/div/unauthenticated")).waitUntil(visible, 20000);
    }

    @When("^click to Configuration menu$")
    public void clickToConfigurationMenu() throws InterruptedException {
        $(xpath("//*[@class='app__menu']/a[13]")).shouldHave(text("Configuration"));
        Thread.sleep(1000);
        $(xpath("//*[@class='app__menu']/a[13]/span")).click();
        $(xpath("//*[@id='currentComponent']/div/unauthenticated")).waitUntil(visible, 20000);

    }


    @When("^click to Search menu$")
    public void clickToSearchMenu() throws InterruptedException {
        $(xpath("//*[@class='app__menu']/a[3]")).shouldHave(text("Search"));
        Thread.sleep(1000);
        $(xpath("//*[@class='app__menu']/a[3]/span")).click();
        $(xpath("//*[@id='currentComponent']/div/unauthenticated")).waitUntil(visible, 20000);
    }

    @When("^click to Data Sources menu as user$")
    public void clickToDataSourcesMenuAsUser() {
        $(xpath("//*[@class='app__menu']/a[2]")).shouldHave(text("Data Sources"));
        $(xpath("//*[@class='app__menu']/a[2]")).click();
    }

    @When("^click to Characterizations menu$")
    public void clickToCharacterizationsMenu() throws InterruptedException {
        $(xpath("//*[@class='app__menu']/a[6]")).shouldHave(text("Characterizations"));
        Thread.sleep(1000);
        $(xpath("//*[@class='app__menu']/a[6]/span")).click();
        $(xpath("//*[@id='currentComponent']/div/unauthenticated")).waitUntil(visible, 20000);
    }

    @When("^click to Cohort Pathways menu$")
    public void clickToCohortPathwaysMenu() throws InterruptedException {
        $(xpath("//*[@class='app__menu']/a[7]")).shouldHave(text("Cohort Pathways"));
        Thread.sleep(1000);
        $(xpath("//*[@class='app__menu']/a[7]/span")).click();
        $(xpath("//*[@id='currentComponent']/div/unauthenticated")).waitUntil(visible, 20000);
    }

    @When("^click to Search menu as QA$")
    public void clickToSearchMenuAsQA() throws InterruptedException {
        $(xpath("//*[@class='app__menu']/a[3]")).shouldHave(text("Search"));
        Thread.sleep(1000);
        $(xpath("//*[@class='app__menu']/a[3]/span")).click();
    }

    @When("^click to Concept Sets menu as QA$")
    public void clickToConceptSetsMenuAsQA() throws InterruptedException {
        $(xpath("//*[@class='app__menu']/a[4]")).shouldHave(text("Concept Sets"));
        Thread.sleep(3000);
        $(xpath("//*[@class='app__menu']/a[4]/span")).click();
    }


    @When("^click to Cohort Definitions menu as QA$")
    public void clickToCohortDefinitionsMenuAsQA() throws InterruptedException {
        $(xpath("//*[@class='app__menu']/a[5]")).shouldHave(text("Cohort Definitions"));
        Thread.sleep(1000);
        $(xpath("//*[@class='app__menu']/a[5]/span")).click();
    }

    @When("^click to Characterizations menu as QA$")
    public void clickToCharacterizationsMenuAsQA() throws InterruptedException {
        $(xpath("//*[@class='app__menu']/a[6]")).shouldHave(text("Characterizations"));
        Thread.sleep(1000);
        $(xpath("//*[@class='app__menu']/a[6]")).click();
    }

    @When("^click to Cohort Pathways menu as QA$")
    public void clickToCohortPathwaysMenuAsQA() throws InterruptedException {
        $(xpath("//*[@class='app__menu']/a[7]")).shouldHave(text("Cohort Pathway"));
        Thread.sleep(1000);
        $(xpath("//*[@class='app__menu']/a[7]")).click();
    }

    @When("^click to Incidence Rates menu as QA$")
    public void clickToIncidentRatesMenuAsQA() throws InterruptedException {
        $(xpath("//*[@class='app__menu']/a[8]")).shouldHave(text("Incidence Rates"));
        Thread.sleep(1000);
        $(xpath("//*[@class='app__menu']/a[8]")).click();
    }

    @When("^click to Profiles menu as QA$")
    public void clickToProfilesMenuAsQA() throws InterruptedException {
        $(xpath("//*[@class='app__menu']/a[9]")).shouldHave(text("Profiles"));
        Thread.sleep(1000);
        $(xpath("//*[@class='app__menu']/a[9]")).click();
    }

    @When("^click to Estimation menu as QA$")
    public void clickToEstimationMenuAsQA() throws InterruptedException {
        $(xpath("//*[@class='app__menu']/a[10]")).shouldHave(text("Estimation"));
        Thread.sleep(1000);
        $(xpath("//*[@class='app__menu']/a[10]")).click();
    }

    @When("^click to Prediction menu as QA$")
    public void clickToPredictionMenuAsQA() throws InterruptedException {
        $(xpath("//*[@class='app__menu']/a[11]")).shouldHave(text("Prediction"));
        Thread.sleep(1000);
        $(xpath("//*[@class='app__menu']/a[11]")).click();
    }
}
