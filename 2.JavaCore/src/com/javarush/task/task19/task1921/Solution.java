package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader file = new BufferedReader(new FileReader(args[0]));
        String line;
        String name;
        String da;
        while(!((line=file.readLine())==null)) {
            StringBuilder sB= new StringBuilder();

            String[] str = line.split("\\s");

            for(int i=0;i<str.length-3;i++) {
                sB=sB.append(str[i]).append(" ");
            }
            name=sB.toString();

            StringBuilder sD= new StringBuilder();

            for(int i=str.length-3;i<str.length;i++) {
                sD=sD.append(str[i]).append(" ");
            }
            da=sD.toString();

            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("dd MM yyyy");
            Date docDate= format.parse(da);

            PEOPLE.add(new Person(name.trim(), docDate));
        }
        file.close();

        for(Person p:PEOPLE)
            System.out.println(p.getName() + " " + p.getBirthDate());
    }
}
