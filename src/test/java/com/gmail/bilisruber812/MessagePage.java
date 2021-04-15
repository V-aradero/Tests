package com.gmail.bilisruber812;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

class MessagePage {
    private WebDriver driver;
    String theme = "Simbirsoft Тестовое задание";

    MessagePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@class, 'svgicon-mail--ComposeButton')]")
    private WebElement composeBtn;

    void entryCompose() {
        composeBtn.click();
    }

    int getCountLetters() {
        int count = 0;
        List<WebElement> email = driver.findElements(By.xpath(" //*[contains(@class, 'mail-MessageSnippet-Item_subjectWrapper')]"));
        for (
                WebElement emailsub : email) {
            if (emailsub.getText().equals(theme)) {
                count++;
            }
        }
        return count;
    }
}
