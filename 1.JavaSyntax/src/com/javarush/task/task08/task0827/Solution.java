package com.javarush.task.task08.task0827;

import java.util.Date;
import java.util.Locale;
import java.text.*;
/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
            Date date1 = new Date(Date.parse(date));
            SimpleDateFormat day = new SimpleDateFormat("D");
            int n = Integer.parseInt(day.format(date1));
        return (n%2)!=0? true:false;
    }
}
