package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) {
    ArrayList<String> mama = new ArrayList <String>();
    mama.add ("мама");
    mama.add("мыла");
    mama.add("раму");
    mama.add(1, "именно");
    mama.add(3, "именно");
    mama.add(5, "именно");
    for (String i:mama) {
        System.out.println (i);
    }
}
}
