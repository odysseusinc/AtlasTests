package atlastests.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public interface FilterControl {
    default void search(String query) {
        $("input[type='search']").waitUntil(Condition.visible, 5000).setValue(query);
    }

    default void facetedTableSearch(String query) {
        SelenideElement searchTab = $(".facetedDataTable [type='search']");
        searchTab.clear();
        searchTab.sendKeys(query);
    }
}
