package atlastests.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public interface PageControl {

    default void checkPageHeader(String expectedHeader) {
        $(".heading-title span").shouldHave(Condition.text(expectedHeader));
    }

    default void copyToClipboard() {
        $("[title='Copy to clipboard']").click();
    }
}
