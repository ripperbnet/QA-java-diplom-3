import config.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.html5.WebStorage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    @Before
    public void setUp() {
        setUpBrowserForRegistrationTest();
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
        registrationPage.startRegistration(name, emailForRegistration, password);
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
