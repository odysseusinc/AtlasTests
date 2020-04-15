package atlastests.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public interface PageControl {
    default void checkPageHeader(String expectedHeader)
    {
        $(".heading-title span").shouldHave(Condition.text(expectedHeader));
    }
}
