package com.saucelab.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    WebElement txtUsername;

    @FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(id = "login-button")
    WebElement submit;

    public void gotoSauceDemo(String url) {
        driver.navigate().to(url);
        wait.until(ExpectedConditions.visibilityOf(txtUsername));

    }

    public void login(String userName, String Password) {
        txtUsername.sendKeys(userName);
        txtPassword.sendKeys(Password);
        submit.click();
    }

    public void invalidLogin(String userName, String Password) {
        txtUsername.sendKeys(userName);
        txtPassword.sendKeys(password);
        submit.click();
    }
}