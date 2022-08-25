package com.saucelab.regressionTest;

import com.saucelab.test.pages.LoginPage;
import com.saucelab.test.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Base64;

public class LoginTest extends BaseTest {

    public void setUp(String browser) throws Exception {
        driver= setupDriver(browser);
        configProp  = loadProperties();
    }

    @Test
    public void testValidLogin() throws Exception {
        setUp("chrome");
     //Login with Valid username and password
        LoginPage loginPage = new LoginPage(driver);
        String URL = configProp.getProperty("TestURL");
        loginPage.gotoSauceDemo(URL);
        String username=configProp.getProperty("username");
        String password = configProp.getProperty("password");
        loginPage.login(username,password);
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.testLogo(),"Product page is not displayed");
    }

    @Test
    public void testInValidLogin() throws Exception {
        setUp("chrome");
        //Login with Valid username and password
        LoginPage loginPage = new LoginPage(driver);
        String URL = configProp.getProperty("TestURL");
        loginPage.gotoSauceDemo(URL);
        //String username=configProp.getProperty("username");
        //String password = configProp.getProperty("password");
        String username = "ABC";
        String password = "ABd";
        LoginPage.login(ABC,ABD);


        // Assert.assertEquals("Epic sadface: Username and password do not match any user in this service");
    }


    }

