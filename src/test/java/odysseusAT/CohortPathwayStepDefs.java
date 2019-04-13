package odysseusAT;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CohortPathwayStepDefs {
    String namePathway;


    @Then("^can see Cohort Pathway page$")
    public void canSeeCohortPathwayPage() {
        $(By.xpath("//*[@class='heading-title heading-title--dark'")).waitUntil(visible,4000);
        $(By.xpath("//*[@class='heading-title heading-title--dark'")).shouldHave(text("Cohort Pathways"));


    }

    @When("^click to button New Pathway Analysis$")
    public void clickToButtonNewPathwayAnalysis() {
        $(By.xpath("//*[@class='pathways-browser__toolbar']/button")).waitUntil(visible,3000);
        $(By.xpath("//*[@class='pathways-browser__toolbar']/button")).click();
    }

    @Then("^can see creation page of New Cohort Pathway$")
    public void canSeeCreationPageOfNewCohortPathway() {
        $(By.xpath("//*[@class='linked-entity-list__title']")).waitUntil(visible,4000);
        $(By.xpath("//*[@class='linked-entity-list__title']")).shouldHave(text("Target Cohorts\n"));
    }

    @When("^enter new name of cohort pathway$")
    public void enterNewNameOfCohortPathway() {
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        namePathway = "Test_" + generatedString ;
        $(By.xpath("//*[@type='text']")).clear();
        $(By.xpath("//*[@type='text']")).setValue(namePathway);
    }

    @When("^click to save New Cohort Pathway button$")
    public void clickToSaveNewCohortPathwayButton() {
        $(By.xpath("//*[@class='btn btn-success']")).click();
    }

    @Then("^can see buttons to cohort pathway$")
    public void canSeeButtonsToCohortPathway() {
        $(By.xpath("//*[@class='btn btn-primary']")).waitUntil(visible, 2000);
    }

    @When("^click to cancel button$")
    public void clickToCancelButton() {
        $(By.xpath("//*[@class='btn btn-primary']")).click();
    }

    @Then("^can see table with our cohort pathway$")
    public void canSeeTableWithOurCohortPathway() {
        $(By.xpath("//*[@class=' pathways-browser__tbl-col pathways-browser__tbl-col--name ']")).waitUntil(visible,4000);
    }

    @When("^enter name of our pathway in filter$")
    public void enterNameOfOurPathwayInFilter() {
        $(By.xpath("//*[@type='search']")).setValue(String.valueOf(text(namePathway)));
    }

    @Then("^can see name of new cohort pathway in table$")
    public void canSeeNameOfNewCohortPathwayInTable() {
        $(By.xpath("//table/tbody/tr/td/a")).shouldHave(text(namePathway));
    }

    @When("^click to cohort pathway in table$")
    public void clickToCohortPathwayInTable() {
        $(By.xpath("//table/tbody/tr/td/a")).click();
    }
}

