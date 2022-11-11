import config.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.html5.WebStorage;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Before
    public void setUp() {
        setUpBrowserForLoginTest();
    }

    @After
    public void tearDown() {
        webDriver.manage().deleteAllCookies();
        ((WebStorage) webDriver).getSessionStorage().clear();
        ((WebStorage) webDriver).getLocalStorage().clear();
        webDriver.quit();
    }

    @Test
    @DisplayName("Логин по кнопке «Войти в аккаунт»")
    @Description("Позитивный тест")
    public void loginByClickingTheLoginButton() {

        mainPage.clickOnLoginButton();
        loginPage.loggingIn(emailForLogin, password);
        boolean isButtonDisplayed = orderPage.isOrderButtonDisplayed();
        assertTrue("Button is not displayed", isButtonDisplayed);
    }

    @Test
    @DisplayName("Логин по кнопке «Личный кабинет»")
    @Description("Позитивный тест")
    public void loginByPersonalAccountButton() {
        mainPage.clickOnPersonalAccountButton();
        loginPage.loggingIn(emailForLogin, password);
        boolean isButtonDisplayed = orderPage.isOrderButtonDisplayed();
        assertTrue("Button is not displayed", isButtonDisplayed);
    }

    @Test
    @DisplayName("Логин через форму регистрации")
    @Description("Позитивный тест")
    public void loginViaRegistrationForm() {
        mainPage.clickOnLoginButton();
        registrationPage.startRegistration(name, emailForRegistration, password);
        loginPage.loggingIn(emailForRegistration, password);
        boolean isButtonDisplayed = orderPage.isOrderButtonDisplayed();
        assertTrue("Button is not displayed", isButtonDisplayed);
    }

    @Test
    @DisplayName("Логин через форму восстановления пароля")
    @Description("Позитивный тест")
    public void loginViaPasswordRecoverForm() {
        mainPage.clickOnLoginButton();
        loginPage.clickOnPasswordRecoverButton();
        loginPage.clickOnLoginButtonInRecoverPWForm();
        loginPage.loggingIn(emailForLogin, password);
        boolean isButtonDisplayed = orderPage.isOrderButtonDisplayed();
        assertTrue("Button is not displayed", isButtonDisplayed);
    }
}
