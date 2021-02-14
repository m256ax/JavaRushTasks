package com.javarush.task.task22.task2202;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
//        StringBuilder sB= new StringBuilder();
//        String temp=string.substring(string.indexOf(32)+1);
//        String[] str = temp.split("\\s");
//        if(str.length<3) throw new TooShortStringException();
//        for(int i=0; i<4; i++){
//            sB = sB.append(str[i]).append(" ");
//        }
//        return sB.toString();
        if (string==null) throw new TooShortStringException();
        int ind = 0;
        for(int i=0; i<4; i++){
            ind=string.indexOf(32, ind);
            if (ind==-1) throw new TooShortStringException();
            ind=ind+1;
        }
        return string.substring(string.indexOf(32)+1, ind+1) + string.substring(ind+1).replaceAll("\\s.*", "");
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
