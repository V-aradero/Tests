package com.gmail.bilisruber812;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    /**
     * конструктор класса
     */
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    /**
     * определение локатора меню пользователя
     */
    @FindBy(xpath = "//*[contains(@class, 'user-account__name')]")
    private WebElement userMenu;
    /**
     * определение локатора кнопки сообщения
     */
    @FindBy(xpath =  "//*[contains(@class, 'legouser__menu-item legouser__menu-item_action_mail')]")
    private WebElement messageBtn;
    /**
     * определение локатора кнопки выхода из аккаунта
     */
    @FindBy(xpath = "//*[contains(@class, 'legouser__menu-item legouser__menu-item_action_exit')]")
    private WebElement logoutBtn;
    /**
     * метод для получения логина из меню пользователя
     */
    public String getLogin() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'user-account__name')]")));
        String login = userMenu.getText();
        return login; }
    /**
     * определение локатора имени
     */
    @FindBy(xpath = "//*[contains(@class, 'personal-info__last')]")
    private WebElement userLast;
    /**
     * метод для получения имени пользователя
     */
    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'personal-info__last')]")));
        String userName = userLast.getText();
        return userName; }
    /**
     * метод для нажатия кнопки меню пользователя
     */
    public void entryMenu() {
        userMenu.click();
    }
    /**
     * метод для нажатия кнопки выхода из аккаунта
     */
    public void userLogout() {
        logoutBtn.click();
    }
    /**
     * метод для нажатия кнопки входа в сообщения
     */
    public void entryMessage() {
        messageBtn.click();
    }
}

