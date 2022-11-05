package PageObject;

import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Config {

    protected LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    protected By loginButton = By.xpath("(.//button[text()='Войти в аккаунт'])");

    protected By emailField = By.xpath(".//input[@class='text input__textfield text_type_main-default'][@name='name'][@value='']");

    protected By passwordField = By.xpath(".//input[@class='text input__textfield text_type_main-default'][@name='Пароль']");

    protected By loginAfterRegistrationButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa'][text()='Войти']");

}
