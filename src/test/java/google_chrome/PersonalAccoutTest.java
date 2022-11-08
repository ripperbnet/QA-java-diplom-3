package google_chrome;

import steps.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;
import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class PersonalAccoutTest {

    private WebDriver webDriver;

    private LoginPage loginPage;

    private MainPage mainPage;

    private ProfilePage profilePage;

    private OrderPage orderPage;

    private String email = "test-client-practice@yandex.ru";

    private String password = "123456";

    @Before
    public void setUpChrome() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://stellarburgers.nomoreparties.site");
        loginPage = new LoginPage(webDriver);
        profilePage = new ProfilePage(webDriver);
        mainPage = new MainPage(webDriver);
        orderPage = new OrderPage(webDriver);
    }

    @After
    public void tearDownChrome() {
        webDriver.manage().deleteAllCookies();
        ((WebStorage) webDriver).getSessionStorage().clear();
        ((WebStorage) webDriver).getLocalStorage().clear();
        webDriver.quit();
    }

    @Test
    @DisplayName("Проверка перехода в личный кабинет по кнопке «Личный кабинет»")
    @Description("Позитивный тест из браузера google chrome")
    public void loginVerificationInPersonalAccount() {
        mainPage.clickOnLoginButton();
        loginPage.setLoginData(email, password);
        loginPage.clickOnLoginButtonWithCreatedUser();
        mainPage.clickOnPersonalAccountButton();
        boolean isExitButtonDisplayed = profilePage.isExitButtonDisplayed();
        assertTrue("Button is not displayed", isExitButtonDisplayed);
    }

    @Test
    @DisplayName("Переход в конструктор по кнопке «Конструктор» из личного кабинета")
    @Description("Позитивный тест из браузера google chrome")
    public void clickOnConstructorFromPersonalAccount() {
    mainPage.clickOnLoginButton();
    loginPage.setLoginData(email, password);
    loginPage.clickOnLoginButtonWithCreatedUser();
    mainPage.clickOnPersonalAccountButton();
    profilePage.clickOnConstructorButton();
    boolean isButtonDisplayed = orderPage.isOrderButtonDisplayed();
    assertTrue("Button is not displayed", isButtonDisplayed);
    }

    @Test
    @DisplayName("Переход в конструктор по клику на логотип")
    @Description("Позитивный тест из браузера google chrome")
    public void clickOnBurgersLogoFromPersonalAccount() {
        mainPage.clickOnLoginButton();
        loginPage.setLoginData(email, password);
        loginPage.clickOnLoginButtonWithCreatedUser();
        mainPage.clickOnPersonalAccountButton();
        profilePage.clickOnStellarBurgerLogo();
        boolean isButtonDisplayed = orderPage.isOrderButtonDisplayed();
        assertTrue("Button is not displayed", isButtonDisplayed);
    }

    @Test
    @DisplayName("Выход из аккаунта по кнопке «Выход» из личного кабинета")
    @Description("Позитивный тест из браузера google chrome")
    public void clickOnExitButton() {
        mainPage.clickOnLoginButton();
        loginPage.setLoginData(email, password);
        loginPage.clickOnLoginButtonWithCreatedUser();
        mainPage.clickOnPersonalAccountButton();
        profilePage.clickOnExitButton();
        boolean isPWRecoverButtonDisplayed = loginPage.isPassWordRecoverButtonDisplayed();
        assertTrue("Button is not displayed", isPWRecoverButtonDisplayed);
    }
}
