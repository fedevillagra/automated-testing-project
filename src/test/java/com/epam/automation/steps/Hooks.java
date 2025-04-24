package com.epam.automation.steps;

import com.epam.automation.utils.ConfigReader;
import com.epam.automation.utils.DriverManager;
import com.epam.automation.utils.LogUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {

    private static final Logger logger = LogUtils.getLogger(Hooks.class);

    @Before
    public void beforeScenario(Scenario scenario) {
        logger.info("Iniciando escenario: {}", scenario.getName());
    }

    @After
    public void takeScreenshotOnFailure(Scenario scenario) {
        DriverManager.BrowserType browserType = DriverManager.BrowserType.valueOf(
                ConfigReader.get("browser").toUpperCase()
        );

        WebDriver driver = DriverManager.getDriver(browserType);

        if (scenario.isFailed() && driver != null) {
            logger.error("El escenario ha fallado: {}", scenario.getName());
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            saveScreenshotToFile(driver, scenario);
        }

        DriverManager.quitDriver();
        logger.info("Finalizando escenario: {}", scenario.getName());
    }

    private void saveScreenshotToFile(WebDriver driver, Scenario scenario) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String path = "src/test/resources/screenshots/";
            Files.createDirectories(Paths.get(path));
            File destination = new File(path + scenario.getName().replaceAll("\\s+", "_") + "_" + timestamp + ".png");
            Files.copy(screenshot.toPath(), destination.toPath());
            logger.error("Captura guardada en: {}", destination.getAbsolutePath());
        } catch (IOException e) {
            logger.error("Error al guardar screenshot: {}", e.getMessage());
        }
    }
}