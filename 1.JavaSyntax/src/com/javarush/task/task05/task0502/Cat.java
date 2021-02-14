package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int count=0;
        int anotherCount = 0;
        if (this.age>anotherCat.age)         {
            count++;
            }
        else if (this.age==anotherCat.age)
        {
            count++;
            anotherCount++;
        }
        else {
            anotherCount++;
        }

        if (this.weight>anotherCat.weight)
        {count++; }
        else if (this.weight==anotherCat.weight)
        {
            count++;
            anotherCount++;
        }
        else {
            anotherCount++;
        }
        if (this.strength>anotherCat.strength)
        {
            count++;
        }
        else if (this.strength==anotherCat.strength)
        {
            count++;
            anotherCount++;
        }
        else {
            anotherCount++;
        }
        if (count>anotherCount)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
