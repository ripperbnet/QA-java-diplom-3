
import generator.LoginPage;
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

public class RegistrationTest {

    private WebDriver webDriver;

    private LoginPage loginPage;

    private OrderPage orderPage;

    private RegistrationPage registrationPage;

    private String email = "dinosaur" + RandomStringUtils.randomNumeric(4) + "@yandex.ru";

    private String password = "password";

    private String name = "Test-name";



    @Before
    public void setUpChrome() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        webDriver.get("https://stellarburgers.nomoreparties.site/");
        loginPage = new LoginPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        orderPage = new OrderPage(webDriver);
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
        loginPage.clickOnLoginButton();
        registrationPage.clickOnRegistrationButton();
        registrationPage.setRegistrationData(name, email, password);
        registrationPage.clickOnStartRegistrationButton();
        loginPage.setLoginData(email, password);
        loginPage.clickOnLoginButtonWithCreatedUser();
        boolean isButtonDisplayed = orderPage.isOrderButtonDisplayed();
        assertTrue("Button is not displayed", isButtonDisplayed);
    }
}
