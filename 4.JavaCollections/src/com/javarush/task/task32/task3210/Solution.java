package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        Long number = Long.parseLong(args[1]);
        byte[] text = args[2].getBytes();

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

        String res = "true";

        byte[] boo = new byte[text.length];
raf.seek(number);
        raf.read(boo, 0, text.length);

            String q = new String(boo, StandardCharsets.UTF_8);
        if (!q.equals(args[2])) {
            res = "false";
        }


        raf.seek(raf.length());
        raf.write(res.getBytes());

        raf.close();
    }
}
