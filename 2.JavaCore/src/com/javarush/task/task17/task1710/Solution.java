package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут

         //      args = "-c Миронов м 15/04/1990".split(" ");
         //       args = "-u 1 Petrov м 01/01/1980".split(" ");
         //       args = "-d 1".split(" ");
         //       args = "-i 1".split(" ");


        String arg = args[0];
        switch (arg) {
            case "-c":
                add(args[1], args[2], args[3]);
                System.out.println(allPeople.size()-1);
                break;
            case "-u":
                ref(Integer.parseInt(args[1]), args[2],
                        args[3],
                        args[4]);
                break;
            case "-d":
                del(Integer.parseInt(args[1]));
                break;
            case "-i":
                pri(Integer.parseInt(args[1]));
                break;
        }
    }

    public static void add(String name, String sex, String birthDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        if (sex.equals("м")) {
            try {
                allPeople.add(Person.createMale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(birthDate)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else if (sex.equals("ж")) {
            try {
                allPeople.add(Person.createFemale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(birthDate)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    static void ref(int id, String name, String sex, String birthDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        if (sex.equals("м")) {
            try {
                allPeople.set(id, Person.createMale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(birthDate)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else if (sex.equals("ж")) {
            try {
                allPeople.set(id, Person.createFemale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(birthDate)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    static Person del(Integer d) {
        Person cPerson = allPeople.get(d);
        cPerson.setName(null);
        cPerson.setSex(null);
        cPerson.setBirthDate(null);
        return cPerson;
    }

    static void pri(Integer id) {
        System.out.println(allPeople.get(id).toString());
    }

}
