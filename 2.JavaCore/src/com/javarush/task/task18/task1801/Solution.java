package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
    FileInputStream inputStream = new FileInputStream(reader.readLine());
    int max=0;
    int i = 0;
    while (inputStream.available()>0) {
        if (max<(i=inputStream.read())) max=i;
    }
    System.out.println(max);
    inputStream.close();
    }
}
