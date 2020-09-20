package com.zerowebapp.base;

import com.zerowebapp.utils.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties properties;

    public TestBase(){
        try {
            properties = new Properties();
            FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/zerowebapp/config/config.properties");
            properties.load(fs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization(){
        String browserName = properties.getProperty("browser");
        String path = System.getProperty("user.dir");
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/drivers/chromedriver");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        }
        if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", path + "/src/main/resources/drivers/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

        driver.get(properties.getProperty("url"));
    }
}
