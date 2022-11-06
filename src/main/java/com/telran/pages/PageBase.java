package com.telran.pages;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class PageBase {

   public WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element){
        element.click();
    }

    public void type(WebElement element, String text){
        if(text != null){
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void clickWithJSExecutor(WebElement element, int x, int y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        click(element);
    }

    public void typeWithJSExecutor(WebElement element, int x, int y, String text){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if(text != null){
            clickWithJSExecutor(element, x, y);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void takeScreenshot(String pathToFile){
        File tmp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(pathToFile);
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void hideAd(){
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("document.getElementById('adplus-anchor').style.display = 'none'");
    }


    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void hideFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display = 'none'");
    }

    public void clickWithRectangle(WebElement element, int i, int j){
        Rectangle rectangle = element.getRect();
        int offsetX = rectangle.getWidth()/i;
        int offsetY = rectangle.getHeight()/j;
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.moveByOffset(-offsetX, -offsetY).click().perform();
    }

    public void verifyLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() >= 400) {
                System.out.println(linkUrl + "-" + httpURLConnection.getResponseMessage() + " is broken link");
            } else {
                System.out.println(linkUrl + "-" + httpURLConnection.getResponseMessage());
            }
        }
        catch (Exception e){
            System.out.println(linkUrl + "- " + e.getMessage() + " is broken link");
        }
    }
}
