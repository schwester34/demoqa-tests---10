package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeFormTest {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        String firstName = "Marina";
        String lastName = "Romanova";
        String email = "mari@rom.eu";
        String gender = "Female";
        String phoneNumber = "1234567899";
        String day = "19";
        String month = "February";
        String year = "1999";
        String subject = "Maths";
        String hobby_1 = "Civics";
        String hobby_2 = "Music";
        String fileName = "hdr009.jpg";
        String address = "Moscow";
        String state = "Haryana";
        String city = "Panipat";

        registrationPage.openPage();

        registrationPage.setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobileNumber(phoneNumber)
                .setBirthDate(day, month, year)
                .selectSubject(subject)
                .selectHobbies(hobby_1, hobby_2)
                .uploadImage(fileName)
                .setCurrentAddress(address)
                .selectState(state)
                .selectCity(city)
                .submitForm();

        registrationPage.verifyForm("Student Name", firstName + " " + lastName)
                .verifyForm("Student Email", email)
                .verifyForm("Gender", gender)
                .verifyForm("Mobile", phoneNumber)
                .verifyForm("Date of Birth", day + " " + month + "," + year)
                .verifyForm("Subjects", subject)
                .verifyForm("Hobbies", hobby_1 + ", " + hobby_2)
                .verifyForm("Picture", fileName)
                .verifyForm("Address", address)
                .verifyForm("State and City", state + " " + city);
        }


    }

