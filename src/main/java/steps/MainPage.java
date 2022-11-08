package steps;

import PageObject.MainPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage extends MainPageObject {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step
    public void clickOnLoginButton() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        webDriver.findElement(loginButton).click();
    }

    @Step
    public void clickOnPersonalAccountButton() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(personalAccountButton));
        webDriver.findElement(personalAccountButton).click();
    }

    @Step
    public void clickOnSaucesMenu() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(constructorSauceButton));
        webDriver.findElement(constructorSauceButton).click();
    }

    @Step
    public void clickOnFillsMenu() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(constructorFillingsButton));
        webDriver.findElement(constructorFillingsButton).click();
    }

    @Step
    public void ClickOnBunsMenu() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(constructorBunsButton));
        webDriver.findElement(constructorBunsButton).click();
    }

    @Step
    public boolean isSauceConstructorDisplayed() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(sauceSpicy));
        return webDriver.findElement(sauceSpicy).isDisplayed();
    }

    @Step
    public boolean isBunConstructorDisplayed() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(r2D3Bun));
        return webDriver.findElement(r2D3Bun).isDisplayed();
    }

    @Step
    public boolean isFillConstructorDisplayed() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(ImmortalClamMeat));
        return webDriver.findElement(ImmortalClamMeat).isDisplayed();
    }
}
