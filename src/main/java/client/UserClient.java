package client;

import dto.UserCreateRequest;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient  extends RestClient {

    public static final String AUTH_REGISTER = "/api/auth/register";

    public static final String AUTH_USER = "/api/auth/user";

    public static final String AUTH_TOKEN = "/api/auth/token";


    @Step("Создание пользователя")
    public ValidatableResponse createUser(UserCreateRequest userCreateRequest) {
        return RestAssured.given()
                .spec(getDefaultRequestSpec())
                .body(userCreateRequest)
                .post(AUTH_REGISTER)
                .then();
    }

    @Step("Удаление пользователя")
    public ValidatableResponse deleteUser(String token) {
        return RestAssured.given()
                .spec(getDefaultRequestSpec())
                .header("authorization", token)
                .delete(AUTH_USER)
                .then();
    }

    @Step("Создание невалидного пользователя")
    public Response createUserResponse(UserCreateRequest userCreateRequest) {
        return   given()
                .spec(getDefaultRequestSpec())
                .body(userCreateRequest)
                .post(AUTH_REGISTER);
    }

    @Step("Обновление токена")
    public Response refreshToken(UserCreateRequest userCreateRequest) {
        return given()
                .spec(getDefaultRequestSpec())
                     .body(userCreateRequest)
                .post(AUTH_TOKEN);
    }
}
