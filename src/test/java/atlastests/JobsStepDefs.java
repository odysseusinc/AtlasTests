package atlastests;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static atlastests.SearchDefs.isFileDownloaded;
import static com.google.common.net.HttpHeaders.USER_AGENT;

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

    @When("^send post request to get all jobs$")
    public void sendPostRequestToGetAllJobs() throws Exception {
        JobsStepDefs http = new JobsStepDefs();

        System.out.println("Testing 1 - Send Http GET request");
        http.sendPost();
//        http.sendGet();

    }
    private void sendPost() throws Exception {

        String url = "https://qaatlas-ema.arachnenetwork.com/WebAPI/user/login/db";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

    private void sendGet() throws Exception {

        String url = "https://qaatlas-ema.arachnenetwork.com/WebAPI/job/execution?comprehensivePage=true";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }
}
