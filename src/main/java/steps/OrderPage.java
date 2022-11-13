package steps;

import page_object.OrderPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderPage extends OrderPageObject {

    public OrderPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Проверка отображения кнопки создания заказов")
    public boolean isOrderButtonDisplayed() {
        new WebDriverWait(webDriver, 8)
                .until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
       return webDriver.findElement(createOrderButton).isDisplayed();
    }


}
