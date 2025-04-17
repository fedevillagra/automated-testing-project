package base;

import com.epam.automation.utils.DriverManager;
import com.epam.automation.utils.DriverManager.BrowserType;
import com.epam.automation.utils.LogUtils;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public abstract class BaseTests {

    protected WebDriver driver;
    protected static final Logger logger = LogUtils.getLogger(BaseTests.class);

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        logger.info("Running: " + testInfo.getDisplayName());
        driver = DriverManager.getDriver(BrowserType.CHROME);
        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        try {
            DriverManager.quitDriver();
        } catch (Exception e) {
            takeScreenshot(testInfo.getDisplayName());
        }
    }

    protected void takeScreenshot(String testName) {
        try {
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            File destination = new File("src/test/resources/screenshots/" + testName + ".png");
            Files.move(screenshot.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
            logger.error("Captura de pantalla guardada en: " + destination.getAbsolutePath());
        } catch (IOException | WebDriverException e) {
            logger.error("No se pudo guardar la captura de pantalla", e);
        }
    }
}
