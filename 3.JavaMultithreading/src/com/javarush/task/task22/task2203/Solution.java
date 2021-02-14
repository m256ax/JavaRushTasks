package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if(string==null) throw new TooShortStringException();
        int temp=0;
        for(int i=0; i<2;i++){
            temp = string.indexOf("\t", temp);
            if(temp==-1) throw new TooShortStringException();
            temp=temp+1;
        }
        return string.substring(string.indexOf("\t")+1, temp-1);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
