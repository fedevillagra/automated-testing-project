package com.epam.automation.steps;

import com.epam.automation.models.LoginPage;
import com.epam.automation.utils.DriverManager;
import com.epam.automation.utils.NavigationUtils;
import io.cucumber.java.en.*;
import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginSteps {

    private LoginPage loginPage;

    @Given("the Home Page is displayed")
    public void navigateToSauceDemo() {
        WebDriver driver = NavigationUtils.goToSauceDemo();
        loginPage = new LoginPage(driver);
    }

    @When("I enter the username {string} and password {string}")
    public void completeLoginForm(String user, String pass) {
        loginPage.enterUsername(user);
        loginPage.enterPassword(pass);
    }

    @When("I enter a random user of {int} characters and password {string}")
    public void iEnterRandomUser(int length, String password) {
        // String randomUser = RandomStringUtils.randomAlphanumeric(length); // deprecated
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('0', 'z')  // rango de caracteres
                .filteredBy(Character::isLetterOrDigit)  // solo letras y dígitos
                .get();

        String randomUser = generator.generate(length);

        loginPage.enterUsername(randomUser);
        loginPage.enterPassword(password);
    }


    @And("I click the login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("the error message {string} is displayed")
    public void verifyErrorMessage(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        assertThat(actualMessage, containsString(expectedMessage));
        DriverManager.quitDriver();
    }

    @Then("the page has the title {string}")
    public void verifyPageTitle(String expectedTitle) {
        String actualTitle = loginPage.getPageTitle();
        assertThat(actualTitle, equalTo(expectedTitle));
        DriverManager.quitDriver();
    }
}
