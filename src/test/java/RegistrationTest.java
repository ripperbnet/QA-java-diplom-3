import PageObject.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    private WebDriver webDriver;

    @Before
    public void setUpChrome() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://stellarburgers.nomoreparties.site/");
    }

    @After
    public void tearDownChrome() {
        webDriver.manage().deleteAllCookies();
        ((WebStorage) webDriver).getSessionStorage().clear();
        ((WebStorage) webDriver).getLocalStorage().clear();
        webDriver.quit();
    }

    @Test
    public void userShouldBeCreated() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickOnLoginButton();
        mainPage.clickOnRegisterButton();
        mainPage.userRegistrationData("name", "test-mail356@gmail.com", "123456");
        mainPage.clickOnStartRegistrationButton();
        mainPage.userLoginData("test-mail356@gmail.com", "123456");
        mainPage.clickOnLoginButtonWithCreatedUser();
        assertTrue(webDriver.findElement(By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg'][text()='Оформить заказ']")).getText().contains("Оформить заказ"));
    }
}
