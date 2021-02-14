package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt (reader.readLine());
        int b = Integer.parseInt (reader.readLine());
        int c = Integer.parseInt (reader.readLine());
        int d = Integer.parseInt (reader.readLine());
        int e = Integer.parseInt (reader.readLine());
        int temp = 0;
        for (int i=1; i<=4;i++){
            if (a>b){
                temp = a;
                a= b;
                b= temp;
            }
            if (b>c){
                temp = b;
                b= c;
                c= temp;
            }
            if (c>d){
                temp = c;
                c= d;
                d= temp;
            }
            if (d>e){
                temp = d;
                d= e;
                e= temp;
            }
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        }
    }
