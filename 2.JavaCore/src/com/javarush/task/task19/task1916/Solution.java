package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();
        ArrayList<String> file1 = Filer(name1);
        ArrayList<String> file2 = Filer(name2);
        int i = 0;
        int j = 0;

        if(file1.size()>file2.size()) {
            while (i < file1.size() || j < file2.size()) {
                if (i >= file2.size()) {
                    lines.add(new LineItem(Type.REMOVED, file1.get(i)));
                    i++;
                    continue;
                }
                if (file1.get(i).equals(file2.get(j))) {
                    lines.add(new LineItem(Type.SAME, file1.get(i)));
                    i++;
                    j++;
                    continue;
                } else if (!file1.get(i).equals(file2.get(j)) && file1.get(i + 1).equals(file2.get(j))) {
                    lines.add(new LineItem(Type.REMOVED, file1.get(i)));
                    lines.add(new LineItem(Type.SAME, file1.get(i + 1)));
                    i += 2;
                    j++;
                    continue;
                } else if (!file1.get(i).equals(file2.get(j)) && file1.get(i).equals(file2.get(j + 1))) {
                    lines.add(new LineItem(Type.ADDED, file2.get(j)));
                    lines.add(new LineItem(Type.SAME, file1.get(i)));
                    i++;
                    j += 2;
                    continue;
                }
            }
        } else if (file1.size()<file2.size()) {
            while (i < file1.size() || j < file2.size()) {
                if (j >= file1.size()) {
                    lines.add(new LineItem(Type.ADDED, file2.get(j)));
                    j++;
                    continue;
                }

                if (file1.get(i).equals(file2.get(j))) {
                    lines.add(new LineItem(Type.SAME, file1.get(i)));
                    i++;
                    j++;
                } else if (!file1.get(i).equals(file2.get(j)) && !file1.get(i).equals(file2.get(j+1))) {
                    lines.add(new LineItem(Type.REMOVED, file1.get(i)));
                    i++;
                } else if (!file1.get(i).equals(file2.get(j)) && file1.get(i).equals(file2.get(j + 1))) {
                    lines.add(new LineItem(Type.ADDED, file2.get(j)));
                    lines.add(new LineItem(Type.SAME, file1.get(i)));
                    i++;
                    j += 2;
                }
            }
        } else {
            while (i < file1.size()-1) {
                if (file1.get(i).equals(file2.get(i))) {
                    lines.add(new LineItem(Type.SAME, file1.get(i)));
                    i++;
                } else if (!file1.get(i).equals(file2.get(i)) && !file1.get(i).equals(file2.get(i+1))) {
                    lines.add(new LineItem(Type.REMOVED, file1.get(i)));
                    i++;
                } else if (!file1.get(i).equals(file2.get(i)) && file1.get(i).equals(file2.get(i + 1))) {
                    lines.add(new LineItem(Type.ADDED, file2.get(i)));
                    i++;
                }
            }
            if(file1.get(file1.size()-1)!=file2.get(file2.size()-1)) {
                lines.add(new LineItem(Type.REMOVED, file1.get(file1.size()-1)));
                lines.add(new LineItem(Type.ADDED, file2.get(file2.size()-1)));
            } else lines.add(new LineItem(Type.SAME, file1.get(file1.size()-1)));
        }

        for(LineItem lI:lines)
            System.out.println(lI);
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
        @Override
        public String toString() {
            return this.type + " " + this.line;
        }
    }

    public static ArrayList<String> Filer(String name){
        ArrayList<String> list = new ArrayList<>();
        String contains;
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(name));
            while(!((contains=fileReader.readLine())==null)){
                list.add(contains);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}