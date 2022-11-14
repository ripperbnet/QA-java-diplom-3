import client.UserClient;
import config.BaseTest;
import dto.UserCreateRequest;
import dto.UserLoginRequest;
import generator.CreateUserRequestGenerator;
import generator.LoginUserRequestGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Before
    public void setUp() {
        userClient = new UserClient();
    }

    @Test
    @DisplayName("Логин по кнопке «Войти в аккаунт»")
    @Description("Позитивный тест")
    public void loginByClickingTheLoginButton() {
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
        boolean isURLDisplayed = mainPage.isRightURLDisplayed();
        assertTrue("URL not displayed", isURLDisplayed);
    }


    @Test
    @DisplayName("Логин по кнопке «Личный кабинет»")
    @Description("Позитивный тест")
    public void loginByPersonalAccountButton() {
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
        mainPage.clickOnPersonalAccountButton();
        loginPage.loggingIn(userLoginRequest);
        boolean isURLDisplayed = mainPage.isRightURLDisplayed();
        assertTrue("URL not displayed", isURLDisplayed);
    }

    @Test
    @DisplayName("Логин через форму регистрации")
    @Description("Позитивный тест")
    public void loginViaRegistrationForm() {
        UserCreateRequest randomUser = CreateUserRequestGenerator.getRandomUser();
        token = userClient.createUser(randomUser)
                .assertThat()
                .statusCode(SC_OK)
                .and()
                .body("success", equalTo(true))
                .extract()
                .path("accessToken");

        setUpBrowserForRegistrationTest();

        UserLoginRequest userLoginRequest = LoginUserRequestGenerator.from(randomUser);
        mainPage.clickOnLoginButton();
        registrationPage.clickOnRegistrationButton();
        registrationPage.clickOnEnterButton();
        loginPage.loggingIn(userLoginRequest);
        boolean isURLDisplayed = mainPage.isRightURLDisplayed();
        assertTrue("URL not displayed", isURLDisplayed);
    }

    @Test
    @DisplayName("Логин через форму восстановления пароля")
    @Description("Позитивный тест")
    public void loginViaPasswordRecoverForm() {
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
        loginPage.clickOnPasswordRecoverButton();
        loginPage.clickOnLoginButtonInRecoverPWForm();
        loginPage.loggingIn(userLoginRequest);
        boolean isURLDisplayed = mainPage.isRightURLDisplayed();
        assertTrue("URL not displayed", isURLDisplayed);
}
}

