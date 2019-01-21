package com.saucelab.test.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;

public class LoginPage {
    private final WebDriver driver;
    WebDriverWait wait;


    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,120);
    }

    @FindBy(id = "user-name")
    WebElement txtUsername;

    @FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(css = ".login-button")
    WebElement submit;

    public void gotoSauceDemo(String url){
        driver.navigate().to(url);
        wait.until(ExpectedConditions.visibilityOf(txtUsername));

    }

    public void Login(String userName,String Password){
        txtUsername.sendKeys(userName);
        txtPassword.sendKeys(Password);
        submit.click();
    }


}
