import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {
    String URL = "/text-box";
    String userName = "Stas";
    String userEmail = "example@example.ru";
    String currentAddress = "SPB, Russia";
    String permanentAddress = "Sankt-Peterburg, Russia";

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage(URL)
                .setFullName(userName)
                .setEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickInput();

        textBoxPage.checkResult ("Name:", userName)
                .checkResult("Email:", userEmail)
                .checkResult("Current Address :", currentAddress)
                .checkResult("Permananet Address :", permanentAddress);
    }
}