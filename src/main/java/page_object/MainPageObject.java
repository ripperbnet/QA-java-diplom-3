package page_object;

import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageObject extends Config {

    protected MainPageObject(WebDriver webDriver) {
        super(webDriver);
    }

    protected By personalAccountButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2'][text()='Личный Кабинет']");

    protected By loginButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg'][text()='Войти в аккаунт']");

    protected By constructorSauceButton = By.xpath(".//span[text()='Соусы']");

    protected By constructorSauceButtonParent = By.xpath(".//span[text()='Соусы']/parent::div");

    protected By constructorFillsButtonParent = By.xpath(".//span[text()='Начинки']/parent::div");

    protected By constructorBunsButtonParent = By.xpath(".//span[text()='Булки']/parent::div");

    protected By constructorFillingsButton = By.xpath(".//span[text()='Начинки']");

    protected By constructorBunsButton = By.xpath(".//span[text()='Булки']");


    protected By sauceSpicy = By.xpath(".//p[@class='BurgerIngredient_ingredient__text__yp3dH'][text()='Соус Spicy-X']");

    protected By ImmortalClamMeat = By.xpath(".//p[@class='BurgerIngredient_ingredient__text__yp3dH'][text()='Мясо бессмертных моллюсков Protostomia']");

    protected By r2D3Bun = By.xpath(".//p[@class='BurgerIngredient_ingredient__text__yp3dH'][text()='Флюоресцентная булка R2-D3']");
}
