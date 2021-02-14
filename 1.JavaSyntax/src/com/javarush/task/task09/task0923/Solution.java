package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
         BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        String s = reader.readLine();
        ArrayList<Character> vowel = new ArrayList <Character> ();
        ArrayList<Character> noVowel = new ArrayList <Character> ();;
        char [] mas = s.toCharArray();
         for (int i = 0; i< mas.length; i++)
         {
             if (Character.isWhitespace (mas[i]))
             {
                 continue;
             }
             else if (isVowel(mas[i]))
             {
                 vowel.add(mas[i]);
             }
             else {
                 noVowel.add(mas[i]);
         }
         }
         
         print (vowel);
         
         print (noVowel);
    }

    public static void print (ArrayList <Character> list) {
        for (char c : list) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}