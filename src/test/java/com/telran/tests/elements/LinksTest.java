package com.telran.tests.elements;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.LinksPage;
import com.telran.tests.TestBase;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collection;

public class LinksTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getElements();
        new SidePanelPage(driver).selectLinks();
    }


    @Test
    public void checkSimpleLinkTest(){
        new LinksPage(driver).selectSimpleLink();
        Assert.assertTrue(new LinksPage(driver).newTabURL().contains("https://demoqa.com"));
    }

    @Test
    public void checkDynamicLinkTest(){
        new LinksPage(driver).selectDynamicLink();
        Assert.assertTrue(new LinksPage(driver).newTabURL().contains("https://demoqa.com"));
    }

    @Test
    public void checkCreatedCodeTest(){
        new LinksPage(driver).selectCreatedLink();
        Assert.assertTrue(new LinksPage(driver).getResponseCode().contains("201"));
        Assert.assertTrue(new LinksPage(driver).getResponseCode().contains("Created"));
    }


    @Test
    public void checkNoContentCodeTest(){
        new LinksPage(driver).selectNoContentLink();
        Assert.assertTrue(new LinksPage(driver).getResponseCode().contains("204"));
        Assert.assertTrue(new LinksPage(driver).getResponseCode().contains("No Content"));
    }

    @Test
    public void checkMovedCodeTest(){
        new LinksPage(driver).selectMovedLink();
        Assert.assertTrue(new LinksPage(driver).getResponseCode().contains("301"));
        Assert.assertTrue(new LinksPage(driver).getResponseCode().contains("Moved Permanently"));
    }

    @Test
    public void checkBadRequestCodeTest(){
        new LinksPage(driver).selectBadRequestLink();
        Assert.assertTrue(new LinksPage(driver).getResponseCode().contains("400"));
        Assert.assertTrue(new LinksPage(driver).getResponseCode().contains("Bad Request"));
    }

    @Test
    public void checkUnauthorizedCodeTest(){
        new LinksPage(driver).selectUnauthorizedLink();
        Assert.assertTrue(new LinksPage(driver).getResponseCode().contains("401"));
        Assert.assertTrue(new LinksPage(driver).getResponseCode().contains("Unauthorized"));
    }

    @Test
    public void checkForbiddenCodeTest(){
        new LinksPage(driver).selectForbiddenLink();
        Assert.assertTrue(new LinksPage(driver).getResponseCode().contains("403"));
        Assert.assertTrue(new LinksPage(driver).getResponseCode().contains("Forbidden"));
    }

    @Test
    public void checkNotFoundCodeTest(){
        new LinksPage(driver).selectNotFoundLink();
        Assert.assertTrue(new LinksPage(driver).getResponseCode().contains("404"));
        Assert.assertTrue(new LinksPage(driver).getResponseCode().contains("Not Found"));
    }
}
