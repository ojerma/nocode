package utils;

import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class UserRegistrationPage {
    Random random = new Random();
    private SelenideElement signUpHeaderButton = $(byText("Sign up"));

    private SelenideElement noCodeLogoHeader = $(byClassName("navbar-brand"));
    private SelenideElement dropdownRole = $(byText("Select your role"));
    private SelenideElement dropdownRoleTeacher =$(byText("teacher"));
    private SelenideElement dropdownRoleStudent =$(byText("student"));
    private SelenideElement fullNameField = $(byId("sw-form-capture-full_name-input"));
    private SelenideElement emailField = $(byAttribute("placeholder", "Email"));
    private SelenideElement passwordField = $(byId("sw-form-password-input"));
    private SelenideElement checkBox = $(By.cssSelector(".checkmark.position-relative.sw-checkbox"));
    private SelenideElement signUpButton = $(byId("sw-sign-up-submit-btn"));
    private SelenideElement errorMessage = $(By.cssSelector("[class='error-message required-errors d-block']"));


    public void pushSignUpHeaderButton() {
        signUpHeaderButton.click();
    }

    public void noCodeLogoIsDisplayed() {
        noCodeLogoHeader.shouldBe(visible);
    }

    public void selectDropdownRole(){
        dropdownRole.click();
    }

    public void selectTeacherRole(){
        dropdownRole.click();
        dropdownRoleTeacher.click();
    }
    public void selectStudentRole(){
        dropdownRole.click();
        dropdownRoleStudent.click();
    }

    public void fullNameFieldValue(String fullNameValue){

        fullNameField.setValue(fullNameValue);
    }
    public void emailFieldValue(String emailValue){

        emailField.setValue(emailValue);
    }
    public void passwordFieldValue(String passwordValue){

        passwordField.setValue(passwordValue);
    }

    public void checkboxChecked(){
        if (!checkBox.isSelected()){
            checkBox.click();
        }
    }
    public void pushSignUpButton(){
        signUpButton.click();

    }
    public void invalidCredText(String expectedText){
        errorMessage.shouldHave(text(expectedText));
    }}