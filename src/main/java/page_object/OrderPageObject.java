package page_object;

import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageObject extends Config {

    public OrderPageObject(WebDriver webDriver) {
        super(webDriver);
    }

    protected By createOrderButton = By.xpath("[text()='Оформить заказ']");
}
