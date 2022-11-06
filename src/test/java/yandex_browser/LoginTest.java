package yandex_browser;

import generator.LoginPage;
import generator.MainPage;
import generator.OrderPage;
import generator.RegistrationPage;
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

import static org.junit.Assert.assertTrue;

public class LoginTest {

    private WebDriver webDriver;

    private LoginPage loginPage;

    private OrderPage orderPage;

    private MainPage mainPage;

    private RegistrationPage registrationPage;

    private String emailForLogin = "test-client-practice@yandex.ru";

    private String password = "123456";

    private String emailForRegistration = "test-clients" + RandomStringUtils.randomNumeric(3) + "@yandex.ru";

    private String name = "text-name";

    @Before
    public void setUpYandex() {

        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\bin\\yandexdriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://stellarburgers.nomoreparties.site");
        loginPage = new LoginPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        orderPage = new OrderPage(webDriver);
        mainPage = new MainPage(webDriver);
    }

    @After
    public void tearDownYandex() {
        webDriver.manage().deleteAllCookies();
        ((WebStorage) webDriver).getSessionStorage().clear();
        ((WebStorage) webDriver).getLocalStorage().clear();
        webDriver.quit();
    }

    @Test
    @DisplayName("Логин по кнопке «Войти в аккаунт»")
    @Description("Positive test on google yandex browser")
    public void loginByClickingTheLoginButton() {
        mainPage.clickOnLoginButton();
        loginPage.setLoginData(emailForLogin, password);
        loginPage.clickOnLoginButtonWithCreatedUser();
        boolean isButtonDisplayed = orderPage.isOrderButtonDisplayed();
        assertTrue("Button is not displayed", isButtonDisplayed);
    }

    @Test
    @DisplayName("Логин по кнопке «Личный кабинет»")
    @Description("Позитивный тест из браузера yandex browser")
    public void loginByPersonalAccountButton() {
        mainPage.clickOnPersonalAccountButton();
        loginPage.setLoginData(emailForLogin, password);
        loginPage.clickOnLoginButtonWithCreatedUser();
        boolean isButtonDisplayed = orderPage.isOrderButtonDisplayed();
        assertTrue("Button is not displayed", isButtonDisplayed);
    }

    @Test
    @DisplayName("Логин через форму регистрации")
    @Description("Позитивный тест из браузера yandex browser")
    public void loginViaRegistrationForm() {
        mainPage.clickOnLoginButton();
        registrationPage.clickOnRegistrationButton();
        registrationPage.setRegistrationData(name, emailForRegistration, password);
        registrationPage.clickOnStartRegistrationButton();
        loginPage.setLoginData(emailForRegistration, password);
        loginPage.clickOnLoginButtonWithCreatedUser();
        boolean isButtonDisplayed = orderPage.isOrderButtonDisplayed();
        assertTrue("Button is not displayed", isButtonDisplayed);
    }

    @Test
    @DisplayName("Логин через форму восстановления пароля")
    @Description("Позитивный тест из браузера yandex browser")
    public void loginViaPasswordRecoverForm() {
        mainPage.clickOnLoginButton();
        loginPage.clickOnPasswordRecoverButton();
        loginPage.clickOnLoginButtonInRecoverPWForm();
        loginPage.setLoginData(emailForLogin, password);
        loginPage.clickOnLoginButtonWithCreatedUser();
        boolean isButtonDisplayed = orderPage.isOrderButtonDisplayed();
        assertTrue("Button is not displayed", isButtonDisplayed);
    }
}
