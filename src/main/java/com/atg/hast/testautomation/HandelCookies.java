package com.atg.hast.testautomation;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandelCookies extends Initialization {

    private static Logger logger = LogManager.getLogger(Hast.class);

    public boolean acceptCookies() {

        WebElement popupBoxgodkannButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        logger.info("Cookies PopUp Box accept button found :");
        if (popupBoxgodkannButton.isDisplayed()) {
            logger.info("Cookies Popup box accept button displayed");
            popupBoxgodkannButton.click();
            logger.info("Godkänn button Clicked");
            return true;
        } else {
            logger.error("Cookies Popup Box accept button is not displayed");
            return false;
        }
    }
}
