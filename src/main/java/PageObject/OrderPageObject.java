package PageObject;

import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageObject extends Config {

    public OrderPageObject(WebDriver webDriver) {
        super(webDriver);
    }

    protected By createOrderButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg'][text()='Оформить заказ']");
}
