package com.telran.pages.allertsFrameWindows;

import com.telran.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
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
}
