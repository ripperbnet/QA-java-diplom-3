import steps.LoginPage;
import steps.MainPage;
import steps.OrderPage;
import steps.RegistrationPage;
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

import static org.junit.Assert.assertTrue;

public class LoginTest {

    // Выбор браузера chrome/yandex
    private String chooseBrowser = "chrome";

    private WebDriver webDriver;

    private LoginPage loginPage;

    private OrderPage orderPage;

    private MainPage mainPage;

    private RegistrationPage registrationPage;

    private String emailForLogin = "test-client-practice@yandex.ru";

    private String password = "123456";

    private String emailForRegistration = "valid-test-client" + RandomStringUtils.randomNumeric(3) + "@yandex.ru";

    private String name = "text-name";

    @Before
    public void setUpChrome() {
        if (chooseBrowser == "chrome") {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            webDriver.get("https://stellarburgers.nomoreparties.site");
            loginPage = new LoginPage(webDriver);
            registrationPage = new RegistrationPage(webDriver);
            orderPage = new OrderPage(webDriver);
            mainPage = new MainPage(webDriver);
        }
        else if (chooseBrowser == "yandex") {
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
    }

    @After
    public void tearDownChrome() {
        webDriver.manage().deleteAllCookies();
        ((WebStorage) webDriver).getSessionStorage().clear();
        ((WebStorage) webDriver).getLocalStorage().clear();
        webDriver.quit();
    }

    @Test
    @DisplayName("Логин по кнопке «Войти в аккаунт»")
    @Description("Positive test on google chrome browser")
    public void loginByClickingTheLoginButton() {
        mainPage.clickOnLoginButton();
        loginPage.loggingIn(emailForLogin, password);
        boolean isButtonDisplayed = orderPage.isOrderButtonDisplayed();
        assertTrue("Button is not displayed", isButtonDisplayed);
    }

    @Test
    @DisplayName("Логин по кнопке «Личный кабинет»")
    @Description("Позитивный тест из браузера google chrome")
    public void loginByPersonalAccountButton() {
        mainPage.clickOnPersonalAccountButton();
        loginPage.loggingIn(emailForLogin, password);
        boolean isButtonDisplayed = orderPage.isOrderButtonDisplayed();
        assertTrue("Button is not displayed", isButtonDisplayed);
    }

    @Test
    @DisplayName("Логин через форму регистрации")
    @Description("Позитивный тест из браузера google chrome")
    public void loginViaRegistrationForm() {
        mainPage.clickOnLoginButton();
        registrationPage.startRegistration(name, emailForRegistration, password);
        loginPage.loggingIn(emailForRegistration, password);
        boolean isButtonDisplayed = orderPage.isOrderButtonDisplayed();
        assertTrue("Button is not displayed", isButtonDisplayed);
    }

    @Test
    @DisplayName("Логин через форму восстановления пароля")
    @Description("Позитивный тест из браузера google chrome")
    public void loginViaPasswordRecoverForm() {
        mainPage.clickOnLoginButton();
        loginPage.clickOnPasswordRecoverButton();
        loginPage.clickOnLoginButtonInRecoverPWForm();
        loginPage.loggingIn(emailForLogin, password);
        boolean isButtonDisplayed = orderPage.isOrderButtonDisplayed();
        assertTrue("Button is not displayed", isButtonDisplayed);
    }
}
