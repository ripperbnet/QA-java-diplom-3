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
}
