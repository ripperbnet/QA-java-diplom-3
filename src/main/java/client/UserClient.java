package client;

import dto.UserCreateRequest;
import dto.UserLoginRequest;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient  extends RestClient {

    public static final String AUTH_REGISTER = "/api/auth/register";

    public static final String AUTH_USER = "/api/auth/user";

    private static final String AUTH_LOGIN = "/api/auth/login/";


    @Step("Создание пользователя")
    public ValidatableResponse createUser(UserCreateRequest userCreateRequest) {
        return RestAssured.given()
                .spec(getDefaultRequestSpec())
                .body(userCreateRequest)
                .post(AUTH_REGISTER)
                .then();
    }

    @Step("Логин пользователя")
    public Response loginUser(UserLoginRequest userLoginRequest) {
        return given()
                .spec(getDefaultRequestSpec())
                .body(userLoginRequest)
                .post(AUTH_LOGIN);
    }

    @Step("Удаление пользователя")
    public ValidatableResponse deleteUser(String token) {
        return RestAssured.given()
                .spec(getDefaultRequestSpec())
                .header("authorization", token)
                .delete(AUTH_USER)
                .then();
    }
}
