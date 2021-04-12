package com.gmail.bilisruber812;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class MessageTest {

    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static MessagePage messagePage;
    public static NewLetterPage newLetterPage;
    public static WebDriver driver;
    public static int count = 0;
    public static String nodeURL;

    @BeforeClass()
    public static void setUp() throws MalformedURLException {
        nodeURL = "http://localhost:4546/wd/hub";
        System.out.println("Chrome Browser Initiated");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL(nodeURL),capabilities);
            loginPage = new LoginPage(driver);
            profilePage = new ProfilePage(driver);
            messagePage = new MessagePage(driver);
            newLetterPage = new NewLetterPage(driver);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
            //окно разворачивается на полный экран
            driver.manage().window().maximize();
            //задержка на выполнение теста = 10 сек.
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void messageTest() {
        //вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickPasswordBtn();
        String theme = "Simbirsoft Тестовое задание";
        String lastName = profilePage.getUserName();
        // System.out.println("Фамилия: " + lastName);
        //получаем отображаемый логин
        String login = profilePage.getLogin();
        // System.out.println("Имя: " + login);
        //и сравниваем его с логином из файла настроек
        Assert.assertEquals(ConfProperties.getProperty("login"), login);
        profilePage.entryMenu();
        profilePage.entryMessage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Количество писем в ящике
        List<WebElement> email = driver.findElements(By.xpath(" //*[contains(@class, 'mail-MessageSnippet-Item_subjectWrapper')]"));
       // System.out.println("длина списка email: " + email.size());
       // System.out.println("Имэйл: " + email );
        for(WebElement emailsub : email){
            if(emailsub.getText().equals(theme)){
                count++;
            }
        }
       // System.out.println("Количество писем с темой: Simbirsoft Тестовое задание: " + count);
        messagePage.entryCompose();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        newLetterPage.inputAddress(ConfProperties.getProperty("mail"));
        newLetterPage.inputTopic(theme + "." + "<" + lastName + ">");
        newLetterPage.inputBody(String.valueOf(count));
        newLetterPage.sendLetter();

        assertTrue(driver.findElements(By.linkText("Pobierz plik")).isEmpty());
           }
    /**
     * осуществление выхода из аккаунта с последующим закрытием окна браузера
     */
    @AfterClass
    public static void tearDown() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        profilePage.entryMenu();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        profilePage.userLogout();
        driver.quit();
    }





}
