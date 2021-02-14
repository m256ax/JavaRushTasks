package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] bild = new int [15];
        int even = 0;
        int odd = 0;
        for (int i=0;i<bild.length;i++)
            bild[i] = Integer.parseInt(reader.readLine());
        for (int i=0;i<bild.length;i++) {
            if (i%2!=0) {
                even+=bild[i];
            }
            else {
                odd+=bild[i];
            }
        }
        if (even+bild[0]>odd){
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }
        else {
            System.out.println( "В домах с нечетными номерами проживает больше жителей.");
        }
    }
}
