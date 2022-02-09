package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void successFillTest() throws InterruptedException {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Marina");
        $("#lastName").setValue("Romanova");
        $("#userEmail").setValue("mari@rom.eu");

        executeJavaScript("arguments[0].click()", $(By.id("gender-radio-2")));

        $("#userNumber").setValue("1234567899");
        //$("#dateOfBirthInput").clear();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(".react-datepicker__year-select").selectOptionByValue("1999");
        $(".react-datepicker__day--007").click();


        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#subjectsInput").setValue("Civics").pressEnter();


        executeJavaScript("arguments[0].click()", $(By.id("hobbies-checkbox-2")));
        executeJavaScript("arguments[0].click()", $(By.id("hobbies-checkbox-3")));
        $("#uploadPicture").uploadFile(new File("src/test/resources/picture.jpg"));

        $("#currentAddress").setValue("Moscow");

        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Panipat").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave((textCaseSensitive("Thanks for submitting the form")));
        $(".table-responsive").shouldHave(
                textCaseSensitive("Student Name"),    textCaseSensitive("Marina Romanova"),
                textCaseSensitive("Student Email"),   textCaseSensitive("mari@rom.eu"),
                textCaseSensitive("Gender"),          textCaseSensitive("Female"),
                textCaseSensitive("Mobile"),          textCaseSensitive("1234567899"),
                textCaseSensitive("Date of Birth"),   textCaseSensitive("09 February,1999"),
                textCaseSensitive("Subjects"),        textCaseSensitive("Arts, Civics"),
                textCaseSensitive("Hobbies"),         textCaseSensitive("Reading, Music"),
                textCaseSensitive("Picture"),         textCaseSensitive("picture.jpg"),
                textCaseSensitive("Address"),         textCaseSensitive("Moscow"),
                textCaseSensitive("State and City"),  textCaseSensitive("Haryana Panipat")
        );

        $("#closeLargeModal").click();
    }
}
