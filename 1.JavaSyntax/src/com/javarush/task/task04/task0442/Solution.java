package com.javarush.task.task04.task0442;

/* 
Суммирование
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int c=0;
        int o=0;
        while(true) {

            int a = in.nextInt();
            c += a;
            if (a==-1)
            {
                break;
            }
        }
        System.out.println(c);
    }
    }

