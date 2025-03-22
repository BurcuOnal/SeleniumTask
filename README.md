# BurcuOnalSeleniumTask - Web Test Automation

## Project Overview
This project is a Selenium-based web test automation framework designed to validate the functionality of the **UseInsider** website. The test cases are implemented following the Page Object Model (POM) structure.

## Test Scope
The automation covers the following scenarios:

1. **Verify Homepage Accessibility:**
   - Navigate to [UseInsider](https://useinsider.com/)
   - Check if the homepage is successfully loaded.

2. **Validate Career Page Navigation:**
   - Click on the "Company" menu and navigate to "Careers."
   - Verify that the **Careers Page**, **Locations**, **Teams**, and **Life at Insider** sections are displayed.

3. **Filter QA Job Listings:**
   - Open the [Quality Assurance Careers Page](https://useinsider.com/careers/quality-assurance/)
   - Click "See all QA jobs."
   - Apply filters: **Location: Istanbul, Turkey**, **Department: Quality Assurance**
   - Verify that job listings are displayed.

4. **Validate Job Listings Details:**
   - Ensure all listed jobs contain:
     - Position: "Quality Assurance"
     - Department: "Quality Assurance"
     - Location: "Istanbul, Turkey"

5. **Check Job Application Redirection:**
   - Click the "View Role" button on any job listing.
   - Confirm that it redirects to the Lever application form page.

---

## Project Structure
```
BurcuOnalSeleniumTask/
│── src/
│   ├── main/
│   │   ├── java/com/useinsider/
│   │   │   ├── base/       # Base test class setup
│   │   │   ├── methods/    # Common test methods
│   │   │   ├── utils/      # Utility classes (e.g., ConfigReader, LocatorHelper)
│   │
│   ├── test/
│   │   ├── java/pages/     # Page Object Model classes
│   │   │   ├── Careers
│   │   │   ├── CareersOpenPositions
│   │   │   ├── CareersQA
│   │   │   ├── Home
│   │   │   ├── JobLever
│   │   ├── java/testCases/ # Test execution class
│   │   │   ├── WebTest1.java
│   │   ├── resources/      # Configuration & Locators
│   │   │   ├── elementValues/
│   │   │   │   ├── careersOpenPositionsPage.json
│   │   │   │   ├── careersPage.json
│   │   │   │   ├── careersQAPage.json
│   │   │   │   ├── homePage.json
│   │   │   │   ├── jobLeverPage.json
│   │   │   ├── config.properties
│   │   │   ├── log4j.properties
```

---

## Technologies & Dependencies
This project is built using Java and Selenium, with the following dependencies:

```xml
<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
    </dependency>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.16.1</version>
    </dependency>
    <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>1.2.17</version>
    </dependency>
    <dependency>
        <groupId>org.json</groupId>
        <artifactId>json</artifactId>
        <version>20231013</version>
    </dependency>
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.7.0</version>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.11.4</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

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

