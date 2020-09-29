package atlastests.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public final class StaticElements {
    public static final ElementsCollection EXECUTION_ACTION_BUTTONS = $$(".analysis-execution-list__action");
    public static final ElementsCollection ANALYSIS_EXECUTION_LIST = $$(".analysis-execution-list__heading");
    public static final  SelenideElement CONCEPT_SET_IN_TABLE = $("#repositoryConceptSetTable .linkish");
    public static final  ElementsCollection NAV_TABS = $$(".nav-tabs a");
    public static final ElementsCollection NAV_PILLS = $$(".nav-pills.nav a");
}
