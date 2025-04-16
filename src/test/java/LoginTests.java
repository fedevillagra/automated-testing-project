//package com.epam.automation;

import com.epam.automation.models.LoginPage;
import com.epam.automation.utils.DataProviderUtils;
import com.epam.automation.utils.DriverManager;
import com.epam.automation.utils.DriverManager.BrowserType;
import com.epam.automation.utils.LogUtils;

import org.junit.jupiter.api.*;
import org.apache.logging.log4j.Logger;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private static final Logger logger = LogUtils.getLogger(LoginTests.class);

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        logger.info("Running: " + testInfo.getDisplayName());
        driver = DriverManager.getDriver(BrowserType.CHROME);
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @Test
    @Order(1)
    public void testLoginWithEmptyCredentials() {
        loginPage.login("", "");
        String errorMessage = loginPage.getErrorMessage();
        MatcherAssert.assertThat(errorMessage, Matchers.containsString("Username is required"));
        logger.info("UC-1 passed");
    }

    @Test
    @Order(2)
    public void testLoginWithUsernameOnly() {
        loginPage.login("standard_user","");
        String errorMessage = loginPage.getErrorMessage();
        MatcherAssert.assertThat(errorMessage, Matchers.containsString("Password is required"));
        logger.info("UC-2 passed");
    }

    @Test
    @Order(3)
    public void testSuccessfulLogin() {
        loginPage.login("standard_user", "secret_sauce");
        String title = loginPage.getPageTitle();
        MatcherAssert.assertThat(title, Matchers.equalTo("Swag Labs"));
        logger.info("UC-3 passed");
    }
}
