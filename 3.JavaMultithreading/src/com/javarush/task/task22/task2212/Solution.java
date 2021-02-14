package com.javarush.task.task22.task2212;

import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        boolean check = false;
        if(telNumber==null||telNumber.length()==0) return check;
        if (telNumber.charAt(0)=='+') {
            String regex12 ="\\+\\d{2}\\(?\\d{3}\\)?\\-?\\d{3}\\-?\\d{2}\\-?\\d{2}";
            if(Pattern.matches(regex12, telNumber)) check=true;
        } else {
            String regex10 ="\\(?\\d{3}\\)?\\-?\\d{3}\\-?\\d{2}\\-?\\d{2}";
            if(Pattern.matches(regex10, telNumber)) check=true;
        }
        return check;
    }

    public static void main(String[] args) {
//        System.out.println(checkTelNumber("+380501234567"));
//        System.out.println(checkTelNumber("+38(050)123-45-67"));
//        System.out.println(checkTelNumber("+38050123-45-67"));
//        System.out.println(checkTelNumber("050123-4567"));
//        System.out.println(checkTelNumber("+38)050(1234567"));
//        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
//        System.out.println(checkTelNumber("050ххх4567"));
//        System.out.println(checkTelNumber("050123456"));
//        System.out.println(checkTelNumber("(0)501234567"));
    }
}
