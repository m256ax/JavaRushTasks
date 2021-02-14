package com.javarush.task.task01.task0129;

/* 
Считаем длину окружности
*/
import java.lang.Math;
public class Solution {
    public static void main(String[] args) {
        printCircleLength(5);
    }

    public static void printCircleLength(int radius) {
       
       System.out.println (2*Math.PI*radius); //напишите тут ваш код
    }
}