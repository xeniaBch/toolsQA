package com.telran.tests.allertsFrameWindows;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.allertsFrameWindows.FramesPage;
import com.telran.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getAlertsFrameWindows();
        new SidePanelPage(driver).selectFrames();
    }

    @Test
    public void returnListOfFramesTest()  {
        new FramesPage(driver).returnListOfIFrames();

    }

    @Test
    public void switchToIframeByIndexTest(){
        new FramesPage(driver).switchToIframeByIndex(1);
    }

    @Test
    public void switchToIframeByIdTest(){
        new FramesPage(driver).switchToIframeById();
    }
}
