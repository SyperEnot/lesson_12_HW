package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResponsiveComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName"),

    lastNameInput = $("#lastName"),

    userEmailInput = $("#userEmail"),

    genderWrapper = $("#genterWrapper"),

    userNumberInput = $("#userNumber"),

    subjectsInput = $("#subjectsInput"),

    hobbiesWrapperInput = $("#hobbiesWrapper"),

    uploadPicture = $("#uploadPicture"),

    currentAddress = $("#currentAddress"),

    pressSubmitButton = $("#submit"),

    dateOfBirth = $("#dateOfBirthInput"),

    chooseState = $("#react-select-3-input"),

    chooseCity = $("#react-select-4-input");

    CalendarComponent calendarComponent = new CalendarComponent();

    TableResponsiveComponent tableResponsiveComponent = new TableResponsiveComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGenderWrapper(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setSubjectsInput(String value) {
        subjectsInput.val(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbiesWrapperInput(String value) {
        hobbiesWrapperInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;

    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirth.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setChooseState(String value) {
        chooseState.val(value).pressEnter();

        return this;

    }

    public RegistrationPage setChooseCity(String value) {
        chooseCity.val(value).pressEnter();

        return this;

    }

    public RegistrationPage pressSubmit() {
        pressSubmitButton.pressEnter();

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        tableResponsiveComponent.checkResultTable(key, value);

        return this;
    }

    public RegistrationPage checkNotCompleteForm() {
        firstNameInput.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));

        return this;
    }

}
