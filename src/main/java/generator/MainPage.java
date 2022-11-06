package generator;

import PageObject.MainPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends MainPageObject {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnLoginButton() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        webDriver.findElement(loginButton).click();
    }

    public void clickOnPersonalAccountButton() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(personalAccountButton));
        webDriver.findElement(personalAccountButton).click();
    }
}
