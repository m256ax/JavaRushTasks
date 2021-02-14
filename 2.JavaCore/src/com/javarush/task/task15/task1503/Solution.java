package com.javarush.task.task15.task1503;

/* 
ООП - машинки
*/

public class Solution {
    public static void main(String[] args) {
        new Solution.LuxuriousCar().printlnDesire();
        new Solution.CheapCar().printlnDesire();
        new Solution.Ferrari().printlnDesire();
        new Solution.Lanos().printlnDesire();
    }

    public static class Ferrari extends LuxuriousCar {
        public void printlnDesire() {
            System.out.println(new StringBuilder().append(Constants.WANT_STRING).append(Constants.FERRARI_NAME).toString());
        }
    }

    public static class Lanos extends CheapCar {
        public void printlnDesire() {
            System.out.println(new StringBuilder().append(Constants.WANT_STRING).append(Constants.LANOS_NAME).toString());
        }
    }

    public static class Constants {
        public static String WANT_STRING = "Я хочу ездить на ";
        public static String LUXURIOUS_CAR = "роскошной машине";
        public static String CHEAP_CAR = "дешевой машине";
        public static String FERRARI_NAME = "Феррари";
        public static String LANOS_NAME = "Ланосе";
    }
    
    public static class LuxuriousCar {
        void printlnDesire() {
            System.out.println(new StringBuilder().append(Constants.WANT_STRING).append(Constants.LUXURIOUS_CAR).toString());
        }
    }
    
    public static class CheapCar {
         void printlnDesire() {
             System.out.println(new StringBuilder().append(Constants.WANT_STRING).append(Constants.CHEAP_CAR).toString());
        }
    }
    
}
