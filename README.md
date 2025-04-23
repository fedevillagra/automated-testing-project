# Automated Testing Project - SauceDemo

This project automates end-to-end login tests for [SauceDemo](https://www.saucedemo.com/) using **Java**, **Selenium WebDriver**, **JUnit 5**, and **Cucumber** (BDD with Gherkin).
The project is structured using the **Page Object Model (POM)** and enhanced with various design patterns to ensure maintainability, and scalability. 
It incorporates best practices such as **logging, screenshots on failure, and modular structure**.

---

## 🚀 Technologies Used

- Java 24
- Selenium WebDriver 4
- JUnit 5 (Jupiter + Platform Suite)
- Cucumber 7 (BDD with Gherkin)
- Maven
- WebDriverManager 6 (Chrome, Edge)
- Log4j2 (logging to console and file)
- Hamcrest (expressive assertions)
- HTML test reports (generated automatically)
- Design Patterns:
  - Page Object Model (POM)
  - Singleton (DriverManager)
  - Facade inside PageObjects (applied inside Page Object methods)
  - Abstract Factory + Adapter (for browser setup)

---

## 📁 Project Structure

```
src/
├── main/java/com/epam/automation/
│   ├── models/             # Page Object (LoginPage.java)
│   └── utils/              # DriverManager, LogUtils
├── test/java/com/epam/automation/
│   ├── runners/            # CucumberRunnerTest.java
│   └── steps/              # Hooks.java, LoginSteps.java
├── test/resources/features/login/
│   ├── uc1_empty_credentials.feature
│   ├── uc2_username_only.feature
│   └── uc3_successful_login.feature
│
├── test/resources/screenshots/     # Screenshots on failure
├── test/resources/log4j2.properties
├── logs/test-log.log               # Execution logs
```

---

## ✅ Test Cases

### UC-1: Login with empty credentials
Asserts the error message `"Username is required"` is shown.

### UC-2: Login with only username
Asserts the error message `"Password is required"` is shown.

### UC-3: Successful login with multiple valid users
Asserts the page title is `"Swag Labs"`.

---

## 📌 How to Run the Tests

Run from terminal:

```bash
mvn clean test
```

### View HTML Report

Open the generated report:

```
target/cucumber-report.html
```

### Browser Execution

Tests will execute in Chrome by default. To run with Edge, Firefox, Safari or Internet Explorer change the browser in:
```
src/test/java/com/epam/automation/steps/LoginSteps.java
BrowserType.EDGE;
BrowserType.FIREFOX;
BrowserType.SAFARI;
BrowserType.IE;
```

---

## 🧪 Filter by Tags

Run only scenarios tagged with `@LoginTests`, for example:

```java
@IncludeTags("LoginTests")
```

Add the tag in your `.feature` files like:

```gherkin
@LoginTests
Feature: Basic login validations
```

---

## 🖼️ Automatic Screenshots

- Saved in `src/test/resources/screenshots/` in failure case.
- Attached to HTML report on test failure

---

## 👤 Author

Project created by Federico Villagra as a final complex task for the testing course on EPAM.


