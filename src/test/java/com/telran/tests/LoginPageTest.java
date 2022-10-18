package com.telran.tests;

import com.telran.pages.HomePage;
import com.telran.pages.LoginPage;
import com.telran.pages.ProfilePage;
import com.telran.pages.SidePanelPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).openBookStoreApp();
        new SidePanelPage(driver).clickOnLogin();
    }

    @Test
    public void loginPositiveTest(){
        new LoginPage(driver).login("Testovic", "!q2w3e4R");
        new ProfilePage(driver).verifyUserName("Testovic").logout();
    }
}
