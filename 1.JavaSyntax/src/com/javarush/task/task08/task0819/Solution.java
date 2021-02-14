package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        cats.remove(cats.iterator().next());

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        Set <Cat> set = new HashSet<> ();
        Cat murzik = new Cat ();
        Cat vaska = new Cat ();
        Cat tigr = new Cat ();

        set.add(murzik);
        set.add(vaska);
        set.add(tigr);

        return set;
    }

    public static void printCats(Set<Cat> cats) {
    for (Cat t: cats) {
        System.out.println(t);
    }
    }

    public static class Cat {
    }
}
