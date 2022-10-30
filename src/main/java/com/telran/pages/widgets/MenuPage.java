package com.telran.pages.widgets;

import com.telran.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends PageBase {
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//a[.='Main Item 2']")
    WebElement mainItem2;

    @FindBy (xpath = "//a[.='SUB SUB LIST »']")
    WebElement subSubList;

    @FindBy(xpath = "//a[.='Sub Sub Item 2']")
    WebElement subSubItem2;
    public MenuPage moveToSubMenu() {
        hideAd();
        Actions actions = new Actions(driver);
        pause(1000);
        actions.moveToElement(mainItem2).perform();
        System.out.println(mainItem2.getText());
        actions.moveToElement(subSubList).perform();
        System.out.println(subSubList.getText());
        actions.moveToElement(subSubItem2).perform();
        System.out.println(subSubItem2.getText());
        return this;
    }
}
