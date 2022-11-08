package config;

import org.openqa.selenium.WebDriver;

public abstract class Config {

    protected final WebDriver webDriver;

    protected Config(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
