package com.gmail.bilisruber812;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MessageTest {
    private static LoginPage loginPage;
    private static ProfilePage profilePage;
    private static MessagePage messagePage;
    private static NewLetterPage newLetterPage;
    private static WebDriver driver;
    private static String nodeURL;

    @BeforeClass()
    public static void setUp() throws MalformedURLException {
        nodeURL = "http://localhost:4546/wd/hub";
        System.out.println("Chrome Browser Initiated");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL(nodeURL), capabilities);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        messagePage = new MessagePage(driver);
        newLetterPage = new NewLetterPage(driver);
        driver.get(ConfProperties.getProperty("loginpage"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void messageTest() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        String lastName = profilePage.getUserName();
        String login = profilePage.getLogin();
        Assert.assertEquals(ConfProperties.getProperty("login"), login);
        profilePage.entryMenu();
        profilePage.entryMessage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        messagePage.entryCompose();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        newLetterPage.inputAddress(ConfProperties.getProperty("mail"));
        newLetterPage.inputTopic(messagePage.theme + "." + "<" + lastName + ">");
        newLetterPage.inputBody(String.valueOf(messagePage.getCountLetters()));
        newLetterPage.sendLetter();
    }

    @AfterClass
    public static void tearDown() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        profilePage.entryMenu();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        profilePage.userLogout();
        driver.quit();
    }
}
