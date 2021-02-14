package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader( new FileReader(bufferedReader.readLine()));
        StringBuilder sB= new StringBuilder();

        while(fileReader.ready()) {
            sB=sB.append(fileReader.readLine());
            sB=sB.append(" ");
        }
        fileReader.close();

        String line = sB.toString();
        line = line.replace("\uFEFF", "");

        String[] str = line.split(" ");

        for(int j=0, n=str.length; j<n; j++){
            for(int i=j+1; i<n; i++){
                String compar=str[i].trim();
                if(str[i].length()>1) {
                    StringBuilder com = new StringBuilder(str[i].trim()).reverse();
                    compar=com.toString();
                }
                if (str[j].trim().equals(compar)) {
                    Pair pair = new Pair();
                    pair.first=str[j].trim();
                    str[j]=str[j]+j;
                    pair.second=str[i].trim();
                    str[i]=str[i]+i;
                    result.add(pair);
                }
            }
        }

//        for (Pair p : result){
//            System.out.println(String.format("%s %s", p.first, p.second));
//        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
