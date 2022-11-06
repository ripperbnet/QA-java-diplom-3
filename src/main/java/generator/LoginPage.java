package generator;

import PageObject.LoginPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends LoginPageObject {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }



    public void setEmail(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    public void setLoginData(String email, String password) {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(emailField));
        setEmail(email);
        setPassword(password);
    }

    public void clickOnLoginButtonWithCreatedUser() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(loginAfterRegistrationButton));
        webDriver.findElement(loginAfterRegistrationButton).click();
    }

    public String getURL() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
       return webDriver.getCurrentUrl();
    }

    public void clickOnPasswordRecoverButton() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(passwordRecoverButton));
        webDriver.findElement(passwordRecoverButton).click();
    }

    public void clickOnLoginButtonInRecoverPWForm() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButtonInPasswordRecoveryForm));
        webDriver.findElement(loginButtonInPasswordRecoveryForm).click();
    }

    public boolean isPassWordRecoverButtonDisplayed() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(passwordRecoverButton));
        return webDriver.findElement(passwordRecoverButton).isDisplayed();
    }
}
