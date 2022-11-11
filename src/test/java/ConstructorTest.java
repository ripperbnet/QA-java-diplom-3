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
    @DisplayName("Проверка отображения начинок в конструкторе после логина")
    @Description("Позитивный тест")
    public void validatingConstructorFillsAfterLogin() {
        mainPage.clickOnLoginButton();
        loginPage.loggingIn(email, password);
        mainPage.clickOnFillsMenu();
        boolean isFillChosen = mainPage.isFillConstructorDisplayed();
        assertTrue("Fill is not displayed", isFillChosen);
    }

    @Test
    @DisplayName("Проверка отображения соусов в конструкторе после логина")
    @Description("Позитивный тест")
    public void validatingConstructorSaucesAfterLogin() {
        mainPage.clickOnLoginButton();
        loginPage.loggingIn(email, password);

        mainPage.clickOnSaucesMenu();
        boolean isSauceChosen = mainPage.isSauceConstructorDisplayed();
        assertTrue("Sauce is not displayed", isSauceChosen);
    }

    @Test
    @DisplayName("Проверка отображения булок в конструкторе после логина")
    @Description("На кнопку булки не нажимаем, так как она уже выделена")
    public void validatingConstructorBunsAfterLogin() {
        mainPage.clickOnLoginButton();
        loginPage.loggingIn(email, password);
        boolean isBunChosen = mainPage.isBunConstructorDisplayed();
        assertTrue("Bun is not displayed", isBunChosen);
    }

    @Test
    @DisplayName("Проверка отображения начинок в конструкторе БЕЗ логина")
    @Description("Позитивный тест")
    public void validatingConstructorFillsWithoutLogin() {
        mainPage.clickOnFillsMenu();
        boolean isFillChosen = mainPage.isFillConstructorDisplayed();
        assertTrue("Fill is not displayed", isFillChosen);
    }

    @Test
    @DisplayName("Проверка отображения соусов в конструкторе БЕЗ логина")
    @Description("Позитивный тест")
    public void validatingConstructorSaucesWithoutLogin() {
        mainPage.clickOnSaucesMenu();
        boolean isSauceChosen = mainPage.isSauceConstructorDisplayed();
        assertTrue("Sauce is not displayed", isSauceChosen);
    }

    @Test
    @DisplayName("Проверка отображения булок в конструкторе БЕЗ логина")
    @Description("На кнопку булки не нажимаем, так как она уже выделена")
    public void validatingConstructorBunsWithoutLogin() {
        boolean isBunChosen = mainPage.isBunConstructorDisplayed();
        assertTrue("Bun is not displayed", isBunChosen);
    }
}
