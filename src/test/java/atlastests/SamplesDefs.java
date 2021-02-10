package atlastests;

import atlastests.models.SampleModel;
import com.codeborne.selenide.*;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static atlastests.TestDefs.getDataProperties;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class SamplesDefs {

    private static SelenideElement sampleInTable = $("[data-bind='visible: !$component.isLoadingSampleData() " +
            "&& $component.sampleSourceKey()'] .linkish");
    private static ElementsCollection personsInTable = $$("[data-bind='visible: " +
            "$component.sampleSourceKey() && $component.selectedSampleId() &&" +
            " !$component.sampleDataLoading()'] .linkish");

    private SampleModel sampleModel;

    @When("^Select source for samples from properties: \"([^\"]*)\"$")
    public void selectSourceForSamples(String propertyName) throws Exception {
        $(".active select.form-control").selectOption(getDataProperties(propertyName));
    }

    @Then("^Samples table is shown$")
    public void samplesTableIsShown() {
        $("[aria-label='Sample name: activate to sort column ascending']").shouldBe(Condition.visible);
    }

    @When("^Trying to add a sample:")
    public void addSample(DataTable dataTable) {
        sampleModel = dataTable.asList(SampleModel.class).get(0);

        $("[data-bind='click:addNewSample']").click();

        SelenideElement sampleCreatingForm = $(".sampleCreatingForm");
        sampleCreatingForm.find("#sampleCreatingName").setValue(sampleModel.getName());

        ElementsCollection numbers = sampleCreatingForm.findAll("input[placeholder='Enter a number']");
        numbers.get(0).setValue(String.valueOf(sampleModel.getSize()));
        numbers.get(1).setValue(String.valueOf(sampleModel.getAge()));

        sampleCreatingForm.findAll(".sampleCreatingForm .checkbox").
                find(Condition.text(sampleModel.getGender())).find("input").click();

        sampleCreatingForm.find(".btn[type='submit']").click();
    }

    @Then("^Sample is added$")
    public void checkSampleIsAdded() {
        sampleInTable.shouldHave(Condition.text(sampleModel.getName()));
    }

    @When("^Click on created sample to see results$")
    public void clickOnSampleInTable() {
        sampleInTable.click();
    }

    @Then("^Results are shown$")
    public void checkPersonsAreLoaded() {
        personsInTable.shouldHave(CollectionCondition.size(10)).forEach(e -> e.shouldBe(Condition.visible));
    }

    @When("^Click to a person from results table$")
    public void clickOnFirstPerson() {
        personsInTable.first().click();
        Selenide.switchTo().window(1);
    }

    @Then("^Profile is opened$")
    public void checkProfileIsOpened() {
        $(".profile-manager__profile-control").waitUntil(Condition.visible, 15000);
    }

}
