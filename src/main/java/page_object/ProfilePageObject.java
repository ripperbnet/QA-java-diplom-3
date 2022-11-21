package page_object;

import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePageObject extends Config {

    protected ProfilePageObject(WebDriver webDriver) {
        super(webDriver);
    }

    protected By exitButton = By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive'][text()='Выход']");

    protected By constructorButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2'][text()='Конструктор']");

    protected By stellarBurgersLogo = By.xpath("//*[name()='svg'][@width='290']");

}
