package com.telran.pages.elements;

import com.telran.pages.PageBase;
import com.telran.pages.bookStore.BookStorePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class BrokenLinksImagesPage extends PageBase {
    public BrokenLinksImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (tagName = "a")
    List<WebElement> linkList;
    public BrokenLinksImagesPage checkAllLinks() {
        hideAd();
        hideFooter();
        System.out.println("Total number of links on page " + linkList.size());
        String url = "";
        Iterator<WebElement> iterator = linkList.iterator();
        while(iterator.hasNext()){
            url = iterator.next().getText();
            System.out.println(url);
        }
        return this;
    }

    public BrokenLinksImagesPage checkBrokenLinks() {
        for (int i = 0; i < linkList.size(); i++) {
            WebElement element = linkList.get(i);
            String attribute = element.getAttribute("href");
            verifyLinks(attribute);
        }
        return this;
    }

    @FindBy (tagName = "src")
    List<WebElement> imageList;
    public BrokenLinksImagesPage checkBrokenImages() {
        for (int i = 0; i < imageList.size(); i++) {
            WebElement image = imageList.get(i);
            String imageUrl = image.getAttribute("src");
            System.out.println("URL of image " + (i + 1) + "is" + imageUrl);
            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return(typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth > 0);", image);
                if(imageDisplayed){
                    System.out.println("DISPLAY - OK");
                } else {
                    System.out.println("DISPLAY - BROKEN");
                }
            } catch (Exception e) {
                System.out.println("Error exception");
            }
        }
        return this;
    }
}
