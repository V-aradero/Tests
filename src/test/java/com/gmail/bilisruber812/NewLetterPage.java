package com.gmail.bilisruber812;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLetterPage {
    /**
     * конструктор класса
     */
    public WebDriver driver;
    public NewLetterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    /**
     * определение локатора имени
     */
    @FindBy(xpath = "//*[@id='nb-1']/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[1]/div/div/div/div/div")
    private WebElement addressField;

    public void inputAddress(String address) {
        addressField.sendKeys(address);
    }
    /**
     * определение локатора поля темы
     */
    @FindBy(xpath = "//*[@id='nb-1']/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[3]/div/div/input")
    private WebElement topicField;

    public void inputTopic(String topic) {
        topicField.sendKeys(topic);
    }
    /**
     * определение локатора поля тела письма
     */
    @FindBy(xpath = "//*[@id='cke_1_contents']/div/div")
    private WebElement bodyField;

    public void inputBody(String body) {
        bodyField.sendKeys(body);
    }

    /**
     * определение локатора кнопки "ОТПРАВИТЬ"
     */
    @FindBy(xpath =  "//*[@id='nb-1']/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/div[1]")
    private WebElement sendBtn;
    /**
     * метод для нажатия кнопки "ОТПРАВИТЬ"
     */
    public void sendLetter() {
        sendBtn.click();
    }

}
