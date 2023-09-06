import io.qameta.allure.Description;
import org.junit.Test;
import utils.RandomDataGenerator;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertEquals;

public class UserRegistrationTest extends BaseTest {
    public String randomEmailValue = RandomDataGenerator.generateRandomEmail();
    String randomPasswordValue = RandomDataGenerator.generateRandomPassword(8);
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
        welcomePage.avatarButtonIsVisible();
        ApiRequests requests = new ApiRequests();
        requests.deleteRequest("user/" + randomEmailValue);

        }

    @Test @Description("Registration with empty email field is not successful")
    public void FailureRegisterTeacherWithEmptyEmailField() {
        userRegistrationPage.pushSignUpHeaderButton();
        userRegistrationPage.noCodeLogoIsDisplayed();
        userRegistrationPage.selectTeacherRole();
        userRegistrationPage.fullNameFieldValue(randomFullName);
        userRegistrationPage.emailFieldValue("");
        userRegistrationPage.passwordFieldValue(randomPasswordValue);
        userRegistrationPage.checkboxChecked();
        userRegistrationPage.pushSignUpButton();
        userRegistrationPage.invalidCredText("Please make sure there are no empty required fields.");

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
        welcomePage.avatarButtonIsVisible();
        ApiRequests requests = new ApiRequests();
        requests.deleteRequest("user/" + randomEmailValue);

    }

    @Test @Description("Registration with empty role is not successful")
    public void FailureRegistrRoleNotSelected() {
        userRegistrationPage.pushSignUpHeaderButton();
        userRegistrationPage.noCodeLogoIsDisplayed();
        userRegistrationPage.fullNameFieldValue(randomFullName);
        userRegistrationPage.emailFieldValue(randomEmailValue);
        userRegistrationPage.passwordFieldValue(randomPasswordValue);
        userRegistrationPage.checkboxChecked();
        userRegistrationPage.pushSignUpButton();
        userRegistrationPage.invalidCredText("Please make sure there are no empty required fields.");


    }
}