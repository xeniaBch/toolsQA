package com.telran.tests.bookStore;

import com.telran.data.BookData;
import com.telran.data.UserData;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.bookStore.BookStorePage;
import com.telran.pages.bookStore.LoginPage;
import com.telran.pages.bookStore.ProfilePage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookStoreSmokeTest extends TestBase {
    @BeforeMethod

    public void ensurePrecondition(){
        new HomePage(driver).openBookStoreApp();
        new SidePanelPage(driver).clickOnLogin();
        new LoginPage(driver).login(UserData.USER_NAME, UserData.PASSWORD);
    }

    @Test
    public void addBookToCollectionTest() throws InterruptedException {
        new BookStorePage(driver).searchBook(BookData.BOOK_NAME).clickOnFirstBook().addToYourCollection();
        new SidePanelPage(driver).selectProfile();
        Assert.assertTrue(new BookStorePage(driver).takeNameofBook().contains("Git"));
    }

    @AfterMethod
    public void deleteBook() throws InterruptedException {
        new ProfilePage(driver).deleteBook();
    }
}
