package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
       private int age;
       private String firstName;
       private String lastName;
       private String hairColor;
       private String eyeColor;
       private boolean sex;
       
       public Human(int age) {
           this.age = age;
       }
       
       public Human(boolean sex) {
           this.sex = sex;
       }
       
       public Human(String firstName) {
           this.firstName = firstName;
       }
       
       public Human(boolean sex, String lastName) {
           this.sex = sex;
           this.lastName = lastName;
       }
       
       public Human(int age, boolean sex) {
           this.age = age;
           this.sex = sex;
       }
       
       public Human(int age, String firstName) {
           this.age = age;
           this.firstName = firstName;
       }
       
       public Human(int age, String lastName, boolean sex) {
           this.age = age;
           this.lastName = lastName;
           this.sex = sex;
       }
        
        public Human(int age, boolean sex, String firstName) {
           this.age = age;
           this.sex = sex;
           this.firstName = firstName;
       }
       
       public Human(int age, String firstName, String lastName, String hairColor, String eyeColor, boolean sex) {
           this.age = age;
           this.firstName = firstName;
           this.lastName = lastName;
           this.hairColor = hairColor;
           this.eyeColor = eyeColor;
           this.sex = sex;
       }
       
       public Human(int age, boolean sex, String lastName, String hairColor, String eyeColor) {
           this.age = age;
           this.sex = sex;
            this.lastName = lastName;
           this.hairColor = hairColor;
           this.eyeColor = eyeColor;
       }
       
    }
}
