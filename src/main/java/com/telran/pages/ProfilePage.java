package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.AuthProvider;

public class ProfilePage extends PageBase{
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
}
