package atlastests;

import com.codeborne.selenide.Selectors;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class EstimationStepDefs {


    private String generatedString;
    private String newGeneratedString;
    private String cohortVal;



    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }


    @Then("^can see Estimation page$")
    public void canSeeEstimationPage() {
        $(By.xpath("//table/tbody/tr/td[1]")).waitUntil(visible, 4000);
    }

    @When("^click to New Population Level Effect Estimation$")
    public void clickToNewPopulationLevelEffectEstimation() {
        $(By.xpath("//*[@class='estimation-browser paddedWrapper flexed']/span")).click();
    }

    @Then("^can see creation page of Estimation$")
    public void canSeeCreationPageOfEstimation() {
        $(By.xpath("//*[@data-bind='text: title']")).waitUntil(visible, 3000);
        $(By.xpath("//*[@data-bind='text: title']")).shouldHave(text("New Population Level Effect Estimation - Comparative Cohort Analysis"));

    }

    @When("^enter new name of Estimation$")
    public void enterNewNameOfEstimation() {
        generatedString = RandomStringUtils.randomAlphanumeric(10);
        generatedString = "Test_" + generatedString;
        $$(By.xpath("//*[@type='text']")).get(0).clear();
        $$(By.xpath("//*[@type='text']")).get(0).setValue(generatedString);
    }

    @When("^click to save New Estimation button$")
    public void clickToSaveNewEstimationButton() {
        $(By.xpath("//*[@title='Save']")).waitUntil(visible, 3500);
        $(By.xpath("//*[@title='Save']")).click();
    }

    @Then("^can see buttons to Estimation$")
    public void canSeeButtonsToEstimation() {
        $(By.xpath("//*[@title='Close']")).waitUntil(visible, 3500);
        $(By.xpath("//*[@title='Create a copy']")).waitUntil(visible, 3500);

    }

    @Then("^can see table with our Estimation$")
    public void canSeeTableWithOurEstimation() {
        $(By.xpath("//table/tbody/tr/td")).waitUntil(visible, 4000);
    }

    @When("^enter name of our estimation in filter$")
    public void enterNameOfOurEstimationInFilter() throws InterruptedException {
        Thread.sleep(1000);
        $(By.xpath("//*[@type='search']")).waitUntil(visible,3000);
        $(By.xpath("//*[@type='search']")).setValue(generatedString);
    }

    @Then("^can see name of new Estimation in table$")
    public void canSeeNameOfNewEstimationInTable() {
        $(By.xpath("//tbody/tr/td[2]")).shouldHave(text(generatedString));
    }

    @When("^click to Estimation in table$")
    public void clickToEstimationInTable() throws InterruptedException {
        Thread.sleep(1000);
        $(By.xpath("//tbody/tr/td[2]/a")).click();
    }

    @Then("^can see our Estimation$")
    public void canSeeOurEstimation() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).waitUntil(visible,5000);
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).shouldHave(text("Population Level Effect Estimation - Comparative Cohort Analysis #"));
    }

    @Then("^can see new name of new Estimation in table$")
    public void canSeeNewNameOfNewEstimationInTable() {
        $(By.xpath("//*[@type='search']")).waitUntil(visible,3000);
        $(By.xpath("//*[@type='search']")).setValue(newGeneratedString);
    }

    @When("^change name of Estimation and press save$")
    public void changeNameOfEstimationAndPressSave() {
        newGeneratedString = RandomStringUtils.randomAlphanumeric(10);
        newGeneratedString = "Test_"+ newGeneratedString;
        $(By.xpath("//*[@type='text']")).clear();
        $(By.xpath("//*[@type='text']")).setValue(newGeneratedString);
        $(By.xpath("//*[@title='Save']")).click();
    }

    @When("^click to delete our Estimation$")
    public void clickToDeleteOurEstimation() {
        $(By.xpath("//*[@title='Delete']")).click();
    }

    @When("^accept delete Estimation$")
    public void acceptDeleteEstimation() {
        switchTo().alert().accept();
    }

    @Then("^cant see our Estimation in table$")
    public void cantSeeOurEstimationInTable() {
        $(By.xpath("//*[@type='search']")).waitUntil(visible,3000);
        $(By.xpath("//*[@type='search']")).setValue(newGeneratedString);
        $(By.xpath("//tbody/tr/td[2]")).shouldNotHave(text(newGeneratedString));
    }

    @When("^click to Comparisons tab$")
    public void clickToComparisonsTab() {
        $(By.xpath("//*[@class='pull-left']/ul/li[2]")).click();
    }

    @Then("^can see comparision page$")
    public void canSeeComparisionPage() throws InterruptedException {
        Thread.sleep(5000);
        $(By.xpath("//*[@id='summary']/div/div[3]/div/div/div[1]")).shouldNotHave(visible);
    }

    @When("^click to Analysis Setting tab$")
    public void clickToAnalysisSettingTab() {
        $(By.xpath("//*[@class='pull-left']/ul/li[3]")).click();
    }

    @Then("^can see Analysis Setting page$")
    public void canSeeAnalysisSettingPage() {
        $(By.xpath("//*[@id='summary']/div/div[2]/div/div/div[1]")).shouldNotHave(visible);
    }

    @When("^click to Evaluation Setting tab$")
    public void clickToEvaluationSettingTab() {
        $(By.xpath("//*[@class='pull-left']/ul/li[4]")).click();
    }

    @Then("^can see Evaluation Setting page$")
    public void canSeeEvaluationSettingPage() {
        $(By.xpath("//*[@id='summary']/div/div[2]/div/div/div[1]")).shouldNotHave(visible);
    }

    @When("^click to Executions tab in Estimation$")
    public void clickToExecutionsTabInEstimation() {
        $(byText("Executions")).click();
    }

    @Then("^can see Execution page in Estimation$")
    public void canSeeExecutionPageInEstimation() {
        $(By.xpath("//*[@class='comparative-cohort-analysis-executions__title']")).shouldHave(text("Generations"));
    }

    @When("^click to Utilities page in Estimation$")
    public void clickToUtilitiesPageInEstimation() {
        $(byText("Utilities")).click();
    }

    @Then("^can see Utilities page in Estimation$")
    public void canSeeUtilitiesPageInEstimation() {
        $(byText("Download")).shouldHave(visible);
        $(byText("Import")).shouldHave(visible);
        $(byText("Export")).shouldHave(visible);
    }

    @When("^click to add Comparison$")
    public void clickToAddComparison() {
        $$(By.xpath("//*[@class='btn btn-primary btn-sm pull-right']")).get(0).click();
    }

    @Then("^can see Comparison inputs$")
    public void canSeeComparisonInputs() {
        $(By.xpath("//*[@class='editor-heading']")).waitUntil(visible,3000);
        $(By.xpath("//*[@class='editor-heading']")).shouldHave(text("Comparison"));
    }

    @When("^click to open target cohort button$")
    public void clickToOpenTargetCohortButton() {
        $$(By.xpath("//*[@class='fa fa-folder-open']")).get(0).click();
    }

    @Then("^can see Select Cohort window$")
    public void canSeeSelectCohortWindow() {
        $$(By.xpath("//*[@class='linkish']")).get(1).waitUntil(visible,4000);

    }

    @When("^enter \"([^\"]*)\" in Filter in Cohort window$")
    public void enterInFilterInCohortWindow(String arg0) throws Throwable {
        $$(By.xpath("//*[@type='search']")).get(3).setValue(arg0);
    }

    @When("^click to result in CR in Cohort Window$")
    public void clickToResultInCRInCohortWindow() {
        cohortVal = $$(By.xpath("//*[@class='linkish']")).get(1).getText();
        $$(By.xpath("//*[@class='linkish']")).get(1).click();
    }


    @When("^click to open comparator cohort button$")
    public void clickToOpenComparatorCohortButton() {
        $$(By.xpath("//*[@class='fa fa-folder-open']")).get(1).click();
    }


    @Then("^can see choosed cohort in estimation outcome table$")
    public void canSeeChoosedCohortInEstimationOutcomeTable() {
        $(By.xpath("//*[@class=' linked-cohort-list__col-cohort-name ']")).shouldHave(text(cohortVal));
    }

    @When("^click to Add Outcome button$")
    public void clickToAddOutcomeButton() {
        $(By.xpath("//*[@class='linked-entity-list__actions']/button")).click();
    }

    @When("^click to Open Concept window$")
    public void clickToOpenConceptWindow() {
        $$(By.xpath("//*[@class='fa fa-folder-open']")).get(2).click();
    }

    @Then("^can see concept set window$")
    public void canSeeConceptSetWindow() {
        $(By.xpath("//*[@class='btn btn-sm btn-primary new-concept-set']")).waitUntil(visible,4000);

    }

    @When("^enter \"([^\"]*)\" in concept set window$")
    public void enterInConceptSetWindow(String arg0) throws Throwable {
        $(By.xpath("//*[@class='conceptset-browser-panel']/following-sibling::div/div/div/div[2]/label/input")).setValue(arg0);
    }

    @When("^click to search result in concept set window$")
    public void clickToSearchResultInConceptSetWindow() {
        $(By.xpath("//*[@class='stripe compact hover dataTable no-footer']/tbody/tr/td[2]")).click();
    }

    @When("^click back button to specification tab$")
    public void clickBackButtonToSpecificationTab() {
        $(By.xpath("//*[@class='fa fa-chevron-left fa-lg']")).click();
    }

    @When("^press Add Analysis Settings$")
    public void pressAddAnalysisSettings() {
        $(By.xpath("//*[@class='btn btn-primary btn-sm pull-right']")).waitUntil(visible,4000);
        $$(By.xpath("//*[@class='btn btn-primary btn-sm pull-right']")).get(1).click();
    }

    @When("^Enter Study Start and end date$")
    public void enterStudyStartAndEndDate() {
        $$(By.xpath("//*[@class='form-control dateField hasDatepicker']")).get(0).setValue("2019-01-01");
        $$(By.xpath("//*[@class='form-control dateField hasDatepicker']")).get(1).setValue("2019-02-02");
    }

    @When("^Enter include concept set in baseline covariates in the propensity score model$")
    public void enterIncludeConceptSetInBaselineCovariatesInThePropensityScoreModel() {
        $$(By.xpath("//*[@class='btn btn-primary']")).get(2).click();
    }

    @When("^Enter exclude concept set in baseline covariates in the propensity score model$")
    public void enterExcludeConceptSetInBaselineCovariatesInThePropensityScoreModel() {
        $$(By.xpath("//*[@class='btn btn-primary']")).get(3).click();
    }

    @When("^click to cancel button in Estimation$")
    public void clickToCancelButtonInEstimation() {
        $(By.xpath("//*[@title='Close']")).click();
    }


    @When("^click to Import tab in Estimation$")
    public void clickToImportTabInEstimation() {
        $$(By.xpath("//*[@class='nav nav-pills']/li[2]")).get(1).click();
    }

    @When("^past body of file \"([^\"]*)\" in Import input$")
    public void pastBodyOfFileInImportInput(String arg0) throws Throwable {
        String myString = readFile("src/test/java/atlastests/json/Celecoxib.json", StandardCharsets.ISO_8859_1);
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        $(By.xpath("//*[@class='import__json-box']")).sendKeys(Keys.CONTROL, "v");
    }

    @When("^click to Import button in Estimation$")
    public void clickToImportButtonInEstimation() {
        $(By.xpath("//*[@class='import__import-btn btn btn-default btn-sm']")).click();
    }

    @Then("^can see \"([^\"]*)\" in Comparisons table$")
    public void canSeeInComparisonsTable(String arg0) throws Throwable {
        $(By.xpath("//table/tbody/tr/td[2]")).shouldHave(text(arg0));
    }
}
