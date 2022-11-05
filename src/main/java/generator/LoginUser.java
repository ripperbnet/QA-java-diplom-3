package generator;

import PageObject.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginUser extends LoginPage {

    public LoginUser(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnLoginButton() {
        webDriver.findElement(loginButton).click();
    }

    public void setEmail(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    public void userLoginData(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    public void clickOnLoginButtonWithCreatedUser() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(loginAfterRegistrationButton));
        webDriver.findElement(loginAfterRegistrationButton).click();
    }
}
