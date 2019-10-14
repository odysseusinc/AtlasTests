package atlastests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.xpath;


public class MyStepdefs extends testDefs {

    @Before
    public void chromeDriver() {
    }

    @After
    public void closeOnFail() {
        try {
            closeBrowser();
        } catch (Exception e) {
            throw new AssertionError("A clear description of the failure", e);
        }
    }

    @When("^open project page$")
    public static void openProjectPage() throws Exception {
        Configuration.headless = false;
        open(getDataProperties("link"));
        closeLicenseAgreement();
    }

    public static void closeLicenseAgreement() {
        $(xpath("//*[@id='wrapperLogo']/a")).waitUntil(visible, 10000);
        $$(".modal-title").find(matchesText("License Agreement")).waitUntil(visible, 10000);
        $(".atlas-modal__modal-dialog .btn-success").hover().click();
        $("heading-title .fa-home").waitUntil(visible, 5000);
    }

    @Then("^close browser$")
    public static void closeBrowser() {
        close();
    }

    @Then("^check unauthorized user$")
    public void checkUnauthorizedUser() {
        $("[data-bind='click: function () { $component.signInOpened(true) }']").shouldHave(text("Sign In"));
    }

    @Then("^can see message \"([^\"]*)\"$")
    public void canSeeMessage(String warningAboutUnauthorized) {
        $("unauthenticated").waitUntil(visible, 5000).
                shouldHave(text(warningAboutUnauthorized));
    }

    @Then("^click to Data Sources menu$")
    public void clickToDataSourcesMenu() {
        $(xpath("//*[@class='app__menu']/a[2]")).shouldHave(text("Data Sources")).click();
        unauthenticatedCheck();
    }

    @Then("^can see message at home menu \"([^\"]*)\"$")
    public void canSeeMessageAtHomeMenu(String welcomeText) {
        $(xpath("//*[@class='home-welcome']/div")).shouldHave(text(welcomeText));
    }

    @When("^click to Concept Sets menu$")
    public void clickToConceptSetsMenu() {
        $(xpath("//*[@class='app__menu']/a[4]")).shouldHave(text("Concept Sets")).click();
        unauthenticatedCheck();
    }

    @When("^click to Cohort Definitions menu$")
    public void clickToCohortDefinitionsMenu() {
        $(xpath("//*[@class='app__menu']/a[5]")).shouldHave(text("Cohort Definitions")).click();
        unauthenticatedCheck();
    }

    @When("^click to Incidence Rates menu$")
    public void clickToIncidenceRatesMenu() {
        $(xpath("//*[@class='app__menu']/a[8]")).shouldHave(text("Incidence Rates")).click();
        unauthenticatedCheck();
    }

    @When("^click to Profiles menu$")
    public void clickToProfilesMenu() {
        $(xpath("//*[@class='app__menu']/a[9]")).shouldHave(text("Profiles")).click();
        unauthenticatedCheck();
    }

    @When("^click to Estimation menu$")
    public void clickToEstimationMenu() {
        $(xpath("//*[@class='app__menu']/a[10]")).shouldHave(text("Estimation")).click();
        unauthenticatedCheck();
    }

    @When("^click to Prediction menu$")
    public void clickToPredictionMenu() {
        $(xpath("//*[@class='app__menu']/a[11]")).shouldHave(text("Prediction")).click();
        unauthenticatedCheck();
    }

    @When("^click to Jobs menu$")
    public void clickToJobsMenu() {
        $(xpath("//*[@class='app__menu']/a[12]")).shouldHave(text("Jobs")).click();
        unauthenticatedCheck();
    }

    @When("^click to Configuration menu$")
    public void clickToConfigurationMenu() {
        $(xpath("//*[@class='app__menu']/a[13]")).shouldHave(text("Configuration")).click();
        unauthenticatedCheck();
    }

    @When("^click to Search menu$")
    public void clickToSearchMenu() {
        $(xpath("//*[@class='app__menu']/a[3]")).shouldHave(text("Search")).click();
        unauthenticatedCheck();
    }

    @When("^click to Data Sources menu as user$")
    public void clickToDataSourcesMenuAsUser() {
        $(xpath("//*[@class='app__menu']/a[2]")).shouldHave(text("Data Sources")).click();
    }

    @When("^click to Characterizations menu$")
    public void clickToCharacterizationsMenu() {
        $(xpath("//*[@class='app__menu']/a[6]")).shouldHave(text("Characterizations")).click();
        unauthenticatedCheck();
    }

    @When("^click to Cohort Pathways menu$")
    public void clickToCohortPathwaysMenu() {
        $(xpath("//*[@class='app__menu']/a[7]")).shouldHave(text("Cohort Pathways")).click();
        unauthenticatedCheck();
    }

    @When("^click to Search menu as QA$")
    public void clickToSearchMenuAsQA() {
        $(xpath("//*[@class='app__menu']/a[3]")).shouldHave(text("Search")).click();
    }

    @When("^click to Concept Sets menu as QA$")
    public void clickToConceptSetsMenuAsQA() {
        $(xpath("//*[@class='app__menu']/a[4]")).shouldHave(text("Concept Sets")).click();
    }

    @When("^click to Cohort Definitions menu as QA$")
    public void clickToCohortDefinitionsMenuAsQA() {
        $("[href='#/cohortdefinitions']").waitUntil(Condition.enabled, 5000).
                shouldHave(text("Cohort Definitions")).click();
        $(".buttons-collection").waitUntil(visible, 5000);
    }

    @When("^click to Characterizations menu as QA$")
    public void clickToCharacterizationsMenuAsQA() {
        $(xpath("//*[@class='app__menu']/a[6]")).shouldHave(text("Characterizations")).click();
    }

    @When("^click to Cohort Pathways menu as QA$")
    public void clickToCohortPathwaysMenuAsQA() {
        $(xpath("//*[@class='app__menu']/a[7]")).shouldHave(text("Cohort Pathway")).click();
    }

    @When("^click to Incidence Rates menu as QA$")
    public void clickToIncidentRatesMenuAsQA() {
        $(xpath("//*[@class='app__menu']/a[8]")).shouldHave(text("Incidence Rates")).click();
    }

    @When("^click to Profiles menu as QA$")
    public void clickToProfilesMenuAsQA() {
        $(xpath("//*[@class='app__menu']/a[9]")).shouldHave(text("Profiles")).click();
    }

    @When("^click to Estimation menu as QA$")
    public void clickToEstimationMenuAsQA() {
        $(xpath("//*[@class='app__menu']/a[10]")).shouldHave(text("Estimation")).click();
    }

    @When("^click to Prediction menu as QA$")
    public void clickToPredictionMenuAsQA() {
        $(xpath("//*[@class='app__menu']/a[11]")).shouldHave(text("Prediction")).click();
    }

    @When("^click to Jobs menu as QA$")
    public void clickToJobsMenuAsQA() {
        $(xpath("//*[@class='app__menu']/a[12]")).shouldHave(text("Jobs")).click();
    }

    @When("^click to Feedback menu as QA$")
    public void clickToFeedbackMenuAsQA() {
        $(xpath("//*[@class='app__menu']/a[14]")).shouldHave(text("Feedback")).click();
    }

    @When("^click to Configuration menu as QA$")
    public void clickToConfigurationMenuAsQA() {
        $(xpath("//*[@class='app__menu']/a[13]")).shouldHave(text("Configuration")).click();
    }

    private void unauthenticatedCheck() {
        $("unauthenticated").waitUntil(visible, 20000);
    }
}
