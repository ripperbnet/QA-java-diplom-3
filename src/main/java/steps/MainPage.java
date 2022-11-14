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
        new WebDriverWait(webDriver,  Duration.ofSeconds(10));
       //    .until(ExpectedConditions.elementToBeClickable(loginButton));
        webDriver.findElement(loginButton).click();
    }

    @Step("Клик на кнопку личного кабинета")
    public void clickOnPersonalAccountButton() {
        new WebDriverWait(webDriver,  Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(personalAccountButton));
        webDriver.findElement(personalAccountButton).click();
    }

    @Step("Клик на кнопку выбора соусов")
    public void clickOnSaucesMenu() {
        new WebDriverWait(webDriver,  Duration.ofSeconds(10));
        webDriver.findElement(constructorSauceButton).click();
    }

    @Step("Клик на кнопку выбора начинок")
    public void clickOnFillsMenu() {
        new WebDriverWait(webDriver,  Duration.ofSeconds(10));
        webDriver.findElement(constructorFillingsButton).click();
    }

    @Step("Клик на кнопку выбора булок")
    public void сlickOnBunsMenu() {
        new WebDriverWait(webDriver,  Duration.ofSeconds(10));
        webDriver.findElement(constructorBunsButton).click();
    }

    @Step("Проверка отображения конструктора соусов")
    public boolean isSauceConstructorDisplayed() {
        new WebDriverWait(webDriver,  Duration.ofSeconds(10));
        String attributeSauce = webDriver.findElement(constructorSauceButtonParent).getAttribute("class");
        return attributeSauce.equals("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect");
    }

    @Step("Проверка отображения конструктора булок")
    public boolean isBunConstructorDisplayed() {
        new WebDriverWait(webDriver,  Duration.ofSeconds(10));
        String attributeBun = webDriver.findElement(constructorBunsButtonParent).getAttribute("class");
       return attributeBun.equals("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect");
    }

    @Step("Проверка отображения конструктора начинок")
    public boolean isFillConstructorDisplayed() {
        new WebDriverWait(webDriver,  Duration.ofSeconds(10));
        String attributeFill = webDriver.findElement(constructorFillsButtonParent).getAttribute("class");
        return attributeFill.equals("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect");
    }
}
