package com.telran.pages.interactions;

import com.telran.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class DragAndDropPage extends PageBase {
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "draggable")
    WebElement dragMe;

    @FindBy (id = "droppable")
    WebElement dropHere;
    public DragAndDropPage actionDragMe() {
    Actions actions = new Actions(driver);
    pause(2000);
    actions.dragAndDrop(dragMe, dropHere).perform();
        String textTo = dropHere.getText();
        if (textTo.equals("Dropped!")){
            System.out.println("pass");
        } else System.out.println("fail");
        return this;
    }

    public DragAndDropPage dragAndDropBy() {
        Actions actions = new Actions(driver);
        int xOffSet = dragMe.getLocation().getX();
        int yOffSet = dragMe.getLocation().getY();
        System.out.println("XOffSett-->" + xOffSet + "YOffSet-->" + yOffSet);

        int xOffSet1 = dropHere.getLocation().getX();
        int yOffSet1 = dropHere.getLocation().getY();
        System.out.println("XOffSett-->" + xOffSet1 + "YOffSet-->" + yOffSet1);

        xOffSet1 = (xOffSet1-xOffSet)+30;
        yOffSet1 = (yOffSet1-yOffSet)+50;

        pause(1000);
        actions.dragAndDropBy(dragMe, xOffSet1, yOffSet1).perform();
        String textTo = dropHere.getText();
        if (textTo.equals("Dropped!")){
            System.out.println("pass");
        } else System.out.println("fail");
        return this;
    }

    public DragAndDropPage dragAndDropByIndex(int x, int y) {
        Actions actions = new Actions(driver);
        pause(1000);
        actions.dragAndDropBy(dragMe, x, y).perform();
        return this;
    }
}
