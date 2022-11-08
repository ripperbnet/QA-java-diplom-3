package steps;

import PageObject.RegistrationPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegistrationPage extends RegistrationPageObject {

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step
    public void clickOnRegistrationButton() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlMatches("https://stellarburgers.nomoreparties.site/login"));
        webDriver.findElement(registerButton).click();
    }

    @Step
    public void setName(String name) {
        webDriver.findElement(nameField).sendKeys(name);
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
    public void setRegistrationData(String name, String email, String password) {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(nameField));
        setName(name);
        setEmail(email);
        setPassword(password);
    }

    @Step
    public void clickOnStartRegistrationButton() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(registrationButton));
        webDriver.findElement(registrationButton).click();
    }

    @Step
    public boolean isErrorMessageDisplayed() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return webDriver.findElement(errorMessage).isDisplayed();
    }
}
