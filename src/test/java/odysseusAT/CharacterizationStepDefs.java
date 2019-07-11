package odysseusAT;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CharacterizationStepDefs {

    private String generatedString;
    private String characterizationName;
    private String generatedStringFeature;
    private String featureName;


    @Then("^can see Characterization page$")
    public void canSeeCharaterizationPage() {
        $(By.xpath("//*[@data-bind='text: title']")).shouldHave(text("Cohort Characterizations"));
    }

    @When("^click to New characterization button$")
    public void clickToNewCharacterizationButton() {
        $(By.xpath("//*[@class='characterizations-tabbed-grid__new-entity-btn btn btn-primary btn-sm']")).click();
        $(By.xpath("//*[@data-bind='text: title']")).shouldHave(text("New Characterization"));

    }

    @When("^enter Characterization name and save it$")
    public void enterCharacterizationNameAndSaveIt() {
        generatedString = RandomStringUtils.randomAlphanumeric(10);
        characterizationName = "Test_" + generatedString;
        $(By.xpath("//*[@class='input-group']/input")).clear();
        $(By.xpath("//*[@class='input-group']/input")).setValue(characterizationName);
        $(By.xpath("//*[@class='fa fa-save']")).click();
    }

    @When("^return to Characterization table$")
    public void returnToCharacterizationTable() {
        $(By.xpath("//*[@class='input-group-btn']/button[2]")).click();

    }

    @When("^enter created characterization name in filter$")
    public void enterCreatedCharacterizationNameInFilter() {
        $(By.xpath("//*[@type='search']")).waitUntil(visible, 3000);
        $(By.xpath("//*[@type='search']")).setValue(characterizationName);

    }

    @Then("^can see new characterization in table$")
    public void canSeeNewCharacterizationInTable() {
        $(By.xpath("//*[@class=' characterizations-list__tbl-col characterizations-list__tbl-col--name ']/a")).shouldHave(text(characterizationName));
    }

    @When("^click to our characterization$")
    public void clickToOurCharacterization() {
        $(By.xpath("//*[@class=' characterizations-list__tbl-col characterizations-list__tbl-col--name ']/a")).click();

    }

    @When("^click to delete characterization button$")
    public void clickToDeleteCharacterizationButton() {
        $(By.xpath("//*[@class='btn btn-danger']")).waitUntil(visible, 3000);
        $(By.xpath("//*[@class='btn btn-danger']")).click();


    }

    @When("^accept delete characterization$")
    public void acceptDeleteCharacterization() {
        switchTo().alert().accept();
    }

    @Then("^cant find characterization in the table$")
    public void cantFindCharacterizationInTheTable() {
        $(By.xpath("//*[@type='search']")).waitUntil(visible, 3000);
        $(By.xpath("//*[@type='search']")).setValue(characterizationName);
        $(By.xpath("//*[@class=' characterizations-list__tbl-col characterizations-list__tbl-col--name ']/a")).shouldNotHave(text(characterizationName));

    }

    @When("^click to Import Cohort Definition$")
    public void clickToImportCohortDefinition() {
        $$(byText("Import")).get(0).click();

    }

    @When("^choose cohort definition from the table in characterization$")
    public void chooseCohortDefinitionFromTheTableInCharacterization() {
        $(By.xpath("//*[@class='col-xs-6 search']/div/label/input")).setValue("test");
        $(By.xpath("//table/tbody/tr/td[2]/span")).shouldHave(text("test"));
        $(By.xpath("//table/tbody/tr/td[2]/span")).click();

    }


    @When("^click to Feature Analyses tab$")
    public void clickToFeatureAnalysesTab() throws InterruptedException {
        $(By.xpath("//*[@class='characterizations-tabbed-grid__toolbar-nav nav nav-tabs']/li[2]/a")).click();
        Thread.sleep(1500);
        $(By.xpath("//*[@class='characterizations-tabbed-grid__new-entity-btn btn btn-primary btn-sm']")).waitUntil(visible, 4000);
    }

    @Then("^can see Feature Analyses table$")
    public void canSeeFeatureAnalysesTable() {
        $(By.xpath("//table/tbody/tr")).waitUntil(visible, 5000);
    }

    @When("^click to New Feature analyses$")
    public void clickToNewFeatureAnalyses() {
        $(By.xpath("//*[@class='characterizations-tabbed-grid__new-entity-btn btn btn-primary btn-sm']")).click();
    }

    @Then("^can see page of creation New Feature Analyse$")
    public void canSeePageOfCreationNewFeatureAnalyse() {
        $(By.xpath("//*[@class='panel-heading']")).waitUntil(visible, 4000);
    }

    @When("^enter description$")
    public void enterDescription() {
        $(By.xpath("//*[@class='feature-analysis-view-edit__descr form-control']")).setValue("TEST DESCRIPTION");
    }

    @When("^choose Criteria design$")
    public void chooseCriteriaDesign() {
        $(By.xpath("//*[@class='feature-analysis-view-edit__type-selector']/ul/li[1]")).click();
        $(By.xpath("//*[@class='feature-analysis-view-edit__criteria-name form-control']")).waitUntil(visible, 3000);
    }

    @When("^enter name of New Feature Analyse$")
    public void enterNameOfNewFeatureAnalyse() {
        generatedStringFeature = RandomStringUtils.randomAlphanumeric(10);
        featureName = "Test_" + generatedStringFeature;
        $(By.xpath("//*[@class='input-group']/input")).setValue(featureName);
    }

    @When("^click to save feature analyse button$")
    public void clickToSaveFeatureAnalyseButton() {
        $(By.xpath("//*[@class='btn btn-success']")).click();
    }

    @Then("^go to feature analyses table by pressing close button$")
    public void goToFeatureAnalysesTableByPressingCloseButton() throws InterruptedException {
        Thread.sleep(1500);
        $(By.xpath("//*[@class='fa fa-times']")).waitUntil(visible,4000);
        $(By.xpath("//*[@class='fa fa-times']")).click();

    }

    @When("^enter name of our feature to filter$")
    public void enterNameOfOurFeatureToFilter() {
        $(By.xpath("//*[@type='search']")).setValue(featureName);
    }

    @Then("^can see our feature in table of feature analyses$")
    public void canSeeOurFeatureInTableOfFeatureAnalyses() {
        $(By.xpath("//*[@class=' feature-analyses-list__tbl-col feature-analyses-list__tbl-col--name ']")).shouldHave(text(featureName));

    }

    @When("^click to our feature analyse$")
    public void clickToOurFeatureAnalyse() {
        $(By.xpath("//*[@class=' feature-analyses-list__tbl-col feature-analyses-list__tbl-col--name ']/a")).click();
    }

    @Then("^can see page of our Feature Analyse$")
    public void canSeePageOfOurFeatureAnalyse() {
//         $(byText("Feature Analysis #")).waitUntil(visible,4000);
        $(By.xpath("//*[@data-bind='text: title'][1]")).waitUntil(visible,3000);
        $(By.xpath("//*[@data-bind='text: title'][1]")).shouldHave(text("Feature Analysis #"));
    }


    @When("^click to delete feature analyse$")
    public void clickToDeleteFeatureAnalyse() {
        $(By.xpath("//*[@class='btn btn-danger']")).click();
    }

    @When("^accept delete feature analyse$")
    public void acceptDeleteFeatureAnalyse() {
        switchTo().alert().accept();
    }

    @Then("^cant find feature analyse in the table$")
    public void cantFindFeatureAnalyseInTheTable() {
        $(By.xpath("//*[@type='search']")).setValue(featureName);
        $(By.xpath("//*[@class=' feature-analyses-list__tbl-col feature-analyses-list__tbl-col--name ']")).shouldNotHave(text(featureName));
    }

    @When("^click to Import Feature analyses$")
    public void clickToImportFeatureAnalyses() {
        $$(byText("Import")).get(1).click();
    }

    @Then("^can see Feature analyses window$")
    public void canSeeFeatureAnalysesWindow() {
        $(By.xpath("//*[@class='atlas-modal__modal-dialog modal-dialog characterization-design__feature-analyses-modal']/div/div[1]/div")).waitUntil(visible, 4000);
        $(By.xpath("//*[@class='atlas-modal__modal-dialog modal-dialog characterization-design__feature-analyses-modal']/div/div[1]/div")).shouldHave(text("Choose a Feature analyses"));
    }

    @Then("^Feature analyse table is visible$")
    public void featureAnalyseTableIsVisible() {
        $(By.xpath("//*[@class='characterization-design__col-feature-id sorting_asc']")).waitUntil(visible,3000);


    }


    @When("^click to Import Feature analyse$")
    public void clickToImportFeatureAnalyse() {
        $(By.xpath("//*[@class='characterization-design__button-panel']/button[1]")).click();

    }

    @When("^enter the same Characterization name and save it$")
    public void enterTheSameCharacterizationNameAndSaveIt() {
        $(By.xpath("//*[@class='input-group']/input")).clear();
        $(By.xpath("//*[@class='input-group']/input")).setValue(characterizationName);
        $(By.xpath("//*[@class='fa fa-save']")).click();
    }

    @Then("^can see alert message about uniqueness$")
    public void canSeeAlertMessageAboutUniqueness() {
        switchTo().alert().accept();
    }

    @When("^choose cohort definition \"([^\"]*)\" from the table in characterization$")
    public void chooseCohortDefinitionFromTheTableInCharacterization(String arg0) throws Throwable {
        $(By.xpath("//*[@class='col-xs-6 search']/div/label/input")).setValue(arg0);
        $(By.xpath("//table/tbody/tr/td[2]/span")).shouldHave(text(arg0));
        $(By.xpath("//table/tbody/tr/td[2]/span")).click();    }

    @Then("^can see cohort definition in characterization list with text \"([^\"]*)\"$")
    public void canSeeCohortDefinitionInCharacterizationListWithText(String arg0) throws Throwable {
        $(By.xpath("//table/tbody/tr/td[2]")).waitUntil(visible, 2000);
        $(By.xpath("//table/tbody/tr/td[2]")).shouldHave(text(arg0));
    }

    @When("^click to feature checkbox with text \"([^\"]*)\" from Feature analyses$")
    public void clickToFeatureCheckboxWithTextFromFeatureAnalyses(String arg0) throws Throwable {
        $(By.xpath("//*[@class='facetedDataTable']/div/div[2]/label/input")).setValue(arg0);
        $(By.xpath("//*[@class='fa fa-check'][1]")).click();
    }

    @Then("^can see result of our search \"([^\"]*)\" and \"([^\"]*)\"$")
    public void canSeeResultOfOurSearchAnd(String arg0, String arg1) throws Throwable {
        $$(By.xpath("//*[@class=' characterization-design__col-feature-name ']")).get(0).shouldHave(text(arg0));
        $$(By.xpath("//*[@class=' characterization-design__col-feature-name ']")).get(1).shouldHave(text(arg1));
    }

    @When("^click to save Chacterization$")
    public void clickToSaveChacterization() {
        $(By.xpath("//*[@class='fa fa-save']")).click();
    }

    @When("^click Remove first Feature Analyse from the table$")
    public void clickRemoveFirstFeatureAnalyseFromTheTable() {
        $(By.xpath("//*[@class=' characterization-design__col-feature-remove ']/a")).click();
    }

    @When("^click to Executions tab in Characterizations$")
    public void clickToExecutionsTabInCharacterizations() {
        $(By.xpath("//*[@class='tabs__header']/span[2]")).click();
    }
}
