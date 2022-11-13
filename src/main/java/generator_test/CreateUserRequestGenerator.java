package generator_test;

import dto_test.UserCreateRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import page_object.LoginPageObject;

public class CreateUserRequestGenerator extends LoginPageObject {

    public CreateUserRequestGenerator(WebDriver webDriver) {
        super(webDriver);
    }

    public static UserCreateRequest getRandomUser() {
        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setName("test-client" + RandomStringUtils.randomNumeric(4));
        userCreateRequest.setEmail("test-email" + RandomStringUtils.randomNumeric(4) + "@yandex.ru");
        userCreateRequest.setPassword("123456");
        return userCreateRequest;
    }
}
