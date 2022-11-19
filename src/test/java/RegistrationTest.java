import client.UserClient;
import dto.UserCreateRequest;
import io.restassured.response.Response;
import test_config.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;

import static generator.CreateUserRequestGenerator.getRandomUser;
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
        assertEquals("https://stellarburgers.nomoreparties.site/login", loginPage.getURL());
    }

    @Test
    @DisplayName("Регистрация пользователя с невалидным паролем (5 символов)")
    @Description("Негативный тест")
    public void creatingUserWithInvalidPassword() {
        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setEmail("test-email444@yandex.ru");
        userCreateRequest.setName("test-name");
        userCreateRequest.setPassword("12345");
        Response response = userClient.createUserResponse(userCreateRequest);
        token = response.path("accessToken");

        setUpBrowserForRegistrationTest();

        mainPage.clickOnLoginButton();
        registrationPage.startRegistration(userCreateRequest);
        boolean isErrorDisplayed = registrationPage.isErrorMessageDisplayed();;
        assertTrue("Error message is not displayed", isErrorDisplayed);
    }
}
