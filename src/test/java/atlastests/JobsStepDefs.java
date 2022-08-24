package atlastests;

import atlastests.components.PageControl;
import atlastests.components.TablesControl;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class JobsStepDefs implements TablesControl, PageControl {
    private static final ElementsCollection COLUMN_HEADERS = $$("thead th");
    private File jobs;

    @Then("^can see Jobs page$")
    public void canSeeJobsPage() {
        checkPageHeader("Jobs");
    }

    @Then("^can see job table with all fields$")
    public void canSeeJobTableWithAllFields() {
        COLUMN_HEADERS.shouldHave(CollectionCondition.size(6),
                CollectionCondition.exactTexts("Execution Id", "Job Name", "Status",
                        "Author", "Start Date", "End Date"));
    }

    @When("^click to Column visibility button$")
    public void clickToColumnVisibilityButton() {
        $(".buttons-collection").click();
    }

    @Then("^can see window with column names$")
    public void canSeeWindowWithColumnNames() {
        $(".dt-button-collection").waitUntil(visible, 4000);
    }

    @When("^click to \"([^\"]*)\" button$")
    public void clickToButton(String arg0) {
        $$(".buttons-columnVisibility").find(matchesText(arg0)).click();
    }

    @Then("^cant see ExecutionId in table$")
    public void cantSeeExecutionIdInTable() {
        $(byText("Execution Id")).shouldNotBe(visible);
    }

    @When("^click to CSV button in Jobs$")
    public void clickToCSVButtonInJobs() throws FileNotFoundException {
        jobs = $(".buttons-csv").download();
    }

    @Then("^can see downloaded file$")
    public void canSeeDownloadedFile() {
        Assert.assertEquals("ATLAS Jobs.csv", jobs.getName());
    }

    @When("^click to name of column$")
    public void clickToNameOfColumn() {
        $(withText("No data available in table")).waitUntil(hidden, 5000);
        COLUMN_HEADERS.first().click();
    }

    @Then("^can see that Id order was changed$")
    public void canSeeThatIdOrderWasChanged() {
        String fValue = $(By.xpath("//table/tbody/tr/td[1]")).waitUntil(visible, 5000).getText();
        String sValue = $(By.xpath("//table/tbody/tr[2]/td[1]")).getText();
        Assert.assertTrue(Integer.parseInt(fValue) < Integer.parseInt(sValue));
    }

    @When("^enter \"([^\"]*)\" in search filter$")
    public void enterInSearchFilter(String arg0) {
        search(arg0);
    }

    @Then("^can see our result in table$")
    public void canSeeOurResultInTable() {
        $(".odd").shouldHave(text("warming"));
    }

    @When("^click to free space$")
    public void clickToFreeSpace() {
        $(By.xpath("//*[@class='dt-button buttons-columnVisibility active']")).waitUntil(enabled, 5000).
                pressEscape();
    }
}
