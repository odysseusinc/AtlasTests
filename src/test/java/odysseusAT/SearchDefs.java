package odysseusAT;

import com.codeborne.selenide.Selenide;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SearchDefs {
    @When("^enter in search panel \"([^\"]*)\"$")
    public void enterInSearchPanel(String arg0) throws Throwable {
        $(By.xpath("//*[@placeholder='Type your search here']")).setValue(arg0);
    }

    @When("^search activated$")
    public void searchActivated() {
        $(By.xpath("//*[@class='pull-right btn btn-primary']")).click();

    }

    @Then("^can see search result table$")
    public void canSeeSearchResultTable() {
        $(By.xpath("//*[@class='conceptTable stripe compact hover dataTable no-footer']")).waitUntil(visible,15000);
        $(By.xpath("//*[@class='fa fa-shopping-cart']")).shouldBe(visible);
        $(By.xpath("//*[@id='DataTables_Table_2']/thead/tr/th[2]")).shouldHave(text("Id"));
        $(By.xpath("//*[@id='DataTables_Table_2']/thead/tr/th[3]")).shouldHave(text("Code"));
        $(By.xpath("//*[@id='DataTables_Table_2']/thead/tr/th[4]")).shouldHave(text("Name"));
        $(By.xpath("//*[@id='DataTables_Table_2']/thead/tr/th[5]")).shouldHave(text("Class"));
//        $(By.xpath("//*[@id='DataTables_Table_2']/thead/tr/th[6]")).shouldHave(text("Standard Concept Caption"));
        $(By.xpath("//*[@id='DataTables_Table_2']/thead/tr/th[6]")).shouldHave(text("RC"));
        $(By.xpath("//*[@id='DataTables_Table_2']/thead/tr/th[7]")).shouldHave(text("DRC"));
        $(By.xpath("//*[@id='DataTables_Table_2']/thead/tr/th[8]")).shouldHave(text("Domain"));
        $(By.xpath("//*[@id='DataTables_Table_2']/thead/tr/th[9]")).shouldHave(text("Vocabulary"));
        //check paganation
        $(By.xpath("//*[@data-dt-idx='2']")).shouldBe(text("2"));



    }//*[@id="DataTables_Table_8_wrapper"]/div/div[1]/div[1]/div[1]/div/div[2]/button[6]

    @When("^click to Column visibility$")
    public void clickToColumnVisibility() throws InterruptedException {
        $(By.xpath("//*[@class='dt-button buttons-collection buttons-colvis']")).click();
        $(By.xpath("//*[@class='dt-button-collection']")).waitUntil(visible,3000);


    }

    @When("^click to button Standard Concept Caption$")
    public void clickToButtonStandardConceptCation() throws InterruptedException {
        $(By.xpath("//*[@data-cv-idx='5']")).waitUntil(visible,3000);
        $(By.xpath("//*[@data-cv-idx='5']")).click();
        $(By.xpath("//*[@class='dt-button-background']")).click();


    }

    @Then("^Standard Concept Caption should be shown$")
    public void standardConceptCationShouldBeShown() {
        $(By.xpath("//*[@id='DataTables_Table_2']/thead/tr/th[6]")).waitUntil(visible,4000);
        $(By.xpath("//*[@id='DataTables_Table_2']/thead/tr/th[6]")).shouldHave(text("Standard Concept Caption"));
    }

    @When("^click to Id header$")
    public void clickToIdHeader() {
        $(By.xpath("//*[@id='DataTables_Table_2']/thead/tr/th[2]")).click();
    }

    @Then("^first value more then second$")
    public void firstValueMoreThenSecond() {

        String value1 = $(By.xpath("//*[@id='DataTables_Table_2']/tbody/tr[1]/td[2]")).getText();
        String value2 = $(By.xpath("//*[@id='DataTables_Table_2']/tbody/tr[2]/td[2]")).getText();

        Assert.assertTrue(Integer.parseInt(value1)<= Integer.parseInt(value2));

    }

    @Then("^second value more then first$")
    public void secondValueMoreThenFirst() {
        String value1 = $(By.xpath("//*[@id='DataTables_Table_2']/tbody/tr[1]/td[2]")).getText();
        String value2 = $(By.xpath("//*[@id='DataTables_Table_2']/tbody/tr[2]/td[2]")).getText();

        Assert.assertTrue(Integer.parseInt(value1)>= Integer.parseInt(value2));
    }

    @When("^enter in filtering search area \"([^\"]*)\"$")
    public void enterInFilteringSearchArea(String arg0) throws Throwable {
        $(By.xpath("//*[@type='search']")).setValue(arg0);

    }

    @Then("^can see search result only with \"([^\"]*)\"$")
    public void canSeeSearchResultOnlyWith(String arg0) throws Throwable {
        $(By.xpath("//*[@class='invalid']")).shouldHave(text(arg0));

    }

    @When("^click to CSV button$")
    public void clickToCSVButton() throws Exception {
        $(By.xpath("//*[@class='dt-button buttons-csv buttons-html5']")).click();
        Thread.sleep(2000);
        Assert.assertTrue(isFileDownloaded(LoginStepsDefs.getDataProperties("downloadpath"), "ATLAS Search.csv"));

    }



    public boolean isFileDownloaded(String downloadPath, String fileName) {
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName))
                return flag=true;
        }

        return flag;
    }
}
