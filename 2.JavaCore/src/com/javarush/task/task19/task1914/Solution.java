package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);
        String[] line = result.split(" ");
        System.out.println(line[0] + " " + line[1] + " " + line[2] + " " + line[3] + " " + form(line));
    }

    public static Integer form(String[] line){

        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[2]);

        switch (line[1]) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
//            case "^":
//                return Math.pow(a, b);
            case "%":
                return a % b;
            default:
                System.out.println("Неверная входная строка");
        }
        return 0;
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

