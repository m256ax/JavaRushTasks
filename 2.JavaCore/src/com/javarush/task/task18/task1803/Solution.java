package com.javarush.task.task18.task1803;

/* 
Самые частые байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        String name = reader.readLine();

        int [] list = new int[256];

        FileInputStream fis = new FileInputStream(name);

        while (fis.available()>0) {
            list [fis.read()]++;
        }

        fis.close();

        int max=0;

        for(int i= 0; i<list.length; i++) {
            if(list[i]>max) max=list[i];
        }


        for(int i=0; i<list.length; i++)
            if (list[i]==max)  System.out.print(i + " ");
    }
}
