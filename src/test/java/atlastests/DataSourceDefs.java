package atlastests;

import atlastests.components.PageControl;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static atlastests.TestDefs.getDataProperties;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class DataSourceDefs implements PageControl {
    private static final ElementsCollection SELECTS = $$(".reportControls select");
    private static final ElementsCollection REPORT_TABS_HEADERS = $$("#report .panel-heading");

    @When("^choose Source from Data Source as IMPALA$")
    public void chooseSourceFromDataSourceAsIMPALA() {
        $(By.xpath("//*[@id='currentComponent']/div/div[1]/div[1]/div/select")).selectOption("IMPALA");
    }

    @When("^Data Source Page opened$")
    public void dataSourcePageOpened() {
        checkPageHeader("Data Sources");
    }

    @When("^choose Report from Data Source as Dashboard$")
    public void chooseReportFromDataSourceAsDashboard() {
        $(By.xpath("//*[@id='currentComponent']/div/div[1]/div[2]/div/select")).selectOption("Dashboard");
    }

    @Then("^can see dashboard$")
    public void canSeeDashboard() {
        titleCheck("Dashboard Report");
    }

    @Then("^can see windows in DASHBOARD page$")
    public void canSeeWindowsInDashboard() {
        titleCheck("Dashboard Report");
        REPORT_TABS_HEADERS.shouldHave(CollectionCondition.size(5)).shouldHave(CollectionCondition.texts("CDM Summary",
                "Population by Gender", "Age at First Observation", "Cumulative Observation",
                "Persons With Continuous Observation By Month"));
    }

    @When("^choose Source from Data Source as SynPUF110KCost&Util$")
    public void chooseSourceFromDataSourceAsSynPUFKCostUtil() {
        $(By.xpath("//*[@id='currentComponent']/div/div[1]/div[1]/div/select")).selectOption("SynPUF 110K Cost&Util");
    }

    @When("^choose Source from Data Source as \"([^\"]*)\"$")
    public void chooseSourceFromDataSourceAs(String dataSourceName) {
        SELECTS.first().selectOption(dataSourceName);
    }

    @When("^choose Source from Data Source as \"([^\"]*)\" from property")
    public void chooseSourceFromDataSourceAsFromProperty(String arg0) throws Exception {
        $(By.xpath("//*[@class='reportControls pad-5']/div/div/select")).selectOption(getDataProperties(arg0));
    }

    @When("^choose Report from Data Source as \"([^\"]*)\" from property")
    public void chooseReportFromDataSourceAsFromProperty(String arg0) throws Exception {
        $(By.xpath("//*[@class='reportControls pad-5']/div[2]/div/select")).selectOption(getDataProperties(arg0));
    }

    @Then("^can see Data Density windows$")
    public void canSeeDataDensityWindows() {
        titleCheck("Data Density Report");
        REPORT_TABS_HEADERS.shouldHave(CollectionCondition.size(3)).
                shouldHave(CollectionCondition.texts("Total Rows", "Records Per Person", "Concepts Per Person"));
    }

    @Then("^can see Person windows$")
    public void canSeePersonWindows() {
        titleCheck("Person Report");
        REPORT_TABS_HEADERS.shouldHave(CollectionCondition.size(4)).
                shouldHave(CollectionCondition.texts("Year of Birth", "Gender", "Race", "Ethnicity"));
    }

    @Then("^can see Visit windows$")
    public void canSeeVisitWindows() {
        titleCheck("Visit Report");
    }

    @Then("^can see Condition windows$")
    public void canSeeConditionWindows() {
        titleCheck("Condition Occurrence Report");
    }

    @Then("^can see Condition Era windows$")
    public void canSeeConditionEraWindows() {
        titleCheck("Condition Era Report");
    }

    @Then("^can see Procedure windows$")
    public void canSeeProcedureWindows() {
        titleCheck("Procedure Report");
    }

    @Then("^can see Drug windows$")
    public void canSeeDrugWindows() {
        titleCheck("Drug Exposure Report");
    }

    @Then("^can see Drug Era windows$")
    public void canSeeDrugEraWindows() {
        titleCheck("Drug Era Report");
    }

    @Then("^can see Measurement windows$")
    public void canSeeMeasurementWindows() {
        titleCheck("Measurement Report");
    }

    @Then("^can see Observation windows$")
    public void canSeeObservationWindows() {
        titleCheck("Observation Report");
    }

    @Then("^can see Death windows$")
    public void canSeeDeathWindows() {
        titleCheck("Death Report");
        REPORT_TABS_HEADERS.shouldHave(CollectionCondition.size(4)).
                shouldHave(CollectionCondition.texts("Death Prevalence by Age, Gender, Year",
                        "Death Prevalence by Month", "Death by Type", "Age at Death"));
    }

    @Then("^can see Achilles Heel windows$")
    public void canSeeAchillesHeelWindows() {
        titleCheck("Achilles Heel Report");
        REPORT_TABS_HEADERS.shouldHave(CollectionCondition.texts("Achilles Heel Results"));
    }

    private void titleCheck(String expectedTitleText) {
        $(By.xpath("//*[@params='name: title']/div/span")).waitUntil(visible, 60000).
                shouldHave(text(expectedTitleText));
    }

    @When("^choose Report from Data Source as \"([^\"]*)\"$")
    public void chooseReportFromDataSourceAs(String reportName) {
        SELECTS.last().selectOption(reportName);
    }

    @When("^click to element in prevalence in Visit$")
    public void clickToElementInPrevalence() {
        $(By.xpath("//*[@class='cell']")).click();
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/heading-title/div/span")).waitUntil(visible, 2000);
    }

    @When("^click to element in prevalence in condition table$")
    public void clickToElementInPrevalenceInConditionTable() {
        $(By.xpath("//*[@class='cell']")).click();
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/heading-title/div/span")).waitUntil(visible, 120000);

    }

    @When("^click to element in prevalence in condition era table$")
    public void clickToElementInPrevalenceInConditionEraTable() {
        $(By.xpath("//*[@class='cell']")).click();
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/heading-title/div/span")).waitUntil(visible, 120000);

    }

    @When("^click to element in prevalence in table$")
    public void clickToElementInPrevalenceInTable() {
        $(By.xpath("//*[@class='cell']")).click();
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/heading-title/div/span")).waitUntil(visible, 120000);
    }

    @Then("^can see tables in Visit for cell$")
    public void canSeeTablesInVisitForCell() {
        REPORT_TABS_HEADERS.shouldHave(CollectionCondition.size(4)).
                shouldHave(CollectionCondition.texts("Prevalence", "Prevalence", "Prevalence by Month",
                        "Age at First Occurrence"));
    }

    @Then("^can see tables in Condition for cell$")
    public void canSeeTablesInConditionForCell() {
        REPORT_TABS_HEADERS.shouldHave(CollectionCondition.size(5)).
                shouldHave(CollectionCondition.texts("Prevalence", "Prevalence", "Prevalence by Month",
                        "Type", "Age at First Occurrence"));
    }

    @Then("^can see tables in Condition era for cell$")
    public void canSeeTablesInConditionEraForCell() {
        REPORT_TABS_HEADERS.shouldHave(CollectionCondition.size(4)).
                shouldHave(CollectionCondition.texts("Prevalence", "Prevalence", "Prevalence by Month",
                        "Age at First Occurrence"));
    }

    @Then("^can see tables in Procedure for cell$")
    public void canSeeTablesInProcedureForCell() {
        REPORT_TABS_HEADERS.shouldHave(CollectionCondition.size(6)).
                shouldHave(CollectionCondition.texts("Prevalence", "Prevalence", "Prevalence by Month",
                        "Type", "Age at First Occurrence", "Frequency Distribution"));
    }

    @Then("^can see tables in Drugs for cell$")
    public void canSeeTablesInDrugsForCell() {
        REPORT_TABS_HEADERS.shouldHave(CollectionCondition.size(6)).
                shouldHave(CollectionCondition.texts("Prevalence", "Prevalence", "Prevalence by Month",
                        "Type", "Age at First Occurrence", "Frequency Distribution"));
    }

    @Then("^can see tables in Drugs Era for cell$")
    public void canSeeTablesInDrugsEraForCell() {
        REPORT_TABS_HEADERS.shouldHave(CollectionCondition.size(5)).
                shouldHave(CollectionCondition.texts("Prevalence", "Prevalence", "Prevalence by Month",
                        "Age at First Occurrence", "Length of Era Distribution"));
    }

    @Then("^can see tables in Measurement for cell$")
    public void canSeeTablesInMeasurementForCell() {
        REPORT_TABS_HEADERS.
                shouldHave(CollectionCondition.texts("Prevalence", "Prevalence", "Prevalence by Month",
                        "Type", "Age at First Occurrence", "Value As Concept", "Operator Concept",
                        "Measurement Records by Unit", "Measurement Value Distribution", "Lower limit Distribution",
                        "Upper Limit Distribution", "Values Relative to Normal Range", "Frequency Distribution"));
    }

    @Then("^can see tables in Observation for cell$")
    public void canSeeTablesInObservationForCell() {
        REPORT_TABS_HEADERS.
                shouldHave(CollectionCondition.texts("Prevalence", "Prevalence", "Prevalence by Month",
                        "Type", "Age at First Occurrence", "Value As Concept", "Qualifier Concept",
                        "Frequency Distribution"));
    }

    @Then("^can see preloader in Data Source$")
    public void canSeePreloaderInDataSource() {
        $(By.xpath("//*[@id='currentComponent']/div/loading")).waitUntil(visible, 3000);
    }
}