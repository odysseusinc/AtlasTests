package atlastests;

import atlastests.components.FormControl;
import atlastests.components.PageControl;
import atlastests.components.TablesControl;
import atlastests.components.TabsControl;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CohortPathwayStepDefs implements PageControl, FormControl, TablesControl, TabsControl {
    private String namePathway;
    private String newNamePathway;
    private final SelenideElement cohortOnPathwaysPage = $("[data-bind='clickToEdit: name']");
    private final ElementsCollection tableLinksInTable = $$("tbody .pathways-browser__tbl-col--name a");

    @Step ("can see Cohort Pathway page")
    @Then("^can see Cohort Pathway page$")
    public void canSeeCohortPathwayPage() {
        checkPageHeader("Cohort Pathways");
    }

    @Step ("click to button new Pathway Analysis")
    @When("^click to button New Pathway Analysis$")
    public void clickToButtonNewPathwayAnalysis() {
        $(".pathways-browser__create-btn").shouldBe(visible, Duration.ofMillis(5000)).click();
    }

    @Step ("can see creation page for New Cohort PAthway")
    @Then("^can see creation page of New Cohort Pathway$")
    public void canSeeCreationPageOfNewCohortPathway() {
        checkPageHeader("New Cohort Pathway");
    }

    @Step ("enter new name of cohort pathway")
    @When("^enter new name of cohort pathway$")
    public void enterNewNameOfCohortPathway() {
        namePathway = "Test_" + RandomStringUtils.randomAlphanumeric(10);
        setTitle(namePathway);
    }

    @Step ("click to save New Cohort PAthway button")
    @When("^click to save New Cohort Pathway button$")
    public void clickToSaveNewCohortPathwayButton() {
        saveAction();
        $(".fa-trash-alt").shouldBe(enabled, Duration.ofMillis(5000));
    }

    @Step ("click to save New Cohort PAtway button special case")
    @When("^click to save New Cohort Pathway button special case$")
    public void clickToSaveNewCohortPathwaySpecialCaseButton() {
        saveAction();
    }

    @Step ("can see button to cohort pathway")
    @Then("^can see buttons to cohort pathway$")
    public void canSeeButtonsToCohortPathway() {
        $(".fa-times.fa").shouldBe(visible, Duration.ofMillis(5000));
    }

    @Step ("click to cancel button")
    @When("^click to cancel button$")
    public void clickToCancelButton() {
        closeAction();
    }

    @Step ("click to cancel button Cohort definition")
    @When("^click to cancel button Cohort definition$")
    public void clickToCancelButtonCohortDefinition() {
        $$(".asset-heading .input-group-btn .btn").shouldHave(CollectionCondition.size(5)).
                forEach(SelenideElement::hover);
        $("[title='Close cohort definition']").shouldBe(enabled, Duration.ofMillis(5000)).click();
    }

    @Step ("can see table with our cohort pathway")
    @Then("^can see table with our cohort pathway$")
    public void canSeeTableWithOurCohortPathway() {
        $(By.xpath("//*[@class=' pathways-browser__tbl-col pathways-browser__tbl-col--name ']")).
                shouldBe(visible, Duration.ofMillis(10000));
    }

    @Step ("enter name of our pathway in filter")
    @When("^enter name of our pathway in filter$")
    public void enterNameOfOurPathwayInFilter() {
        $(By.xpath("//*[@type='search']")).setValue(namePathway);
    }

    @Step ("can see name of new cohort pathway in table")
    @Then("^can see name of new cohort pathway in table$")
    public void canSeeNameOfNewCohortPathwayInTable() {
        tableLinksInTable.first().shouldHave(text(namePathway));
    }

    @Step ("click to cohort pathway in table")
    @When("^click to cohort pathway in table$")
    public void clickToCohortPathwayInTable() {
        tableLinksInTable.first().click();
    }

    @Step ("can see our cohort pathway")
    @Then("^can see our cohort pathway$")
    public void canSeeOurCohortPathway() {
        checkPageHeader("Cohort Pathway #");
    }

    @Step ("change name and press save")
    @When("^change name and press save$")
    public void changeNameAndPressSave() {
        newNamePathway = "Test_" + RandomStringUtils.randomAlphanumeric(10);
        setTitle(newNamePathway);
        saveAction();
    }

    @Step ("can see new name of new cohort pathway in table")
    @Then("^can see new name of new cohort pathway in table$")
    public void canSeeNewNameOfNewCohortPathwayInTable() {
        closeAction();
        search(newNamePathway);
        tableLinksInTable.first().shouldHave(text(newNamePathway));
    }

    @Step ("click to delete our cohort pathway")
    @When("^click to delete our cohort pathway$")
    public void clickToDeleteOurCohortPathway() {
        deleteAction();
    }

    @Step ("accept delete cohort pathway")
    @When("^accept delete cohort pathway$")
    public void acceptDeleteCohortPathway() {
        switchTo().alert().accept();
    }

    @Step ("can NOT see our cohort pathway in table")
    @Then("^cant see our cohort pathway in table$")
    public void cantSeeOurCohortPathwayInTable() {
        search(newNamePathway);
        tableLinksInTable.first().shouldNotHave(text("COPY OF: " + newNamePathway));
    }

    @Step ("click to Import Target Cohorts")
    @When("^click to Import Target Cohorts$")
    public void
    clickToImportTargetCohorts() {
        $$(byText("Import")).get(0).click();
    }

    @Step ("choose cohort definition from table")
    @When("^choose cohort definition \"([^\"]*)\" from the table$")
    public void chooseCohortDefinitionFromTheTableInTargetCohortList(String arg0) {
        facetedTableSearch(arg0);
        selectInTableResults(arg0);
        importButtonClick();
    }

    @Step ("can see cohort definition in target cohort list")
    @Then("^can see cohort definition in target cohort list list$")
    public void canSeeCohortDefinitionInTargetCohortListList() {
        cohortOnPathwaysPage.shouldBe(visible, Duration.ofMillis(5000));
    }

    @Step ("click to Import Event Cohorts")
    @When("^click to Import Event Cohorts$")
    public void clickToImportEventCohorts() {
        $$(byText("Import")).get(1).click();
    }

    @Step ("can see cohort definition in event list")
    @Then("^can see cohort definition in event cohort list list$")
    public void canSeeCohortDefinitionInEventCohortListList() {
        $$("table.linked-entity-list__table").first().find(".linked-cohort-list__col-cohort-id").
                shouldBe(visible, Duration.ofMillis(5000));
    }

    @Step ("click to Executions tab")
    @When("^click to Executions tab$")
    public void clickToExecutionsTab() {
        chooseTab("Executions");
    }

    @Step ("can see Execution page")
    @Then("^can see Execution page$")
    public void canSeeExecutionPage() {
        checkExecutionTitle();
    }

    @Step ("click to Utilities tab")
    @When("^click to Utilities tab$")
    public void clickToUtilitiesTab() {
        chooseTab("Utilities");
    }

    @Step("can see Utilities page")
    @Then("^can see Utilities page$")
    public void canSeeUtilitiesPage() {
        $(".pathway-utils__title").shouldBe(visible, Duration.ofMillis(5000)).shouldHave(text("Utilities"));
    }

    @Step ("enter the same name of cohort pathway")
    @When("^enter the same name of cohort pathway$")
    public void enterTheSameNameOfCohortPathway() {
        setTitle(namePathway);
    }

    @Step ("click to save our cohort pathway")
    @When("^click to save our cohort pathway$")
    public void clickToSaveOurCohortPathway() {
        saveAction();
        $(By.xpath("//*[@class='btn btn-success disabled']")).shouldBe(visible, Duration.ofMillis(4000));
    }

    @Step ("click to copy button for our cohort pathway")
    @When("^click to copy button for our cohort pathway$")
    public void clickToCopyButtonForOurCohortPathway() {
        copyAction();
    }

    @Step ("enter name for  of cohort pathway")
    @When("^enter \"([^\"]*)\" and name of our cohort pathway$")
    public void enterAndNameOfOurCohortPathway(String arg0) {
        $(By.xpath("//*[@type='search']")).setValue(arg0 + newNamePathway);
    }

    @Step ("can see copy of our pathway")
    @Then("^can see copy of our pathway$")
    public void canSeeCopyOfOurPathway() {
        $(By.xpath("//*[@class=' pathways-browser__tbl-col pathways-browser__tbl-col--name ']/a")).
                shouldHave(text("COPY OF " + newNamePathway));
    }

    @Step ("copy text from export textarea")
    @When("^copy text from export textarea$")
    public void copyTextFromExportTextarea() {
        copyToClipboard();
    }

    @Step ("click to Import cohort pathway")
    @When("^click to Import cohort pathway$")
    public void clickToImportCohortPathway() {
        $$(".pathway-utils__nav-pill a").find(text("Import")).click();
    }

    @Step("past json to pathway textarea")
    @When("^past json to pathway textarea$")
    public void pastJsonToPathwayTextarea() {
        $("textarea.import__json-box").setValue(Selenide.clipboard().getText());
    }

    @Step ("click IMport button in pathway")
    @When("^click Import button in Pathways$")
    public void clickImportButtonInPathways() {
        $(".import__import-btn").click();
    }

    @Step ("can see target cohort in table")
    @Then("^can see target cohorts in table like as \"([^\"]*)\"$")
    public void canSeeTargetCohortsInTableLikeAs(String arg0) {
        cohortOnPathwaysPage.shouldHave(text(arg0));
    }

    @Step ("click to Design tab")
    @When("^click to Design tab$")
    public void clickToDesignTab() {
        chooseTab("Design");
    }
}

