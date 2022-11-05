package generator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderBurger extends PageObject.OrderPage {

    public OrderBurger(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isOrderButtonDisplayed() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
        return webDriver.findElement(createOrderButton).isDisplayed();
    }

}
