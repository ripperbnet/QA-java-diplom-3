import client.UserClient;
import test_config.BaseTest;
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

public class ConstructorTest extends BaseTest {


    @Before
    public void setUp() {
        userClient = new UserClient();
    }

    @Test
    @DisplayName("Проверка отображения начинок в конструкторе после логина")
    @Description("Позитивный тест")
    public void validatingConstructorFillsAfterLogin() {
        UserCreateRequest randomUser = CreateUserRequestGenerator.getRandomUser();
        token = userClient.createUser(randomUser)
                .assertThat()
                .statusCode(SC_OK)
                .and()
                .body("success", equalTo(true))
                .extract()
                .path("accessToken");

        setUpBrowserForConstructorTest();

        UserLoginRequest userLoginRequest = LoginUserRequestGenerator.from(randomUser);
        mainPage.clickOnLoginButton();
        loginPage.loggingIn(userLoginRequest);
        mainPage.clickOnFillsMenu();
        boolean isFillChosen = mainPage.isFillConstructorDisplayed();
        assertTrue("Fill is not displayed", isFillChosen);
    }

    @Test
    @DisplayName("Проверка отображения соусов в конструкторе после логина")
    @Description("Позитивный тест")
    public void validatingConstructorSaucesAfterLogin() {
        UserCreateRequest randomUser = CreateUserRequestGenerator.getRandomUser();
        token = userClient.createUser(randomUser)
                .assertThat()
                .statusCode(SC_OK)
                .and()
                .body("success", equalTo(true))
                .extract()
                .path("accessToken");

        setUpBrowserForConstructorTest();

        UserLoginRequest userLoginRequest = LoginUserRequestGenerator.from(randomUser);
        mainPage.clickOnLoginButton();
        loginPage.loggingIn(userLoginRequest);
        mainPage.clickOnSaucesMenu();
        boolean isSauceChosen = mainPage.isSauceConstructorDisplayed();
        assertTrue("Sauce is not displayed", isSauceChosen);
    }

    @Test
    @DisplayName("Проверка отображения булок в конструкторе после логина")
    @Description("Позитивный тест, сначала выбираем начинки, чтобы проверить переключение")
    public void validatingConstructorBunsAfterLogin() {
        UserCreateRequest randomUser = CreateUserRequestGenerator.getRandomUser();
        token = userClient.createUser(randomUser)
                .assertThat()
                .statusCode(SC_OK)
                .and()
                .body("success", equalTo(true))
                .extract()
                .path("accessToken");

        setUpBrowserForConstructorTest();

        UserLoginRequest userLoginRequest = LoginUserRequestGenerator.from(randomUser);
        mainPage.clickOnLoginButton();
        loginPage.loggingIn(userLoginRequest);
        mainPage.clickOnFillsMenu();
        mainPage.сlickOnBunsMenu();
        boolean isBunChosen = mainPage.isBunConstructorDisplayed();
        assertTrue("Bun is not displayed", isBunChosen);
    }

    @Test
    @DisplayName("Проверка отображения начинок в конструкторе БЕЗ логина")
    @Description("Позитивный тест")
    public void validatingConstructorFillsWithoutLogin() {
        setUpBrowserForConstructorTest();
        mainPage.clickOnFillsMenu();
        boolean isFillChosen = mainPage.isFillConstructorDisplayed();
        assertTrue("Fill is not displayed", isFillChosen);
    }

    @Test
    @DisplayName("Проверка отображения соусов в конструкторе БЕЗ логина")
    @Description("Позитивный тест")
    public void validatingConstructorSaucesWithoutLogin() {
        setUpBrowserForConstructorTest();
        mainPage.clickOnSaucesMenu();
        boolean isSauceChosen = mainPage.isSauceConstructorDisplayed();
        assertTrue("Sauce is not displayed", isSauceChosen);
    }

    @Test
    @DisplayName("Проверка отображения булок в конструкторе БЕЗ логина")
    @Description("Позитивный тест, сначала выбираем начинки, чтобы проверить переключение")
    public void validatingConstructorBunsWithoutLogin() {
        setUpBrowserForConstructorTest();
        mainPage.clickOnFillsMenu();
        mainPage.сlickOnBunsMenu();
        boolean isBunChosen = mainPage.isBunConstructorDisplayed();
        assertTrue("Bun is not displayed", isBunChosen);
    }
}

