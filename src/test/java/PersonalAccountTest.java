import config.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.html5.WebStorage;

import static org.junit.Assert.assertTrue;

public class PersonalAccountTest extends BaseTest {

    @Before
    public void setUp() {
        setUpBrowserForPersonalAccountTest();
    }

    @After
    public void tearDown() {
        webDriver.manage().deleteAllCookies();
        ((WebStorage) webDriver).getSessionStorage().clear();
        ((WebStorage) webDriver).getLocalStorage().clear();
        webDriver.quit();
    }
/*
    @Test
    @DisplayName("Проверка перехода в личный кабинет по кнопке «Личный кабинет»")
    @Description("Позитивный тест")
    public void loginVerificationInPersonalAccount() {
        mainPage.clickOnLoginButton();
        loginPage.loggingIn(email, password);
        mainPage.clickOnPersonalAccountButton();
        boolean isExitButtonDisplayed = profilePage.isExitButtonDisplayed();
        assertTrue("Button is not displayed", isExitButtonDisplayed);
    }

    @Test
    @DisplayName("Переход в конструктор по кнопке «Конструктор» из личного кабинета")
    @Description("Позитивный тест")
    public void clickOnConstructorFromPersonalAccount() {
        mainPage.clickOnLoginButton();
        loginPage.loggingIn(email, password);
        mainPage.clickOnPersonalAccountButton();
        profilePage.clickOnConstructorButton();
        boolean isButtonDisplayed = orderPage.isOrderButtonDisplayed();
        assertTrue("Button is not displayed", isButtonDisplayed);
    }

    @Test
    @DisplayName("Переход в конструктор по клику на логотип")
    @Description("Позитивный тест")
    public void clickOnBurgersLogoFromPersonalAccount() {
        mainPage.clickOnLoginButton();
        loginPage.loggingIn(email, password);
        mainPage.clickOnPersonalAccountButton();
        profilePage.clickOnStellarBurgerLogo();
        boolean isButtonDisplayed = orderPage.isOrderButtonDisplayed();
        assertTrue("Button is not displayed", isButtonDisplayed);
    }

    @Test
    @DisplayName("Выход из аккаунта по кнопке «Выход» из личного кабинета")
    @Description("Позитивный тест")
    public void clickOnExitButton() {
        mainPage.clickOnLoginButton();
        loginPage.loggingIn(email, password);
        mainPage.clickOnPersonalAccountButton();
        profilePage.clickOnExitButton();
        boolean isPWRecoverButtonDisplayed = loginPage.isPassWordRecoverButtonDisplayed();
        assertTrue("Button is not displayed", isPWRecoverButtonDisplayed);
    } */
}
