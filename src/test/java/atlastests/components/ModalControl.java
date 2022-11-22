package atlastests.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$$;

public interface ModalControl {
    default void checkModalTitle(String title) {
        $$(".modal-title").filter(Condition.visible).first().shouldHave(Condition.text(title));
    }
}
