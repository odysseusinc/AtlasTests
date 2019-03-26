package odysseusAT;

import com.codeborne.selenide.Condition;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class CohortDefinitionStepDefs {

    String nameCohort;

    @Then("^can see Cohort Definition page$")
    public void canSeeCohortDefinitionPage() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).waitUntil(visible, 4000);
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).shouldHave(text("Cohort definitions"));
    }

    @When("^click New Cohort button$")
    public void clickNewCohortButton() {
        $(By.xpath("//*[@class='btn btn-sm btn-primary']")).click();


    }

    @Then("^can see new cohort page creation$")
    public void canSeeNewCohortPageCreation() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']")).waitUntil(visible,3000);
        $(By.xpath("//*[@class='heading-title heading-title--dark']")).shouldHave(text("New Cohort Definition"));

    }

    @When("^enter name of New Cohort Definition and save it$")
    public void enterNameOfNewCohortDefinitionAndSaveIt() throws InterruptedException {
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        nameCohort = "Test_" + generatedString ;
        $(By.xpath("//*[@class='form-control']")).clear();
        $(By.xpath("//*[@class='input-group']/input")).setValue(nameCohort);
        Thread.sleep(300);
        $(By.xpath("//*[@class='fa fa-save']")).click();

    }

    @Then("^filtered Cohort Definition$")
    public void filteredCohortDefinition() throws InterruptedException {
        $(By.xpath("//*[@type='search']")).waitUntil(visible,4000);
        $(By.xpath("//*[@type='search']")).setValue(nameCohort);

    }

    @Then("^Cohort Definition should be found$")
    public void cohortDefinitionShouldBeFound() {
        $(By.xpath("//table/tbody/tr/td[2]")).shouldHave(text(nameCohort));

    }

    @When("^click to our Cohort Definition$")
    public void clickToOurCohortDefinition() {
        $(By.xpath("//table/tbody/tr/td[2]")).click();
    }

    @Then("^can see our Cohort Definition$")
    public void canSeeOurCohortDefinition() {
//        $(By.xpath("//*[@id='cohortTextView']/div")).shouldHave(value(nameCohort));
        $(By.xpath("//*[@class='panel panel-primary cohort-definition-panel']")).waitUntil(visible,2000);

    }

    @When("^click to delete our Cohort Definition$")
    public void clickToDeleteOurCohortDefinition() {
        $(By.xpath("//*[@class='fa fa-trash-o']")).click();

    }

    @When("^accept delete Cohort Definition alert$")
    public void acceptDeleteCohortDefinitionAlert() {
        switchTo().alert().accept();

    }

    @Then("^Cohort Definition should be not found$")
    public void cohortDefinitionShouldBeNotFound() {
        $(By.xpath("//table/tbody/tr/td")).shouldHave(text("No matching records found"));

    }

    @When("^press Add Initial Event$")
    public void pressAddInitialEvent() {
        $(By.xpath("//*[@class='btn btn-primary btn-sm dropdown-toggle']")).click();
    }

    @When("^press Add Condition Era$")
    public void pressAddConditionEra() {
        $(By.xpath("//*[@class='dropdown-menu']/li/a")).click();
    }

    @Then("^a condition era block shown$")
    public void aConditionEraBlockShown() {
        $(By.xpath("//*[@class='criteriaTable'][1]/tbody/tr/td")).shouldHave(text("a condition era of"));
    }

    @When("^click to Any Condition menu$")
    public void clickToAnyConditionMenu() {
        $(By.xpath("//*[@class='btn btn-primary dropdown-toggle']")).click();
    }

    @When("^choose Import Concept Set$")
    public void chooseImportConceptSet() {
        $(By.xpath("//*[@class='dropdown-menu dropdown-menu-right']/li[2]")).click();
    }

    @Then("^Import Concept Set window shown$")
    public void importConceptSetWindowShown() {
        $(By.xpath("//*[@class='modal fade in']/div/div/div")).shouldHave(text("Import Concept Set From Repository..."));
    }


    @When("^enter \"([^\"]*)\" to Filter of Concept Set from Repository$")
    public void enterToFilterOfConceptSetFromRepository(String arg0) throws Throwable {
        $(By.xpath("//*[@type='search']")).setValue(arg0);
    }

    @Then("^can see only one field$")
    public void canSeeOnlyOneField() {
        $(By.xpath("//*[@class='stripe compact hover dataTable no-footer']/tbody/tr/td")).shouldHave(text("71"));
    }

    @When("^click to chosen concept set from repository$")
    public void clickToChosenConceptSetFromRepository() {
        $(By.xpath("//*[@class='stripe compact hover dataTable no-footer']/tbody/tr/td")).click();
    }

    @Then("^can see name of concept set at the button$")
    public void canSeeNameOfConceptSetAtTheButton() {
        $(By.xpath("//*[@class='btn btn-primary conceptset_edit']")).shouldHave(text("Testeeeest"));
    }

    @When("^click to Concept Sets tab$")
    public void clickToConceptSetsTab() {
        $(By.xpath("//*[@class='nav nav-tabs']/li[2]")).click();
    }

    @Then("^can see row with name of Concept Set in the table$")
    public void canSeeRowWithNameOfConceptSetInTheTable() {
        $(By.xpath("//*[@class='conceptSetTable stripe compact hover dataTable no-footer']/tbody/tr/td")).shouldHave(text("0"));

    }

    @When("^click on the row in table concept set in cohort definitions$")
    public void clickOnTheRowInTableConceptSetInCohortDefinitions() {
        $(By.xpath("//*[@class='conceptSetTable stripe compact hover dataTable no-footer']/tbody/tr/td")).click();
    }

    @Then("^can see table of concept set with concepts$")
    public void canSeeTableOfConceptSetWithConcepts() {
        $(By.xpath("//*[@class='standard']")).shouldHave(text("Aspirin"));
    }
}
