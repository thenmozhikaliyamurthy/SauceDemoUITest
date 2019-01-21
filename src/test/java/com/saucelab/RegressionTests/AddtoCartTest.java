package com.saucelab.RegressionTests;

import com.saucelab.test.PageObjects.CartPage;
import com.saucelab.test.PageObjects.LoginPage;
import com.saucelab.test.PageObjects.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddtoCartTest extends BaseTest{

    @Parameters({"browser"})
    @BeforeClass
    public void SetUp(String browser) throws Exception {
        driver= setupDriver(browser);
        configProp  = loadConstant();
    }

    @Test
    public void AddtoCart(){
        //Login with Passed username and password
        LoginPage loginPage = new LoginPage(driver);
        String URL = configProp.getProperty("TestURL");
        loginPage.gotoSauceDemo(URL);
        String username = configProp.getProperty("username");
        String password = configProp.getProperty("password");
        loginPage.Login(username,password);

        //Add the items to cart
        ProductsPage products = new ProductsPage(driver);
        String[] items = configProp.getProperty("ProductsToCart").split(",");
        products.addtoCart(items);

        //Check Items in cart
        CartPage cart = new CartPage(driver);
        Assert.assertTrue(cart.validateNumberofItemsinCart(items));

    }


}
