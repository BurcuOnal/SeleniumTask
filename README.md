# BurcuOnalSeleniumTask - Web Test Automation

## Project Overview
This project is a Selenium-based web test automation framework designed to validate the functionality of the **UseInsider** website. The test cases are implemented following the Page Object Model (POM) structure.

## Test Scope
This automation project focuses on verifying the key functionalities of the Careers page, ensuring that users can navigate through job listings, apply filters, view job descriptions, and navigating to another job application page.

---

## Project Structure
```
The project follows the Page Object Model (POM) design pattern.  

- `src/main/java/com/useinsider/base` → Base setup and configurations  
- `src/main/java/com/useinsider/methods` → Reusable helper methods  
- `src/main/java/com/useinsider/utils` → Utility classes for configurations and locators  
- `src/test/java/pages` → Page classes representing different sections  
- `src/test/java/testCases` → Test case implementations  
- `src/test/resources/elementValues` → JSON files storing locators  
- `config.properties` → Stores base URLs and configurations  
- `log4j.properties` → Logging configurations 
```

---

## Technologies & Dependencies
- **Programming Language:** Java  
- **Test Framework:** JUnit 4 & JUnit 5  
- **Web Automation:** Selenium WebDriver  
- **Logging:** Log4j  
- **JSON Parsing:** org.json  
- **Driver Management:** WebDriverManager  

For a complete list of dependencies, check the `pom.xml` file.

---
## Configuration
The `config.properties` file contains essential configurations, including base URLs and locator file paths
---

## Running the Tests
You can execute the test cases directly from the `WebTest1.java` class.
Branch Information: All code is located in the master branch. Make sure you are on the correct branch after cloning the repository.

---

## Reporting
- Test logs are managed using **Log4j**.
- Test execution results will be displayed in the console.

---

## Notes
- The project follows **POM (Page Object Model)** for better maintainability.
- Optimized XPath and CSS selectors are used.
- Assertions are included to validate expected behaviors.
- No BDD frameworks (Cucumber, Quantum, etc.) are used as per project requirements.

