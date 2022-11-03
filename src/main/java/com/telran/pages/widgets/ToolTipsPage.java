package com.telran.pages.widgets;

import com.telran.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToolTipsPage extends PageBase {
    public ToolTipsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "toolTipButton")
    WebElement toolTipButton;

    @FindBy(css=".tooltip-inner")
    WebElement buttonToolTip;
    public ToolTipsPage hoverToolTipWithAttribute() {
        hideAd();
        click(toolTipButton);
        pause(500);
        String actualToolTip = buttonToolTip.getText();
        System.out.println("Retrived tooltip as: " + actualToolTip);
        String expectedToolTip = "You hovered over the Button";
        if (actualToolTip.equals(expectedToolTip)) System.out.println("pass");
        else System.out.println("fail");
        return this;
    }
}
