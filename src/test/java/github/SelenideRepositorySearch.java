package github;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @Test
    void selenideRepositorySearch() {
        open("https://github.com/");
        $("button[placeholder='Search or jump to...']").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $$("[data-hpc='true']").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }

}
