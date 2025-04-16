# SauceDemo Automated Testing Project

## Overview
This Java-based automated testing project is structured using the **Page Object Model (POM)** and enhanced with various design patterns to ensure modularity, maintainability, and scalability. It automates login test cases for [SauceDemo](https://www.saucedemo.com/) using Selenium WebDriver.

---

## Project Structure
```
src/test/java/
├── business/               # Core logic layer
│   └── models/             # Page Object classes
│       └── LoginPage.java
│       └── DashboardPage.java
│   └── facades/            # Facade pattern to abstract workflows
│       └── LoginFacade.java
│
├── test/                   # Test layer (JUnit test cases)
│   └── LoginTests.java
│
├── utils/                  # Utility layer
│   └── DriverManager.java  # Singleton WebDriver
│   └── LogUtils.java       # Log4j logger setup
│   └── DataProviderUtils.java

resources/
└── log4j.properties
```

---

## Technologies Used
- **Language:** Java
- **Automation Tool:** Selenium WebDriver
- **Project Management:** Maven
- **Test Runner:** JUnit
- **Browsers:** Chrome, Edge
- **Design Patterns:**
    - Page Object Model
    - Abstract Factory
    - Adapter
    - Decorator
    - Facade
    - Singleton
- **Logging:** Log4j
- **Assertions:** Hamcrest
- **Automation Approach:** BDD (behavioral test descriptions)
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
- Enter valid username from "Accepted usernames".
- Password: `secret_sauce`
- Click Login.
- Assert: Title is `"Swag Labs"`.

---

## Advanced Features
- **Page Factory** for object initialization
- **DataProvider** for test parameterization
- **Parallel Execution** with Maven Surefire plugin
- **Log4j Logging** in all layers

---

## How to Run
```bash
# Run tests via Maven
mvn clean test

# Generate reports or logs if applicable
```

---

## Notes
- Ensure browser drivers for **Chrome** and **Edge** are installed or managed via WebDriverManager.
- Tests are compatible with **JUnit** runners and written using **BDD-style assertions**.

---

## Author
Federico Villagra  
QA Automation Engineer

