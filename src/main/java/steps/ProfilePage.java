package steps;

import PageObject.ProfilePageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProfilePage extends ProfilePageObject {

    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step
    public void clickOnConstructorButton() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(constructorButton));
        webDriver.findElement(constructorButton).click();
    }

    @Step
    public void clickOnStellarBurgerLogo() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(stellarBurgersLogo));
        webDriver.findElement(stellarBurgersLogo).click();
    }

    @Step
    public void clickOnExitButton() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(exitButton));
        webDriver.findElement(exitButton).click();
    }

    @Step
    public boolean isExitButtonDisplayed() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(exitButton));
        return webDriver.findElement(exitButton).isDisplayed();
    }
}
