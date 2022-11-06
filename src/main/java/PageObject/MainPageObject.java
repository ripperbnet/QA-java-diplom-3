package PageObject;

import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageObject extends Config {

    protected MainPageObject(WebDriver webDriver) {
        super(webDriver);
    }

    protected By personalAccountButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2'][text()='Личный Кабинет']");

    protected By loginButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg'][text()='Войти в аккаунт']");

}
