package atlastests.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$$;

public interface TabsControl {

    default void chooseTab(String tabName) {
        $$(".tabs__header-title").filter(Condition.visible).
                find(Condition.text(tabName)).click();
    }
}
