package com.telran.pages.bookStore;

import com.telran.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProfilePage extends PageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName-value")
    WebElement username;

    @FindBy(id = "submit")
    WebElement logoutButton;
    public ProfilePage verifyUserName(String uName) {
        if (username.getText().equalsIgnoreCase(uName)){
            System.out.println("Correct username is " + uName);
        } else {
            System.out.println("Incorrect");

        }

        return this;
    }

    public LoginPage logout() {
        click(logoutButton);
        return new LoginPage(driver);
    }

    @FindBy(id = "delete-recorde-undefined")
    List<WebElement> bookList;

    @FindBy(id = "closeSmallModal-ok")
    WebElement okButton;
    public ProfilePage deleteBook() throws InterruptedException {
        bookList.get(0).click();
        wait(1000);
        click(okButton);
        wait(1000);
        driver.switchTo().alert().accept();
        return this;
    }
}
