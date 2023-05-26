package atlastests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static atlastests.TestDefs.getDataProperties;

public class ConfigurationStepDefs {
    private String generatedString;
    private String newGeneratedString;
    private int dataSourceQuantity;

    @Step ("Configuration page opens")
    @Then("^Configuration page opens$")
    public void configurationPageOpens() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).shouldBe(visible, Duration.ofMillis(3000)).
                shouldHave(text("Configuration"));
    }

    @Step ("click to every datasource connection button")
    @When("^Click to every datasource connection button$")
    public void checkEveryDataSourceConnection() {
        ElementsCollection dataSources = $$("[data-bind='if: $component.canCheckConnection($data)'] .btn");
        dataSources.shouldHave(CollectionCondition.sizeGreaterThan(0), Duration.ofMillis(5000));
        dataSourceQuantity = dataSources.size();
        dataSources.forEach(SelenideElement::click);
    }
    @Step ("Successful connection message are visible")
    @Then("^Successful connection messages are visible$")
    public void checkVisibilityOfAnySuccessfulConnection() {
        $$("[data-bind='if: $component.canCheckConnection($data)'] .btn-success").shouldHave(
                CollectionCondition.sizeGreaterThan(2));
    }

    @Step ("click to Manage permission button")
    @When("^click to Manage permission button$")
    public void clickToManagePermissionButton() {
        $(By.xpath("//*[@class='btn btn-sm btn-primary configuration__manage-btn']")).click();
    }

    @Step ("Can see Roles creation page")
    @Then("^can see Roles creation page$")
    public void canSeeRolesCreationPage() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).shouldBe(visible, Duration.ofMillis(3000)).
                shouldHave(text("Roles"));
    }

    @Step ("click to New role button")
    @When("^click to New role button$")
    public void clickToNewRoleButton() {
        $(By.xpath("//*[@class='pull-right btn btn-sm btn-primary new-role']")).click();
    }

    @Step("can see new role creation page")
    @Then("^can see new role creation page$")
    public void canSeeNewRoleCreationPage() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']/span")).shouldHave(text("New Role"));
    }

    @Step ("enter new name of role")
    @When("^enter new name of role$")
    public void enterNewNameOfRole() {
        generatedString = RandomStringUtils.randomAlphanumeric(10);
        $(By.xpath("//*[@class='form-control']")).shouldBe(visible, Duration.ofMillis(4000)).clear();
        $(By.xpath("//*[@class='form-control emptyInput']")).setValue("Test_" + generatedString);
    }

    @Step ("choose qa login from table")
    @When("^choose qa login from table$")
    public void chooseQaLoginFromTable() throws Exception {
        $(By.xpath("//*[@type='search']")).setValue(getDataProperties("login"));
        $(By.xpath("//*[@class=' text-center']/span")).click();
    }

    @Step ("click to save button of new role")
    @When("^click to save button of new role$")
    public void clickToSaveButtonOfNewRole() {
        $("[title='Save']").click();
        $(".disabled[title='Save']").shouldBe(visible, Duration.ofMillis(5000));
    }

    @Step ("click to cancel button in role")
    @When("^click to cancel button in roles$")
    public void clickToCancelButtonInRoles() {
        $(By.xpath("//*[@title='Close']")).click();
    }

    @Step ("enter name of our role in filter")
    @When("^enter name of our role in filter$")
    public void enterNameOfOurRoleInFilter() {
        $("[data-bind='text: title']").shouldHave(Condition.text("Roles"), Duration.ofMillis(10000));
        $(".dataTables_filter input[type='search']").shouldBe(enabled, Duration.ofMillis(5000)).setValue(generatedString);
    }

    @Step ("can see our role in table")
    @Then("^can see our role in table$")
    public void canSeeOurRoleInTable() {
        $(By.xpath("//table/tbody/tr/td")).shouldHave(text(generatedString));
    }

    @Step ("click to our role")
    @When("^click to our role$")
    public void clickToOurRole() {
        $(By.xpath("//table/tbody/tr/td")).click();
    }

    @Step ("can see our role page")
    @Then("^can see our role page$")
    public void canSeeOurRolePage() {
        $(By.xpath("//*[@class='heading-title heading-title--dark']")).shouldBe(visible, Duration.ofMillis(3000)).
                shouldHave(text("Role #"));
    }
    @Step ("enter new name of our role")
    @When("^enter new name of our role$")
    public void enterNewNameOfOurRole() {
        newGeneratedString = RandomStringUtils.randomAlphanumeric(10);
        $(By.xpath("//*[@class='form-control']")).clear();
        $(By.xpath("//*[@class='form-control emptyInput']")).setValue("Test_" + newGeneratedString);
    }

    @Step ("can see our new name role in table")
    @Then("^can see our new name role in table$")
    public void canSeeOurNewNameRoleInTable() {
        $(By.xpath("//*[@type='search']")).shouldBe(visible, Duration.ofMillis(5000)).setValue(newGeneratedString);
        $(By.xpath("//table/tbody/tr/td")).shouldHave(text(newGeneratedString));
    }

    @Step ("click to our new name role")
    @When("^click to our new name role$")
    public void clickToOurNewNameRole() {
        $(By.xpath("//table/tbody/tr/td")).click();
    }

    @Step ("click delete button in role")
    @When("^click delete button in role$")
    public void clickDeleteButtonInRole() {
        $(By.xpath("//*[@title='Delete']")).click();
        switchTo().alert().accept();
    }

    @Step ("can not see our role in table")
    @Then("^cant see our role in table$")
    public void cantSeeOurRoleInTable() {
        $(By.xpath("//*[@type='search']")).setValue(newGeneratedString);
        $(By.xpath("//table/tbody/tr/td")).shouldNotHave(text(newGeneratedString));
    }
}
