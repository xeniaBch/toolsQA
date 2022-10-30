package com.telran.pages.widgets;

import com.telran.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


import java.util.Collection;
import java.util.List;

public class SelectMenuPage extends PageBase {
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;
    public SelectMenuPage oldStyleSelectMenu(String text) {
        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(text);
        List<WebElement> options = select.getOptions();
        System.out.println(select.getFirstSelectedOption().getText());
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }
        return this;
    }

    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[3]")
    WebElement multySelectDropDown;

    @FindBy (xpath = "//html")
    WebElement space;
    public SelectMenuPage multySelectDropDown(String text) {
        clickWithJSExecutor(multySelectDropDown,0,300);
        WebElement element = driver.findElement(By.xpath(String.format("//div[text()='%s']", text)));
        clickWithJSExecutor(element, 0, 200);
        pause(2000);
        click(space);
        return this;
    }

    @FindBy(css = ".css-xb97g8")
    WebElement deselect;
    public SelectMenuPage deselect() {
        click(deselect);
        return this;
    }

    @FindBy(id = "react-select-4-input")
    WebElement inputSelect;
    public SelectMenuPage multySelectDropDown1(String[] text) {
        for (int i = 0; i < text.length; i++) {
        if(text[i]!=null){
            inputSelect.sendKeys(text[i]);
            inputSelect.sendKeys(Keys.ENTER);
        }
        }
        pause(2000);
        click(space);
        return this;
    }

    @FindBy(id= "cars")
    WebElement cars;
    public SelectMenuPage standartMultySelect() {
        Select multy = new Select(cars);
        if (multy.isMultiple()){
            multy.selectByIndex(1);
            multy.selectByIndex(2);
            multy.selectByIndex(3);
        }
        List<WebElement> allSelectedOptions = multy.getAllSelectedOptions();
        for (WebElement el :
                allSelectedOptions) {
            System.out.println(el.getText());
        }
        return this;
    }

    @FindBy(id = "withOptGroup")
    WebElement selectValue;

    @FindBy(id = "react-select-2-option-0-1")
    WebElement value;

    public SelectMenuPage selectValue() {
      click(selectValue);
      pause(1000);
      click(value);
      return this;
    }

    public String getSelectValueText() {
        String items = selectValue.getText();
        return items;
    }


    @FindBy(id = "selectOne")
    WebElement selectOne;
    @FindBy(id = "react-select-3-option-0-1")
    WebElement oneValue;

    public SelectMenuPage selectOne() {
        clickWithJSExecutor(selectOne, 0, 100);
        pause(1000);
        clickWithJSExecutor(oneValue, 0, 200);
        return this;
    }


    public String getSelectOneText() {
        return selectOne.getText();
    }
}
