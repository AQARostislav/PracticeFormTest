package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static com.codeborne.selenide.Selenide.sleep;

public class PracticeFormTest {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void fillFormTest() {
        practiceFormPage.openPage()
                .setFirstName("Rostislav")
                .setLastName("Olegovich")
                .setEmail("aqa@qa.ru")
                .setGender("Female")
                .setPhone("2323232132")
                .setBirthDay("06", "October", "1993")
                .addSubject("History")
                .selectHobby("Sports")
                .selectHobby("Reading")
                .selectHobby("Music")
                .uploadPicture("images/pic.png")
                .setAddress("PushkinaKolotushkina")
                .selectState("NCR")
                .selectCity("Gurgaon")
                .submit()
                .checkFormAppears()
                .checkResult("Rostislav", "Olegovich", "aqa@qa.ru", "2323232132");
        sleep(5000);
    }
}