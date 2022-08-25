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

    public void setUp(String browser) throws Exception {
        driver= setupDriver(browser);
        configProp  = loadProperties();
    }

    @Test
    public void addToCart() throws Exception {
        setUp("chrome");

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

        //Check Items in cart
        CartPage cart = new CartPage(driver);
        cart.clickAddtoCart();
        //Cartbadge.clickCart();
        takeScreenshot("cartPage");
        Assert.assertEquals(cart.getQuantity(),1,"cart qty is not matching");
        /*add more assertion */
        // Add to Cart page
    }

    @AfterClass
    public void tear(){
        driver.quit();
    }


}
