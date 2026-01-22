package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest2 {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Rostislav");
        $("#lastName").setValue("Olegovich");
        $("#userEmail").setValue("aqa@qa.ru");
        $("label[for='gender-radio-2']").click();
        $("#userNumber").setValue("2323232132");

        // Date of Birth: 06 October 1993
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__day--006:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue("History").pressEnter();

        $("label[for='hobbies-checkbox-1']").click(); // Sports
        $("label[for='hobbies-checkbox-2']").click(); // Reading
        $("label[for='hobbies-checkbox-3']").click(); // Music

        $("#uploadPicture").uploadFromClasspath("images/pic.png");
        $("#currentAddress").setValue("PushkinaKolotushkina");

        $("#state").click();
        $(byText("NCR")).click();

        $("#city").click();
        $(byText("Gurgaon")).click();

        $("#submit").click();
    }
}
