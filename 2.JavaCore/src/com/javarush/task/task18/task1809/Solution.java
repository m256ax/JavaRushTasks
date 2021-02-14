package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());

        Stack <Byte> stack = new Stack<>();

        while (inputStream.available()>0) stack.push((byte) inputStream.read());
        while (!stack.empty()) outputStream.write(stack.pop());

        reader.close();
        inputStream.close();
        outputStream.close();

    }
}
