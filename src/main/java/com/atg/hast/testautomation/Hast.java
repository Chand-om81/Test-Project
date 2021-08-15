package com.atg.hast.testautomation;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class Hast extends Initialization {

    private static Logger logger = LogManager.getLogger(Hast.class);
    private WebElement selectHast;
    private WebElement gameType;
    private WebElement newCouponButton;
    private WebElement emptyCouponButton;

    // Initialization of Page Objects
    public void Hast() {
        PageFactory.initElements(driver, this);

    }


    // Actions
    public String urlLoad() {

        logger.info("The loading current Url       :" + driver.getCurrentUrl());
        logger.info("\"The title of Website is : " + driver.getTitle());
        return driver.getCurrentUrl();

    }

    public boolean selectHast() {
        try {
            selectHast = driver.findElement(By.xpath("//*[text()='Häst']"));
            logger.info("Häst Game displayed");
            selectHast.click();
            logger.info("Häst game clicked");
            return true;
        } catch (NoSuchElementException ex) {
            logger.error("Hast game not displayed or clicked");
            return false;

        }
    }

    public boolean selectGameType() {


        try {
            gameType = driver.findElement(By.partialLinkText("V4"));
            logger.info("v4 Game displayed");
            gameType.click();
            logger.info("v4 game selected");
            return true;
        } catch (NoSuchElementException ex) {
            logger.error("V4 game not displayed or selected");
        }


        try {
            gameType = driver.findElement(By.partialLinkText("V3"));
            logger.info("v3 Game displayed");
            gameType.click();
            logger.info("v3 game selected");
            return true;
        } catch (NoSuchElementException ex) {
            logger.error("V3 game not displayed or selected");
        }

        try {
            gameType = driver.findElement(By.partialLinkText("V5"));
            logger.info("Häst v5 Game displayed");
            gameType.click();
            logger.info("Häst v5 Game selected");
            return true;
        } catch (NoSuchElementException ex) {
            logger.error("Häst V5 Game not displayed or selected");
        }
        try {
            gameType = driver.findElement(By.partialLinkText("V75"));
            logger.info("v75 Game displayed");
            gameType.click();
            logger.info("v75 Game clicked");
            return true;
        } catch (NoSuchElementException ex) {
            logger.error("V75 Game not displayed or selected");
        }
        try {
            gameType = driver.findElement(By.partialLinkText("V64"));
            logger.info("v64 Game displayed");
            gameType.click();
            logger.info("v64 Game clicked");

            return true;
        } catch (NoSuchElementException ex) {
            logger.error("V64 Game not displayed or selected");

        }

        return false;
    }


    public boolean makeCoupon() {
        newCouponButton = driver.findElement(By.xpath("//button[contains(text(),'Ny Kupong')]"));
        newCouponButton.click();
        emptyCouponButton = driver.findElement(By.xpath("//button[contains(text(),'Tom kupong')]"));
        emptyCouponButton.click();

        return true;
    }

    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
