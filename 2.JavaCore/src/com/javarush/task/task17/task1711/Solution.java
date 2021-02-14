package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        //       args = "-c Миронов м 15/04/1990 Миронов м 15/04/1990 Миронов м 15/04/1990".split(" ");
         //          args = "-u 0 Petrov ж 01/01/1980 1 Vb м 15/04/1990 0 Ivanov ж 01/01/1980".split(" ");
        //       args = "-d 1 ".split(" ");
        //       args = "-i 1 2 3".split(" ");

        switch (args[0]) {
            case "-c":
                synchronized(allPeople) {
                    for (int i = 1; i < args.length - 2; i += 3) {
                        add(args[i], args[i + 1], args[i + 2]);
                        System.out.println(allPeople.size() - 1);
                    }
                }
                    break;
                    case "-u":
                        synchronized (allPeople) {
                            for (int i = 1; i < args.length - 3; i = i + 4) {
                                System.out.println("было " + allPeople);
                                ref(Integer.parseInt(args[i]), args[i + 1], args[i + 2], args[i + 3]);
                                System.out.println("стало" + allPeople);
                            }
                        }
                            break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        del(Integer.parseInt(args[i]));
                    }
                }
                break;
                case "-i":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            pri(Integer.parseInt(args[i]));
                        }
                    }
                    break;
        }
    }

    public static void add(String name, String sex, String birthDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        if (sex.equals("м")) {
            try {
                allPeople.add(com.javarush.task.task17.task1711.Person.createMale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(birthDate)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else if (sex.equals("ж")) {
            try {
                allPeople.add(com.javarush.task.task17.task1711.Person.createFemale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(birthDate)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    static void ref(int id, String name, String sex, String birthDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        if (sex.equals("м")) {
            try {
                allPeople.set(id, com.javarush.task.task17.task1711.Person.createMale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(birthDate)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else if (sex.equals("ж")) {
            try {
                allPeople.set(id, com.javarush.task.task17.task1711.Person.createFemale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(birthDate)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    static com.javarush.task.task17.task1711.Person del(Integer d) {
        com.javarush.task.task17.task1711.Person cPerson = allPeople.get(d);
        cPerson.setName(null);
        cPerson.setSex(null);
        cPerson.setBirthDate(null);
        return cPerson;
    }

    static void pri(Integer id) {
        System.out.println(allPeople.get(id).toString());
    }

}
