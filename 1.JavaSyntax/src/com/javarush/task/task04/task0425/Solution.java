package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (a>0&& b>0)
        {
            System.out.println(1);
        }
        else if (a>0&&b<0)
        {
            System.out.println(4);
        }
        else if (a<0&&b>0)
        {
            System.out.println(2);
        }
        else if (a<0&&b<0)
        {
            System.out.println(3);
        }
    }
}
