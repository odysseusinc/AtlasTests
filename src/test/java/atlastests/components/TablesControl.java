package atlastests.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public interface TablesControl {

    default void search(String query) {
        $("input[type='search']").waitUntil(Condition.visible, 5000).setValue(query);
    }

    default void facetedTableSearch(String query) {
        SelenideElement searchTab = $(".facetedDataTable [type='search']");
        searchTab.clear();
        searchTab.sendKeys(query);
    }

    default void importButtonClick() {
        $(".import-modal-footer .btn-primary").click();
    }

    default void selectInTableResults(String chosenItem) {
        $$(".dataTables_scrollBody tr").
                find(Condition.matchesText(chosenItem)).
                find(".dataTables_scrollBody .fa-check").click();
    }
}
