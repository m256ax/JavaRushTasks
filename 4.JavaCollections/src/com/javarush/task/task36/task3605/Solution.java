package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.TreeSet;

/* 
Использование TreeSet

Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортируй буквы по алфавиту и выведи на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то выведи их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрой потоки.

Пример 1 данных входного файла:
zBk yaz b-kN

Пример 1 вывода:
abkny

Пример 2 данных входного файла:
caAC
A, aB? bB

Пример 2 вывода:
abc

Подсказка: использовать TreeSet


Requirements:
1. Программа должна использовать класс TreeSet.
2. У объекта типа TreeSet вызови метод add для добавления элементов.
3. Программа должна выводить результат на экран.
4. Вывод программы должен соответствовать условию задачи.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> chars = new TreeSet<>();
        String fileName = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) {
            String time = reader.readLine().toLowerCase(Locale.ROOT);
            char[] c = new char[time.length()];
            time.getChars(0, time.length(), c, 0);
            for (char ch : c) {
                if (ch >= 97 && ch <= 122) {
                    chars.add(ch);
                }
            }
        }

        int i = 0;
        Iterator<Character> iterator = chars.iterator();
        while (i < 5 && iterator.hasNext()) {
            System.out.print(iterator.next());
            i++;
        }
    }
}
