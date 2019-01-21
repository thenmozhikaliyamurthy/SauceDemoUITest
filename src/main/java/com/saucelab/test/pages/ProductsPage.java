package com.saucelab.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage{
    String productname;


    public ProductsPage(WebDriver driver){

        super(driver);
    }


    @FindBy(css = ".product_label")
    WebElement productLabel;



    public void addtoCart(String[] productName){

        wait.until(ExpectedConditions.visibilityOf(productLabel));
        for(int i = 0; i<productName.length ; i++){
            WebElement Add_to_Cart= driver.findElement(By.xpath(".//*[contains(text(),'"+productName[i]+"')]/../../..//button"));
            Add_to_Cart.click();
        }


    }



}
