package atlastests;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ConfigurationStepDefs {
    private String generatedString;
    private String newGeneratedString;


    @Then("^Configuration page opens$")
    public void configurationPageOpens() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).waitUntil(visible, 3000).
                shouldHave(text("Configuration"));
    }

    @When("^click to check connection button for Impala$")
    public void clickToCheckConnectionButtonForImpala() {
        $(By.xpath("//table/tbody/tr[1]/td[9]/button")).waitUntil(visible, 5000).click();
    }

    @Then("^can see success message in button for Impala$")
    public void canSeeSuccessMessageInButtonForImpala() {
        $(By.xpath("//table/tbody/tr[1]/td[9]/button")).waitUntil(attribute("class",
                "connection-check-button btn btn-sm btn-success"), 10000);
    }

    @When("^click to check connection button for Netezza$")
    public void clickToCheckConnectionButtonForNetezza() {
        $(By.xpath("//table/tbody/tr[2]/td[9]/button")).click();

    }

    @Then("^can see success message in button for Netezza$")
    public void canSeeSuccessMessageInButtonForNetezza() {
        $(By.xpath("//table/tbody/tr[2]/td[9]/button")).waitUntil(attribute("class",
                "connection-check-button btn btn-sm btn-success"), 10000);

    }

    @When("^click to check connection button for OVH(\\d+)$")
    public void clickToCheckConnectionButtonForOVH(int arg0) {
        $(By.xpath("//table/tbody/tr[3]/td[9]/button")).click();

    }

    @Then("^can see success message in button for OVH(\\d+)$")
    public void canSeeSuccessMessageInButtonForOVH(int arg0) {
        $(By.xpath("//table/tbody/tr[3]/td[9]/button")).waitUntil(attribute("class",
                "connection-check-button btn btn-sm btn-success"), 10000);
    }

    @When("^click to check connection button for SynPUF (\\d+)K Cost and Util$")
    public void clickToCheckConnectionButtonForSynPUFKCostAndUtil(int arg0) {
        $(By.xpath("//table/tbody/tr[4]/td[9]/button")).click();
    }

    @Then("^can see success message in button for SynPUF (\\d+)K Cost and Util$")
    public void canSeeSuccessMessageInButtonForSynPUFKCostAndUtil(int arg0) {
        $(By.xpath("//table/tbody/tr[4]/td[9]/button")).waitUntil(attribute("class",
                "connection-check-button btn btn-sm btn-success"), 10000);
    }

    @When("^click to check connection button for SynPUF (\\d+)K GCP Big query$")
    public void clickToCheckConnectionButtonForSynPUFKGCPBigQuery(int arg0) {
        $(By.xpath("//table/tbody/tr[5]/td[9]/button")).click();
    }

    @Then("^can see success message in button for SynPUF (\\d+)K GCP Big query$")
    public void canSeeSuccessMessageInButtonForSynPUFKGCPBigQuery(int arg0) {
        $(By.xpath("//table/tbody/tr[5]/td[9]/button")).waitUntil(attribute("class",
                "connection-check-button btn btn-sm btn-success"), 10000);
    }

    @When("^click to check connection button for SynPUF (\\d+)K CDM(\\d+) (\\d+)$")
    public void clickToCheckConnectionButtonForSynPUFKCDM(int arg0, int arg1, int arg2) {
        $(By.xpath("//table/tbody/tr[6]/td[9]/button")).click();
    }

    @Then("^can see success message in button for SynPUF (\\d+)K CDM(\\d+) (\\d+)$")
    public void canSeeSuccessMessageInButtonForSynPUFKCDM(int arg0, int arg1, int arg2) {
        $(By.xpath("//table/tbody/tr[6]/td[9]/button")).waitUntil(attribute("class",
                "connection-check-button btn btn-sm btn-success"), 10000);
    }

    @When("^click to check connection button for SynPUF (\\d+) (\\d+) GCP BigQuery$")
    public void clickToCheckConnectionButtonForSynPUFGCPBigQuery(int arg0, int arg1) {
        $(By.xpath("//table/tbody/tr[7]/td[9]/button")).click();
    }

    @Then("^can see success message in button for SynPUF (\\d+) (\\d+) GCP BigQuery$")
    public void canSeeSuccessMessageInButtonForSynPUFGCPBigQuery(int arg0, int arg1) {
        $(By.xpath("//table/tbody/tr[7]/td[9]/button")).waitUntil(attribute("class",
                "connection-check-button btn btn-sm btn-success"), 10000);
    }

    @When("^click to check connection button for SynPUF (\\d+)M GCP BigQuery$")
    public void clickToCheckConnectionButtonForSynPUFMGCPBigQuery(int arg0) {
        $(By.xpath("//table/tbody/tr[8]/td[9]/button")).click();
    }

    @Then("^can see success message in button for SynPUF (\\d+)M GCP BigQuery$")
    public void canSeeSuccessMessageInButtonForSynPUFMGCPBigQuery(int arg0) {
        $(By.xpath("//table/tbody/tr[8]/td[9]/button")).waitUntil(attribute("class",
                "connection-check-button btn btn-sm btn-success"), 10000);
    }

    @When("^click to check connection button for SynPUF Geo$")
    public void clickToCheckConnectionButtonForSynPUFGeo() {
        $(By.xpath("//table/tbody/tr[9]/td[9]/button")).click();
    }

    @Then("^can see success message in button for SynPUF Geo$")
    public void canSeeSuccessMessageInButtonForSynPUFGeo() {
        $(By.xpath("//table/tbody/tr[9]/td[9]/button")).waitUntil(attribute("class",
                "connection-check-button btn btn-sm btn-success"), 10000);
    }

    @When("^click to check connection button for oracle (\\d+)k$")
    public void clickToCheckConnectionButtonForOracleK(int arg0) {
        $(By.xpath("//table/tbody/tr[10]/td[9]/button")).click();
    }

    @Then("^can see success message in button for oracle (\\d+)k$")
    public void canSeeSuccessMessageInButtonForOracleK(int arg0) {
        $(By.xpath("//table/tbody/tr[10]/td[9]/button")).waitUntil(attribute("class",
                "connection-check-button btn btn-sm btn-success"), 10000);
    }

    @When("^click to Manage permission button$")
    public void clickToManagePermissionButton() {
        $(By.xpath("//*[@class='btn btn-sm btn-primary configuration__manage-btn']")).click();
    }

    @Then("^can see Roles creation page$")
    public void canSeeRolesCreationPage() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).waitUntil(visible, 3000).
                shouldHave(text("Roles"));
    }

    @When("^click to New role button$")
    public void clickToNewRoleButton() {
        $(By.xpath("//*[@class='pull-right btn btn-sm btn-primary new-role']")).click();
    }

    @Then("^can see new role creation page$")
    public void canSeeNewRoleCreationPage() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).shouldHave(text("New Role"));
    }

    @When("^enter new name of role$")
    public void enterNewNameOfRole() {
        generatedString = RandomStringUtils.randomAlphanumeric(10);
        $(By.xpath("//*[@class='form-control']")).waitUntil(visible, 4000).clear();
        $(By.xpath("//*[@class='form-control emptyInput']")).setValue("Test_" + generatedString);
    }

    @When("^choose qa login from table$")
    public void chooseQaLoginFromTable() {
        $(By.xpath("//*[@type='search']")).setValue("qa");
        $(By.xpath("//*[@class=' text-center']/span")).click();
    }

    @When("^click to save button of new role$")
    public void clickToSaveButtonOfNewRole() {
        $("[title='Save']").click();
        $(".disabled[title='Save']").waitUntil(visible, 5000);
    }

    @When("^click to cancel button in roles$")
    public void clickToCancelButtonInRoles() {
        $(By.xpath("//*[@title='Close']")).click();
    }

    @When("^enter name of our role in filter$")
    public void enterNameOfOurRoleInFilter() {
        $("[data-bind='text: title']").waitUntil(Condition.text("Roles"), 5000);
        $(".dataTables_filter input[type='search']").waitUntil(enabled, 5000).setValue(generatedString);
    }

    @Then("^can see our role in table$")
    public void canSeeOurRoleInTable() {
        $(By.xpath("//table/tbody/tr/td")).shouldHave(text(generatedString));
    }

    @When("^click to our role$")
    public void clickToOurRole() {
        $(By.xpath("//table/tbody/tr/td")).click();
    }

    @Then("^can see our role page$")
    public void canSeeOurRolePage() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']")).waitUntil(visible, 3000).
                shouldHave(text("Role #"));
    }

    @When("^enter new name of our role$")
    public void enterNewNameOfOurRole() {
        newGeneratedString = RandomStringUtils.randomAlphanumeric(10);
        $(By.xpath("//*[@class='form-control']")).clear();
        $(By.xpath("//*[@class='form-control emptyInput']")).setValue("Test_" + newGeneratedString);
    }

    @Then("^can see our new name role in table$")
    public void canSeeOurNewNameRoleInTable() {
        $(By.xpath("//*[@type='search']")).waitUntil(visible, 5000).setValue(newGeneratedString);
        $(By.xpath("//table/tbody/tr/td")).shouldHave(text(newGeneratedString));
    }

    @When("^click to our new name role$")
    public void clickToOurNewNameRole() {
        $(By.xpath("//table/tbody/tr/td")).click();
    }

    @When("^click delete button in role$")
    public void clickDeleteButtonInRole() {
        $(By.xpath("//*[@title='Delete']")).click();
        switchTo().alert().accept();
    }

    @Then("^cant see our role in table$")
    public void cantSeeOurRoleInTable() {
        $(By.xpath("//*[@type='search']")).setValue(newGeneratedString);
        $(By.xpath("//table/tbody/tr/td")).shouldNotHave(text(newGeneratedString));
    }
}
