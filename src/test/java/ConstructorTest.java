import config.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.html5.WebStorage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    @Before
    public void setUp() {
        setUpBrowserForConstructorTest();
    }

    @After
    public void tearDown() {
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
        loginPage.loggingIn(email, password);

        mainPage.clickOnFillsMenu();
        boolean isFillDisplayed = mainPage.isFillConstructorDisplayed();
        assertTrue("Fill is not displayed", isFillDisplayed);

        mainPage.clickOnSaucesMenu();
       boolean isSauceDisplayed = mainPage.isSauceConstructorDisplayed();
        assertTrue("Sauce is not displayed", isSauceDisplayed);


        mainPage.сlickOnBunsMenu();
        boolean isBunDisplayed = mainPage.isBunConstructorDisplayed();
        assertTrue("Bun is not displayed", isBunDisplayed);
    }

    @Test
    @DisplayName("Проверка отображения булок/соусов/начинок в конструкторе БЕЗ логина")
    @Description("Позитивный тест из браузера google chrome")
    public void validatingConstructorWithoutLogin() {
        mainPage.clickOnFillsMenu();
        boolean isFillDisplayed = mainPage.isFillConstructorDisplayed();
        assertTrue("Fill is not displayed", isFillDisplayed);

        mainPage.clickOnSaucesMenu();
        boolean isSauceDisplayed = mainPage.isSauceConstructorDisplayed();
        assertTrue("Sauce is not displayed", isSauceDisplayed);


        mainPage.сlickOnBunsMenu();
        boolean isBunDisplayed = mainPage.isBunConstructorDisplayed();
        assertTrue("Bun is not displayed", isBunDisplayed);
    }
}
