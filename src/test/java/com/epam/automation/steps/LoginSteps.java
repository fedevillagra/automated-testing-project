package com.epam.automation.steps;

import com.epam.automation.models.LoginPage;
import com.epam.automation.utils.DriverManager;
import com.epam.automation.utils.DriverManager.BrowserType;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginSteps {

    private static WebDriver driver;
    private LoginPage loginPage;
    private String currentUser;
    private String currentPassword;

    @Given("the user is on the home screen of saucedemo.com")
    public void navigateToSauceDemo() {
        driver = DriverManager.getDriver(BrowserType.CHROME);
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("the user completes the login form with username {string} and password {string}")
    public void completeLoginForm(String user, String pass) {
        currentUser = user;
        currentPassword = pass;
        loginPage.enterUsername(user);
        loginPage.enterPassword(pass);
    }

    @And("the user clicks the login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("the user should see the error message {string}")
    public void verifyErrorMessage(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        assertThat(actualMessage, containsString(expectedMessage));
        DriverManager.quitDriver();
    }

    @Then("the user should see the page title {string}")
    public void verifyPageTitle(String expectedTitle) {
        String actualTitle = loginPage.getPageTitle();
        assertThat(actualTitle, equalTo(expectedTitle));
        DriverManager.quitDriver();
    }
}
