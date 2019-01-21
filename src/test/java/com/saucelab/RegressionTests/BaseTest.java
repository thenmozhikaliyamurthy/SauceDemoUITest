package com.saucelab.RegressionTests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    static String workingDirectory = System.getProperty("user.dir");
    public static WebDriver driver;
    public String fileSeperator = System.getProperty("file.seperator");
    public static Properties configProp;


    public static void takeScreenshot(String screename){
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(src,new File(workingDirectory +System.getProperty("file.seperator") +screename+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void setUp(String browser) throws Exception{
        driver = setupDriver(browser);
        configProp = loadConstant();
    }

    public Properties loadConstant() throws IOException {
        configProp = new Properties();
        FileInputStream fileInput = new FileInputStream(workingDirectory+
                File.separator+"config.properties");
        configProp.load(fileInput);
        return configProp;
    }

    public WebDriver setupDriver(String browser) throws Exception {
        if(browser.equalsIgnoreCase("firefox")){
            String FilePath = System.getProperty("user.dir");
            System.setProperty("webdriver.gecko.driver",FilePath +System.getProperty("file.seperator")+" geckodriver.exe");
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            driver = new FirefoxDriver(capabilities);
        }

        else if(browser.equalsIgnoreCase("chrome")){
            String FilePath = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver",FilePath +File.separator+"chromedriver.exe");
            driver = new ChromeDriver();
        }

        else if(browser.equalsIgnoreCase("ie")){
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            String FilePath = System.getProperty("user.dir");
            System.setProperty("webdriver.ie.driver",FilePath +System.getProperty("file.seperator")+"IEDriverServer.exe");
            driver = new InternetExplorerDriver(capabilities);
        }

        driver.manage().window().maximize();
        return driver;

    }
    @AfterClass
    public void teat(){
        driver.quit();
    }

}
