package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static <string> void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nA = reader.readLine();

        int a = Integer.parseInt(nA);
        int z = nA.length();
        String n = "", s = "";


        if (a>=1&&a<=999)
        {
            if (a % 2 == 0) {
                n = "четное";
            } else {
                n = "нечетное";
            }

            if (z== 3) {
                s = "трехзначное";
            } else if (z == 2) {
                s = "двузначное";
            } else if (z == 1) {
                s = "однозначное";
            }
            System.out.println(n + " " + s + " число");
        }
         }
}






