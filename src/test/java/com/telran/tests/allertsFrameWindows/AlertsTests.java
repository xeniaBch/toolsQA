package com.telran.tests.allertsFrameWindows;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.allertsFrameWindows.AlertsPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getAlertsFrameWindows();
        new SidePanelPage(driver).selectAlerts();
    }

    @Test
    public void acceptSimpleAlert(){
        new AlertsPage(driver).clickOnSimpleAlertButton();
    }

    @Test
    public void waitOfAlertTest(){
        new AlertsPage(driver).clickOnTimerAlertButton();
    }

    @Test
    public void confirmAlertsTest(){
        new AlertsPage(driver).clickOnConfirmButton("Cancel");
        Assert.assertTrue(new AlertsPage(driver).getConfirmResult().contains("Cancel"));
    }

    @Test
    public void sendTextInAlertTest(){
        new AlertsPage(driver).clickMessageAlertButton("Hello World");
        Assert.assertTrue(new AlertsPage(driver).getConfirmMessageResult().contains("Hello"));
    }
}
