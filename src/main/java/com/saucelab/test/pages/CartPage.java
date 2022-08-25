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


   // @FindBy(css =".btn_inventory" )
    private WebElement AddToCartButton;


     @FindBy(css=".inventory_item_name")
      private WebElement addItem;

    @FindBy(css=".inventory_item_price")
    private WebElement productPrice;

    @FindBy(css=".cart_quantity")
    private WebElement productQty;
    @FindBy (css = ".shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(id ="checkout")
    private WebElement checkoutItem;

    public boolean validateItemsinCart(String[] productName){
        wait.until(ExpectedConditions.visibilityOf(shoppingCart));
        boolean isDisplayed =false ;
        shoppingCart.click();
        return isDisplayed;
    }

    public void clickAddtoCart() {
        wait.until(ExpectedConditions.visibilityOf(AddToCartButton));
        AddToCartButton.click();
    }

    public int getQuantity(){
        return Integer.parseInt(productQty.getText());
    }


    //public String toString() {
        //return super.toString(cartBadge.getText());
    //}

    public void clickCart() {
    }
}
