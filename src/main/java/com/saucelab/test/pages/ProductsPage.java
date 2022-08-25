package com.saucelab.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductsPage extends BasePage{
    String productname;


    public ProductsPage(WebDriver driver){

        super(driver);
    }

    @FindAll(@FindBy(css = ".inventory_item_name"))
    List<WebElement> productLabel;

    @FindBy(css=".app_logo")
    WebElement logoLabel;




    public void addtoCart(String[] productName){
        wait.until(ExpectedConditions.visibilityOf(productLabel.get(0)));
        productLabel.get(0).click();
    }

    public Boolean testLogo(){
        return logoLabel.isDisplayed();

    }
}
