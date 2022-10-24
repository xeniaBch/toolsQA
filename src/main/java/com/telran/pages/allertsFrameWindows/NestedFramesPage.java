package com.telran.pages.allertsFrameWindows;

import com.telran.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NestedFramesPage extends PageBase {
    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (tagName = "frame")
    List<WebElement> iframe;

    @FindBy (id = "frame1")
    WebElement frame1;

    @FindBy (tagName = "body")
    WebElement body;

    public NestedFramesPage handleNestedFrames(){
        hideAd();
        System.out.println("Nuber of frames " + iframe.size());
        driver.switchTo().frame(frame1);
        System.out.println("Frame 1 is "+ body.getText());
        System.out.println("Number of iframes inside parent frame" + iframe.size());
        driver.switchTo().frame(0);
        System.out.println("Frame 2 is " + body.getText());
        System.out.println("Number of frames inside the Frame 2" + iframe.size());
        return this;
    }

    public NestedFramesPage switchToParentFrame() {
        driver.switchTo().frame(frame1);
        System.out.println("Frame 1 is " + body.getText());
        driver.switchTo().frame(0);
        System.out.println("Frame 2 is " + body.getText());
        driver.switchTo().parentFrame();
        System.out.println("Parent Frame is " + body.getText());
        return this;
    }
}
