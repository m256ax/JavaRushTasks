package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<String>();
        list.add ("p");
        list.add ("a");
    list.add ("s");
    list.add ("s");
    list.add ("!");
    System.out.println (list.size());
    for (int i = 0; i<5; i++) {
      System.out.println (list.get (i));  
    }
    
    }
}
