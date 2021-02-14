package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader name = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(name.readLine());

        int [] list = new int [256];

        while(fis.available()>0) {
            list[fis.read()]++;
        }

        fis.close();

        for(int i = 0; i<list.length; i++) {
            if (list[i]!=0) System.out.print(i + " ");
        }

    }
}
