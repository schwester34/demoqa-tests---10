package tests;



import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class PracticeFormTest extends TestBase{
    @Test
    @DisplayName("Successful fill registration test")
    void fillFormTest(){

        String firstName = "Name";
        String lastName = "Surname";
        String userEmail = "mail@mail.ru";
        String gender = "Female";
        String userNumber = "123456";
        String year = "1999";
        String month = "February";
        String day = "12";
        String subject = "English";
        String hobby = "Music";
        String address = "Country, City, Street 5";
        String state = "NCR";
        String city = "Delhi";

        step("Open registration form", () -> {
            open("/automation-practice-form");

            Selenide.executeJavaScript("document.getElementById('fixedban').hidden = 'true'");
            executeJavaScript("$('footer').remove()");
        });

        step("Fill registration form", () -> {
            $("#firstName").setValue(firstName);
            $("#lastName").setValue(lastName);
            $("#userEmail").setValue(userEmail);
            $("#genterWrapper").$(byText(gender)).click();
            $("#userNumber").setValue(userNumber);


            $("#dateOfBirthInput").click();
            $(" .react-datepicker__year-select").selectOption(year);
            $(" .react-datepicker__month-select").selectOption(month);
            $(byText(day)).click();

            $("#subjectsInput").setValue(subject).pressEnter();
            $("#hobbiesWrapper").$(byText(hobby)).click();
            $("#uploadPicture").uploadFromClasspath("hdr009.jpg");

            $("#currentAddress").setValue(address);
            $("#state").click();
            $(byText(state)).click();
            $("#city").click();
            $(byText(city)).click();
            $("#submit").click();
        });

        step("Verify", () -> {
            $(".table-responsive").shouldHave(
                    text(firstName + " " + lastName),
                    text(userEmail),
                    text(gender),
                    text(userNumber),
                    text(day + " " + month + "," + year),
                    text(subject),
                    text(hobby),
                    text("hdr009.jpg"),
                    text(address),
                    text(state + " " + city)
            );
        });
    }
}


