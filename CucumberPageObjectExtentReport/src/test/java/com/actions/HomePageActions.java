package com.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.HelperClass;

public class HomePageActions {

    public String getHomePageText() {
        WebDriverWait wait = new WebDriverWait(
                HelperClass.getDriver(),
                Duration.ofSeconds(30));  // increased to 30s for page load

        WebElement dashboard = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h6[normalize-space()='Dashboard']")));

        return dashboard.getText();
    }
}