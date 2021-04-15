package com.gmail.bilisruber812;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class LoginPage {
    private WebDriver driver;

    LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@id, 'passp-field-login')]")
    private WebElement loginField;
    @FindBy(xpath = "//*[contains(@class, 'passp-sign-in-button')]")
    private WebElement loginBtn;
    @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]")
    private WebElement passwdField;

    void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    void clickLoginBtn() {
        loginBtn.click();
    }
}
