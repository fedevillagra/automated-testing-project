package com.epam.automation.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    // Locators (using XPath as required)
    @FindBy(xpath = "//*[@id=\"user-name\"]")
    @CacheLookup // -> improve performance
    private WebElement usernameInput;

    @FindBy(xpath = "//*[@id=\"password\"]")
    @CacheLookup
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    @CacheLookup
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // POM + Factory
    }

    // Basic Actions

    public void enterUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    // Facade-style Methods

    public void loginWithCredentials(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public void clearFields() {
        usernameInput.clear();
        passwordInput.clear();
    }

    public void loginWithEmptyCredentials() {
        enterUsername("placeholder");
        enterPassword("placeholder");
        clearFields();
        clickLoginButton();
    }

    public void loginWithUsernameOnly(String username) {
        enterUsername(username);
        enterPassword("placeholder");
        passwordInput.clear();
        clickLoginButton();
    }
}
