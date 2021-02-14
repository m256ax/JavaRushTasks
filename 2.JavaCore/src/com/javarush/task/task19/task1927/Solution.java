package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
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
            String [] str= result.split("\n");
            StringBuilder sB= new StringBuilder();
            for(int i=0;i<str.length;i++){
                if(i>0&&i%2==0) sB=sB.append("JavaRush - курсы Java онлайн").append("\n");
                sB=sB.append(str[i]).append("\n");
            }
            result=sB.toString();
            System.setOut(consoleStream);
            System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}