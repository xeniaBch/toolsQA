package com.telran.utils;

import com.telran.utils.model.Student;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> newStudent() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Nevil", "Dolgopups","nevil.d@hogwarts.com", "015239655336", "C:/tools/greece.jpg", "Griffindor", "14", "May", "2004"});
        list.add(new Object[]{"Ron", "Whisley", "ron.w@hogwarts.com", "015212368321", "C:/tools/greece.jpg", "Griffindor", "16", "June", "2004"});
        return list.iterator();
}

    @DataProvider
    public Iterator<Object[]> newStudentWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/students.csv")));
        String line = reader.readLine();
        while (line!=null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Student()
                    .setFirtsname(split[0])
                    .setLastname(split[1])
                    .setEmail(split[2])
                    .setPhone(split[3])
                    .setPath(split[4])
                    .setAddress(split[5])
                    .setDay(split[6])
                    .setMonth(split[7])
                    .setYear(split[8])});
            line = reader.readLine();
        }
        return list.iterator();
    }}

