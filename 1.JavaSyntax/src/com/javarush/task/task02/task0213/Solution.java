package com.javarush.task.task02.task0213;

/* 
Питомцам нужны люди
*/
public class Solution {
    public static void main(String[] args) {
    Woman woman = new Woman ();
    Cat cat = new Cat ();
    Dog dog = new Dog ();
    Fish fish = new Fish ();
    cat.owner = woman;
    dog.owner = woman;
    fish.owner = woman;
    }

    public static class Cat {
        public Woman owner;
    }

    public static class Dog {
        public Woman owner;
    }

    public static class Fish {
        public Woman owner;
    }

    public static class Woman {
    }
}
