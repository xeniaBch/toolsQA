package com.telran.pages.forms;

import com.telran.pages.PageBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Collection;
import java.util.concurrent.CompletionService;

public class PracticeFormPage extends PageBase {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }


    public PracticeFormPage hideIframes() {
        hideAd();
        hideFooter();
        return this;
    }

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userNumber")
    WebElement userNumber;

    public PracticeFormPage enterPersonalData(String fName, String lName, String email, String phNumber) {
        type(firstName, fName);
        type(lastName, lName);
        type(userEmail, email);
        type(userNumber, phNumber);
        return this;
    }

    @FindBy (css = "[for='gender-radio-1']")
    WebElement maleButton;
  @FindBy (css = "[for='gender-radio-2']")
    WebElement femaleButton;
  @FindBy (css = "[for='gender-radio-3']")
    WebElement otherButton;
    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Male")){
            click(maleButton);
        } else if (gender.equals("Female")) {
            click(femaleButton);
        } else {
            click(otherButton);
        }
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;
    public PracticeFormPage typeOfDate(String birthDate) {
        clickWithJSExecutor(dateOfBirthInput, 0, 100);
        String os = System.getProperty("os.name");
        if (os.startsWith("Mac")){
            dateOfBirthInput.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        } else {
            dateOfBirthInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
        dateOfBirthInput.sendKeys(birthDate);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(xpath = "//input[@id='hobbies-checkbox-1']/../label\n")
    WebElement sports;
    @FindBy(xpath = "//input[@id='hobbies-checkbox-2']/../label\n")
    WebElement reading;
    @FindBy(xpath = "//input[@id='hobbies-checkbox-3']/../label\n")
    WebElement music;

    public PracticeFormPage chooseHobbies(String[] hobbies) {

        for (int i = 0; i < hobbies.length; i++) {
            if(hobbies[i].equals("Sports")){
                click(sports);
            }
            if(hobbies[i].equals("Reading")){
                click(reading);
            }
            if(hobbies[i].equals("Music")){
                click(music);
            }
        }
        return this;
    }

    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;
    public PracticeFormPage uploadFile(String photoPath) {
        uploadPicture.sendKeys(photoPath);
        return this;
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;
    public PracticeFormPage enterAddress(String address) {
        typeWithJSExecutor(currentAddress,  0, 200, address);
        return this;
    }

    @FindBy(id = "react-select-3-input")
    WebElement stateInput;

    @FindBy(id = "state")
    WebElement stateContainer;
    public PracticeFormPage inputState(String state) {
        clickWithJSExecutor(stateContainer, 0, 200);
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "react-select-4-input")
    WebElement cityInput;

    @FindBy(id = "city")
    WebElement cityContainer;

    public PracticeFormPage inputCity(String city) {
        clickWithJSExecutor(cityContainer,0, 200);
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy (id = "submit")
    WebElement submit;
    public PracticeFormPage submit() {
    clickWithRectangle(submit, 2, 3);
        return this;
    }

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement title;

    public String getTitleOfDialog() {
        return title.getText();
    }

    @FindBy(id = "closeLargeModal")
    WebElement closeButton;

    public PracticeFormPage closeSuccessDialog() {
        click(closeButton);
        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;
    public PracticeFormPage addSubject(String[] subjects) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null){
                type(subjectsInput, subjects[i]);
                subjectsInput.sendKeys(Keys.ENTER);
            }

        }
        return this;
    }

    @FindBy (css = ".react-datepicker__month-select")
    WebElement selectMonth;

    @FindBy (css = ".react-datepicker__year-select")
    WebElement selectYear;

    public PracticeFormPage chooseDate(String month, String year, String day) {
        clickWithJSExecutor(dateOfBirthInput, 0, 100);
        Select select = new Select(selectMonth);
        select.selectByVisibleText(month);
        pause(500);
        Select select1 = new Select(selectYear);
        select1.selectByVisibleText(year);
        driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[.='" + day + "']")).click();
        return this;
    }


}
