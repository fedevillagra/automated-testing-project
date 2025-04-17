# Automated Testing Project

## Overview
This Java-based automated testing project is structured using the **Page Object Model (POM)** and enhanced with various design patterns to ensure maintainability, and scalability. It automates login test cases for [SauceDemo](https://www.saucedemo.com/) using **Selenium WebDriver** with **JUnit 5**. It incorporates best practices such as **logging, screenshots on failure, and modular structure**.

---

## Project Structure
```
src/
├── main/
│   └── java/com/epam/automation/
│       ├── models/
│       │   └── LoginPage.java              # Page Object for login
│       └── utils/
│           ├── DataProviderUtils.java      # Provides test data (optional)
│           ├── DriverManager.java          # Singleton WebDriver factory
│           └── LogUtils.java               # Logger setup (Log4j2)
│
├── test/
│   ├── java/
│   │   ├── base/
│   │   │   └── BaseTests.java              # Base test class with setup/teardown
│   │   └── login/
│   │       └── LoginTests.java             # Test cases for login functionality
│   └── resources/
│       ├── log4j2.properties               # Log4j2 configuration file
│       └── screenshots/                    # Folder for screenshots on test failure
```

---

## Technologies Used
- **Language:** Java 24
- **Automation Tool:** Selenium WebDriver (v4.31.0)
- **Project Management:** Maven
- **Test Runner:** JUnit 5.13.0-M2
- **Assertions:** Hamcrest 3.0
- **Logger:** Log4j2 (v2.24.3)
- **Browser Drivers:** WebDriverManager 6.0.1 (Chrome, Edge)
- **Design Patterns:**
  - Page Object Model (POM)
  - Singleton (DriverManager)
  - Facade inside PageObjects (applied inside Page Object methods)
  - Abstract Factory + Adapter (for browser setup)
  - Adapter/Decorator placeholders for extensibility
- **Automation Approach:** BDD-style naming
- **Locators:** XPath

---

## How to Run
```bash
mvn clean test
```

Test results and screenshots (if failures occur) will be saved in:
- `target/surefire-reports/`
- `src/test/resources/screenshots/`

Tests will execute in Chrome by default. To run with Edge, change the browser in:
```java
DriverManager.getDriver(BrowserType.EDGE);
```

---

## Use Cases Covered
### UC-1: Login with Empty Credentials
- Submit empty username and password.
- Assert: `"Username is required"`

### UC-2: Login with Username only
- Submit username, leave password blank.
- Assert: `"Password is required"`

### UC-3: Valid Login
- Login with `standard_user` / `secret_sauce`.
- Assert: Title is `Swag Labs`

---

## Author
Federico Villagra  
QA Automation Engineer Student


