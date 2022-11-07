package com.telran.pages;

import com.telran.pages.allertsFrameWindows.AlertsPage;
import com.telran.pages.allertsFrameWindows.FramesPage;
import com.telran.pages.allertsFrameWindows.NestedFramesPage;
import com.telran.pages.allertsFrameWindows.WindowsPage;
import com.telran.pages.bookStore.LoginPage;
import com.telran.pages.bookStore.ProfilePage;
import com.telran.pages.elements.*;
import com.telran.pages.forms.PracticeFormPage;
import com.telran.pages.interactions.DragAndDropPage;
import com.telran.pages.widgets.MenuPage;
import com.telran.pages.widgets.SelectMenuPage;
import com.telran.pages.widgets.ToolTipsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanelPage extends PageBase{
    public SidePanelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login")
    WebElement loginButton;
    public LoginPage clickOnLogin() {
        click(loginButton);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;
    public AlertsPage selectAlerts() {
        clickWithJSExecutor(alerts, 0, 300);
        return new AlertsPage(driver);
    }

    @FindBy (css = ".show #item-3")
    WebElement profile;
    public ProfilePage selectProfile() {
        clickWithJSExecutor(profile, 0, 500);
        return new ProfilePage(driver);
    }

    @FindBy(css = ".show #item-0")
    WebElement windows;
    public WindowsPage selectWindows() {
        clickWithJSExecutor(windows, 0, 100);
        return new WindowsPage(driver);
    }

    @FindBy(xpath = "//span[.='Frames']")
    WebElement frames;
    public FramesPage selectFrames() {
        clickWithJSExecutor(frames, 0, 200);
        return new FramesPage(driver);
    }

    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedFrames;
    public NestedFramesPage selectNestedFrames() {
        clickWithJSExecutor(nestedFrames, 0, 300);
        return new NestedFramesPage(driver);
    }

    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttons;
    public ButtonsPage selectButtons() {
        clickWithJSExecutor(buttons, 0, 500);
        return new ButtonsPage(driver);
    }


    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;
    public SelectMenuPage getSelectMenu() {
        clickWithJSExecutor(selectMenu, 0 ,500);
        return new SelectMenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Droppable']")
    WebElement droppable;
    public DragAndDropPage selectDropable() {
        clickWithJSExecutor(droppable, 0, 500);
        return new DragAndDropPage(driver);
    }

    @FindBy(xpath = "//span[.='Text Box']")
    WebElement textBox;
    public TextBoxPage selectTextBox() {
        click(textBox);
        return new TextBoxPage(driver);
    }

    @FindBy(xpath = "//span[.='Menu']")
    WebElement menu;
    public MenuPage getMenu() {
        clickWithJSExecutor(menu, 0, 500);
        return new MenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceForm;
    public PracticeFormPage selectPracticeForm() {
        click(practiceForm);
        return new PracticeFormPage(driver);
    }

    @FindBy(xpath = "//span[.='Tool Tips']")
    WebElement toolTips;

    public ToolTipsPage getToolTips() {
        clickWithJSExecutor(toolTips,0,500);
        return new ToolTipsPage(driver);
    }

    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement brokenListImages;
    public BrokenLinksImagesPage selectBrokenLinksImages() {
        clickWithJSExecutor(brokenListImages, 0, 400);
        return new BrokenLinksImagesPage(driver);
    }


    @FindBy(xpath = "//span[.='Links']")
    WebElement links;
    public LinksPage selectLinks() {
        clickWithJSExecutor(links,0, 400);
        return new LinksPage(driver);
    }


    @FindBy(xpath = "//span[.='Upload and Download']")
    WebElement upload;
    public UploadAndDownloadPage selectUploadAndDownload() {
        clickWithJSExecutor(upload, 0, 400);
        return new UploadAndDownloadPage(driver);
    }
}
