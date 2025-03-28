package com.useinsider.methods;

import com.useinsider.base.BaseTest;
import com.useinsider.utils.LocatorHelper;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.*;

public class BaseMethods {
    protected static final Logger logger = Logger.getLogger(BaseMethods.class.getName());
    private static Map<String, String> savedValue = new HashMap<>();
    private static int sizeJobList = 0;
    public WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;
    private LocatorHelper helper = new LocatorHelper();
    public static int DEFAULT_MAX_ITERATION_COUNT = 150;
    public static int DEFAULT_MILLISECOND_WAIT_AMOUNT = 100;

    public BaseMethods() {
        driver = BaseTest.driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50), Duration.ofMillis(300)).ignoring(NoSuchElementException.class);
        jsdriver = (JavascriptExecutor) driver;
    }

    protected WebElement findElement(String locatorKey) {
        return helper.findElement(locatorKey, driver);
    }


    protected void waitBySecond(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
            logger.info("Waiting " + seconds + " seconds");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    protected By findElementInfoBy(String locatorKey) {
        return helper.findElementInfoBy(locatorKey);
    }



    protected WebElement waitForElementToBeVisible(String locatorKey) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(findElementInfoBy(locatorKey)));
    }

    protected List<WebElement> findsElements(String locatorKey) {
        return driver.findElements(findElementInfoBy(locatorKey));
    }

    protected void clickElement(String locatorKey) {
        findElement(locatorKey).click();
        logger.info(locatorKey + " element clicked");

    }

    protected void sendKeys(String locatorKey, String text) {
        findElement(locatorKey).sendKeys(text);
        logger.info(text + " written to " + locatorKey + " element");
    }

    protected void sendKeyToElementENTER(String locatorKey) {
        findElement(locatorKey).sendKeys(Keys.ENTER);
        logger.info("Enter was sent to the element " + locatorKey);
    }

    protected void javascriptclicker(String locatorKey) {
        WebElement element = findElement(locatorKey);
        JavascriptExecutor executor = (JavascriptExecutor) jsdriver;
        executor.executeScript("arguments[0].click();", element);
        logger.info(locatorKey + " element clicked with javascript");
    }

    protected WebElement scrollToElementToBeVisible(String key) {
        WebElement webElement = findElement(key);
        try {
            if (webElement != null) {
                scrollTo(webElement.getLocation().getX(), webElement.getLocation().getY() - 100);
                Thread.sleep(1 * 1000L);
                Assert.assertTrue("element Not Found", webElement.isDisplayed());
            }
            logger.info("scrolled to " + key + " element");


            return webElement;

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void scrollTo(int x, int y) {
        String script = String.format("window.scrollTo(%d, %d);", x, y);
        executeJS(script, true);
    }

    private Object executeJS(String script, boolean wait) {
        return wait ? jsdriver.executeScript(script, "") : jsdriver.executeAsyncScript(script, "");
    }


    protected void gotoURL(String url) {
        driver.navigate().to(url);
        logger.info("Going to " + url + " url");
    }

    protected void checkIsTextContainsList(String key, String expectedValue) {
        List<WebElement> keys = findsElements(key);
        sizeJobList = keys.size();
        int workQuantity = 1;
        for (WebElement element : keys) {
            Assert.assertTrue("Text doesn't match", element.getText().contains(expectedValue));
            logger.info("In job option " + workQuantity + ", the content " + element.getText() + " contains the text " + expectedValue);
            workQuantity++;
        }

    }

    protected void hoverOverElementWithSelectedSize(String key) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(findsElements(key).get(sizeJobList - 1)).perform();
            Thread.sleep(1 * 500L);
            logger.info(key + " element was hovered");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    protected void saveValue(String key) {
        String cleanValue = findElement(key).getText().replace(" /", "");
        savedValue.put(key, cleanValue);
        logger.info("the value " + cleanValue + " is registered with the key " + key);
    }

    protected void saveValueLastJob(String key) {
        WebElement element = findsElements(key).get(sizeJobList - 1);
        String cleanValue = element.getText().replace(" /", "");
        savedValue.put(key, cleanValue);
        logger.info("the value " + cleanValue + " is registered with the key " + key);
    }

    protected void isSavedValueEqualExpectedValue(String key, String savedValueKey) {
        String cleanValue = findElement(key).getText().replace(" /", "");
        Assert.assertEquals("Text doesn't match", savedValue.get(savedValueKey), cleanValue);
        logger.info("the saved " + savedValue.get(savedValueKey) + " text is equal to the requested " + cleanValue + " text");
    }

    protected void switchToSecondTab() {
        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(windowHandles);

        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(1));
        } else {
            System.out.println("A second tab was not found");
        }
    }

    protected void checkForElement(String key, String errorMessage) {
        Assert.assertTrue(errorMessage, findElement(key).isDisplayed());
        logger.info(key + " element exists");
    }

    protected void clickElementWithSelectedSize(String key) {
        findsElements(key).get(sizeJobList - 1).click();
        logger.info(key + " element clicked");
    }

    public void waitByMilliSeconds(long milliseconds) {
        try {
            logger.info(milliseconds + " waited for milliseconds.");
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkURLContains(String expectedURL) {
        int loopCount = 0;
        String actualURL = "";
        while (loopCount < DEFAULT_MAX_ITERATION_COUNT) {
            actualURL = driver.getCurrentUrl();

            if (actualURL != null && actualURL.contains(expectedURL)) {
                logger.info("Current URL" + expectedURL + " has in it.");
                return;
            }
            loopCount++;
            waitByMilliSeconds(DEFAULT_MILLISECOND_WAIT_AMOUNT);
        }
        Assertions.fail(
                "Actual URL doesn't match the expected." + "Expected: " + expectedURL + ", Actual: "
                        + actualURL);
    }

}
