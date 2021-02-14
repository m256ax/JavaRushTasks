package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human ann = new Human ("Аня", false, 61);
        Human angel = new Human ("Аня1", false, 58);
        Human did = new Human ("Аня2", true, 70);
        Human did2 = new Human ("Аня3", true, 62);
        Human man = new Human ("Ваня", true, 41, did, ann);
        Human woman = new Human ("Петя", false, 39, did2, angel);
        Human kid = new Human ("Женя", true, 2, man, woman);
        Human kid2 = new Human ("Саня", true, 4, man, woman);
        Human kid3 = new Human ("Иван", true, 56, man, woman);

         System.out.println (ann.toString());
         System.out.println (angel.toString());
         System.out.println (did.toString());
         System.out.println (did2.toString());
         System.out.println (man.toString());
         System.out.println (woman.toString());
         System.out.println (kid.toString());
         System.out.println (kid2.toString());
         System.out.println (kid3.toString());

    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;
        
        public Human (String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        
        public Human (String name, boolean sex, int age, Human father, Human mother) {
            this (name, sex, age);
            this.father = father;
            this.mother = mother;
        }
        
        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}