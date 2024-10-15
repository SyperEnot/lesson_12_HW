import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomDataUtils;

@Tag("simple")
public class PageObjectsFormTests extends TestBase {


    RegistrationPage registrationPage = new RegistrationPage();
    RandomDataUtils ra = new RandomDataUtils();

    private String firstName = ra.FirstName(),
            lastName = ra.LastName(),
            userEmail = ra.Email(),
            genderUser = ra.Gender(),
            userNumber = ra.Phone(),
            monthOfBirth = ra.monthOfBirth(),
            yearOfBirth = ra.yearOfBirth(),
            dayOfBirth = ra.dayOfBirth(),
            picture = "Pika-pika.jpg",
            subjects = ra.Subject(),
            hobbies = ra.Hobby(),
            currentAddress = ra.Address(),
            state = ra.State(),
            city = ra.getCityRandom(state);

    @Test
    @DisplayName("Заполнение всех полей")
    void fillFieldsTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGenderWrapper(genderUser)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjectsInput(subjects)
                .setHobbiesWrapperInput(hobbies)
                .setUploadPicture(picture)
                .setCurrentAddress(currentAddress)
                .setChooseState(state)
                .setChooseCity(city)
                .pressSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", genderUser)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth",dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    @DisplayName("Заполнение обязательных полей")
    void partCompleteFormTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGenderWrapper(genderUser)
                .setUserNumber(userNumber)
                .pressSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", genderUser)
                .checkResult("Mobile", userNumber);
    }

    @Test
    @DisplayName("Форма не заполнена")
    void negativeCompleteFormTest() {

        registrationPage.openPage()
                .pressSubmit()
                .checkNotCompleteForm();
    }
}