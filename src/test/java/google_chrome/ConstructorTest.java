package google_chrome;

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

public class ConstructorTest {

    private WebDriver webDriver;

    private LoginPage loginPage;

    private OrderPage orderPage;

    private MainPage mainPage;

    private RegistrationPage registrationPage;

    private String email = "test-client-practice@yandex.ru";

    private String password = "123456";

    private String emailForRegistration = "test-clients" + RandomStringUtils.randomNumeric(3) + "@yandex.ru";

    @Before
    public void setUpChrome() {
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

    @After
    public void tearDownChrome() {
        webDriver.manage().deleteAllCookies();
        ((WebStorage) webDriver).getSessionStorage().clear();
        ((WebStorage) webDriver).getLocalStorage().clear();
        webDriver.quit();
    }

    @Test
    @DisplayName("Проверка отображения булок/соусов/начинок в конструкторе после логина")
    @Description("Позитивный тест из браузера google chrome")
    public void validatingConstructorAfterLogin() {
        mainPage.clickOnLoginButton();
        loginPage.setLoginData(email, password);
        loginPage.clickOnLoginButtonWithCreatedUser();
        mainPage.clickOnSaucesMenu();
        boolean isSauceDisplayed = mainPage.isSauceConstructorDisplayed();
        assertTrue("Sauce is not displayed", isSauceDisplayed);
        mainPage.clickOnFillsMenu();
        boolean isFillDisplayed = mainPage.isFillConstructorDisplayed();
        assertTrue("Fill is not displayed", isFillDisplayed);
        mainPage.ClickOnBunsMenu();
        boolean isBunDisplayed = mainPage.isBunConstructorDisplayed();
        assertTrue("Bun is not displayed", isBunDisplayed);
    }

    @Test
    @DisplayName("Проверка отображения булок/соусов/начинок в конструкторе БЕЗ логина")
    @Description("Позитивный тест из браузера google chrome")
    public void validatingConstructorWithoutLogin() {
        mainPage.clickOnSaucesMenu();
        boolean isSauceDisplayed = mainPage.isSauceConstructorDisplayed();
        assertTrue("Sauce is not displayed", isSauceDisplayed);
        mainPage.clickOnFillsMenu();
        boolean isFillDisplayed = mainPage.isFillConstructorDisplayed();
        assertTrue("Fill is not displayed", isFillDisplayed);
        mainPage.ClickOnBunsMenu();
        boolean isBunDisplayed = mainPage.isBunConstructorDisplayed();
        assertTrue("Bun is not displayed", isBunDisplayed);
    }
}
