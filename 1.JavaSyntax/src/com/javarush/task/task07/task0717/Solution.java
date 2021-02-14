package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
    ArrayList <String> list = new ArrayList <String> ();
    for (int i=0; i<10; i++) {
        list.add(reader.readLine());
    }
    
        ArrayList<String> result = doubleValues(list);

        for (String i: result) {
        System.out.println (i);
    }
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        ArrayList<String> doubleValues = new ArrayList<String> ();
        for (int i=0; i< list.size(); i++){
            doubleValues.add (i*2, list.get(i));
            doubleValues.add (i*2+1, list.get(i));
        }
        return doubleValues;
    }
}
