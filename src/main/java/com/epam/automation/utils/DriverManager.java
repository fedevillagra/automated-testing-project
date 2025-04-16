package com.epam.automation.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {

    // Constants for change the browser easily
    public enum BrowserType{
        CHROME,
        EDGE
    }

    private static WebDriver driver;

    // private constructor due to Singleton design pattern
    private DriverManager() {
        // prevent instantiation
    }

    // Aplica un enfoque Adapter + Abstract Factory al crear instancias de diferentes navegadores desde una única interfaz (getDriver())
    // Singleton design pattern - only 1 instance is allowed
    public static WebDriver getDriver(BrowserType browser) {
        if (driver == null) {
            switch (browser) {
                case CHROME:
                    WebDriverManager.chromedriver().setup(); // WebDriverManager help to avoid install manually drivers
                    driver = new ChromeDriver();
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Browser not supported: " + browser);
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
