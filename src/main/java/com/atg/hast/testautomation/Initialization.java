package com.atg.hast.testautomation;

import com.atg.has.utilities.TestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Initialization {

    protected static WebDriver driver;
    private static Properties prop;
    private static String driverPath = ".\\chromedriver.exe";
    private static Logger logger = LogManager.getLogger(Initialization.class);

    public Initialization() {

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/main/java/com/atg/hast/testautomation/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            logger.error("config.properties file does not find");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public WebDriver loadBrowser() {

        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
            logger.info("Chrome driver started successfully");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtils.page_LoadTimeOut, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtils.implicitWait, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
        return driver;
    }
}
