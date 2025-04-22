package com.epam.automation.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
    // Constants for change the browser easily
    public enum BrowserType {
        CHROME, EDGE
    }

    private static WebDriver driver;

    // Aplica un enfoque Adapter + Abstract Factory al crear instancias de diferentes navegadores desde una única interfaz (getDriver())
    // Singleton design pattern - only 1 instance is allowed
    public static WebDriver getDriver(BrowserType browser) {
        if (driver == null) {
            switch (browser) {
                case CHROME -> {
                    WebDriverManager.chromedriver().setup(); // WebDriverManager help to avoid install manually drivers
                    driver = new ChromeDriver();
                }
                case EDGE -> {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver getCurrentDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}