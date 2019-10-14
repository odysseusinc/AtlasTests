package atlastests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CohortPathwayStepDefs {
    private String namePathway;
    private String newNamePathway;

    @Then("^can see Cohort Pathway page$")
    public void canSeeCohortPathwayPage() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']")).waitUntil(visible, 4000).
                shouldHave(text("Cohort Pathways"));
    }

    @When("^click to button New Pathway Analysis$")
    public void clickToButtonNewPathwayAnalysis() {
        $(By.xpath("//*[@class='pathways-browser__toolbar']/button")).waitUntil(visible, 3000).click();
    }

    @Then("^can see creation page of New Cohort Pathway$")
    public void canSeeCreationPageOfNewCohortPathway() {
        $(By.xpath("//*[@class='linked-entity-list__title']")).waitUntil(visible, 4000).
                shouldHave(text("Target Cohorts"));
    }

    @When("^enter new name of cohort pathway$")
    public void enterNewNameOfCohortPathway() {
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        namePathway = "Test_" + generatedString;
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
    public void clickToCancelButton()  {
        $$(".asset-heading .input-group-btn .btn").shouldHave(CollectionCondition.size(5)).
                forEach(SelenideElement::hover);
        $("[title='Close cohort definition']").waitUntil(enabled, 5000).click();
    }

    @Then("^can see table with our cohort pathway$")
    public void canSeeTableWithOurCohortPathway() {
        $(By.xpath("//*[@class=' pathways-browser__tbl-col pathways-browser__tbl-col--name ']")).
                waitUntil(visible, 4000);
    }

    @When("^enter name of our pathway in filter$")
    public void enterNameOfOurPathwayInFilter() {
        $(By.xpath("//*[@type='search']")).setValue(namePathway);
    }

    @Then("^can see name of new cohort pathway in table$")
    public void canSeeNameOfNewCohortPathwayInTable() {
        $(By.xpath("//table/tbody/tr/td/a")).shouldHave(text(namePathway));
    }

    @When("^click to cohort pathway in table$")
    public void clickToCohortPathwayInTable() {
        $(By.xpath("//table/tbody/tr/td/a")).click();
    }

    @Then("^can see our cohort pathway$")
    public void canSeeOurCohortPathway() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).shouldHave(text("Cohort Pathway #"));
    }

    @When("^change name and press save$")
    public void changeNameAndPressSave() {
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        newNamePathway = "Test_" + generatedString;
        $(By.xpath("//*[@type='text']")).setValue(newNamePathway);
        $(By.xpath("//*[@class='btn btn-success']")).click();
    }

    @Then("^can see new name of new cohort pathway in table$")
    public void canSeeNewNameOfNewCohortPathwayInTable() {
        $(By.xpath("//*[@class='btn btn-primary']")).click();
        $(By.xpath("//*[@class=' pathways-browser__tbl-col pathways-browser__tbl-col--name ']")).
                waitUntil(visible, 4000);
        $(By.xpath("//*[@type='search']")).setValue(newNamePathway);
        $(By.xpath("//table/tbody/tr/td/a")).shouldHave(text(newNamePathway));


    }

    @When("^click to delete our cohort pathway$")
    public void clickToDeleteOurCohortPathway() {
        $(By.xpath("//*[@class='btn btn-danger']")).click();
    }

    @When("^accept delete cohort pathway$")
    public void acceptDeleteCohortPathway() {
        switchTo().alert().accept();
    }

    @Then("^cant see our cohort pathway in table$")
    public void cantSeeOurCohortPathwayInTable() {
        $(By.xpath("//*[@class=' pathways-browser__tbl-col pathways-browser__tbl-col--name ']")).waitUntil(visible, 4000);
        $(By.xpath("//*[@type='search']")).setValue(String.valueOf(text(newNamePathway)));
        $(By.xpath("//table/tbody/tr/td/a")).shouldNotHave(text(newNamePathway));
    }

    @When("^click to Import Target Cohorts$")
    public void clickToImportTargetCohorts() {
        $$(byText("Import")).get(0).click();
    }

    @When("^choose cohort definition from the table in target cohort list$")
    public void chooseCohortDefinitionFromTheTableInTargetCohortList() {
        $(By.xpath("//*[@class='linkish']")).waitUntil(visible, 3000).click();
    }

    @Then("^can see cohort definition in target cohort list list$")
    public void canSeeCohortDefinitionInTargetCohortListList() {
        $(By.xpath("//*[@class='linked-cohort-list__col-cohort-id sorting_1']")).waitUntil(visible, 3000);
    }

    @When("^click to Import Event Cohorts$")
    public void clickToImportEventCohorts() {
        $$(byText("Import")).get(1).click();
    }

    @When("^choose cohort definition from the table in event cohort list$")
    public void chooseCohortDefinitionFromTheTableInEventCohortList() {
        $(By.xpath("//*[@class='linkish']")).waitUntil(visible, 3000).click();
    }

    @Then("^can see cohort definition in event cohort list list$")
    public void canSeeCohortDefinitionInEventCohortListList() {
        $$("table.linked-entity-list__table").get(1).$(".linked-cohort-list__col-cohort-id").
                waitUntil(visible, 2000);
    }

    @When("^click to Executions tab$")
    public void clickToExecutionsTab() {
        $(byText("Executions")).click();
    }

    @Then("^can see Execution page$")
    public void canSeeExecutionPage() {
        $(By.xpath("//*[@class = 'pathway-executions__title']")).waitUntil(visible, 4000).
                shouldHave(text("Executions"));
    }

    @When("^click to Utilities tab$")
    public void clickToUtilitiesTab() {
        $(byText("Utilities")).click();
    }

    @Then("^can see Utilities page$")
    public void canSeeUtilitiesPage() {
        $(By.xpath("//*[@class = 'pathway-utils__title']")).waitUntil(visible, 3000).
                shouldHave(text("Utilities"));
    }

    @When("^enter the same name of cohort pathway$")
    public void enterTheSameNameOfCohortPathway() {
        $(By.xpath("//*[@type='text']")).setValue(namePathway);
    }

    @When("^click to save our cohort pathway$")
    public void clickToSaveOurCohortPathway() {
        $(By.xpath("//*[@class='fa fa-save']")).click();
    }

    @When("^click to copy button for our cohort pathway$")
    public void clickToCopyButtonForOurCohortPathway() {
        $$(By.xpath("//*[@class='btn btn-primary']")).get(1).click();
    }

    @When("^enter \"([^\"]*)\" and name of our cohort pathway$")
    public void enterAndNameOfOurCohortPathway(String arg0) {
        $(By.xpath("//*[@type='search']")).setValue(arg0 + newNamePathway);
    }

    @Then("^can see copy of our pathway$")
    public void canSeeCopyOfOurPathway() {
        $(By.xpath("//*[@class=' pathways-browser__tbl-col pathways-browser__tbl-col--name ']/a")).
                shouldHave(text("COPY OF: " + newNamePathway));
    }

    @When("^copy text from export textarea$")
    public void copyTextFromExportTextarea() {
        $(By.xpath("//*[@class='export__json-box']")).click();
        $(By.xpath("//*[@class='export__json-box']")).sendKeys(Keys.CONTROL, "a");
        $(By.xpath("//*[@class='export__json-box']")).sendKeys(Keys.CONTROL, "c");
    }

    @When("^click to Import cohort pathway$")
    public void clickToImportCohortPathway() {
        $(By.xpath("//*[@class='pathway-utils__nav-pill']")).click();
    }

    @When("^past json to pathway textarea$")
    public void pastJsonToPathwayTextarea() {
        $(By.xpath("//*[@class='import__json-box']")).sendKeys(Keys.CONTROL, "v");
    }

    @When("^click Import button in Pathways$")
    public void clickImportButtonInPathways() {
        $(By.xpath("//*[@class='import__import-btn btn btn-default btn-sm']")).click();
    }

    @Then("^can see target cohorts in table like as \"([^\"]*)\"$")
    public void canSeeTargetCohortsInTableLikeAs(String arg0) {
        $$(By.xpath("//*[@class=' linked-cohort-list__col-cohort-name linked-cohort-list__col-cohort-name--editable ']/span/span")).get(0).shouldHave(text(arg0));
    }
}

