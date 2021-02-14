package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
    int [] array = new int [20];
    int [] first = new int [10];
    int [] second = new int [10];
    for (int i=0;i<array.length;i++){
        array [i] = Integer.parseInt(reader.readLine());
        if (i<10) {
            first [i]=array[i];
        }
        else {
            second [i-10]=array[i];
        }
    }
    for (int i=0;i<second.length;i++){
        System.out.println(second[i]);
    }

        
    }
}
