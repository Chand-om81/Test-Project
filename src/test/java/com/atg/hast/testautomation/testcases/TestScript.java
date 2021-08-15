package com.atg.hast.testautomation.testcases;

import com.atg.hast.testautomation.HandelCookies;
import com.atg.hast.testautomation.Hast;
import com.atg.hast.testautomation.Initialization;
import com.atg.hast.testautomation.V4Game;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestScript  {
    Hast hast;
    HandelCookies cookies;
    V4Game hastGame_object;

    @BeforeTest
    public void setup() {
        new Initialization().loadBrowser();
        hast = new Hast();
        cookies = new HandelCookies();
        hastGame_object = new V4Game();

    }

    @Test(priority = 3)
    public void playGameTest() {

        Assert.assertEquals("https://www.atg.se/", hast.urlLoad());
        Assert.assertTrue(cookies.acceptCookies());
        Assert.assertTrue(hast.selectHast());
        Assert.assertTrue(hast.selectGameType());
        Assert.assertTrue(hast.makeCoupon());
        Assert.assertTrue(hastGame_object.vType1_Mark_Horses());
        Assert.assertTrue(hastGame_object.vType2_Mark_Horses());
        Assert.assertTrue(hastGame_object.v4Type3_Mark_Horses());
        Assert.assertTrue(hastGame_object.v4Type4_Mark_Horses());

    }

    @AfterTest
    void closeTest() {
        hast.closeBrowser();
    }

}
