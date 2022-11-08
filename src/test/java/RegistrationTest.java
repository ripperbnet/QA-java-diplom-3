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


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    // Выбор браузера chrome/yandex
    private String chooseBrowser = "chrome";
    private WebDriver webDriver;

    private LoginPage loginPage;

    private RegistrationPage registrationPage;

    private MainPage mainPage;

    private String email = "dinosaur" + RandomStringUtils.randomNumeric(4) + "@yandex.ru";

    private String password = "password";

    private String name = "Test-name";



    @Before
    public void setUpBrowser() {
        if (chooseBrowser == "chrome") {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            webDriver.get("https://stellarburgers.nomoreparties.site");
            loginPage = new LoginPage(webDriver);
            registrationPage = new RegistrationPage(webDriver);
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
            mainPage = new MainPage(webDriver);
        }
    }

    @After
    public void tearDown() {
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
        registrationPage.startRegistration(name, email, password);
        assertEquals("https://stellarburgers.nomoreparties.site/login", loginPage.getURL());
    }

    @Test
    @DisplayName("Регистрация пользователя с невалидным паролем (5 символов)")
    @Description("Негативный тест из браузера google chrome")
    public void creatingUserWithInvalidPassword() {
        mainPage.clickOnLoginButton();
        registrationPage.startRegistration(name, email, "12345");
        boolean isErrorDisplayed = registrationPage.isErrorMessageDisplayed();;
        assertTrue("Error message is not displayed", isErrorDisplayed);
    }
}
