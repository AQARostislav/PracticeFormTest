package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
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

        $("#uploadPicture").uploadFile(new File("/Users/rostislavpuckanev/Desktop/Снимок экрана 2026-01-17 в 19.54.15.png"));
        $("#currentAddress").setValue("PushkinaKolotushkina");

        $("#state").click();
        $(byText("NCR")).click();

        $("#city").click();
        $(byText("Gurgaon")).click();

        $("#submit").click();
    }
}
