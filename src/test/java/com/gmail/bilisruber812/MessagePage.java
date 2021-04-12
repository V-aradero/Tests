package com.gmail.bilisruber812;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessagePage {
    /**
     * конструктор класса
     */
    public WebDriver driver;
    public MessagePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    /**
     * определение локатора кнопки "Написать"
     */
    @FindBy(xpath =  "//*[contains(@class, 'svgicon svgicon-mail--ComposeButton')]")
    private WebElement composeBtn;
    /**
     * метод для нажатия кнопки "Написать"
     */
    public void entryCompose() {
        composeBtn.click();
    }

}
