package generator;

import dto.UserCreateRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import page_object.LoginPageObject;

public class CreateUserRequestGenerator extends LoginPageObject {

    public CreateUserRequestGenerator(WebDriver webDriver) {
        super(webDriver);
    }

    public static UserCreateRequest getRandomUser() {
        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setName("Oleg" + RandomStringUtils.randomNumeric(3));
        userCreateRequest.setEmail("my-test-client-email" + RandomStringUtils.randomNumeric(3) + "@yandex.ru");
        userCreateRequest.setPassword(RandomStringUtils.randomNumeric(6));
        return userCreateRequest;
    }

    public static UserCreateRequest getRandomUserNegative() {
        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setName("Oleg" + RandomStringUtils.randomNumeric(3));
        userCreateRequest.setEmail("my-test-client-email" + RandomStringUtils.randomNumeric(3) + "@yandex.ru");
        userCreateRequest.setPassword(RandomStringUtils.randomNumeric(5));
        return userCreateRequest;
    }
}
