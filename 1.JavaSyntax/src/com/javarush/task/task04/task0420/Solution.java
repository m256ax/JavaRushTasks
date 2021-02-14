package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int z = Math.max(a, Math.max(b,c));
        int x = Math.min (a, Math.min(b,c));
            int y = (a+b+c) - (x+z);
            System.out.println(z + " " + y + " " + x);

    }
}
