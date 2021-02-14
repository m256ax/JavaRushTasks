package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.nextLine();
        String name2 = scanner.nextLine();
        int result1 = name1.length();
        int result2 = name2.length();

        if (name1.equals(name2)) {
            System.out.println("Имена идентичны");
        }
        if (!name1.equals(name2)&&result1 == result2) {
            System.out.println("Длины имен равны");
        }

    }
}
