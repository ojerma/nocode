import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import utils.RandomDataGenerator;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginTest extends BaseTest{
    public String emailValue = RandomDataGenerator.generateRandomEmail();
    @Test
    @Description("Login with valid data teacher success")
    public void successLoginTeacher(){
        loginPage.pushSignInHeaderButton();
        loginPage.enterEmail("roxanne@example.com");
        loginPage.enterPassword("123456");
        loginPage.pushSignInButtonLoginPage();
        welcomePage.avatarButtonClick();
        sleep(10000);
    }
    @Test
    @Description("Login with valid data student success")
    public void successLoginStudent(){
        loginPage.pushSignInHeaderButton();
        loginPage.enterEmail("malik@example.com");
        loginPage.enterPassword("123456");
        loginPage.pushSignInButtonLoginPage();
        welcomePage.avatarButtonClick();
        sleep(10000);
    }

    @Test
    @Description("Reset password link redirected to reset password form")
    public void forgotPassword(){
        loginPage.pushSignInHeaderButton();
        loginPage.forgotPasswordButton();
        sleep(5000);
    }

    @Test
    @Description("Login with empty email field not possible")
    public void loginEmptyEmailFailure(){
        loginPage.pushSignInHeaderButton();
        loginPage.enterPassword("123456");
        loginPage.pushSignInButtonLoginPage();
        loginPage.invalidCredText("Invalid email or password");
        sleep(5000);
    }

    @Test
    @Description("Login with empty input fields not possible")
    public void loginEmptyInputFields(){
        loginPage.pushSignInHeaderButton();
        loginPage.enterEmail("");
        loginPage.enterPassword("");
        loginPage.pushSignInButtonLoginPage();
        loginPage.invalidCredText("Invalid email or password");
        sleep(5000);
    }
}
