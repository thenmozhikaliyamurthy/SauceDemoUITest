package com.saucelab.regressionTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    static String workingDirectory = System.getProperty("user.dir");
    public static WebDriver driver;
    public static Properties configProp;
    String os = System.getProperty("os.name").toLowerCase();


    protected static void takeScreenshot(String screename){
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(src,new File(workingDirectory +File.separator +screename+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    protected void setUp(String browser) throws Exception{
        driver = setupDriver(browser);
        configProp = loadProperties();
    }

    protected Properties loadProperties() throws IOException {
        configProp = new Properties();
        FileInputStream fileInput = new FileInputStream(workingDirectory+
                File.separator+"config.properties");
        configProp.load(fileInput);
        return configProp;
    }

    protected WebDriver setupDriver(String browser) throws Exception {
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
            if(os.contains("mac")){
                System.setProperty("webdriver.chrome.driver",FilePath +File.separator+"chromedriver");
            }
            else {
                System.setProperty("webdriver.chrome.driver", FilePath + File.separator + "chromedriver-windows.exe");
            }
            driver = new ChromeDriver();
        }

        else if(browser.equalsIgnoreCase("ie")){
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            String FilePath = System.getProperty("user.dir");
            System.setProperty("webdriver.ie.driver",FilePath +System.getProperty("file.seperator")+"IEDriverServer.exe");
            driver = new InternetExplorerDriver(capabilities);
        }

        else if (browser.equalsIgnoreCase("html")){
            driver = new HtmlUnitDriver();
        }

        driver.manage().window().maximize();
        return driver;

    }

}
