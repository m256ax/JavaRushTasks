package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Set;
import java.util.*;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        Set<Cat> result = new HashSet<Cat>();

        Cat murzik = new Cat ();
        Cat vaska = new Cat ();
        Cat tigr = new Cat ();
        Cat tiger = new Cat ();

        result.add(murzik);
        result.add(vaska);
        result.add(tigr);
        result.add(tiger);

        return result;
    }

    public static Set<Dog> createDogs() {
        Set<Dog> result = new HashSet<Dog>();

        Dog murzik1 = new Dog ();
        Dog vaska1 = new Dog ();
        Dog tigr1 = new Dog ();

        result.add(murzik1);
        result.add(vaska1);
        result.add(tigr1);

        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        Set<Object> join= new HashSet<>();
            join.addAll(cats);
            join.addAll(dogs);

        return join;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
         pets.removeAll(cats);
    }

    public static void printPets(Set<Object> pets) {
        for (Object t: pets) {
            System.out.println(t);
        }
    }

    public static class Cat {
    }

    public static class Dog {
    }
}
