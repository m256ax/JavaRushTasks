package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
    int [] digital = new int [10];
    String [] line = new String [10];
    for (int i=0;i<line.length;i++){
        line [i] = reader.readLine();
        digital [i] = line[i].length();
        System.out.println (digital[i]);
    }
    }
}
