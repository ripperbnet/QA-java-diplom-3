package steps;

import page_object.ProfilePageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProfilePage extends ProfilePageObject {

    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Клик на кнопку конструктор")
    public void clickOnConstructorButton() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(constructorButton));
        webDriver.findElement(constructorButton).click();
    }

    @Step("Клик на логотип Stellar Burger")
    public void clickOnStellarBurgerLogo() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(stellarBurgersLogo));
        webDriver.findElement(stellarBurgersLogo).click();
    }

    @Step("Клик на кнопку выхода")
    public void clickOnExitButton() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(exitButton));
        webDriver.findElement(exitButton).click();
    }

    @Step("Проверка отображения кнопки выхода")
    public boolean isExitButtonDisplayed() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(exitButton));
        return webDriver.findElement(exitButton).isDisplayed();
    }
}
