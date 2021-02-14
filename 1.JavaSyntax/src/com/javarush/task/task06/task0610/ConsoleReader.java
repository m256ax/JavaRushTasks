package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
       BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
       String s = reader.readLine();
        return s;
    }

    public static int readInt() throws Exception {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        String iI = reader.readLine();
        int i = Integer.parseInt(iI);
        return i;
    }

    public static double readDouble() throws Exception {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        String dD = reader.readLine();
        double d = Double.parseDouble(dD);
        return d;

    }

    public static boolean readBoolean() throws Exception {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        String bB = reader.readLine();
        boolean b = Boolean.parseBoolean(bB);
        return b;

    }

    public static void main(String[] args) throws Exception {

    }
}
