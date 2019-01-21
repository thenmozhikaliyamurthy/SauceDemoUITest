package com.saucelab.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver){
        super(driver);
    }


    @FindBy(css = ".shopping_cart_container a")
    private WebElement shoppingCart;

    @FindAll({@FindBy(css=".inventory_item_name")})
    private List<WebElement> itemsInCart;


    public boolean validateItemsinCart(String[] productName){

        wait.until(ExpectedConditions.visibilityOf(shoppingCart));
        boolean isDisplayed =false ;
        shoppingCart.click();
        for(int i = 0;i<productName.length;i++) {
            String itemName = itemsInCart.get(i).getText();
            if (productName[i].contains(itemName)) {
                isDisplayed = true;
            } else {
                isDisplayed = false;
            }
        }

        return isDisplayed;

    }



}
