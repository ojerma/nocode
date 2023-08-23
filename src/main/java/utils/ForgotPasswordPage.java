package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {
    private SelenideElement emailInputField = $(byId("forgot-password-email--1161217580"));

    public void emailInputFieldIsVisible(){

        emailInputField.shouldBe(Condition.visible);
    }
}
