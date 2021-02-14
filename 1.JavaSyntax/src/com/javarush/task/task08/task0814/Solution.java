package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.*;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        Random rand = new Random (4700);
        Set <Integer> set = new HashSet <Integer> ();
        while (set.size()<20) {
        set.add(rand.nextInt(3000));
        }
        return set;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        Iterator <Integer> setInterator = set.iterator();
        while (setInterator.hasNext()) {
            Integer setNext = setInterator.next();
            if (setNext>10)
            setInterator.remove ();
        }
        return set;
    }

    public static void main(String[] args) {
    }
}
