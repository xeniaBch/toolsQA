package com.telran.pages.bookStore;

import com.telran.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStorePage extends PageBase {
    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "searchBox")
    WebElement searchBox;

    public BookStorePage searchBook(String text) {
        type(searchBox, text);
        return this;
    }

    @FindBy(xpath = "//span[@class='mr-2']/a")
    WebElement nameOfBook;
    public String takeNameofBook() {
        return nameOfBook.getText();
    }

    @FindBy(css = ".rt-tr-group:nth-child(1) .rt-td:nth-child(2)")
    WebElement emptyField;

    public String verifyEmptyField() {
        return emptyField.getText();
    }

    public BookStorePage clickOnFirstBook() {
        click(nameOfBook);
        return this;
    }

    @FindBy(css = ".text-right.fullButton")
    WebElement addToColectionButton;
    public BookStorePage addToYourCollection() throws InterruptedException {
        clickWithJSExecutor(addToColectionButton, 0, 300);
        wait(1000);
        driver.switchTo().alert().accept();
        wait(1000);
        return this;
    }
}
