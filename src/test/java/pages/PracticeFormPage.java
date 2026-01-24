package pages;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

    public class PracticeFormPage {

        public PracticeFormPage openPage() {
            open("https://demoqa.com/automation-practice-form");
            return this;
        }

        public PracticeFormPage setFirstName(String value) {
            $("#firstName").setValue(value);
            return this;
        }

        public PracticeFormPage setLastName(String value) {
            $("#lastName").setValue(value);
            return this;
        }

        public PracticeFormPage setEmail(String value) {
            $("#userEmail").setValue(value);
            return this;
        }

        public PracticeFormPage setGender(String gender) {

            $("#genterWrapper").$(byText(gender)).click();
            return this;
        }

        public PracticeFormPage setPhone(String value) {
            $("#userNumber").setValue(value);
            return this;
        }

        public PracticeFormPage setBirthDay(String day, String month, String year) {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption(month);
            $(".react-datepicker__year-select").selectOption(year);

            // day "06" -> "006"
            int d = Integer.parseInt(day);
            String dayCss = String.format("%03d", d);

            $(".react-datepicker__day--" + dayCss + ":not(.react-datepicker__day--outside-month)").click();
            return this;
        }

        public PracticeFormPage addSubject(String subject) {
            $("#subjectsInput").setValue(subject).pressEnter();
            return this;
        }

        public PracticeFormPage selectHobby(String hobby) {
            // hobby: Sports / Reading / Music
            $("#hobbiesWrapper").$(byText(hobby)).click();
            return this;
        }

        public PracticeFormPage uploadPicture(String classpathFile) {
            $("#uploadPicture").uploadFromClasspath(classpathFile);
            return this;
        }

        public PracticeFormPage setAddress(String value) {
            $("#currentAddress").setValue(value);
            return this;
        }

        public PracticeFormPage selectState(String state) {
            $("#state").click();
            $(byText(state)).click();
            return this;
        }

        public PracticeFormPage selectCity(String city) {
            $("#city").click();
            $(byText(city)).click();
            return this;
        }

        public PracticeFormPage submit() {
            $("#submit").click();
            return this;
        }

        // ===== Assertions (проверки) =====

        public PracticeFormPage checkFormAppears() {
            $(".modal-dialog").should(appear);
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            return this;
        }

        public PracticeFormPage checkResult(String... expectedTexts) {
            var table = $(".table-responsive");
            for (String t : expectedTexts) {
                table.shouldHave(text(t));
            }
            return this;
        }
    }