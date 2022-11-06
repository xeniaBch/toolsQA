package com.telran.tests.widgets;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.widgets.ToolTipsPage;
import com.telran.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTipsTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getWidgets();
        new SidePanelPage(driver).getToolTips();
    }

    @Test
    public void hoverToolTipWithAttribute(){
        new ToolTipsPage(driver).hoverToolTipWithAttribute();
    }

    @Test
    public void textToolTipTest(){
        new ToolTipsPage(driver).findTextToolTips();
    }
}
