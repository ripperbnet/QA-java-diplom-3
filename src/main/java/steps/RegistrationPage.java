package steps;

import dto.UserCreateRequest;
import page_object.RegistrationPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegistrationPage extends RegistrationPageObject {

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Начало регистрации пользователя, невалидный пароль")
    public void startRegistrationNegative(UserCreateRequest userCreateRequest) {
        clickOnRegistrationButton();
        setName(userCreateRequest.getName());
        setEmail(userCreateRequest.getEmail());
        setPassword("12345");
        clickOnStartRegistrationButton();
    }

    @Step("Начало регистрации пользователя, валидные данные")
    public void startRegistration(UserCreateRequest userCreateRequest) {
        clickOnRegistrationButton();
        setRegistrationData(userCreateRequest);
        clickOnStartRegistrationButton();
    }

    @Step("Клик на кнопку регистрация")
    public void clickOnRegistrationButton() {
        new WebDriverWait(webDriver,  Duration.ofSeconds(10));
        new WebDriverWait(webDriver,  Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(registerButton));
        webDriver.findElement(registerButton).click();
    }

    @Step("Ввод имени")
    public void setName(String name) {
        webDriver.findElement(nameField).sendKeys(name);
    }

    @Step("Ввод почты")
    public void setEmail(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввод пароля")
    public void setPassword(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    @Step("Ввод имени, почты и пароля")
    public void setRegistrationData(UserCreateRequest userCreateRequest) {
        new WebDriverWait(webDriver,  Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(nameField));
        setName(userCreateRequest.getName());
        setEmail(userCreateRequest.getEmail());
        setPassword(userCreateRequest.getPassword());
    }

    @Step("Клик на кнопку начала регистрации")
    public void clickOnStartRegistrationButton() {
        new WebDriverWait(webDriver,  Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(registrationButton));
        webDriver.findElement(registrationButton).click();
    }

    @Step("Клик на кнопку входа")
    public void clickOnEnterButton() {
        new WebDriverWait(webDriver,  Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(enterButton));
        webDriver.findElement(enterButton).click();
    }

    @Step("Проверка отображения сообщения об ошибке")
    public boolean isErrorMessageDisplayed() {
        new WebDriverWait(webDriver,  Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return webDriver.findElement(errorMessage).isDisplayed();
    }
}
