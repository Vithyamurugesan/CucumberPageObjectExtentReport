package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {

   
    @FindBy(xpath = "//h6[contains(text(),'Dashboard')]")
    public WebElement homePageUserName;
}