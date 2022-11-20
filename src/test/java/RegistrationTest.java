import client.UserClient;
import dto.UserCreateRequest;
import io.restassured.response.Response;
import test_config.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;

import static generator.CreateUserRequestGenerator.getRandomUser;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    @Before
    public void setUp() {
        userClient = new UserClient();
    }

    @Test
    @DisplayName("Регистрация пользователя с валидными данными")
    @Description("Позитивный тест")
    public void creatingUserWithValidData() {
        UserCreateRequest randomUser = getRandomUser();

        setUpBrowserForRegistrationTest();
        mainPage.clickOnLoginButton();
        registrationPage.startRegistration(randomUser);
        Response response = userClient.refreshToken(randomUser);
        token = response.path("accessToken");
        System.out.println(token);

        //     assertEquals("https://stellarburgers.nomoreparties.site/login", loginPage.getURL());
    }

    @Test
    @DisplayName("Регистрация пользователя с невалидным паролем (5 символов)")
    @Description("Негативный тест")
    public void creatingUserWithInvalidPassword() {
        UserCreateRequest randomUser = getRandomUser();
        Response response = userClient.createUserResponse(randomUser);
        token = response.path("accessToken");

        setUpBrowserForRegistrationTest();

        mainPage.clickOnLoginButton();
        registrationPage.startRegistrationNegative(randomUser);
        boolean isErrorDisplayed = registrationPage.isErrorMessageDisplayed();;
        assertTrue("Error message is not displayed", isErrorDisplayed);
    }
}
