package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
    strings = new ArrayList<String>();
    int max=0;
    for (int i = 0; i <5; i++) {
        strings.add (i, reader.readLine());
        if (max<=strings.get(i).length ()) {
            max=strings.get(i).length();}
    }
     for (int i = 0; i <5; i++) {
     if (max==strings.get(i).length ()) {
    System.out.println (strings.get(i));}
    }
}
}
