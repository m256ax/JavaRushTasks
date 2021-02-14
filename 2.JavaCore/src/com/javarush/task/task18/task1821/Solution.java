package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
    FileInputStream fileInputStream = new FileInputStream(args[0]);

    int [] buf = new int[256];

     while(fileInputStream.available()>0) {
             buf[fileInputStream.read()]++;
     }

     fileInputStream.close();

     for (int i = 0; i < buf.length; i++) {
         if(buf[i]!=0)
         System.out.println((char) i + " " + buf[i]);
     }

    }
}
