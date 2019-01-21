package com.saucelab.test.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage {
    private final WebDriver driver;
    WebDriverWait wait;


    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,120);
    }


    @FindBy(css = ".shopping_cart_container a")
    WebElement Shopping_cart;

    @FindAll({@FindBy(css=".inventory_item_name")})
    public List<WebElement> ItemsinCart;


    public boolean  validateNumberofItemsinCart(String[] productName){

        wait.until(ExpectedConditions.visibilityOf(Shopping_cart));
        boolean isDisplayed =false ;
        Shopping_cart.click();
        for(int i = 0;i<productName.length;i++) {
            String itemname = ItemsinCart.get(i).getText();
            if (productName[i].contains(itemname)) {
                isDisplayed = true;
            } else {
                isDisplayed = false;
            }
        }

        return isDisplayed;

    }



}
