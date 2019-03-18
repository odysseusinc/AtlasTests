package odysseusAT;

import com.codeborne.selenide.Selectors;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class DataSourceDefs {
    @When("^choose Source from Data Source as IMPALA$")
    public void chooseSourceFromDataSourceAsIMPALA() throws InterruptedException {

        $(By.xpath("//*[@id='currentComponent']/div/div[1]/div[1]/div/select")).selectOption("IMPALA");
        Thread.sleep(1000);

    }

    @When("^Data Source Page opened$")
    public void dataSourcePageOpened() {
        //*[@id="currentComponent"]/heading-title/div/span
        $(xpath("//*[@id='currentComponent']/heading-title/div/span")).waitUntil(visible, 30000);
        $(xpath("//*[@id='currentComponent']/heading-title/div/span")).shouldHave(text("Data Sources"));
    }

    @When("^choose Report from Data Source as Dashboard$")
    public void chooseReportFromDataSourceAsDashboard() throws InterruptedException {
        $(By.xpath("//*[@id='currentComponent']/div/div[1]/div[2]/div/select")).selectOption("Dashboard");
        Thread.sleep(1000);
    }

    @Then("^can see dashboard$")
    public void canSeeDashboard() {
        $(By.xpath("//*[@params='name: title']/div/span")).waitUntil(visible, 20000);
        $(By.xpath("//*[@params='name: title']/div/span")).shouldHave(text("Dashboard Report"));


    }

    @Then("^can see windows in DASHBOARD page$")
    public void canSeeWindowsInDashboard() throws Throwable {
        $(By.xpath("//*[@params='name: title']/div/span")).waitUntil(visible, 20000);
        $(By.xpath("//*[@params='name: title']/div/span")).shouldHave(text("Dashboard Report"));
        $(By.xpath("//*[@id='report']/div/div[1]/div/div[1]")).shouldHave(text("CDM Summary"));
        $(By.xpath("//*[@id='report']/div/div[2]/div/div[1]")).shouldHave(text("Population by Gender"));
        $(By.xpath("//*[@id='report']/div/div[3]/div/div[1]")).shouldHave(text("Age at First Observation"));
        $(By.xpath("//*[@id='report']/div/div[4]/div/div[1]")).shouldHave(text("Cumulative Observation"));
        $(By.xpath("//*[@id='report']/div/div[5]/div/div[1]")).shouldHave(text("Persons With Continuous Observation By Month"));
    }

    @When("^choose Source from Data Source as SynPUF110KCost&Util$")
    public void chooseSourceFromDataSourceAsSynPUFKCostUtil() throws InterruptedException {
        $(By.xpath("//*[@id='currentComponent']/div/div[1]/div[1]/div/select")).selectOption("SynPUF 110K Cost&Util");
        Thread.sleep(1000);

    }

    @Then("^can see dashboard synpuf110kcost$")
    public void canSeeDashboardSynpufKcost() throws InterruptedException {

        Thread.sleep(2000);


    }

    @Then("^can see windows in SynPufCostUtil Dashboard$")
    public void canSeeWindowsInSynPufCostUtilDashboard() {
        $(By.xpath("//*[@params='name: title']/div/span")).waitUntil(visible, 60000);
        $(By.xpath("//*[@params='name: title']/div/span")).shouldHave(text("Dashboard Report"));
        $(By.xpath("//*[@id='report']/div/div[1]/div/div[1]")).shouldHave(text("CDM Summary"));
        $(By.xpath("//*[@id='report']/div/div[2]/div/div[1]")).shouldHave(text("Population by Gender"));
        $(By.xpath("//*[@id='report']/div/div[3]/div/div[1]")).shouldHave(text("Age at First Observation"));
        $(By.xpath("//*[@id='report']/div/div[4]/div/div[1]")).shouldHave(text("Cumulative Observation"));
        $(By.xpath("//*[@id='report']/div/div[5]/div/div[1]")).shouldHave(text("Persons With Continuous Observation By Month"));
    }

    @When("^choose Source from Data Source as \"([^\"]*)\"$")
    public void chooseSourceFromDataSourceAs(String arg0) throws InterruptedException {
        $(By.xpath("//*[@class='reportControls pad-5']/div/div/select")).selectOption(arg0);
        Thread.sleep(1000);
    }

    @Then("^can see Data Density windows$")
    public void canSeeDataDensityWindows() {
        $(By.xpath("//*[@params='name: title']/div/span")).waitUntil(visible, 60000);
        $(By.xpath("//*[@params='name: title']/div/span")).shouldHave(text("Data Density Report"));
        $(By.xpath("//*[@id='report']/div/div[1]/div/div[1]")).shouldHave(text("Total Rows"));
        $(By.xpath("//*[@id='report']/div/div[2]/div/div[1]")).shouldHave(text("Records Per Person"));
        $(By.xpath("//*[@id='report']/div/div[3]/div/div[1]")).shouldHave(text("Concepts Per Person"));
    }

    @Then("^can see Person windows$")
    public void canSeePersonWindows() {
        $(By.xpath("//*[@params='name: title']/div/span")).waitUntil(visible, 60000);
        $(By.xpath("//*[@params='name: title']/div/span")).shouldHave(text("Person Report"));
        $(By.xpath("//*[@id='report']/div/div[1]/div/div[1]")).shouldHave(text("Year of Birth"));
        $(By.xpath("//*[@id='report']/div/div[2]/div/div[1]")).shouldHave(text("Gender"));
        $(By.xpath("//*[@id='report']/div/div[3]/div/div[1]")).shouldHave(text("Race"));
        $(By.xpath("//*[@id='report']/div/div[4]/div/div[1]")).shouldHave(text("Ethnicity"));
    }

    @Then("^can see Visit windows$")
    public void canSeeVisitWindows() {
        $(By.xpath("//*[@params='name: title']/div/span")).waitUntil(visible, 60000);
        $(By.xpath("//*[@params='name: title']/div/span")).shouldHave(text("Visit Report"));
        $(By.xpath("//*[@id='report']/div/div/div[1]")).shouldHave(text("Prevalence"));
    }

    @Then("^can see Condition windows$")
    public void canSeeConditionWindows() {
        $(By.xpath("//*[@params='name: title']/div/span")).waitUntil(visible, 60000);
        $(By.xpath("//*[@params='name: title']/div/span")).shouldHave(text("Condition Occurrence Report"));
        $(By.xpath("//*[@id='report']/div/div/div[1]")).shouldHave(text("Prevalence"));
    }

    @Then("^can see Condition Era windows$")
    public void canSeeConditionEraWindows() {
        $(By.xpath("//*[@params='name: title']/div/span")).waitUntil(visible, 60000);
        $(By.xpath("//*[@params='name: title']/div/span")).shouldHave(text("Condition Era Report"));
        $(By.xpath("//*[@id='report']/div/div/div[1]")).shouldHave(text("Prevalence"));

        //*[@id="treemap-panel"]/treemap/empty-state/div/span


    }

    @Then("^can see Procedure windows$")
    public void canSeeProcedureWindows() {
        $(By.xpath("//*[@params='name: title']/div/span")).waitUntil(visible, 60000);
        $(By.xpath("//*[@params='name: title']/div/span")).shouldHave(text("Procedure Report"));
        $(By.xpath("//*[@id='report']/div/div/div[1]")).shouldHave(text("Prevalence"));
    }

    @Then("^can see Drug windows$")
    public void canSeeDrugWindows() {
        $(By.xpath("//*[@params='name: title']/div/span")).waitUntil(visible, 60000);
        $(By.xpath("//*[@params='name: title']/div/span")).shouldHave(text("Drug Exposure Report"));
        $(By.xpath("//*[@id='report']/div/div/div[1]")).shouldHave(text("Prevalence"));
    }

    @Then("^can see Drug Era windows$")
    public void canSeeDrugEraWindows() {
        $(By.xpath("//*[@params='name: title']/div/span")).waitUntil(visible, 60000);
        $(By.xpath("//*[@params='name: title']/div/span")).shouldHave(text("Drug Era Report"));
        $(By.xpath("//*[@id='report']/div/div/div[1]")).shouldHave(text("Prevalence"));
    }

    @Then("^can see Measurement windows$")
    public void canSeeMeasurementWindows() {
        $(By.xpath("//*[@params='name: title']/div/span")).waitUntil(visible, 60000);
        $(By.xpath("//*[@params='name: title']/div/span")).shouldHave(text("Measurement Report"));
        $(By.xpath("//*[@id='report']/div/div/div[1]")).shouldHave(text("Prevalence"));
    }

    @Then("^can see Observation windows$")
    public void canSeeObservationWindows() {
        $(By.xpath("//*[@params='name: title']/div/span")).waitUntil(visible, 60000);
        $(By.xpath("//*[@params='name: title']/div/span")).shouldHave(text("Observation Report"));
        $(By.xpath("//*[@id='report']/div/div/div[1]")).shouldHave(text("Prevalence"));
    }

    @Then("^can see Death windows$")
    public void canSeeDeathWindows() {
        $(By.xpath("//*[@params='name: title']/div/span")).waitUntil(visible, 60000);
        $(By.xpath("//*[@params='name: title']/div/span")).shouldHave(text("Death Report"));
        $(By.xpath("//*[@id='report']/div/div[1]/div/div[1]")).shouldHave(text("Death Prevalence by Age, Gender, Year"));
        $(By.xpath("//*[@id='report']/div/div[2]/div/div[1]")).shouldHave(text("Death Prevalence by Month"));
        $(By.xpath("//*[@id='report']/div/div[3]/div/div[1]")).shouldHave(text("Death by Type"));
        $(By.xpath("//*[@id='report']/div/div[4]/div/div[1]")).shouldHave(text("Age at Death"));

    }

    @Then("^can see Achilles Heel windows$")
    public void canSeeAchillesHeelWindows() {
        $(By.xpath("//*[@params='name: title']/div/span")).waitUntil(visible, 60000);
        $(By.xpath("//*[@params='name: title']/div/span")).shouldHave(text("Achilles Heel Report"));
        $(By.xpath("//*[@id='report']/div/div/div[1]")).shouldHave(text("Achilles Heel Results"));

    }

    @When("^choose Report from Data Source as \"([^\"]*)\"$")
    public void chooseReportFromDataSourceAs(String arg0) throws Throwable {
        $(By.xpath("//*[@class='reportControls pad-5']/div[2]/div/select")).selectOption(arg0);

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
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/heading-title/div/span")).shouldHave(text("Drilldown Report"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[1]/div/div[1]")).shouldHave(text("Prevalence"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[2]/div/div[1]")).shouldHave(text("Prevalence by Month"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[3]/div/div[1]")).shouldHave(text("Age at First Occurrence"));
    }

    @Then("^can see tables in Condition for cell$")
    public void canSeeTablesInConditionForCell() {
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/heading-title/div/span")).shouldHave(text("Drilldown Report"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[1]/div/div[1]")).shouldHave(text("Prevalence"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[2]/div/div[1]")).shouldHave(text("Prevalence by Month"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[3]/div/div[1]")).shouldHave(text("Type"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[3]/div[2]/div/div[1]")).shouldHave(text("Age at First Occurrence"));
    }

    @Then("^can see tables in Condition era for cell$")
    public void canSeeTablesInConditionEraForCell() {
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/heading-title/div/span")).shouldHave(text("Drilldown Report"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[1]/div/div[1]")).shouldHave(text("Prevalence"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[2]/div/div[1]")).shouldHave(text("Prevalence by Month"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[3]/div/div[1]")).shouldHave(text("Age at First Occurrence"));
    }

    @Then("^can see tables in Drugs for cell$")
    public void canSeeTablesInDrugsForCell() {
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/heading-title/div/span")).shouldHave(text("Drilldown Report"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[1]/div/div[1]")).shouldHave(text("Prevalence"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[2]/div/div[1]")).shouldHave(text("Prevalence by Month"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[3]/div/div[1]")).shouldHave(text("Type"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[3]/div[2]/div/div[1]")).shouldHave(text("Age at First Occurrence"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[5]/div/div[1]")).shouldHave(text("Frequency Distribution"));

    }

    @Then("^can see tables in Drugs Era for cell$")
    public void canSeeTablesInDrugsEraForCell() {
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/heading-title/div/span")).shouldHave(text("Drilldown Report"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[1]/div/div[1]")).shouldHave(text("Prevalence"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[2]/div/div[1]")).shouldHave(text("Prevalence by Month"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[3]/div/div[1]")).shouldHave(text("Age at First Occurrence"));
    }

    @Then("^can see tables in Procedure for cell$")
    public void canSeeTablesInProcedureForCell() {
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/heading-title/div/span")).shouldHave(text("Drilldown Report"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[1]/div/div[1]")).shouldHave(text("Prevalence"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[2]/div/div[1]")).shouldHave(text("Prevalence by Month"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[3]/div/div[1]")).shouldHave(text("Type"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[3]/div[2]/div/div[1]")).shouldHave(text("Age at First Occurrence"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[5]/div/div[1]")).shouldHave(text("Frequency Distribution"));
    }

    @Then("^can see tables in Measurement for cell$")
    public void canSeeTablesInMeasurementForCell() {
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/heading-title/div/span")).shouldHave(text("Drilldown Report"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[1]/div/div[1]")).shouldHave(text("Prevalence"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[2]/div/div[1]")).shouldHave(text("Prevalence by Month"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[3]/div/div[1]")).shouldHave(text("Type"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[3]/div[2]/div/div[1]")).shouldHave(text("Age at First Occurrence"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[4]/div[1]/div/div[1]")).shouldHave(text("Value As Concept"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[4]/div[2]/div/div[1]")).shouldHave(text("Operator Concept"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[5]/div[1]/div/div[1]")).shouldHave(text("Measurement Records by Unit"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[5]/div[2]/div/div[1]")).shouldHave(text("Measurement Value Distribution"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[6]/div[1]/div/div[1]")).shouldHave(text("Lower limit Distribution"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[6]/div[2]/div/div[1]")).shouldHave(text("Upper limit Distribution"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[6]/div[3]/div/div[1]")).shouldHave(text("Values Relative to Normal Range"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[7]/div/div[1]")).shouldHave(text("Frequency Distribution"));

    }

    @Then("^can see tables in Observation for cell$")
    public void canSeeTablesInObservationForCell() {
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/heading-title/div/span")).shouldHave(text("Drilldown Report"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[1]/div/div[1]")).shouldHave(text("Prevalence"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[2]/div/div[1]")).shouldHave(text("Prevalence by Month"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[3]/div/div[1]")).shouldHave(text("Type"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[3]/div[2]/div/div[1]")).shouldHave(text("Age at First Occurrence"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[4]/div[1]/div/div[1]")).shouldHave(text("Value As Concept"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[4]/div[2]/div/div[1]")).shouldHave(text("Qualifier Concept"));
        $(By.xpath("//*[@id='report']/div/report-treemap-drilldown/div/div[5]/div/div[1]")).shouldHave(text("Frequency Distribution"));

    }

    @Then("^can see preloader in Data Source$")
    public void canSeePreloaderInDataSource() {
        $(By.xpath("//*[@id='currentComponent']/div/loading")).waitUntil(visible,3000);
    }
}