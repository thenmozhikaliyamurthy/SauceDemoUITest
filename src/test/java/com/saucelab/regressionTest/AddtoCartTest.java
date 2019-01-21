package com.saucelab.regressionTest;

import com.saucelab.test.pages.BasePage;
import com.saucelab.test.pages.CartPage;
import com.saucelab.test.pages.LoginPage;
import com.saucelab.test.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddtoCartTest extends BaseTest{

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(String browser) throws Exception {
        driver= setupDriver(browser);
        configProp  = loadProperties();
    }

    @Test
    public void addToCart(){


        //Login with Passed username and password
        LoginPage loginPage = new LoginPage(driver);
        String URL = configProp.getProperty("TestURL");
        loginPage.gotoSauceDemo(URL);
        String username = configProp.getProperty("username");
        String password = configProp.getProperty("password");
        loginPage.login(username,password);

        //Add the items to cart
        ProductsPage products = new ProductsPage(driver);
        String[] items = configProp.getProperty("ProductsToCart").split(",");
        products.addtoCart(items);

        //click Shopping Cart

        products.clickCart();

        //Check Items in cart
        CartPage cart = new CartPage(driver);
        takeScreenshot("cartPage");
        Assert.assertTrue(cart.validateItemsinCart(items));

    }

    @AfterClass
    public void tear(){
        driver.quit();
    }


}
