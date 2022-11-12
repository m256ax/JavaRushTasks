package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        Long number = Long.parseLong(args[1]);
        byte[] text = args[2].getBytes();

        RandomAccessFile raf = new RandomAccessFile(fileName, "w");
        if (number > raf.length()) {
            raf.seek(raf.length());
        } else {
            raf.seek(number);
        }
        raf.write(text);

        raf.close();
    }
}
