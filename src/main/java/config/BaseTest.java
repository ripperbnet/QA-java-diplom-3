package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private String chooseBrowser = "chrome";

    protected WebDriver webDriver;

    protected LoginPage loginPage;

    protected MainPage mainPage;

    protected OrderPage orderPage;

    protected ProfilePage profilePage;

    protected String emailForLogin = "test-client-practice@yandex.ru";

    protected RegistrationPage registrationPage;

    protected String emailForRegistration = "valid-test-client" + RandomStringUtils.randomNumeric(4) + "@yandex.ru";

    protected String email = "test-client-practice@yandex.ru";

    protected String name = "text-name";

    protected String password = "123456";

    public void setUpBrowserForConstructorTest() {
        if (chooseBrowser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            webDriver.get("https://stellarburgers.nomoreparties.site");
            loginPage = new LoginPage(webDriver);
            mainPage = new MainPage(webDriver);
        }
        else if (chooseBrowser.equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\bin\\yandexdriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            webDriver.get("https://stellarburgers.nomoreparties.site");
            loginPage = new LoginPage(webDriver);
            mainPage = new MainPage(webDriver);
        }
        else {
            System.out.println("Выберите браузер chrome/yandex");
        }
    }

    public void setUpBrowserForLoginTest() {
        if (chooseBrowser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            webDriver.get("https://stellarburgers.nomoreparties.site");
            loginPage = new LoginPage(webDriver);
            registrationPage = new RegistrationPage(webDriver);
            orderPage = new OrderPage(webDriver);
            mainPage = new MainPage(webDriver);
        }
        else if (chooseBrowser.equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\bin\\yandexdriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            webDriver.get("https://stellarburgers.nomoreparties.site");
            loginPage = new LoginPage(webDriver);
            registrationPage = new RegistrationPage(webDriver);
            orderPage = new OrderPage(webDriver);
            mainPage = new MainPage(webDriver);
        }
        else {
            System.out.println("Выберите браузер chrome/yandex");
        }
    }
    public void setUpBrowserForPersonalAccountTest() {
        if (chooseBrowser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            webDriver.get("https://stellarburgers.nomoreparties.site");
            loginPage = new LoginPage(webDriver);
            orderPage = new OrderPage(webDriver);
            mainPage = new MainPage(webDriver);
            profilePage = new ProfilePage(webDriver);
        }
        else if (chooseBrowser.equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\bin\\yandexdriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            webDriver.get("https://stellarburgers.nomoreparties.site");
            loginPage = new LoginPage(webDriver);
            orderPage = new OrderPage(webDriver);
            mainPage = new MainPage(webDriver);
            profilePage = new ProfilePage(webDriver);
        }
        else {
            System.out.println("Выберите браузер chrome/yandex");
        }
    }

    public void setUpBrowserForRegistrationTest() {
        if (chooseBrowser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            webDriver.get("https://stellarburgers.nomoreparties.site");
            loginPage = new LoginPage(webDriver);
            registrationPage = new RegistrationPage(webDriver);
            mainPage = new MainPage(webDriver);
        }
        else if (chooseBrowser.equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\bin\\yandexdriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            webDriver.get("https://stellarburgers.nomoreparties.site");
            loginPage = new LoginPage(webDriver);
            registrationPage = new RegistrationPage(webDriver);
            mainPage = new MainPage(webDriver);
        }
        else {
            System.out.println("Выберите браузер chrome/yandex");
        }
    }
}
