package com.javarush.task.task10.task1020;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[30];
        for (int i = 0; i < 30; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);
       
        System.out.println(array[9]);
        System.out.println(array[10]);
    }

    public static void sort(int[] array) {
    for (int j= 0; j < array.length; j++) {
        int temp = 0;
        for (int i = 1; i < array.length; i++) {
            if (array [i-1]>array[i]) {
                temp = array [i];
                array[i]= array[i-1];
                array[i-1]= temp;
            }
        }
    }
    }
}
