package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private final CalendarComponent calendarComponent = new CalendarComponent();

    private final SelenideElement
            pageHeader = $(".main-header");
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement birthDatePicker = $("#dateOfBirthInput");
    private final SelenideElement mobileNumberInput = $("#userNumber");
    private final SelenideElement subjectsDropdown = $("#subjectsInput");
    private final SelenideElement chooseFileButton = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateDropdown = $("#state");
    private final SelenideElement cityDropdown = $("#city");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement filledFormModal = $(".modal-content");

    public void openPage() {
        open("/automation-practice-form");
        pageHeader.shouldHave(text("Practice Form"));

    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    public RegistrationPage setGender(String gender) {
        $(byText(gender)).click();

        return this;
    }

    public RegistrationPage setMobileNumber(String number) {
        mobileNumberInput.setValue(number);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthDatePicker.click();
        calendarComponent.setBirthDate(day, month, year);

        return this;
    }

    public RegistrationPage selectSubject(String subject) {
        subjectsDropdown.sendKeys("a");
        $(byText(subject)).click();

        return this;
    }

    public RegistrationPage selectHobbies(String hobbyOne, String hobbyTwo) {
        $(byText(hobbyOne)).click();
        $(byText(hobbyTwo)).click();

        return this;
    }

    public RegistrationPage uploadImage(String fileName) {
        chooseFileButton.uploadFromClasspath(fileName);

        return this;
    }

    public RegistrationPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);

        return this;
    }

    public RegistrationPage selectState(String state) {
        stateDropdown.scrollTo().click();
        $(byText(state)).click();

        return this;
    }

    public RegistrationPage selectCity(String city) {
        cityDropdown.click();
        $(byText(city)).click();

        return this;
    }

    public void submitForm() {
        submitButton.click();

    }

    public RegistrationPage verifyForm(String label, String value) {
        filledFormModal.shouldBe(visible);
        filledFormModal.$(byText(label)).parent().shouldHave(text(value));

        return this;
    }
}

