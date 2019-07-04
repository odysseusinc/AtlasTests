package odysseusAT;

import com.codeborne.selenide.Selectors;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static odysseusAT.SearchDefs.isFileDownloaded;

public class JobsStepDefs {
    @Then("^can see Jobs page$")
    public void canSeeJobsPage() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).waitUntil(visible, 4000);
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).shouldHave(text("Jobs"));
    }

    @Then("^can see job table with all fields$")
    public void canSeeJobTableWithAllFields() {
        $(By.xpath("//table/tbody/tr/td[1]")).shouldNotBe(empty);
        $(By.xpath("//table/tbody/tr/td[1]")).shouldNotBe(text("-"));
        $(By.xpath("//table/tbody/tr/td[2]")).shouldNotBe(empty);
        $(By.xpath("//table/tbody/tr/td[2]")).shouldNotBe(text("-"));
        $(By.xpath("//table/tbody/tr/td[3]")).shouldNotBe(empty);
        $(By.xpath("//table/tbody/tr/td[3]")).shouldNotBe(text("-"));
        $(By.xpath("//table/tbody/tr/td[4]")).shouldNotBe(empty);
        $(By.xpath("//table/tbody/tr/td[4]")).shouldNotBe(text("-"));
        $(By.xpath("//table/tbody/tr/td[5]")).shouldNotBe(empty);
        $(By.xpath("//table/tbody/tr/td[6]")).shouldNotBe(empty);

    }

    @When("^click to Column visibility button$")
    public void clickToColumnVisibilityButton() {
        $(By.xpath("//*[@class='dt-button buttons-collection buttons-colvis']/span")).click();
    }

    @Then("^can see window with column names$")
    public void canSeeWindowWithColumnNames() {
        $$(By.xpath("//*[@class='dt-button buttons-columnVisibility active']/span")).get(0).waitUntil(visible, 4000);

    }

    @When("^click to \"([^\"]*)\" button$")
    public void clickToButton(String arg0) throws Throwable {
        $$(By.xpath("//*[@class='dt-button buttons-columnVisibility active']/span")).get(0).click();
    }

    @Then("^cant see ExecutionId in table$")
    public void cantSeeExecutionIdInTable() throws InterruptedException {
        Thread.sleep(3000);
        $(byText("ExecutionId")).shouldNotBe(visible);
    }

    @When("^click to CSV button in Jobs$")
    public void clickToCSVButtonInJobs() {
        $(By.xpath("//*[@class='dt-button buttons-csv buttons-html5']")).click();
    }

    @Then("^can see downloaded file$")
    public void canSeeDownloadedFile() throws Exception {
        Assert.assertTrue(isFileDownloaded(LoginStepsDefs.getDataProperties("downloadpath"), "ATLAS Jobs.csv"));
    }

    @When("^click to name of column$")
    public void clickToNameOfColumn() {
        $(By.xpath("//table/thead/tr/th[1]")).click();
    }

    @Then("^can see that Id order was changed$")
    public void canSeeThatIdOrderWasChanged() throws InterruptedException {
        Thread.sleep(1500);
        String fValue  = $(By.xpath("//table/tbody/tr/td[1]")).getText();
        String sValue  = $(By.xpath("//table/tbody/tr[2]/td[1]")).getText();
        Assert.assertTrue(Integer.parseInt(fValue) < Integer.parseInt(sValue));
    }

    @When("^enter \"([^\"]*)\" in search filter$")
    public void enterInSearchFilter(String arg0) throws Throwable {
        $(By.xpath("//*[@type='search']")).setValue(arg0);
    }

    @Then("^can see our result in table$")
    public void canSeeOurResultInTable() {
        $(By.xpath("//table/tbody/tr/td[2]")).shouldHave(text("Generating "));
    }

    @When("^click to free space$")
    public void clickToFreeSpace() throws InterruptedException {
        Thread.sleep(1000);
        $(By.xpath("//*[@class='dt-button buttons-columnVisibility active']")).pressEscape();

    }
}
