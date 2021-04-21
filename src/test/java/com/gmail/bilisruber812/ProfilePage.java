package com.gmail.bilisruber812;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ProfilePage {
    private WebDriverWait wait;
    @FindBy(xpath = "//*[contains(@class, 'user-account__name')]")
    private WebElement userMenu;
    @FindBy(xpath = "//*[contains(@class, 'legouser__menu-item_action_mail')]")
    private WebElement messageBtn;
    @FindBy(xpath = "//*[contains(@class, 'legouser__menu-item_action_exit')]")
    private WebElement logoutBtn;
    @FindBy(xpath = "//*[contains(@class, 'personal-info__last')]")
    private WebElement userLast;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }
    public String getLogin() {
        wait.until(ExpectedConditions.visibilityOf(userMenu));
        return userMenu.getText();
    }
    public String getUserName() {
        wait.until(ExpectedConditions.visibilityOf(userLast));
        return userLast.getText();
    }
    public void entryMenu() {
        userMenu.click();
    }
    public void userLogout() {
        logoutBtn.click();
    }
    public void entryMessage() {
        messageBtn.click();
    }
}