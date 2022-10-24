package com.telran.tests.allertsFrameWindows;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.allertsFrameWindows.NestedFramesPage;
import com.telran.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFramesTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getAlertsFrameWindows();
        new SidePanelPage(driver).selectNestedFrames();
    }

    @Test
    public void handleNestedFramesTest() {
        new NestedFramesPage(driver).handleNestedFrames();
    }

    @Test
    public void switchToParentFrameTest(){
        new NestedFramesPage(driver).switchToParentFrame();

    }
}
