package utils;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class WelcomePage {
    private SelenideElement avatarButton = $(byXpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-17qbyv7']"));

    public void avatarButtonClick(){
        avatarButton.shouldBe(visible).click();
    }
}
