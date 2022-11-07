package com.telran.pages.elements;

import com.telran.pages.PageBase;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Collection;

public class UploadAndDownloadPage extends PageBase {
    public UploadAndDownloadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "uploadFile")
    WebElement uploadFile;


    public UploadAndDownloadPage perfomKeyEventUsingRobot() {
        hideAd();
        hideFooter();
        pause(2000);
        clickWithRectangle(uploadFile, 20, 30);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_PERIOD);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_X);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_ENTER);
        return this;
    }

    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;

    public String getPath() {
        System.out.println(uploadedFilePath.getText());
        return uploadedFilePath.getText();
    }

    public UploadAndDownloadPage perfomMouseEventUsingRobot() {
        hideAd();
        hideFooter();
        pause(2000);
        clickWithRectangle(uploadFile, 20, 30);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        Dimension i = driver.manage().window().getSize();
        pause(1000);
        System.out.println("Screen " + i.getWidth() + " " + i.getHeight());
        int x = (int) (i.getWidth()*0.33);
        int y  = (int) (i.getHeight()*0.5);
        robot.mouseMove(x, y);
        pause(1000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        pause(1000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        int xButton = (int) (i.getWidth()*0.8);
        int yButton  = (int) (i.getHeight()*0.9);
        robot.mouseMove(xButton, yButton);
        pause(1000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        pause(1000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        //robot.keyPress(KeyEvent.VK_ENTER);
        return this;
    }
}
