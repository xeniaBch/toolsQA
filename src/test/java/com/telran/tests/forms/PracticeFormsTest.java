package com.telran.tests.forms;

import com.telran.data.StudentData;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.forms.PracticeFormPage;
import com.telran.tests.TestBase;
import com.telran.utils.DataProviders;
import com.telran.utils.model.Student;
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

    @Test(dataProvider = "newStudent", dataProviderClass = DataProviders.class, priority = 2)
    public void fillStudentRegistrationFormTestWithDataProvider(String firstName, String lastName, String email, String phone, String path, String address, String day, String month, String year){
        new PracticeFormPage(driver).hideIframes()
                .enterPersonalData(firstName, lastName, email, phone)
                .selectGender(StudentData.GENDER)
                .chooseDate(month, year, day)
                .addSubject(StudentData.SUBJECTS)
                .chooseHobbies(StudentData.HOBBIES)
                .uploadFile(path)
                .enterAddress(address)
                .inputState(StudentData.STATE)
                .inputCity(StudentData.CITY)
                .submit();
        Assert.assertTrue(new PracticeFormPage(driver).getTitleOfDialog().contains("Thanks for submitting"));
    }

    @Test(dataProvider = "newStudentWithCsv", dataProviderClass = DataProviders.class, priority = 2)
    public void fillStudentRegistrationFormTestWithCsv(Student student){
        new PracticeFormPage(driver).hideIframes()
                .enterPersonalData(student.getFirtsname(), student.getLastname(), student.getEmail(), student.getPhone())
                .selectGender(StudentData.GENDER)
                .chooseDate(student.getMonth(), student.getYear(), student.getDay())
                .addSubject(StudentData.SUBJECTS)
                .chooseHobbies(StudentData.HOBBIES)
                .uploadFile(student.getPath())
                .enterAddress(student.getAddress())
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
