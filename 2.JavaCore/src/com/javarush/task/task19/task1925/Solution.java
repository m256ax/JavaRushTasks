package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        String line;
        StringBuilder sB= new StringBuilder();

        while(!((line=reader.readLine())==null)){
            String[] str=line.split("\\s");
            for(String s:str) {
                if(s.length()>6) sB=sB.append(s).append(",");
            }
        }
        line=sB.toString();
        for(int i=0; i<line.length()-1;i++) {
            writer.write(line.charAt(i));
        }
        reader.close();
        writer.close();
    }
}
