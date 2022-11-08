package steps;

import PageObject.MainPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage extends MainPageObject {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }


    String attributeOfBun = webDriver.findElement(constructorBunsButton).getAttribute("style");

    String attributeOfFill = webDriver.findElement(constructorFillingsButton).getAttribute("style");

    String attributeOfSauce = webDriver.findElement(constructorSauceButton).getAttribute("style");

    String attributeToBe = webDriver.findElement(typeOfIngredientChosen).getAttribute("style");

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
    public boolean isSauceConstructorChosen() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(constructorSauceButton));
        return attributeOfSauce == attributeToBe;
    //    return webDriver.findElement(constructorSauceButton) == webDriver.findElement(typeOfIngredientChosen);
    }

    @Step
    public boolean isBunConstructorChosen() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(constructorBunsButton));
      //  return webDriver.findElement(constructorBunsButton) == webDriver.findElement(typeOfIngredientChosen);
        return  attributeToBe == attributeOfBun;
    }

    @Step
    public boolean isFillConstructorChosen() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(constructorFillingsButton));
        return attributeToBe == attributeOfFill;
    }
}
