package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.List;
import java.util.*;


/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        Human son1 = new Human("Son1", true, 40);
        Human son2 = new Human("Son2", true, 35);
        Human daughter = new Human ("Douter", false, 30);
        Human father = new Human("Papa", true, 65, son1, son2, daughter);
        Human mother = new Human("Mother", false, 60, son1, son2, daughter);
        Human grandPa1 = new Human("Ded1", true, 99, father);
        Human grandPa2 = new Human("Ded2", true, 89, mother);
        Human grandMa1 = new Human("Baba1", false, 90, father);
        Human grandMa2 = new Human("Baba2", false, 80, mother);

        ArrayList <Human> all = new ArrayList<Human>(Arrays.asList(grandPa1, grandPa2, grandMa1, grandMa2, father, mother, son1, son2, daughter));

        for (Human person : all) {
            System.out.println(person);
        }
    }

    public static class Human {
    String name;
    boolean sex;
    int age;
    List <Human> children= new ArrayList<>();

        public  Human (String name, boolean sex, int age, Human ... human) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children.addAll(children);
        }



        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
