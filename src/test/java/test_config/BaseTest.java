package test_config;

import client.UserClient;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;
import steps.*;
import java.time.Duration;

import static org.hamcrest.CoreMatchers.equalTo;

public class BaseTest {

    @After
    public void tearDown() {
        after();
    }

    protected UserClient userClient;

    protected String token;

    private String chooseBrowser = "chrome";

    protected WebDriver webDriver;

    protected LoginPage loginPage;

    protected MainPage mainPage;

    protected ProfilePage profilePage;

    protected RegistrationPage registrationPage;

    public void setUpBrowserForConstructorTest() {
        if (chooseBrowser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            webDriver.get("https://stellarburgers.nomoreparties.site");
            loginPage = new LoginPage(webDriver);
            mainPage = new MainPage(webDriver);
        }
        else if (chooseBrowser.equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\bin\\yandexdriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            webDriver.get("https://stellarburgers.nomoreparties.site");
            loginPage = new LoginPage(webDriver);
            mainPage = new MainPage(webDriver);
        }
        else {
            afterElse();
        }
    }

    public void setUpBrowserForLoginTest() {
        if (chooseBrowser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            webDriver.get("https://stellarburgers.nomoreparties.site");
            mainPage = new MainPage(webDriver);
            loginPage = new LoginPage(webDriver);
        }
        else if (chooseBrowser.equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\bin\\yandexdriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            webDriver.get("https://stellarburgers.nomoreparties.site");
            loginPage = new LoginPage(webDriver);
            mainPage = new MainPage(webDriver);
        }
        else {
            afterElse();
        }
    }

    public void setUpBrowserForPersonalAccountTest() {
        if (chooseBrowser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            webDriver.get("https://stellarburgers.nomoreparties.site");
            loginPage = new LoginPage(webDriver);
            mainPage = new MainPage(webDriver);
            profilePage = new ProfilePage(webDriver);
        }
        else if (chooseBrowser.equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\bin\\yandexdriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            webDriver.get("https://stellarburgers.nomoreparties.site");
            loginPage = new LoginPage(webDriver);
            mainPage = new MainPage(webDriver);
            profilePage = new ProfilePage(webDriver);
        }
        else {
            afterElse();
        }
    }

    public void setUpBrowserForRegistrationTest() {
        if (chooseBrowser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            webDriver.get("https://stellarburgers.nomoreparties.site");
            loginPage = new LoginPage(webDriver);
            registrationPage = new RegistrationPage(webDriver);
            mainPage = new MainPage(webDriver);
        }
        else if (chooseBrowser.equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\bin\\yandexdriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            webDriver.get("https://stellarburgers.nomoreparties.site");
            loginPage = new LoginPage(webDriver);
            registrationPage = new RegistrationPage(webDriver);
            mainPage = new MainPage(webDriver);
        }
        else {
            afterElse();
        }
    }

    public void afterElse() {
        System.out.println("Выберите браузер chrome/yandex");
    }

    public void after() {
        afterRestTest();
        afterUITest();
    }

    public void afterUITest() {
        webDriver.manage().deleteAllCookies();
        ((WebStorage) webDriver).getSessionStorage().clear();
        ((WebStorage) webDriver).getLocalStorage().clear();
        webDriver.quit();
    }

    public void afterRestTest() {
        if (token != null) {
            userClient.deleteUser(token)
                    .assertThat()
                    .body("message", equalTo("User successfully removed")); }
    }
}
