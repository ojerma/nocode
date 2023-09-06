import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;
import utils.ForgotPasswordPage;
import utils.LoginPage;
import utils.UserRegistrationPage;
import utils.WelcomePage;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    final String BASE_URL = "https://erich416.softr.app/";
        //"https://jere237.softr.app/"; "https://erich416.softr.app/";


    @Before
    public void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open(BASE_URL);
    }

    @After
    public void tearDown(){

        closeWebDriver();
    }

    public void switchToTab(int tabNum){

        switchTo().window(tabNum);
    }

    LoginPage loginPage = new LoginPage();

    WelcomePage welcomePage = new WelcomePage();
    UserRegistrationPage userRegistrationPage = new UserRegistrationPage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
}








