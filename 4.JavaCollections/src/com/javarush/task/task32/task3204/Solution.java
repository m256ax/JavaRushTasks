package com.javarush.task.task32.task3204;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        byte[] result = new byte[8];
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            if (i % 3 == 0) {
                result[i] = ((byte) (random.nextInt(57 - 48) + 48));
            } else if (i % 2 == 0) {
                result[i] = ((byte) (random.nextInt(90 - 65) + 65));
            } else {
                result[i] = ((byte) (random.nextInt(122 - 97) + 97));
            }
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(result);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedInputStream bis = new BufferedInputStream(byteArrayInputStream);
        while (true) {
            try {
                if (!(bis.available() > 0)) break;
            int data = bis.read();
            byteArrayOutputStream.write(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return byteArrayOutputStream;
    }
}
