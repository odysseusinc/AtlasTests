package atlastests;

import atlastests.components.TablesControl;
import atlastests.components.FormControl;
import atlastests.components.PageControl;
import atlastests.components.TabsControl;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CohortPathwayStepDefs implements PageControl, FormControl, TablesControl, TabsControl {
    private String namePathway;
    private String newNamePathway;
    private SelenideElement facetedTableLink = $(".linkish");
    private SelenideElement cohortOnPathwaysPage = $("[data-bind='clickToEdit: name']");
    private ElementsCollection tableLinksInTable = $$("tbody .pathways-browser__tbl-col--name a");

    @Then("^can see Cohort Pathway page$")
    public void canSeeCohortPathwayPage() {
        checkPageHeader("Cohort Pathways");
    }

    @When("^click to button New Pathway Analysis$")
    public void clickToButtonNewPathwayAnalysis() {
        $(".pathways-browser__create-btn").waitUntil(visible, 5000).click();
    }

    @Then("^can see creation page of New Cohort Pathway$")
    public void canSeeCreationPageOfNewCohortPathway() {
        checkPageHeader("New Cohort Pathway");
    }

    @When("^enter new name of cohort pathway$")
    public void enterNewNameOfCohortPathway() {
        namePathway = "Test_" + RandomStringUtils.randomAlphanumeric(10);
        setTitle(namePathway);
    }

    @When("^click to save New Cohort Pathway button$")
    public void clickToSaveNewCohortPathwayButton() {
        saveAction();
        $(".fa-trash-o").waitUntil(enabled, 5000);
    }

    @When("^click to save New Cohort Pathway button special case$")
    public void clickToSaveNewCohortPathwaySpecialCaseButton() {
        saveAction();
    }

    @Then("^can see buttons to cohort pathway$")
    public void canSeeButtonsToCohortPathway() {
        $(".fa-times.fa").waitUntil(visible, 5000);
    }

    @When("^click to cancel button$")
    public void clickToCancelButton() {
        closeAction();
    }

    @When("^click to cancel button Cohort definition$")
    public void clickToCancelButtonCohortDefinition() {
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
        tableLinksInTable.first().shouldHave(text(namePathway));
    }

    @When("^click to cohort pathway in table$")
    public void clickToCohortPathwayInTable() {
        tableLinksInTable.first().click();
    }

    @Then("^can see our cohort pathway$")
    public void canSeeOurCohortPathway() {
        checkPageHeader("Cohort Pathway #");
    }

    @When("^change name and press save$")
    public void changeNameAndPressSave() {
        newNamePathway = "Test_" + RandomStringUtils.randomAlphanumeric(10);
        setTitle(newNamePathway);
        saveAction();
    }

    @Then("^can see new name of new cohort pathway in table$")
    public void canSeeNewNameOfNewCohortPathwayInTable() {
        closeAction();
        search(newNamePathway);
        tableLinksInTable.first().shouldHave(text(newNamePathway));
    }

    @When("^click to delete our cohort pathway$")
    public void clickToDeleteOurCohortPathway() {
        deleteAction();
    }

    @When("^accept delete cohort pathway$")
    public void acceptDeleteCohortPathway() {
        switchTo().alert().accept();
    }

    @Then("^cant see our cohort pathway in table$")
    public void cantSeeOurCohortPathwayInTable() {
        search(newNamePathway);
        tableLinksInTable.first().shouldNotHave(text("COPY OF: " + newNamePathway));
    }

    @When("^click to Import Target Cohorts$")
    public void
    clickToImportTargetCohorts() {
        $$(byText("Import")).get(0).click();
    }

    @When("^choose cohort definition \"([^\"]*)\" from the table$")
    public void chooseCohortDefinitionFromTheTableInTargetCohortList(String arg0) {
        facetedTableSearch(arg0);
        selectInTableResults(arg0);
        importButtonClick();
    }


    @Then("^can see cohort definition in target cohort list list$")
    public void canSeeCohortDefinitionInTargetCohortListList() {
        cohortOnPathwaysPage.waitUntil(visible, 5000);
    }

    @When("^click to Import Event Cohorts$")
    public void clickToImportEventCohorts() {
        $$(byText("Import")).get(1).click();
    }

    @Then("^can see cohort definition in event cohort list list$")
    public void canSeeCohortDefinitionInEventCohortListList() {
        $$("table.linked-entity-list__table").first().find(".linked-cohort-list__col-cohort-id").
                waitUntil(visible, 5000);
    }

    @When("^click to Executions tab$")
    public void clickToExecutionsTab() {
        chooseTab("Executions");
    }

    @Then("^can see Execution page$")
    public void canSeeExecutionPage() {
        $(".analysis-execution-list__title").waitUntil(visible, 5000).shouldHave(text("Executions"));
    }

    @When("^click to Utilities tab$")
    public void clickToUtilitiesTab() {
        chooseTab("Utilities");
    }

    @Then("^can see Utilities page$")
    public void canSeeUtilitiesPage() {
        $(".pathway-utils__title").waitUntil(visible, 5000).shouldHave(text("Utilities"));
    }

    @When("^enter the same name of cohort pathway$")
    public void enterTheSameNameOfCohortPathway() {
        setTitle(namePathway);
    }

    @When("^click to save our cohort pathway$")
    public void clickToSaveOurCohortPathway() {
        saveAction();
        $(By.xpath("//*[@class='btn btn-success disabled']")).waitUntil(visible, 4000);
    }

    @When("^click to copy button for our cohort pathway$")
    public void clickToCopyButtonForOurCohortPathway() {
        copyAction();
    }

    @When("^enter \"([^\"]*)\" and name of our cohort pathway$")
    public void enterAndNameOfOurCohortPathway(String arg0) {
        $(By.xpath("//*[@type='search']")).setValue(arg0 + newNamePathway);
    }

    @Then("^can see copy of our pathway$")
    public void canSeeCopyOfOurPathway() {
        $(By.xpath("//*[@class=' pathways-browser__tbl-col pathways-browser__tbl-col--name ']/a")).
                shouldHave(text("COPY OF " + newNamePathway));
    }

    @When("^copy text from export textarea$")
    public void copyTextFromExportTextarea() {
        copyToClipboard();
    }

    @When("^click to Import cohort pathway$")
    public void clickToImportCohortPathway() {
        $$(".pathway-utils__nav-pill a").find(text("Import")).click();
    }

    @When("^past json to pathway textarea$")
    public void pastJsonToPathwayTextarea() {
        $("textarea.import__json-box").sendKeys(Keys.SHIFT, Keys.INSERT);
    }

    @When("^click Import button in Pathways$")
    public void clickImportButtonInPathways() {
        $(".import__import-btn").click();
    }

    @Then("^can see target cohorts in table like as \"([^\"]*)\"$")
    public void canSeeTargetCohortsInTableLikeAs(String arg0) {
        cohortOnPathwaysPage.shouldHave(text(arg0));
    }

    @When("^click to Design tab$")
    public void clickToDesignTab() {
        chooseTab("Design");
    }
}

