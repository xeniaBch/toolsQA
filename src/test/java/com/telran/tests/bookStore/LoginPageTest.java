package com.telran.tests.bookStore;

import com.telran.data.UserData;
import com.telran.pages.*;
import com.telran.pages.bookStore.LoginPage;
import com.telran.pages.bookStore.ProfilePage;
import com.telran.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).openBookStoreApp();
        new SidePanelPage(driver).clickOnLogin();
    }

    @Test (enabled = false)
    public void loginPositiveTest(){
        new LoginPage(driver).login(UserData.USER_NAME, UserData.PASSWORD);
        new ProfilePage(driver).verifyUserName(UserData.USER_NAME).logout();
    }

    @Test
    @Parameters ({"username", "password"})
    public void loginPositiveParametersTest(String username, String password){
        new LoginPage(driver).login(username, password);
        new ProfilePage(driver).verifyUserName(username).logout();
    }
}
