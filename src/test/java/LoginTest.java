import io.qameta.allure.Description;
import org.junit.Test;
import utils.RandomDataGenerator;

public class LoginTest extends BaseTest{
    public String randomEmailValue = RandomDataGenerator.generateRandomEmail();
    String randomPasswordValue = RandomDataGenerator.generateRandomPassword(8);


    @Test
    @Description("Login with random data is not successful")
    public void loginWithRandomDataNotSuccess(){
        loginPage.pushSignInHeaderButton();
        loginPage.enterEmail(randomEmailValue);
        loginPage.enterPassword(randomPasswordValue);
        loginPage.pushSignInButtonLoginPage();
        welcomePage.avatarButtonIsVisible();
    }
    @Test
    @Description("Login with valid data teacher success")
    public void successLoginTeacherNew(){
        loginPage.pushSignInHeaderButton();
        loginPage.enterEmail("roxanne@example.com");
        loginPage.enterPassword("123456");
        loginPage.pushSignInButtonLoginPage();
        welcomePage.avatarButtonIsVisible();
    }

    @Test
    @Description("Login with valid data student success")
    public void successLoginStudent(){
        loginPage.pushSignInHeaderButton();
        loginPage.enterEmail("malik@example.com");
        loginPage.enterPassword("123456");
        loginPage.pushSignInButtonLoginPage();
        welcomePage.avatarButtonIsVisible();
    }

    @Test
    @Description("Reset password link redirected to reset password form")
    public void successfulForgotPasswordLink(){
        loginPage.pushSignInHeaderButton();
        loginPage.forgotPasswordButton();
        forgotPasswordPage.emailInputFieldIsVisible();
    }

    @Test
    @Description("Login with empty email field not possible")
    public void NotSuccessLoginEmptyEmail(){
        loginPage.pushSignInHeaderButton();
        loginPage.enterEmail("");
        loginPage.enterPassword("123456");
        loginPage.pushSignInButtonLoginPage();
        loginPage.invalidCredText("Invalid email or password");
    }

    @Test
    @Description("Login with empty input fields not possible")
    public void NotSuccessLoginEmptyInputFields(){
        loginPage.pushSignInHeaderButton();
        loginPage.enterEmail("");
        loginPage.enterPassword("");
        loginPage.pushSignInButtonLoginPage();
        loginPage.invalidCredText("Invalid email or password");
    }
}
