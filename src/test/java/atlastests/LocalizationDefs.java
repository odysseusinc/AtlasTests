package atlastests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static atlastests.TestDefs.getDataProperties;
import static com.codeborne.selenide.Selenide.*;

public class LocalizationDefs {
    private SelenideElement LOCALE_BAR = $(".user-bar__locale");

    @When("^Open Atlas and Close Licence Agreement for any locale")
    public void openAtlasAndCloseLicenseAgreement() throws Exception {
        open(getDataProperties("link"));
        $(".terms-and-conditions__btn.btn-success").click();
    }

    @When("^Click to locale bar")
    public void clickToLocaleBar() {
        LOCALE_BAR.click();
    }

    @Then("^Available languages are shown")
    public void checkLanguages(DataTable dataTable) {
        List<String> languages = dataTable.asList(String.class);
        $$("[data-bind='value: $data.code, text:$data.name']").
                shouldHave(CollectionCondition.textsInAnyOrder(languages));
    }

    @Then("^Locale bar should not be visible")
    public void localeModeIsOff()
    {
        LOCALE_BAR.shouldBe(Condition.not(Condition.visible));
    }
}

