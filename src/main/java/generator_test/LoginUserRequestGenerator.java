package generator_test;

import dto_test.UserCreateRequest;
import dto_test.UserLoginRequest;

public class LoginUserRequestGenerator {

    public static UserLoginRequest from(UserCreateRequest userCreateRequest) {
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setEmail(userCreateRequest.getEmail());
        userLoginRequest.setPassword(userCreateRequest.getPassword());
        return userLoginRequest; }
}
