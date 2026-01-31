package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    private static final String PAGE_URL = "https://demoqa.com/automation-practice-form";

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput  = $("#lastName");
    private final SelenideElement emailInput     = $("#userEmail");
    private final SelenideElement phoneInput     = $("#userNumber");
    private final SelenideElement genderWrapper  = $("#genterWrapper");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement monthSelect      = $(".react-datepicker__month-select");
    private final SelenideElement yearSelect       = $(".react-datepicker__year-select");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement uploadPictureInput = $("#uploadPicture");
    private final SelenideElement addressTextArea = $("#currentAddress");
    private final SelenideElement stateDropdown = $("#state");
    private final SelenideElement cityDropdown  = $("#city");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement modalDialog = $(".modal-dialog");
    private final SelenideElement modalTitle  = $("#example-modal-sizes-title-lg");
    private final SelenideElement resultTable = $(".table-responsive");

    @Step("Открыть страницу формы")
    public PracticeFormPage openPage() {
        open(PAGE_URL);
        firstNameInput.shouldBe(visible); // sanity-check
        return this;
    }

    @Step("Заполнить First Name: {value}")
    public PracticeFormPage setFirstName(String value) {
        firstNameInput.shouldBe(visible).setValue(value);
        return this;
    }

    @Step("Заполнить Last Name: {value}")
    public PracticeFormPage setLastName(String value) {
        lastNameInput.shouldBe(visible).setValue(value);
        return this;
    }

    @Step("Заполнить Email: {value}")
    public PracticeFormPage setEmail(String value) {
        emailInput.shouldBe(visible).setValue(value);
        return this;
    }

    @Step("Выбрать Gender: {gender}")
    public PracticeFormPage setGender(String gender) {
        genderWrapper.shouldBe(visible).$(byText(gender)).click();
        return this;
    }

    @Step("Заполнить Phone: {value}")
    public PracticeFormPage setPhone(String value) {
        phoneInput.shouldBe(visible).setValue(value);
        return this;
    }

    @Step("Выбрать дату рождения: {day} {month} {year}")
    public PracticeFormPage setBirthDay(String day, String month, String year) {
        dateOfBirthInput.shouldBe(visible).click();
        monthSelect.shouldBe(visible).selectOption(month);
        yearSelect.shouldBe(visible).selectOption(year);

        clickDayInDatePicker(day);
        return this;
    }

    @Step("Добавить Subject: {subject}")
    public PracticeFormPage addSubject(String subject) {
        subjectsInput.shouldBe(visible).setValue(subject).pressEnter();
        return this;
    }

    @Step("Выбрать Hobby: {hobby}")
    public PracticeFormPage selectHobby(String hobby) {
        hobbiesWrapper.shouldBe(visible).$(byText(hobby)).click();
        return this;
    }

    @Step("Загрузить картинку: {classpathFile}")
    public PracticeFormPage uploadPicture(String classpathFile) {
        uploadPictureInput.shouldBe(enabled).uploadFromClasspath(classpathFile);
        return this;
    }

    @Step("Заполнить Address: {value}")
    public PracticeFormPage setAddress(String value) {
        addressTextArea.shouldBe(visible).setValue(value);
        return this;
    }

    @Step("Выбрать State: {state}")
    public PracticeFormPage selectState(String state) {
        stateDropdown.shouldBe(visible).click();
        $(byText(state)).shouldBe(visible).click();
        return this;
    }

    @Step("Выбрать City: {city}")
    public PracticeFormPage selectCity(String city) {
        cityDropdown.shouldBe(visible).click();
        $(byText(city)).shouldBe(visible).click();
        return this;
    }

    @Step("Нажать Submit")
    public PracticeFormPage submit() {
        submitButton.shouldBe(visible, enabled).scrollIntoView(true).click();
        return this;
    }

    @Step("Проверить, что модальное окно результата появилось")
    public PracticeFormPage checkFormAppears() {
        modalDialog.should(appear);
        modalTitle.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    @Step("Проверить результаты в таблице")
    public PracticeFormPage checkResult(String... expectedTexts) {
        resultTable.shouldBe(visible);
        for (String t : expectedTexts) {
            resultTable.shouldHave(text(t));
        }
        return this;
    }

    private void clickDayInDatePicker(String day) {
        // day "06" -> css "006"
        int d = Integer.parseInt(day);
        String dayCss = String.format("%03d", d);

        $(".react-datepicker__day--" + dayCss + ":not(.react-datepicker__day--outside-month)")
                .shouldBe(visible)
                .click();
    }
}