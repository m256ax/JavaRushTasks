package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream (args[0]);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        List<Byte> arr = new ArrayList<>();

        while (bufferedInputStream.available()>0) {
            arr.add((byte)bufferedInputStream.read());
        }
        int countWhiteSpace = 0;

        for (byte dig: arr ) {
            if(dig == 32) {
                countWhiteSpace++;
            }
        }

        fileInputStream.close();
        bufferedInputStream.close();
        System.out.printf("%.2f%n", 1.0*countWhiteSpace/arr.size()*100.0);
    }
}
