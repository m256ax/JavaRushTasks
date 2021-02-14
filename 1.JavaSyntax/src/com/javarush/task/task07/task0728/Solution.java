package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/* 
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
         Arrays.sort(array);
         
        int temp = array [0];
        for (int i=0; i<array.length; i++) {
        for (int o=1; o<array.length; o++){
            if (array [o-1]<array [o]) {
                temp = array [o-1];
                array [o-1] = array [o];
                array [o] = temp;
            }
        }
        }
    }
}
