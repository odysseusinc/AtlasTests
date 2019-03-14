package odysseusAT;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.commands.PressEnter;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Se;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

import java.nio.charset.Charset;
import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ConseptSetsStepDefs {

    private String generatedString;

    @Then("^Concept Sets page opens$")
    public void conceptSetsPageOpens() {
        $(By.xpath("//*[@id='currentComponent']/heading-title/div/span")).waitUntil(visible,5000);
        $(By.xpath("//*[@id='currentComponent']/heading-title/div/span")).shouldHave(text("Concept Sets"));


    }

    @When("^click to New Concept Set$")
    public void clickToNewConceptSet() throws InterruptedException {
        $(By.xpath("//*[@class='btn btn-sm btn-primary new-concept-set']")).click();
    }

    @Then("^can see Concept Set creation form$")
    public void canSeeConceptSetCreationForm() {
        $(By.xpath("//*[@data-bind='text: title']")).shouldHave(text("New Concept Set"));
    }

    @When("^enter random name of Concept set and save it$")
    public void enterRandomNameOfConceptSetAndSaveIt() throws InterruptedException {
        generatedString = RandomStringUtils.randomAlphanumeric(10);
        $(By.xpath("//*[@id='txtConceptSetName']")).clear();
        $(By.xpath("//*[@id='txtConceptSetName']")).setValue(generatedString);
        $(By.xpath("//*[@class='fa fa-save']")).click();
        Thread.sleep(10000);
    }

    @Then("^show new buttons in Concept Set$")
    public void showNewButtonsInConceptSet() {
        $(By.xpath("//*[@data-bind='click: optimize, css: { disabled: !canOptimize() || isProcessing() }']")).waitUntil(visible,2000);
        $(By.xpath("//*[@data-bind='click: optimize, css: { disabled: !canOptimize() || isProcessing() }']")).shouldHave(text("Optimize"));
    }

    @Then("^new concept set shown in table$")
    public void newConceptSetShownInTable() {
            $(By.xpath("//*[@class='stripe compact hover dataTable no-footer']/tbody/tr[1]/td[2]")).shouldHave(text(generatedString));
    }

    @When("^click to new concept set row$")
    public void clickToNewConceptSetRow() {
        $(By.xpath("//*[@class='stripe compact hover dataTable no-footer']/tbody/tr[1]/td[2]")).click();

    }

    @When("^click to delete concept set$")
    public void clickToDeleteConceptSet() {
        $(By.xpath("//*[@class='fa fa-trash-o']")).click();
        switchTo().alert().accept();

    }

    @Then("^new concept set removed from table$")
    public void newConceptSetRemovedFromTable() {
        $(By.xpath("//*[@class='stripe compact hover dataTable no-footer']/tbody/tr[1]/td[2]")).shouldNotHave(text(generatedString));
    }
}
