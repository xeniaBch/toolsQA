package com.telran.tests.widgets;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.widgets.SelectMenuPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectMenuTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getWidgets();
        new SidePanelPage(driver).getSelectMenu();
    }

    @Test
    public void SelectValueTest(){
        new SelectMenuPage(driver).selectValue();
        Assert.assertTrue(new SelectMenuPage(driver).getSelectValueText().contains("option 2"));
    }

    @Test
    public void SelectOneTest(){
        new SelectMenuPage(driver).selectOne();
        Assert.assertTrue(new SelectMenuPage(driver).getSelectOneText().contains("Mr."));
    }

    @Test
    public void oldStyleSelectMenuTest(){
        new SelectMenuPage(driver).oldStyleSelectMenu("Purple");
    }

    @Test
    public void multiSelectDropDownTest(){
        new SelectMenuPage(driver).multySelectDropDown("Green").deselect().multySelectDropDown1(new String[]{"Red", "Green", "Black"});
    }

    @Test
    public void standartMultySelect(){
        new SelectMenuPage(driver).standartMultySelect();
    }

}
