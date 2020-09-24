package atlastests;

import atlastests.components.TablesControl;
import atlastests.components.TabsControl;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static atlastests.components.StaticElements.CONCEPT_SET_IN_TABLE;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class IncidenceRatesStepDefs implements TabsControl, TablesControl {

    private static final ElementsCollection IR_TABS = $$(".ir-manager.nav-tabs a");
    private static final ElementsCollection CONCEPT_SET_BUTTONS = $$(".conceptset-list__button-pane [type='button']");
    private String generatedString;
    private String newGeneratedString;

    @Then("^can see Incidence Rates page$")
    public void canSeeIncidenceRatesPage() {
        $(By.xpath("//*[@data-bind='text: title']")).waitUntil(visible, 4000).
                shouldHave(text("Incidence Rate Analysis"));
    }

    @When("^click to New Analysis button in Incidence Rates$")
    public void clickToNewAnalysisButtonInIncidenceRates() {
        $(By.xpath("//*[@class='pull-right btn btn-sm btn-primary']")).click();
    }

    @Then("^can see Incidence Rates creation page$")
    public void canSeeIncidenceRatesCreationPage() {
        $(By.xpath("//*[@data-bind='text: title']")).shouldHave(text("New Incidence Rate Analysis"));
    }

    @When("^enter name on new Incidence Rates$")
    public void enterNameOnNewIncidenceRates() {
        generatedString = RandomStringUtils.randomAlphanumeric(10);
        generatedString = "Test_" + generatedString;
        $(By.xpath("//*[@type='text']")).setValue(generatedString);
    }

    @When("^enter \"([^\"]*)\" name on new Incidence Rate$")
    public void enterNameOnNewIncidenceRate(String arg0) {
        $(By.xpath("//*[@type='text']")).setValue(arg0);
    }

    @When("^click to save Incidence Rates Button$")
    public void clickToSaveIncidenceRatesButton() {
        $(By.xpath("//*[@class='fa fa-save']")).click();
    }

    @Then("^can see new buttons in incidence rates field$")
    public void canSeeNewButtonsInIncidenceRatesField() {
        $(By.xpath("//*[@title='Close']")).shouldBe(visible);
        $(By.xpath("//*[@title='Create a copy']")).shouldBe(visible);
        $(By.xpath("//*[@title='Delete']")).shouldBe(visible);
    }

    @When("^click to cancel button in Incidence rates$")
    public void clickToCancelButtonInIncidenceRates() {
        $(By.xpath("//*[@title='Close']")).click();
    }

    @When("^enter name of our IR in filter$")
    public void enterNameOfOurIRInFilter() {
        $(By.xpath("//*[@type='search']")).waitUntil(enabled, 5000).setValue(generatedString);
    }

    @Then("^can see our incidence rate in table$")
    public void canSeeOurIncidenceRateInTable() {
        $(By.xpath("//tbody/tr/td[2]")).shouldHave(text(generatedString));
    }

    @When("^click to our incidence rate$")
    public void clickToOurIncidenceRate() {
        $(By.xpath("//tbody/tr/td[2]/span")).waitUntil(visible, 4000).click();
    }

    @Then("^can see our incidence rate$")
    public void canSeeOurIncidenceRate() {
        $(By.xpath("//*[@data-bind='text: title']")).waitUntil(visible, 5000).
                shouldHave(text("Incidence Rate Analysis #"));
    }

    @When("^enter name of new IR in filter$")
    public void enterNameOfNewIRInFilter() {
        $(By.xpath("//*[@type='search']")).waitUntil(visible, 5000).setValue(newGeneratedString);
    }

    @When("^enter new name of incidence rate$")
    public void enterNewNameOfIncidenceRate() {
        newGeneratedString = RandomStringUtils.randomAlphanumeric(10);
        newGeneratedString = "Test_" + newGeneratedString;
        $(By.xpath("//*[@type='text']")).setValue(newGeneratedString);
    }

    @Then("^can see new incidence rate in table$")
    public void canSeeNewIncidenceRateInTable() {
        $(By.xpath("//tbody/tr/td[2]")).shouldHave(text(newGeneratedString));
    }

    @When("^click to new incidence rate$")
    public void clickToNewIncidenceRate() {
        $(By.xpath("//tbody/tr/td[2]/span")).waitUntil(enabled, 5000).click();
    }

    @When("^click to delete IR button$")
    public void clickToDeleteIRButton() {
        $(By.xpath("//*[@title='Delete']")).waitUntil(visible, 4000);
        $(By.xpath("//*[@title='Delete']")).click();
    }

    @When("^accept delete IR alert$")
    public void acceptDeleteIRAlert() {
        switchTo().alert().accept();
    }

    @Then("^cant find IR in table$")
    public void cantFindIRInTable() {
        $(".dataTables_empty").shouldBe(visible);
    }

    @Then("^can see concept set page in IR$")
    public void canSeeConceptSetPageInIR() {
        CONCEPT_SET_BUTTONS.shouldHave(CollectionCondition.texts("New Concept Set", "Import"));
    }

    @When("^click to \"([^\"]*)\" tab in IR$")
    public void chooseTab(String tabName) {
        IR_TABS.find(matchesText(tabName)).click();
    }

    @Then("^can see Generation page in IR$")
    public void canSeeGenerationPageInIR() {
        $(By.xpath("//*[@class='select-sources-btn__label']")).waitUntil(visible, 3000);
        $(By.xpath("//*[@class='ir-analysis-results__tbl-th ir-analysis-results__tbl-th--source']")).
                shouldHave(text("Source Name"));
    }

    @Then("^can see Utilities page in IR$")
    public void canSeeUtilitiesPageInIR() {
        $(By.xpath("//*[@class='nav nav-pills']/li[1]/a")).shouldHave(text("Import"));
        $(By.xpath("//*[@class='nav nav-pills']/li[2]/a")).shouldHave(text("Export"));
    }

    @When("^click to add Target Cohort$")
    public void clickToAddTargetCohort() {
        $(byText("Add Target Cohort")).waitUntil(visible, 3000).click();
    }

    @When("^enter \"([^\"]*)\" in filter of cohort$")
    public void enterInFilterOfCohort(String arg0) {
        $(By.xpath("//*[@class='dataTables_filter']/label/input")).setValue(arg0);
    }

    @When("^click to result in IR$")
    public void clickToResultInIR() {
        $(By.xpath("//*[@class='linkish']")).click();
    }

    @When("^close Cohort window in IR$")
    public void closeCohortWindowInIR() {
        $(By.xpath("//*[@class = 'modal-dialog']/div/div/button")).click();
    }


    @Then("^can see new rows under Target Cohorts$")
    public void canSeeNewRowsUnderTargetCohorts() {
        $(By.xpath("//table/tbody/tr[2]/td/table/tbody/tr/td[3]/span")).shouldHave(text("New users of phenytoin"));
        $(By.xpath("//table/tbody/tr[2]/td/table/tbody[2]/tr/td[3]/span")).shouldHave(text("New users of levetiracetam "));
    }

    @Then("^can see \"([^\"]*)\" Target Cohort$")
    public void canSeeTargetCohort(String arg0) {
        $(By.xpath("//table/tbody/tr[2]/td/table/tbody/tr/td[3]/span")).shouldHave(text(arg0));
    }

    @When("^click to Add Outcome Cohort$")
    public void clickToAddOutcomeCohort() {
        $(byText("Add Outcome Cohort")).waitUntil(visible, 3000).click();
    }

    @Then("^can see new rows under Outcome Cohort$")
    public void canSeeNewRowsUnderOutcomeCohort() {
        $(By.xpath("//table[1]/tbody/tr[2]/td[2]/table/tbody/tr/td[3]/span")).
                shouldHave(text("Levetriacetam vs phenytoin outcome cohort"));
    }

    @Then("^can see \"([^\"]*)\" Outcome Cohort$")
    public void canSeeOutcomeCohort(String arg0) {
        $(By.xpath("//table[1]/tbody/tr[2]/td[2]/table/tbody/tr/td[3]/span")).shouldHave(text(arg0));
    }

    @When("^choose Time at risk starts with value (\\d+)$")
    public void chooseTimeAtRiskStartsWithValue(int arg0) {
        $$(By.xpath("//*[@class='numericInputField dropdown ui-autocomplete-input']")).get(0).setValue("14");
    }

    @When("^choose Time at risk ends with value (\\d+)$")
    public void chooseTimeAtRiskEndsWithValue(int arg0) {
        $$(By.xpath("//*[@class='numericInputField dropdown ui-autocomplete-input']")).get(1).setValue("14");
    }

    @When("^press Import Concept Set in IR$")
    public void pressLoadConceptSetInIR() {
        CONCEPT_SET_BUTTONS.find(text("Import")).click();
    }

    @When("^choose Import from Repository$")
    public void chooseFromRepository() {
        $$(".conceptset-list-import__conceptset-tabs .tabs__header-title").find(text("Repository")).click();
    }


    @When("^enter \"([^\"]*)\" in filter Concept Set in IR$")
    public void enterInFilterConceptSetInIR(String arg0) {
        facetedTableSearch(arg0);
    }

    @When("^click to \"([^\"]*)\" in CS in IR$")
    public void clickToResultInCSInIR(String conceptName) {
        CONCEPT_SET_IN_TABLE.waitUntil(text(conceptName), 5000).click();
    }

    @Then("^can see chosen concept set in table: \"([^\"]*)\"$")
    public void canSeeChosenConceptSetInTable(String conceptName) {
        $(".repositoryConceptSetItem [data-bind='text: name']").shouldHave(text(conceptName));
    }

    @When("^click to copy button for our IR$")
    public void clickToCopyButtonForOurIR() {
        $(By.xpath("//*[@class='fa fa-copy']")).click();
    }

    @When("^enter \"([^\"]*)\" and name of our IR$")
    public void enterAndNameOfOurIR(String arg0) {
        $(By.xpath("//*[@type='search']")).setValue(arg0 + newGeneratedString);
    }

    @Then("^can see copy of our IR$")
    public void canSeeCopyOfOurIR() {
        $(By.xpath("//tbody/tr/td[2]")).shouldHave(text("COPY OF " + newGeneratedString));
    }

    @When("^click to Export tab in IR$")
    public void clickToExportTabInIR() {
        $$(".tab-content [role='presentation']").find(matchesText("Export")).click();
    }

    @When("^past json to IR textarea$")
    public void pastJsonToIRTextarea() {
        $(By.xpath("//*[@class='import__json-box']")).
                sendKeys(Keys.SHIFT, Keys.INSERT);
    }

    @When("^click to import ir button$")
    public void clickToImportIrButton() {
        $(".import__import-btn").click();
    }

    @Then("^can see Target cohorts with \"([^\"]*)\" and \"([^\"]*)\" values$")
    public void canSeeTargetCohortsWithAndValues(String arg0, String arg1) {
        $$(By.xpath("//table/tbody/tr[2]/td/table/tbody/tr/td[3]")).get(0).shouldHave(text(arg0));
        $$(By.xpath("//table/tbody/tr[2]/td/table/tbody/tr/td[3]")).get(1).shouldHave(text(arg1));
    }

    @Then("^can see Target cohort with \"([^\"]*)\" value$")
    public void canSeeTargetCohortWithValue(String arg0) {
        $$(By.xpath("//table/tbody/tr[2]/td/table/tbody/tr/td[3]")).get(0).shouldHave(text(arg0));
    }
}
