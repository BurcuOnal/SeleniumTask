package com.useinsider.base;

import com.useinsider.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    public static WebDriver driver;
    public static ConfigReader configReader;

    public BaseTest() {
        configReader = new ConfigReader();
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(getChromeOptions());
        driver.manage().window().maximize();
        driver.get(configReader.getFilePath("baseUrl"));

        addCookies();

        driver.navigate().refresh();
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--ignore-certificate-errors-spki-list");
        chromeOptions.addArguments("--suppress-message-center-popups");
        chromeOptions.setAcceptInsecureCerts(true);
        return chromeOptions;
    }

    private void addCookies() {
        driver.manage().addCookie(new Cookie("_gid", "GA1.2.979130077.1742285686"));
        driver.manage().addCookie(new Cookie("cookielawinfo-checkbox-necessary", "yes"));
        driver.manage().addCookie(new Cookie("cookielawinfo-checkbox-functional", "yes"));
        driver.manage().addCookie(new Cookie("cookielawinfo-checkbox-performance", "yes"));
        driver.manage().addCookie(new Cookie("cookielawinfo-checkbox-analytics", "yes"));
        driver.manage().addCookie(new Cookie("cookielawinfo-checkbox-advertisement", "yes"));
        driver.manage().addCookie(new Cookie("viewed_cookie_policy", "yes"));
        driver.manage().addCookie(new Cookie("CookieLawInfoConsent",
                "{\"ver\":\"4\",\"necessary\":\"true\",\"functional\":\"true\",\"performance\":\"true\",\"analytics\":\"true\",\"advertisement\":\"true\",\"others\":\"true\"}"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
