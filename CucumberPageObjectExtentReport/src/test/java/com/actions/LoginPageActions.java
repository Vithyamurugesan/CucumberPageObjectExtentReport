package com.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.LoginPageLocators;
import com.utilities.HelperClass;

public class LoginPageActions {

    LoginPageLocators loginpageLocators = null;

    String strUsername, strPassword;

    public LoginPageActions() {
        this.loginpageLocators = new LoginPageLocators();
        PageFactory.initElements(HelperClass.getDriver(), loginpageLocators);
    }

    public void setStrUserName(String strUserName) {
        // Wait for field before typing
        new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(20))
            .until(ExpectedConditions.visibilityOf(
                this.loginpageLocators.userName));
        this.loginpageLocators.userName.sendKeys(strUserName);
    }

    public void setStrPassWord(String strPassWord) {
        new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(20))
            .until(ExpectedConditions.visibilityOf(
                this.loginpageLocators.passWord));
        this.loginpageLocators.passWord.sendKeys(strPassWord);
    }
    public String getErrorMessage() {

        WebDriverWait wait = new WebDriverWait(
                HelperClass.getDriver(),
                Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOf(loginpageLocators.txtErrorMessage));

        return loginpageLocators.txtErrorMessage.getText();
    }
    
    public void clickLogin() {
    	loginpageLocators.login.click();
    }

    public void Login() {

        File file = new File("src\\test\\resources\\testdata.properties");
        FileInputStream fileInput = null;

		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Properties prop = new Properties();

		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		strUsername = prop.getProperty("username");
		System.out.println("Username : " + strUsername);

		strPassword = prop.getProperty("password");
		System.out.println("Password : " + strPassword);

		this.setStrUserName(strUsername);
		this.setStrPassWord(strPassword);
		this.clickLogin();
	}
   
}




