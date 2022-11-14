import client.UserClient;
import config.BaseTest;
import dto.UserCreateRequest;
import dto.UserLoginRequest;
import generator.CreateUserRequestGenerator;
import generator.LoginUserRequestGenerator;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;

public class PersonalAccountTest extends BaseTest {

    @Before
    public void setUp() {
        userClient = new UserClient();
    }

    @Test
    @DisplayName("Проверка перехода в личный кабинет по кнопке «Личный кабинет»")
    @Description("Позитивный тест")
    public void loginVerificationInPersonalAccount() {
        UserCreateRequest randomUser = CreateUserRequestGenerator.getRandomUser();
        token = userClient.createUser(randomUser)
                .assertThat()
                .statusCode(SC_OK)
                .and()
                .body("success", equalTo(true))
                .extract()
                .path("accessToken");

        setUpBrowserForPersonalAccountTest();

        UserLoginRequest userLoginRequest = LoginUserRequestGenerator.from(randomUser);
        mainPage.clickOnLoginButton();
        loginPage.loggingIn(userLoginRequest);
        mainPage.clickOnPersonalAccountButton();
        boolean isExitButtonDisplayed = profilePage.isExitButtonDisplayed();
        assertTrue("Button is not displayed", isExitButtonDisplayed);
    }

    @Test
    @DisplayName("Переход в конструктор по кнопке «Конструктор» из личного кабинета")
    @Description("Позитивный тест")
    public void clickOnConstructorFromPersonalAccount() {
        UserCreateRequest randomUser = CreateUserRequestGenerator.getRandomUser();
        token = userClient.createUser(randomUser)
                .assertThat()
                .statusCode(SC_OK)
                .and()
                .body("success", equalTo(true))
                .extract()
                .path("accessToken");

        setUpBrowserForPersonalAccountTest();

        UserLoginRequest userLoginRequest = LoginUserRequestGenerator.from(randomUser);
        mainPage.clickOnLoginButton();
        loginPage.loggingIn(userLoginRequest);
        mainPage.clickOnPersonalAccountButton();
        profilePage.clickOnConstructorButton();
        boolean isURLDisplayed = mainPage.isRightURLDisplayed();
        assertTrue("URL not displayed", isURLDisplayed);
    }

    @Test
    @DisplayName("Переход в конструктор по клику на логотип")
    @Description("Позитивный тест")
    public void clickOnBurgersLogoFromPersonalAccount() {
        UserCreateRequest randomUser = CreateUserRequestGenerator.getRandomUser();
        token = userClient.createUser(randomUser)
                .assertThat()
                .statusCode(SC_OK)
                .and()
                .body("success", equalTo(true))
                .extract()
                .path("accessToken");

        setUpBrowserForPersonalAccountTest();

        UserLoginRequest userLoginRequest = LoginUserRequestGenerator.from(randomUser);
        mainPage.clickOnLoginButton();
        loginPage.loggingIn(userLoginRequest);
        mainPage.clickOnPersonalAccountButton();
        profilePage.clickOnStellarBurgerLogo();
        boolean isURLDisplayed = mainPage.isRightURLDisplayed();
        assertTrue("URL not displayed", isURLDisplayed);
    }

    @Test
    @DisplayName("Выход из аккаунта по кнопке «Выход» из личного кабинета")
    @Description("Позитивный тест")
    public void clickOnExitButton() {
        UserCreateRequest randomUser = CreateUserRequestGenerator.getRandomUser();
        token = userClient.createUser(randomUser)
                .assertThat()
                .statusCode(SC_OK)
                .and()
                .body("success", equalTo(true))
                .extract()
                .path("accessToken");

        setUpBrowserForPersonalAccountTest();

        UserLoginRequest userLoginRequest = LoginUserRequestGenerator.from(randomUser);
        mainPage.clickOnLoginButton();
        loginPage.loggingIn(userLoginRequest);
        mainPage.clickOnPersonalAccountButton();
        profilePage.clickOnExitButton();
        boolean isPWRecoverButtonDisplayed = loginPage.isPassWordRecoverButtonDisplayed();
        assertTrue("Button is not displayed", isPWRecoverButtonDisplayed);
    }
}
