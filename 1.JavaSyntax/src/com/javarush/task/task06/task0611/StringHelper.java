package com.javarush.task.task06.task0611;

/* 
Класс StringHelper
*/

public class StringHelper {
    public static String multiply(String s) {
        String result = "";
        for (int a=1; a<=5; a++){
            result=result+s;
        }
        System.out.print(result);
        return result;
    }

    public static String multiply(String s, int count) {
        String result = "";
        for (int a=1; a<=count; a++){
            result=result+s;
        }
        System.out.print(result);
        return result;
    }

    public static void main(String[] args) {

    }
}
