package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        reader.close();

        FileInputStream fileInputStream1 = new FileInputStream(file1);

        byte[] buf1 = new byte[fileInputStream1.available()];
        for (int i = 0; i<buf1.length; i++) {
            buf1[i] = (byte) fileInputStream1.read();
        }
        fileInputStream1.close();

        FileInputStream fileInputStream2 = new FileInputStream(file2);

        byte[] buf2 = new byte[fileInputStream2.available()];
        for (int i = 0; i<buf2.length; i++) {
            buf2[i] = (byte) fileInputStream2.read();
        }
        fileInputStream2.close();

        FileOutputStream fileOutputStream1 = new FileOutputStream(file1);

        fileOutputStream1.write(buf2);
        fileOutputStream1.write(buf1);

        fileOutputStream1.close();
    }
}
