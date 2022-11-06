package google_chrome;

import generator.LoginPage;
import generator.MainPage;
import generator.OrderPage;
import generator.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
    public void loginByClickingTheLoginButton() {
        mainPage.clickOnLoginButton();
        loginPage.setLoginData(emailForLogin, password);
        loginPage.clickOnLoginButtonWithCreatedUser();
        boolean isButtonDisplayed = orderPage.isOrderButtonDisplayed();
        assertTrue("Button is not displayed", isButtonDisplayed);
    }

    @Test
    public void loginByPersonalAccountButton() {
        mainPage.clickOnPersonalAccountButton();
        loginPage.setLoginData(emailForLogin, password);
        loginPage.clickOnLoginButtonWithCreatedUser();
        boolean isButtonDisplayed = orderPage.isOrderButtonDisplayed();
        assertTrue("Button is not displayed", isButtonDisplayed);
    }

    @Test
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
