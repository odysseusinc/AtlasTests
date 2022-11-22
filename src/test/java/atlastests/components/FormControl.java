package atlastests.components;

import static com.codeborne.selenide.Selenide.$;

public interface FormControl {

    default void saveAction() {
        $(".fa-save.fa").click();
    }

    default void closeAction()
    {
        $(".fa-times").click();
    }

    default void deleteAction()
    {
        $(".fa-trash-o").click();
    }

    default void copyAction()
    {
        $(".fa-copy").click();
    }

    default void setTitle(String title)
    {
        $(".input-group input[type='text']").setValue(title);
    }
}
