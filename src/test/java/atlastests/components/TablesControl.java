package atlastests.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public interface TablesControl {

    default void search(String query) {
        $("input[type='search']").shouldBe(Condition.visible, Duration.ofMillis(5000)).setValue(query);
    }

    default void facetedTableSearch(String query) {
        SelenideElement searchTab = $$(".modal-content .facetedDataTable [type='search']").
                filter(Condition.visible).first();
        searchTab.clear();
        searchTab.sendKeys(query);
    }

    default void importButtonClick() {
        $(".import-modal-footer .btn-primary").click();
    }

    default void selectInTableResults(String chosenItem) {
        $$(".dataTables_scrollBody tr").
                find(Condition.matchText(chosenItem)).
                find(".dataTables_scrollBody .fa-check").click();
    }
}
