package odysseusAT;

import com.codeborne.selenide.Condition;
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
}
