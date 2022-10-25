package com.telran.pages.allertsFrameWindows;

import com.telran.pages.PageBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;
import java.util.List;

public class FramesPage extends PageBase {
    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (tagName = "iframe")
    List<WebElement> iframes;
    public FramesPage returnListOfIFrames() {
        //By finding all the web elements using frame tag
        System.out.println("Number of frames" + iframes.size());

        //By executing JS
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer numberOfIframes = Integer.parseInt(js.executeScript("return window.length").toString());
        System.out.println("The total number of iframes" + numberOfIframes);
        return this;
    }

    public FramesPage switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
        driver.switchTo().defaultContent();
        return this;
    }


    @FindBy (id = "frame1")
    WebElement iFrameId;
    public FramesPage switchToIframeById() {
        driver.switchTo().frame(iFrameId);
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(tagName = "body")
    WebElement sampleHeading;
    public String getIframesText() {
        driver.switchTo().frame(iFrameId);
        return sampleHeading.getText();
    }

    public String getIframesByIndexText(int index) {
        driver.switchTo().frame(index);
        return sampleHeading.getText();
    }
}
