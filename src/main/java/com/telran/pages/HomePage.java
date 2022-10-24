package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//h5[contains(.,'Book Store Application')]")
    WebElement element;
    public SidePanelPage openBookStoreApp() {
        clickWithJSExecutor(element, 0, 600);
        return new SidePanelPage(driver);
    }

    @FindBy(xpath = "//h5[contains(.,'Alerts, Frame & Windows')]")
    WebElement alertsFrameWindows;
    public SidePanelPage getAlertsFrameWindows() {
        clickWithJSExecutor(alertsFrameWindows, 0, 400);
        return new SidePanelPage(driver);
    }

    @FindBy(xpath = "//div[.='Elements']")
    WebElement elements;
    public SidePanelPage getElements() {
        clickWithJSExecutor(elements, 0, 300);
        return  new SidePanelPage(driver);
    }
}
