package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {
    @Test
    void andreiSolntsevShouldBeTheFirstContributor() {

        // Открыть старинцу репозитория
        open("https://github.com/selenide/selenide");
        // подвести мышку к первому аватару и блока contributors
       $("div.Layout-sidebar").$(byText("Contributors"))
               .closest(".BorderGrid-cell").$$("ul li").first().hover();
        // Проверка: в о всплывающем окне есть текст Andrei Sontsev
        $(".Popover-message").shouldHave(text("Andrei Solntsev"));




    }
}
