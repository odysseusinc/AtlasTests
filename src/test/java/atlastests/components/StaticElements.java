package atlastests.components;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public final class StaticElements {
    public static final ElementsCollection EXECUTION_ACTION_BUTTONS = $$(".analysis-execution-list__action");
}
