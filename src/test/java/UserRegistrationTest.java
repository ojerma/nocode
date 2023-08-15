import io.qameta.allure.Description;
import org.junit.Test;
import utils.RandomDataGenerator;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class UserRegistrationTest extends BaseTest {
    public String randomEmailValue = RandomDataGenerator.generateRandomEmail();
    String randomPasswordValue = RandomDataGenerator.generateRandomPassword(10);
    String randomFullName = RandomDataGenerator.generateRandomFullName();

    @Test @Description("Registration with teacher role is successful")
    public void successRegistrationTeacher() {
        userRegistrationPage.pushSignUpHeaderButton();
        userRegistrationPage.noCodeLogoIsDisplayed();
        userRegistrationPage.selectTeacherRole();
        userRegistrationPage.fullNameFieldValue(randomFullName);
        userRegistrationPage.emailFieldValue(randomEmailValue);
        userRegistrationPage.passwordFieldValue(randomPasswordValue);
        userRegistrationPage.checkboxChecked();
        userRegistrationPage.pushSignUpButton();
        welcomePage.avatarButtonClick();
        sleep(5000);
    }

    @Test @Description("Registration with empty email field is not successful")
    public void registerTeacherWithEmptyEmailField() {
        userRegistrationPage.pushSignUpHeaderButton();
        userRegistrationPage.noCodeLogoIsDisplayed();
        userRegistrationPage.selectTeacherRole();
        userRegistrationPage.fullNameFieldValue(randomFullName);
        userRegistrationPage.emailFieldValue("");
        userRegistrationPage.passwordFieldValue(randomPasswordValue);
        userRegistrationPage.checkboxChecked();
        userRegistrationPage.pushSignUpButton();
        userRegistrationPage.invalidCredText("Please make sure there are no empty required fields.");
        sleep(5000);
    }

    @Test @Description("Registration with student role is successful")
    public void successRegistrationStudent() {
        userRegistrationPage.pushSignUpHeaderButton();
        userRegistrationPage.noCodeLogoIsDisplayed();
        userRegistrationPage.selectStudentRole();
        userRegistrationPage.fullNameFieldValue(randomFullName);
        userRegistrationPage.emailFieldValue(randomEmailValue);
        userRegistrationPage.passwordFieldValue(randomPasswordValue);
        userRegistrationPage.checkboxChecked();
        userRegistrationPage.pushSignUpButton();
        welcomePage.avatarButtonClick();
        sleep(5000);
    }

    @Test @Description("Registration with empty role is not successful")
    public void registrationRoleNotSelected() {
        userRegistrationPage.pushSignUpHeaderButton();
        userRegistrationPage.noCodeLogoIsDisplayed();
        userRegistrationPage.fullNameFieldValue(randomFullName);
        userRegistrationPage.emailFieldValue(randomEmailValue);
        userRegistrationPage.passwordFieldValue(randomPasswordValue);
        userRegistrationPage.checkboxChecked();
        userRegistrationPage.pushSignUpButton();
        userRegistrationPage.invalidCredText("Please make sure there are no empty required fields.");
        sleep(5000);

    }
}