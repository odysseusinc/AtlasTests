package atlastests;

import atlastests.components.PageControl;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static atlastests.TestDefs.getDataProperties;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProfileStepDefs implements PageControl {

    @Then("^can see Profiles page$")
    public void canSeeProfilesPage() {
        checkPageHeader("Profiles");
    }

    @When("^click to Select a Data Source$")
    public void clickToSelectADataSource() {
        $("[title='choose a data source']").waitUntil(visible, 5000).click();
    }

    @When("^choose \"([^\"]*)\" in Profile Source from property$")
    public void chooseInProfileSourceFromProperty(String arg0) throws Exception {
        chooseInProfileSource(getDataProperties(arg0));
    }

    @When("^choose \"([^\"]*)\" in Profile Source$")
    public void chooseInProfileSource(String arg0) {
        $(withText(arg0)).click();
    }

    @When("^enter (\\d+) in Profile Id and press Enter$")
    public void enterInProfileIdAndPressEnter(int arg0) {
        $("[placeholder='Person Id']").setValue(String.valueOf(arg0)).pressEnter();
    }

    @Then("^can see overlay$")
    public void canSeeOverlay() {
        $(".overlay").waitUntil(visible, 50000);
    }

    @Then("^can see table$")
    public void canSeeTable() {
        $$(".conceptTable").filter(visible).first().shouldBe(enabled);
    }
}
