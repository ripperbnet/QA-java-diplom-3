package generator;

import PageObject.RegistrationPageObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends RegistrationPageObject {

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnRegistrationButton() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlMatches("https://stellarburgers.nomoreparties.site/login"));
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

    public void setRegistrationData(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
    }

    public void clickOnStartRegistrationButton() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(registrationButton));
        webDriver.findElement(registrationButton).click();
    }
}
