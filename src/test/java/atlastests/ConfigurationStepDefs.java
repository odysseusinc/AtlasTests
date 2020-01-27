package atlastests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static atlastests.testDefs.getDataProperties;

public class ConfigurationStepDefs {
    private String generatedString;
    private String newGeneratedString;
    private int dataSourceQuantity;

    @Then("^Configuration page opens$")
    public void configurationPageOpens() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).waitUntil(visible, 3000).
                shouldHave(text("Configuration"));
    }

    @When("^Click to every datasource connection button$")
    public void checkEveryDataSourceConnection() {
        ElementsCollection dataSources = $$("[data-bind='if: $component.canCheckConnection($data)'] .btn");
        dataSourceQuantity = dataSources.size();
        dataSources.forEach(SelenideElement::click);
    }

    @Then("^Successful connection messages are visible$")
    public void checkVisibilityOfEverySuccessfulConnection() {
        $$("[data-bind='if: $component.canCheckConnection($data)'] .btn-success").
                shouldHave(CollectionCondition.size(dataSourceQuantity), 60000);
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
    public void chooseQaLoginFromTable() throws Exception {
        $(By.xpath("//*[@type='search']")).setValue(getDataProperties("login"));
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
        $("[data-bind='text: title']").waitUntil(Condition.text("Roles"), 10000);
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
