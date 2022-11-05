package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MainPage extends  BasePage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    private final By loginButton = By.xpath("(.//button[text()='Войти в аккаунт'])");

    private final By registerButton = By.xpath("//a[@class='Auth_link__1fOlj'][text()='Зарегистрироваться']");

  //  private final By nameField = By.xpath(".//input[@class='text input__textfield text_type_main-default'][text()='Имя']");
    private final By nameField = By.xpath(".//input[@class='text input__textfield text_type_main-default'][@name='name']");

    private final By emailField = By.xpath(".//input[@class='text input__textfield text_type_main-default'][@name='name'][@value='']");

    private final By passwordField = By.xpath(".//input[@class='text input__textfield text_type_main-default'][@name='Пароль']");

    private final By registrationButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa'][text()='Зарегистрироваться']");

    private final By loginAfterRegistrationButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa'][text()='Войти']");

    private final By createOrderButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg'][text()='Оформить заказ']");

    public void clickOnLoginButton() {
        webDriver.findElement(loginButton).click();
    }

    public void clickOnRegisterButton() {
        webDriver.findElement(registerButton).click();
    }

    public void setName(String name) {
        webDriver.findElement(nameField).sendKeys(name);
    }

    public void setEmail(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    public void userRegistrationData(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
    }

    public void userLoginData(String email, String password) {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        setEmail(email);
        setPassword(password);
    }

    public void clickOnStartRegistrationButton() {
        webDriver.findElement(registrationButton).click();
    }

    public void clickOnLoginButtonWithCreatedUser() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.findElement(loginAfterRegistrationButton).click();
    }

    public void clickOnCreateOrderButton() {
        webDriver.findElement(createOrderButton).click();
    }


}
