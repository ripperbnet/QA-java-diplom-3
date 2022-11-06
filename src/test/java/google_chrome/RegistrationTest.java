package google_chrome;

import generator.LoginPage;
import generator.MainPage;
import generator.OrderPage;
import generator.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;


import java.time.Duration;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    private WebDriver webDriver;

    private LoginPage loginPage;

    private OrderPage orderPage;

    private RegistrationPage registrationPage;

    private MainPage mainPage;

    private String email = "dinosaur" + RandomStringUtils.randomNumeric(4) + "@yandex.ru";

    private String password = "password";

    private String name = "Test-name";



    @Before
    public void setUpChrome() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://stellarburgers.nomoreparties.site/");
        loginPage = new LoginPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        orderPage = new OrderPage(webDriver);
        mainPage = new MainPage(webDriver);
    }

    @After
    public void tearDownChrome() {
        webDriver.manage().deleteAllCookies();
        ((WebStorage) webDriver).getSessionStorage().clear();
        ((WebStorage) webDriver).getLocalStorage().clear();
        webDriver.quit();
    }

    @Test
    @DisplayName("Регистрация пользователя с валидными данными")
    @Description("Позитивный тест из браузера google chrome")
    public void creatingUseWithValidData() {
        mainPage.clickOnLoginButton();
        registrationPage.clickOnRegistrationButton();
        registrationPage.setRegistrationData(name, email, password);
        registrationPage.clickOnStartRegistrationButton();
        assertEquals("https://stellarburgers.nomoreparties.site/login", loginPage.getURL());
    }

    @Test
    @DisplayName("Регистрация пользователя с невалидным паролем (5 символов)")
    @Description("Негативный тест из браузера google chrome")
    public void creatingUserWithInvalidPassword() {
        mainPage.clickOnLoginButton();
        registrationPage.clickOnRegistrationButton();
        registrationPage.setRegistrationData(name, email, "12345");
        registrationPage.clickOnStartRegistrationButton();
        boolean isErrorDisplayed = registrationPage.isErrorMessageDisplayed();;
        assertTrue("Error message is not displayed", isErrorDisplayed);
    }
}
