import client_test.UserClient;
import config.BaseTest;
import dto_test.UserCreateRequest;
import dto_test.UserLoginRequest;
import generator_test.CreateUserRequestGenerator;
import generator_test.LoginUserRequestGenerator;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;
import steps.LoginPage;
import steps.MainPage;
import steps.OrderPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {
    WebDriver webDriver;

    private UserClient userClient;
    private String token;
    @Before
    public void setUp() {
        userClient = new UserClient();
    }

    @After
    public void tearDown() {
        if (token != null) {
            userClient.deleteUser(token)
                    .assertThat()
                    .body("message", equalTo("User successfully removed"));
        }
        webDriver.manage().deleteAllCookies();
        ((WebStorage) webDriver).getSessionStorage().clear();
        ((WebStorage) webDriver).getLocalStorage().clear();
        webDriver.quit();
    }


    @Test
    public void userShouldBeLogged() {
        UserCreateRequest randomUser = CreateUserRequestGenerator.getRandomUser();
        token = userClient.createUser(randomUser)
                .assertThat()
                .statusCode(SC_OK)
                .and()
                .body("success", equalTo(true))
                .extract()
                .path("accessToken");

        setUpBrowserForLoginTest();


        UserLoginRequest userLoginRequest = LoginUserRequestGenerator.from(randomUser);
        mainPage.clickOnLoginButton();
        loginPage.loggingIn(userLoginRequest);
        boolean isButtonDisplayed = orderPage.isOrderButtonDisplayed();
        assertTrue("Button is not displayed", isButtonDisplayed);

    }
    }
/*
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
    } */

