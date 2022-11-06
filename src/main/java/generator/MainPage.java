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

    public void clickOnSaucesMenu() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(sauceSpicy));
        webDriver.findElement(constructorSauceButton).click();
    }

    public void clickOnFillsMenu() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(ImmortalClamMeat));
        webDriver.findElement(constructorFillingsButton).click();
    }

    public void ClickOnBunsMenu() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(r2D3Bun));
        webDriver.findElement(constructorBunsButton).click();
    }

    public boolean isSauceConstructorDisplayed() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(sauceSpicy));
        return webDriver.findElement(sauceSpicy).isDisplayed();
    }

    public boolean isBunConstructorDisplayed() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(r2D3Bun));
        return webDriver.findElement(r2D3Bun).isDisplayed();
    }

    public boolean isFillConstructorDisplayed() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(ImmortalClamMeat));
        return webDriver.findElement(ImmortalClamMeat).isDisplayed();
    }
}
