package generator;

import PageObject.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationUser extends RegistrationPage {

    public RegistrationUser(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnRegistrationButton() {
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

    public void clickOnStartRegistrationButton() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(registrationButton));
        webDriver.findElement(registrationButton).click();
    }
}
