package com.epam.automation.utils;

import org.openqa.selenium.WebDriver;

public class NavigationUtils {
    public static WebDriver goToSauceDemo() {
        DriverManager.BrowserType browser = DriverManager.BrowserType.valueOf(ConfigReader.get("browser").toUpperCase());
        WebDriver driver = DriverManager.getDriver(browser);
        driver.get("https://www.saucedemo.com/");
        return driver;
    }
}
