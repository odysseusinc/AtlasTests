package atlastests;

import atlastests.components.ModalControl;
import com.codeborne.selenide.Condition;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static atlastests.TestDefs.getDataProperties;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.xpath;


public class MyStepdefs implements ModalControl {

    @When("^open project page$")
    public void openProjectPage() throws Exception {
        open(getDataProperties("link"));
        closeLicenseAgreement();
    }

    public void closeLicenseAgreement() {
        $("#wrapperLogo").waitUntil(visible, 10000);
        checkModalTitle("License Agreement");
        $(".atlas-modal__modal-dialog .btn-success").hover().click();
        $("heading-title .fa-home").waitUntil(visible, 5000);
    }

    @Then("^check unauthorized user$")
    public void checkUnauthorizedUser() {
        $("[data-bind='click: function () { $component.signInOpened(true) }']").shouldHave(text("Sign In"));
    }

    @Then("^The warning message is shown \"([^\"]*)\"$")
    public void checkUnauthorizedMessage(String warningAboutUnauthorized) {
        $("unauthenticated").waitUntil(visible, 15000).
                shouldHave(text(warningAboutUnauthorized));
    }

    @Then("^can see message at home menu \"([^\"]*)\"$")
    public void canSeeMessageAtHomeMenu(String welcomeText) {
        $(xpath("//*[@class='home-welcome']/div")).shouldHave(text(welcomeText));
    }

    @When("^click to Data Sources menu as user$")
    public void clickToDataSourcesMenuAsUser() {
        $(xpath("//*[@class='app__menu']/a[2]")).shouldHave(text("Data Sources")).click();
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

    @When("^click to Estimation menu as QA$")
    public void clickToEstimationMenuAsQA() {
        $(xpath("//*[@class='app__menu']/a[10]")).shouldHave(text("Estimation")).click();
    }

    @When("^click to Prediction menu as QA$")
    public void clickToPredictionMenuAsQA() {
        $(xpath("//*[@class='app__menu']/a[11]")).shouldHave(text("Prediction")).click();
    }

    @When("^click to \"([^\"]*)\" menu item")
    public void clickToMenuItem(String menuItemName) {
        $$(".app__menu-title").find(matchesText(menuItemName)).click();
        //TODO remove other methods(menu navigation) and replace to this one
    }

    @When("^click to Configuration menu as QA$")
    public void clickToConfigurationMenuAsQA() {
        $(xpath("//*[@class='app__menu']/a[13]")).shouldHave(text("Configuration")).click();
    }

    @When("^click to Configuration menu as admin$")
    public void clickToConfigurationMenuAsAdmin() {
        $(xpath("//*[@class='app__menu']/a[13]")).shouldHave(text("Configuration")).click();
    }
}
