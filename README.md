# Automated Testing Project

## Overview
This Java-based automated testing project is structured using the **Page Object Model (POM)** and enhanced with various design patterns to ensure modularity, maintainability, and scalability. It automates login test cases for [SauceDemo](https://www.saucedemo.com/) using Selenium WebDriver.

---

## Project Structure
```
src/main/java/com/epam/automation/
├── models/               # Page Object classes (LoginPage)
├── utils/                # Utilities (DriverManager, LogUtils, DataProviderUtils)

src/test/java/
├── LoginTests.java       # Test logic

src/test/resources/
├── log4j2.properties     # Logger configuration
```

---

## Technologies Used
- **Language:** Java 24
- **Automation Tool:** Selenium WebDriver (v4.31.0)
- **Project Management:** Maven
- **Test Runner:** JUnit 5.13.0-M2
- **Assertions:** Hamcrest 3.0
- **Browsers:** Chrome, Edge (via WebDriverManager 6.0.1)
- **Design Patterns:**
  - Page Object Model
  - Singleton (DriverManager)
  - Facade (applied inside Page Object methods)
  - Abstract Factory + Adapter (for browser setup)
  - Decorator (available for extensions)
- **Logging:** Log4j 3.0.0-beta3
- **Automation Approach:** BDD-style naming
- **Locators:** XPath

---

## Use Cases Covered
### UC-1: Login with Empty Credentials
- Type any username and password.
- Clear both inputs.
- Click Login.
- Assert: `"Username is required"` message appears.

### UC-2: Login with Empty Password
- Type any valid username.
- Enter password.
- Clear password.
- Click Login.
- Assert: `"Password is required"` message appears.

### UC-3: Successful Login
- Enter valid username from "Accepted usernames":
  - `standard_user`
  - `problem_user`
  - `performance_glitch_user`
- Password: `secret_sauce`
- Click Login.
- Assert: Title is `"Swag Labs"`.

---

## How to Run
```bash
# Run tests with Maven
mvn clean test
```

Tests will execute in Chrome by default. To run with Edge, change the browser in:
```java
DriverManager.getDriver(BrowserType.EDGE);
```

---

## Classes
### `DriverManager.java`
Handles WebDriver instantiation using Singleton + Abstract Factory for browser selection.

### `LoginPage.java`
Implements the Page Object Model. Uses PageFactory and encapsulates workflows like login actions.

### `LoginTests.java`
JUnit 5 tests (UC-1 to UC-3), assertions with Hamcrest, logs with Log4j.

### `DataProviderUtils.java`
Provides lists of credentials for manual test iteration. Easily integrable with loops or DynamicTest.

---

## Logging
Logging is enabled via Log4j 3. Example:
```java
private static final Logger logger = LogUtils.getLogger(LoginTests.class);
logger.info("Test started");
```

---

## Author
Federico Villagra  
QA Automation Engineer Student

