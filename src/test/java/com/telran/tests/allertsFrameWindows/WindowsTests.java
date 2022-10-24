package com.telran.tests.allertsFrameWindows;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.allertsFrameWindows.WindowsPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getAlertsFrameWindows();
        new SidePanelPage(driver).selectWindows();
    }

    @Test
    public void openNewTabTest(){
        new WindowsPage(driver).clickOnNewTabButton();
        Assert.assertTrue(new WindowsPage(driver).getTextFromNewTab().contains("page"));
    }
}
