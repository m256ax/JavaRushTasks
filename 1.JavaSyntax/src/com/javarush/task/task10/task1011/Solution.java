package com.javarush.task.task10.task1011;
import java.util.*;
/* 
Большая зарплата
*/

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

    char [] list = s.toCharArray();
    
    for (int j=0; j<40; j++) {
        for (int i=j; i<list.length; i++) {
            System.out.print (list[i]);
        }
        System.out.println("");
    }
    
}

}

