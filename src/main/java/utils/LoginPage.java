package utils;


import com.codeborne.selenide.SelenideElement;


import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;


import static com.codeborne.selenide.Selenide.$;

public class LoginPage {


    private SelenideElement signInHeaderButton = $(byCssSelector("[class='MuiBox-root css-jf8tht']"));
    private SelenideElement emailField = $(byAttribute("placeholder", "Email"));
    private SelenideElement passwordField = $(byAttribute("placeholder", "Password"));
    private SelenideElement signInButtonLoginPage = $(byId("sw-sign-in-submit-btn"));
    private SelenideElement forgotPasswordButton =$("[href='/forgot-password']");
    private SelenideElement errorMessage = $(byCssSelector("[class='error-message login-error d-block']"));

    public void pushSignInHeaderButton(){
        signInHeaderButton.click();
    }
    public void enterEmail(String emailValue){
        emailField.shouldBe(visible);
        emailField.setValue(emailValue);
    }

    public void enterPassword(String passwordValue){
        passwordField.setValue(passwordValue);
    }

    public void pushSignInButtonLoginPage(){
        signInButtonLoginPage.click();
    }
    public void forgotPasswordButton(){
        signInHeaderButton.click();
        forgotPasswordButton.click();
    }

    public void loginEmptyEmail(String passwordValue){
        signInHeaderButton.click();
        passwordField.setValue(passwordValue);
        signInButtonLoginPage.click();
    }


    public void invalidCredText(String expectedText){
        errorMessage.shouldHave(text(expectedText));
    }

        }

