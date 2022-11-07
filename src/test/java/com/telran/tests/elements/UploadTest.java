package com.telran.tests.elements;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.UploadAndDownloadPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getElements();
        new SidePanelPage(driver).selectUploadAndDownload();
    }

    @Test
    public void robotKeyEventTest(){
        new UploadAndDownloadPage(driver).perfomKeyEventUsingRobot();
        Assert.assertTrue(new UploadAndDownloadPage(driver).getPath().contains("D1.txt"));
    }

    @Test
    public void robotMouseEventTest(){
        new UploadAndDownloadPage(driver).perfomMouseEventUsingRobot();
        Assert.assertTrue(new UploadAndDownloadPage(driver).getPath().contains("D1.txt"));
    }
}
