package steps;

import page_object.MainPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage extends MainPageObject {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Клик на кнопку логина")
    public void clickOnLoginButton() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        webDriver.findElement(loginButton).click();
    }

    @Step("Клик на кнопку личного кабинета")
    public void clickOnPersonalAccountButton() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(personalAccountButton));
        webDriver.findElement(personalAccountButton).click();
    }

    @Step("Клик на кнопку выбора соусов")
    public void clickOnSaucesMenu() {
       new WebDriverWait(webDriver, Duration.ofSeconds(10))
               .until(ExpectedConditions.visibilityOfElementLocated(constructorSauceButton));
        webDriver.findElement(constructorSauceButton).click();
    }

    @Step("Клик на кнопку выбора начинок")
    public void clickOnFillsMenu() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(constructorFillingsButton));
        webDriver.findElement(constructorFillingsButton).click();
    }

    @Step("Клик на кнопку выбора булок")
    public void сlickOnBunsMenu() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(constructorBunsButton));
        webDriver.findElement(constructorBunsButton).click();
    }

    @Step("Проверка отображения конструктора соусов")
    public boolean isSauceConstructorDisplayed() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(sauceSpicy));
        return webDriver.findElement(sauceSpicy).isDisplayed();
    }

    @Step("Проверка отображения конструктора булок")
    public boolean isBunConstructorDisplayed() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(r2D3Bun));
       return webDriver.findElement(r2D3Bun).isDisplayed();
    }

    @Step("Проверка отображения конструктора начинок")
    public boolean isFillConstructorDisplayed() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(ImmortalClamMeat));
        return webDriver.findElement(ImmortalClamMeat).isDisplayed();
    }
}
