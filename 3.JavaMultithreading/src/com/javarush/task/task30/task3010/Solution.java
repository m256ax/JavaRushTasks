package com.javarush.task.task30.task3010;

/*
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        boolean isCorrect = true;
        String number = "";
        try {
            number = args[0];
        } catch (Exception e) {};

        char[] start = number.toCharArray();
        for (int i = 0; i < start.length; i++) {
            if (start[i] < 32 || start[i] > 127) {
                System.out.println("incorrect");
                isCorrect = false;
                break;
            }
        }

    if (isCorrect) {
        for (int i = 2; i < 37; i++) {
               if (calc(number, i)) {
                   System.out.println(i);
                   break;
               }
               else if (i == 36&& !calc(number, i))  System.out.println("incorrect");
            }
        }
    }

    private static boolean calc(String s, int i) {
        boolean r = false;
        try {
            new BigInteger(s, i);
            r = true;
        } catch (NumberFormatException n) {
            if (i < 37)
            calc(s, ++i);
            else return r;
        }
        return r;
    }
}
