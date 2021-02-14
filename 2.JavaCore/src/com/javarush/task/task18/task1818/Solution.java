package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileOut = reader.readLine();
        String fileIn1 = reader.readLine();
        String fileIn2 = reader.readLine();

        reader.close();

        FileOutputStream fileOutputStream = new FileOutputStream(fileOut, true);
        FileInputStream fileInputStream1 = new FileInputStream(fileIn1);
        FileInputStream fileInputStream2 = new FileInputStream(fileIn2);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream1);
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream2);

        while (bufferedInputStream.available()>0) {
            fileOutputStream.write(bufferedInputStream.read());
        }
        fileInputStream1.close();

        while (bufferedInputStream2.available()>0) {
            fileOutputStream.write(bufferedInputStream2.read());
        }

        fileInputStream2.close();
        fileOutputStream.close();

    }

}
