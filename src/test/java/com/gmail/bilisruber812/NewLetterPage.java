package com.gmail.bilisruber812;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class NewLetterPage {
    @FindBy(xpath = "//*[contains(@class, 'composeYabbles')]")
    private WebElement addressField;
    @FindBy(xpath = "//*[contains(@class, 'ComposeSubject-TextField')]")
    private WebElement topicField;
    @FindBy(xpath = "//*[@id='cke_1_contents']/div/div")
    private WebElement bodyField;
    @FindBy(xpath = "//*[contains(@class, 'ComposeSendButton')]")
    private WebElement sendBtn;
    public NewLetterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void inputAddress(String address) {
        addressField.sendKeys(address);
    }
    public void inputTopic(String topic) {
        topicField.sendKeys(topic);
    }
    public void inputBody(String body) {
        bodyField.sendKeys(body);
    }
    public void sendLetter() {
        sendBtn.click();
    }
}