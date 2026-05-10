package com.utilities;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class HelperClass {
    private static HelperClass helperclass;
    private static WebDriver driver;
    private static WebDriverWait wait;
    public final static int TIMEOUT = 20;

    HelperClass() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
    }

    public static void openPage(String url) {
        driver.get(url);

        // Wait until page is fully loaded
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
            .until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")
                .equals("complete"));

   
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
            .until(ExpectedConditions.visibilityOfElementLocated(
                By.name("username")));
    }

    public static WebDriver getDriver() { return driver; }
    public static WebDriverWait getWait() { return wait; }

    public static void setUpDriver() {
        if (helperclass == null) {
            helperclass = new HelperClass();
        }
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        helperclass = null;
    }
}