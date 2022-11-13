package steps;

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

    public void startRegistration(String name, String email, String password) {
        clickOnRegistrationButton();
        setRegistrationData(name, email, password);
        clickOnStartRegistrationButton();

    }

    @Step("Клик на кнопку регистрация")
    public void clickOnRegistrationButton() {
        new WebDriverWait(webDriver, 8)
                .until(ExpectedConditions.urlMatches("https://stellarburgers.nomoreparties.site/login"));
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
    public void setRegistrationData(String name, String email, String password) {
        new WebDriverWait(webDriver, 8)
                .until(ExpectedConditions.visibilityOfElementLocated(nameField));
        setName(name);
        setEmail(email);
        setPassword(password);
    }

    @Step("Клик на кнопку начала регистрации")
    public void clickOnStartRegistrationButton() {
        new WebDriverWait(webDriver, 8)
                .until(ExpectedConditions.visibilityOfElementLocated(registrationButton));
        webDriver.findElement(registrationButton).click();
    }

    @Step("Проверка отображения сообщения об ошибке")
    public boolean isErrorMessageDisplayed() {
        new WebDriverWait(webDriver, 8)
                .until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return webDriver.findElement(errorMessage).isDisplayed();
    }
}
