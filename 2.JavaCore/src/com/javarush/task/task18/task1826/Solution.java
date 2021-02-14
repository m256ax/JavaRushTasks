package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args[0].equals("-e")) cript(args[1], args[2]);
        if (args[0].equals("-d")) deCript(args[1], args[2]);
    }

    static void cript(String filename, String fileOutPutName) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader reader = new BufferedReader (new InputStreamReader(new FileInputStream(filename)));
        while (reader.ready()) stack.push(reader.read());
        reader.close();
        FileOutputStream fileOutputStream = new FileOutputStream(fileOutPutName);

        while(!stack.empty()) fileOutputStream.write(stack.pop());
        fileOutputStream.close();
    }


    static void deCript(String filename, String fileOutPutName) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader reader = new BufferedReader (new InputStreamReader(new FileInputStream(filename)));
        while (reader.ready()) stack.push(reader.read());
        reader.close();
        FileOutputStream fileOutputStream = new FileOutputStream(fileOutPutName);

        while(!stack.empty()) fileOutputStream.write(stack.pop());
        fileOutputStream.close();
    }
}