package com.telran.pages.elements;


import com.telran.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LinksPage extends PageBase {
    public LinksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "simpleLink")
    WebElement simpleLink;
    public LinksPage selectSimpleLink() {
        click(simpleLink);
        return this;
    }

    public String newTabURL() {
        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs .get(1));
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    @FindBy(id = "dynamicLink")
    WebElement dynamicLink;
    public LinksPage selectDynamicLink() {
        click(dynamicLink);
        return this;
    }

    @FindBy(id = "created")
    WebElement created;
    public LinksPage selectCreatedLink() {
        click(created);
        return this;
    }

    @FindBy(id = "linkResponse")
    WebElement linkResponse;
    public String getResponseCode() {
        return linkResponse.getText();
    }

    @FindBy (id = "no-content")
    WebElement noContent;
    public LinksPage selectNoContentLink() {
        click(noContent);
        return this;
    }

    @FindBy (id = "moved")
    WebElement moved;
    public LinksPage selectMovedLink() {
        click(moved);
        return this;
    }


    @FindBy (id = "bad-request")
    WebElement badRequest;
    public LinksPage selectBadRequestLink() {
        pause(1000);
        click(badRequest);
        return this;
    }

    @FindBy (id = "unauthorized")
    WebElement unauthorized;
    public LinksPage selectUnauthorizedLink() {
        click(unauthorized);
        return this;
    }


    @FindBy (id = "forbidden")
    WebElement forbidden;
    public LinksPage selectForbiddenLink() {
        clickWithJSExecutor(forbidden, 0, 100);
        return this;
    }

    @FindBy (id = "invalid-url")
    WebElement invalidUrl;
    public LinksPage selectNotFoundLink() {
        clickWithJSExecutor(invalidUrl, 0, 100);
        return this;
    }
}
