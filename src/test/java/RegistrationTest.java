import generator.LoginUser;
import generator.OrderBurger;
import generator.RegistrationUser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;


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
        RegistrationUser registrationUser = new RegistrationUser(webDriver);
        LoginUser loginUser = new LoginUser(webDriver);
        OrderBurger orderBurger = new OrderBurger(webDriver);
        loginUser.clickOnLoginButton();
        registrationUser.clickOnRegistrationButton();
        registrationUser.userRegistrationData("name", "test-mail372@gmail.com", "123456");
        registrationUser.clickOnStartRegistrationButton();
        loginUser.userLoginData("test-mail372@gmail.com", "123456");
        loginUser.clickOnLoginButtonWithCreatedUser();
        boolean isOrderPage = orderBurger.isOrderButtonDisplayed();
        assertTrue("Button is not displayed", isOrderPage);
    }
}
