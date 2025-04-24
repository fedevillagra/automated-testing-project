package com.epam.automation.utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {
        public enum BrowserType {
            CHROME, EDGE, FIREFOX, IE, SAFARI
        }

        private static WebDriver driver;

        public static WebDriver getDriver(BrowserType browser) {
            if (driver == null) {
                driver = DriverFactory.createDriver(browser); // nuevo constructor externo (SRP)
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