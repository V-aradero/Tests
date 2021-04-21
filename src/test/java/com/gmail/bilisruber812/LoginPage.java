package com.gmail.bilisruber812;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {
    @FindBy(xpath = "//*[contains(@id, 'passp-field-login')]")
    private WebElement loginField;
    @FindBy(xpath = "//*[contains(@class, 'passp-sign-in-button')]")
    private WebElement loginBtn;
    @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]")
    private WebElement passwdField;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }
    public void clickLoginBtn() {
        loginBtn.click();
    }
}