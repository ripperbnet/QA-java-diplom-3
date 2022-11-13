package steps;

import dto_test.UserLoginRequest;
import page_object.LoginPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends LoginPageObject {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void loggingIn(UserLoginRequest userLoginRequest) {
        setLoginData(userLoginRequest);
        clickOnLoginButtonWithCreatedUser();
    }

    @Step("Ввод почты")
    public void setEmail(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввод пароля")
    public void setPassword(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    @Step("Ввод почты и пароля")
    public void setLoginData(UserLoginRequest userLoginRequest) {
        new WebDriverWait(webDriver, 8)
                .until(ExpectedConditions.visibilityOfElementLocated(emailField));
        setEmail(userLoginRequest.getEmail());
        setPassword(userLoginRequest.getPassword());
    }

    @Step("Клик на кнопку логина под созданным раннее пользователем")
    public void clickOnLoginButtonWithCreatedUser() {
        new WebDriverWait(webDriver, 8)
                .until(ExpectedConditions.visibilityOfElementLocated(loginAfterRegistrationButton));
        webDriver.findElement(loginAfterRegistrationButton).click();
    }

    @Step("Получение URL")
    public String getURL() {
        new WebDriverWait(webDriver, 8)
                .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
       return webDriver.getCurrentUrl();
    }

    @Step("Клик на кнопку восстановления пароля")
    public void clickOnPasswordRecoverButton() {
        new WebDriverWait(webDriver, 8)
                .until(ExpectedConditions.visibilityOfElementLocated(passwordRecoverButton));
        webDriver.findElement(passwordRecoverButton).click();
    }

    @Step("Клик на кнопку логина в форме восстановления пароля")
    public void clickOnLoginButtonInRecoverPWForm() {
        new WebDriverWait(webDriver, 8)
                .until(ExpectedConditions.visibilityOfElementLocated(loginButtonInPasswordRecoveryForm));
        webDriver.findElement(loginButtonInPasswordRecoveryForm).click();
    }

    @Step("Проверка отображения кнопки восстановления пароля")
    public boolean isPassWordRecoverButtonDisplayed() {
        new WebDriverWait(webDriver, 8)
                .until(ExpectedConditions.visibilityOfElementLocated(passwordRecoverButton));
        return webDriver.findElement(passwordRecoverButton).isDisplayed();
    }
}
