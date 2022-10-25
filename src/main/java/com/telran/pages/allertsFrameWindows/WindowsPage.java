package com.telran.pages.allertsFrameWindows;

import com.telran.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WindowsPage extends PageBase {
    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "tabButton")
    WebElement tabButton;
    public WindowsPage clickOnNewTabButton() {
        click(tabButton);
        List<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        return this;
    }

    @FindBy(id = "sampleHandling")
    WebElement sampleHandling;
    public String getTextFromNewTab() {
        return sampleHandling.getText();
    }

    @FindBy (id = "windowButton")
    WebElement windowButton;
    public WindowsPage clickOnNewWindowButton() {
        click(windowButton);
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        return this;
    }

    @FindBy (id ="sampleHeading")
    WebElement sampleHeading;
    public String getTextFromNewWindow() {
        return sampleHeading.getText();
    }

    @FindBy (id = "messageWindowButton")
    WebElement messageWindowButton;
    public WindowsPage clickOnNewWindowMessageButton() {
        click(messageWindowButton);
        List<String> messageWindows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(messageWindows.get(1));
        return this;
    }

    @FindBy (xpath = "//body")
    WebElement messageWindow;
    public String getTextFromNewWindowMessage() {
        return messageWindow.getText();
    }
}
