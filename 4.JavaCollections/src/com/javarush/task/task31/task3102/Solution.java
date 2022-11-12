package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();
        Files.walkFileTree(Paths.get(root), new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                File fileIn = new File(file.toString());
                if (fileIn.isFile()) {
                    result.add(fileIn.getAbsolutePath());
                }
                return super.visitFile(file, attrs);
            }
        });
        return result;
    }

    public static void main(String[] args) {
        System.out.println((int) (1 * 3.3554432E7));

        try {
            for (String s : getFileTree("/Users/work/Desktop/test") )
            System.out.println(s + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
