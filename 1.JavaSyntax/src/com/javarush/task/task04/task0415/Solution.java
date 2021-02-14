package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
     Scanner in = new Scanner (System.in);
    int a = in.nextInt ();
    int b = in.nextInt ();
    int c = in.nextInt ();
    
    if (a < (b + c) && b < (c + a) && c < (a + b))
    {
        System.out.print ("Треугольник существует.");
    }
        else
        {
            System.out.print ("Треугольник не существует.");
        }

    }
}