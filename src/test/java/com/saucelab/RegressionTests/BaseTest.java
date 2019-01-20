package com.saucelab.RegressionTests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    static String workingDirectory = System.getProperty("user.dir");
    public static WebDriver driver;

    public static void takeScreenshot(String screename){
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(src,new File(workingDirectory +"src\\test\\screenshots" +screename+".png"))
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(String browser) throws Exception{
        driver = setupDriver(browser);
    }

    public WebDriver setupDriver(String browser) throws Exception {
        if(browser.equalsIgnoreCase("firefox")){
            String FilePath = System.getProperty("user.dir");
            System.setProperty("webdriver.gecko.driver",FilePath + "\\src\main\\resources\\drivers\")
        }
    }

}
