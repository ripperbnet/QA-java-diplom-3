package PageObject;

import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends Config {

    protected RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    protected By registerButton = By.xpath("//a[@class='Auth_link__1fOlj'][text()='Зарегистрироваться']");

    protected By nameField = By.xpath(".//input[@class='text input__textfield text_type_main-default'][@name='name']");

    protected By emailField = By.xpath(".//input[@class='text input__textfield text_type_main-default'][@name='name'][@value='']");

    protected By passwordField = By.xpath(".//input[@class='text input__textfield text_type_main-default'][@name='Пароль']");

    protected By registrationButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa'][text()='Зарегистрироваться']");

}
