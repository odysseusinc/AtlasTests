package atlastests.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public interface PageControl {

    default void checkPageHeader(String expectedHeader) {
        $(".heading-title span").shouldHave(Condition.text(expectedHeader));
    }

    default void copyToClipboard() {
        $("[title='Copy to clipboard']").click();
    }

    default void checkExecutionTitle()
    {
        $(".analysis-execution-list__title").waitUntil(visible, 5000).shouldHave(text("Executions"));
    }
}
