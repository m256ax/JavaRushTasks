package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader name = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(name.readLine());
        FileOutputStream fos2 = new FileOutputStream(name.readLine());
        FileOutputStream fos3 = new FileOutputStream(name.readLine());

        byte[] buffer = new byte[inputStream.available()];

            int count = inputStream.read(buffer);

            if (count%2>0) {
                fos2.write(buffer, 0, count/2+1);
                fos3.write(buffer, count/2+1, count/2);
            } else {
                fos2.write(buffer, 0, count/2);
                fos3.write(buffer, count/2, count/2);
            }

        name.close();
          inputStream.close();
            fos2.close();
            fos3.close();

    }
}
