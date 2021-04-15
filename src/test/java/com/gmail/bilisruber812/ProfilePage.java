package com.gmail.bilisruber812;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ProfilePage {
    private WebDriver driver;

    ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@class, 'user-account__name')]")
    private WebElement userMenu;
    @FindBy(xpath = "//*[contains(@class, 'legouser__menu-item_action_mail')]")
    private WebElement messageBtn;
    @FindBy(xpath = "//*[contains(@class, 'legouser__menu-item_action_exit')]")
    private WebElement logoutBtn;

    String getLogin() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'user-account__name')]")));
        String login = userMenu.getText();
        return login;
    }

    @FindBy(xpath = "//*[contains(@class, 'personal-info__last')]")
    private WebElement userLast;

    String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'personal-info__last')]")));
        String userName = userLast.getText();
        return userName;
    }

    void entryMenu() {
        userMenu.click();
    }

    void userLogout() {
        logoutBtn.click();
    }

    void entryMessage() {
        messageBtn.click();
    }
}

