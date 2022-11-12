package com.javarush.task.task34.task3404;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Рекурсия для мат. выражения

На вход подается строка - математическое выражение.
Выражение включает целые и дробные числа, скобки (), пробелы, знак отрицания -, возведение в степень ^, sin(x), cos(x), tan(x)
Для sin(x), cos(x), tan(x) выражение внутри скобок считать градусами, например, cos(3 + 19*3)=0.5
Степень задается так: a^(1+3) и так a^4, что эквивалентно a*a*a*a.
С помощью рекурсии вычислить выражение и количество математических операций. Вывести через пробел результат в консоль.
Результат выводить с точностью до двух знаков, для 0.33333 вывести 0.33, использовать стандартный принцип округления.
Знак отрицания перед числом также считать математической операцией.
Не создавай в классе Solution дополнительные поля.
Не пиши косвенную рекурсию.

Пример, состоящий из операций sin * - + * +:
sin(2*(-5+1.5*4)+28)
Результат:
0.5 6

Пример, состоящий из операций tan ^:
tan(2025 ^ 0.5)
Результат:
1 2


Requirements:
1. В классе Solution не должны быть созданы дополнительные поля.
2. Метод recurse должен выводить на экран результат вычисления заданного выражения (пример в условии).
3. Метод recurse не должен быть статическим.
4. Метод recurse должен быть рекурсивным.
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); // Expected output: 0.5 6
    }

    public void recurse(final String expression, int countOperation) {
        //implement
    }

    public Solution() {
        //don't delete
    }
}
