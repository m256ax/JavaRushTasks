package com.javarush.task.task13.task1318;

import java.io.*;


/*
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        String name = reader.readLine();

        InputStreamReader isr = new InputStreamReader(new FileInputStream (name));
        BufferedReader fin = new BufferedReader(isr);

        String line;

        while ((line = fin.readLine())!= null) {
            System.out.println(line);
        }
        reader.close();
        isr.close();
        fin.close();
    }
}