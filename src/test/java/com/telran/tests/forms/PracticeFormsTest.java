package com.telran.tests.forms;

import com.telran.data.StudentData;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.forms.PracticeFormPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormsTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getForms();
        new SidePanelPage(driver).selectPracticeForm();
    }

    @Test
    public void fillStudentRegistrationFormTest(){
        new PracticeFormPage(driver).hideIframes()
                .enterPersonalData(StudentData.FIRST_NAME, StudentData.LAST_NAME, StudentData.EMAIL, StudentData.PHONE_NUMBER)
                .selectGender(StudentData.GENDER)
             //   .typeOfDate(StudentData.BIRTH_DATE)
                .chooseDate("December", "1990", "13")
                .addSubject(StudentData.SUBJECTS)
                .chooseHobbies(StudentData.HOBBIES)
                .uploadFile(StudentData.PHOTO_PATH)
                .enterAddress(StudentData.ADDRESS)
                .inputState(StudentData.STATE)
                .inputCity(StudentData.CITY)
                .submit();
        Assert.assertTrue(new PracticeFormPage(driver).getTitleOfDialog().contains("Thanks for submitting"));
    }


    @AfterMethod
    public void closeDialog(){
        new PracticeFormPage(driver).closeSuccessDialog();
    }
}
