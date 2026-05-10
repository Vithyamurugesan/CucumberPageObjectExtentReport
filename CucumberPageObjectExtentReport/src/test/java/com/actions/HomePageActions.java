package com.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utilities.HelperClass;
import java.time.Duration;

public class HomePageActions {

    public String getHomePageText() {
        WebDriverWait wait = new WebDriverWait(
            HelperClass.getDriver(), Duration.ofSeconds(20));

        By dashboard = By.xpath(
            "//span[contains(@class,'oxd-topbar-header-breadcrumb-module')]");

        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));

        return HelperClass.getDriver().findElement(dashboard).getText();
    }
}