package atlastests;

import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static atlastests.SearchDefs.isFileDownloaded;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class JobsStepDefs {
    @Then("^can see Jobs page$")
    public void canSeeJobsPage() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).waitUntil(visible, 4000).
                shouldHave(text("Jobs"));
    }

    @Then("^can see job table with all fields$")
    public void canSeeJobTableWithAllFields() {
        ElementsCollection table = $$(By.xpath("//table/tbody/tr/td"));
        for (int i = 0; i < 2; i++) {
            table.get(i).shouldNotBe(empty, text("-"));
        }
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
        $(byText("ExecutionId")).shouldNotBe(visible);
    }

    @When("^click to CSV button in Jobs$")
    public void clickToCSVButtonInJobs() {
        $(By.xpath("//*[@class='dt-button buttons-csv buttons-html5']")).click();
    }

    @Then("^can see downloaded file$")
    public void canSeeDownloadedFile() throws Exception {
        Assert.assertTrue(isFileDownloaded(LoginStepsDefs.getDataProperties("downloadpath"),
                "ATLAS Jobs.csv"));
    }

    @When("^click to name of column$")
    public void clickToNameOfColumn() {
        $(By.xpath("//table/thead/tr/th[1]")).click();
    }

    @Then("^can see that Id order was changed$")
    public void canSeeThatIdOrderWasChanged() {
        String fValue = $(By.xpath("//table/tbody/tr/td[1]")).waitUntil(visible, 5000).getText();
        String sValue = $(By.xpath("//table/tbody/tr[2]/td[1]")).getText();
        Assert.assertTrue(Integer.parseInt(fValue) < Integer.parseInt(sValue));
    }

    @When("^enter \"([^\"]*)\" in search filter$")
    public void enterInSearchFilter(String arg0) {
        $(By.xpath("//*[@type='search']")).setValue(arg0);
    }

    @Then("^can see our result in table$")
    public void canSeeOurResultInTable() {
        $(By.xpath("//table/tbody/tr/td[2]")).shouldHave(text("Generating "));
    }

    @When("^click to free space$")
    public void clickToFreeSpace() {
        $(By.xpath("//*[@class='dt-button buttons-columnVisibility active']")).waitUntil(enabled, 5000).
                pressEscape();
    }
}
