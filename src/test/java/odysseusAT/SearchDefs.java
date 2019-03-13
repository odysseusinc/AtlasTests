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
        $(By.xpath("//*[@placeholder='Type your search here']")).waitUntil(visible,3000);
        $(By.xpath("//*[@placeholder='Type your search here']")).setValue(arg0);
    }

    @When("^search activated$")
    public void searchActivated() {
        $(By.xpath("//*[@class='pull-right btn btn-primary']")).click();

    }

    @Then("^can see search result table$")
    public void canSeeSearchResultTable() {
        $(By.xpath("//*[@class='conceptTable stripe compact hover dataTable no-footer']")).waitUntil(visible,25000);
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

    @Then("^file download$")
    public void fileDownload() throws Exception {
        Assert.assertTrue(isFileDownloaded(LoginStepsDefs.getDataProperties("downloadpath"), "ATLAS Search.csv"));
    }

    @When("^click to first link in list$")
    public void clickToFirstLinkInList() {
        $(By.xpath("//*[@class='odd']/td[4]/a")).click();

    }



    @Then("^open page with first of four tabs for \"([^\"]*)\"$")
    public void openPageWithFourTabsFor(String arg0) throws Throwable {
        $(By.xpath("//*[@id='currentComponent']/div[1]/span[2]")).waitUntil(visible,5000);
        $(By.xpath("//*[@id='currentComponent']/div[1]/span[2]")).shouldHave(text(arg0));
        $(By.xpath("//*[@class='nav nav-tabs']/li/a")).shouldHave(text("Details"));
        $(By.xpath("//*[@id='wrapperConceptDetails']/table/tbody/tr[1]/td[1]")).shouldHave(text("Concept Name"));
        $(By.xpath("//*[@id='wrapperConceptDetails']/table/tbody/tr[2]/td[1]")).shouldHave(text("Domain Id"));
        $(By.xpath("//*[@id='wrapperConceptDetails']/table/tbody/tr[3]/td[1]")).shouldHave(text("Concept Class Id"));
        $(By.xpath("//*[@id='wrapperConceptDetails']/table/tbody/tr[4]/td[1]")).shouldHave(text("Vocabulary Id"));
        $(By.xpath("//*[@id='wrapperConceptDetails']/table/tbody/tr[5]/td[1]")).shouldHave(text("Concept Id"));
        $(By.xpath("//*[@id='wrapperConceptDetails']/table/tbody/tr[6]/td[1]")).shouldHave(text("Concept Code"));
        $(By.xpath("//*[@id='wrapperConceptDetails']/table/tbody/tr[7]/td[1]")).shouldHave(text("Invalid Reason"));
        $(By.xpath("//*[@id='wrapperConceptDetails']/table/tbody/tr[8]/td[1]")).shouldHave(text("Standard Concept"));

    }

    @Then("^check second of four tabs$")
    public void checkSecondOfFourTabs() {
        $(By.xpath("//*[@class='nav nav-tabs']/li[2]/a")).shouldHave(text("Related Concepts"));
        $(By.xpath("//*[@class='nav nav-tabs']/li[2]/a")).click();
        $(By.xpath("//*[@id='DataTables_Table_4']/tbody/tr[1]/td[4]/a")).waitUntil(visible,15000);
    }

    @Then("^check third of four tabs$")
    public void checkThirdOfFourTabs() {
        $(By.xpath("//*[@class='nav nav-tabs']/li[3]/a")).shouldHave(text("Hierarchy"));
        $(By.xpath("//*[@class='nav nav-tabs']/li[3]/a")).click();
        $(By.xpath("//*[@id='wrapperParents']/div[1]")).waitUntil(visible,14000);
        $(By.xpath("//*[@id='wrapperParents']/div[1]")).shouldHave(text("Parents"));
    }

    @Then("^check fourth of four tabs$")
    public void checkFourthOfFourTabs() {
        $(By.xpath("//*[@class='nav nav-tabs']/li[4]/a")).shouldHave(text("Record Counts"));
        $(By.xpath("//*[@class='nav nav-tabs']/li[4]/a")).click();
        $(By.xpath("//*[@class='panel-heading']")).waitUntil(visible,20000);
        $(By.xpath("//*[@class='panel-heading']")).shouldHave(text("Record Counts across Sources"));

    }
}
