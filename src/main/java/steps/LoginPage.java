package steps;

import PageObject.LoginPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends LoginPageObject {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step
    public void setEmail(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    @Step
    public void setPassword(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    @Step
    public void setLoginData(String email, String password) {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(emailField));
        setEmail(email);
        setPassword(password);
    }

    @Step
    public void clickOnLoginButtonWithCreatedUser() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(loginAfterRegistrationButton));
        webDriver.findElement(loginAfterRegistrationButton).click();
    }

    @Step
    public String getURL() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
       return webDriver.getCurrentUrl();
    }

    @Step
    public void clickOnPasswordRecoverButton() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(passwordRecoverButton));
        webDriver.findElement(passwordRecoverButton).click();
    }

    @Step
    public void clickOnLoginButtonInRecoverPWForm() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButtonInPasswordRecoveryForm));
        webDriver.findElement(loginButtonInPasswordRecoveryForm).click();
    }

    @Step
    public boolean isPassWordRecoverButtonDisplayed() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(passwordRecoverButton));
        return webDriver.findElement(passwordRecoverButton).isDisplayed();
    }
}
