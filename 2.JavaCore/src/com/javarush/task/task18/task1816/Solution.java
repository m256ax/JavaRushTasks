package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        BufferedInputStream bis = new BufferedInputStream(fis);
        int count=0;
        List <Byte> arr = new ArrayList<>();

        while (bis.available()>0) {
            arr.add((byte) bis.read());
        }

        for (byte dig:arr) {
            if (dig >= 65 && dig <= 90 || dig >= 97 && dig <= 122) {
                count++;
            }
        }
        fis.close();
        bis.close();
            System.out.println(count);
    }
}
