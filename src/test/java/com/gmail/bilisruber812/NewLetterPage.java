package com.gmail.bilisruber812;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class NewLetterPage {
    private WebDriver driver;

    NewLetterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@class, 'composeYabbles')]")
    private WebElement addressField;

    void inputAddress(String address) {
        addressField.sendKeys(address);
    }

    @FindBy(xpath = "//*[contains(@class, 'ComposeSubject-TextField')]")
    private WebElement topicField;

    void inputTopic(String topic) {
        topicField.sendKeys(topic);
    }

    @FindBy(xpath = "//*[@id='cke_1_contents']/div/div")
    private WebElement bodyField;

    void inputBody(String body) {
        bodyField.sendKeys(body);
    }

    @FindBy(xpath = "//*[contains(@class, 'ComposeSendButton')]")
    private WebElement sendBtn;

    void sendLetter() {
        sendBtn.click();
    }
}
