package com.telran.pages.elements;

import com.telran.pages.PageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends PageBase {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "userName")
    WebElement userName;

       @FindBy (id = "userEmail")
    WebElement userEmail;

       @FindBy (id = "currentAddress")
    WebElement currentAddress;

       @FindBy (id = "permanentAddress")
    WebElement permanentAddress;

    public TextBoxPage keyBoardEvent() {
        Actions actions = new Actions(driver);
        type(userName, "Test");
        type(userEmail, "test@gmail.com");
        typeWithJSExecutor(currentAddress, 0, 100, "Postdamer Str. 26");
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        return this;
    }

    public String getAttribute() {
        return permanentAddress.getAttribute("value");
    }
}
