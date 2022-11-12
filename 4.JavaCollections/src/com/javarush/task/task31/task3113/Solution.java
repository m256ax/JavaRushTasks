package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/*
Что внутри папки?
*/

public class Solution extends SimpleFileVisitor<Path>{
    static int[] folders = {-1};
    static int[] files = {0};
    static int[] bytes = {0};

    public static void main(String[] args) throws IOException {
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        String line = bR.readLine();
        Path path = Paths.get(line);
        if(!Files.isDirectory(path)){
            System.out.printf("%s - не папка\n", path);
        } else {
            System.out.printf("Всего папок - %d\n", getFolders(line));
            System.out.printf("Всего файлов - %d\n", getFiles(line));
            System.out.printf("Общий размер - %d\n", getFilesLength(line));
        }
    }

    public static int getFolders(String root) throws IOException {
        Files.walkFileTree(Paths.get(root), new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult preVisitDirectory(Path file, BasicFileAttributes attrs) throws IOException {
                if (Files.isDirectory(file)) {
                    folders[0] += 1;
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return folders[0];
    }

    public static int getFiles(String root) throws IOException {
        Files.walkFileTree(Paths.get(root), new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile (Path file, BasicFileAttributes attrs) throws IOException {
                if (Files.isRegularFile(file)) {
                    files[0] += 1;
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return files[0];
    }

    public static long getFilesLength(String root) throws IOException {
        Files.walkFileTree(Paths.get(root), new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile (Path file, BasicFileAttributes attrs) throws IOException {
                if (Files.isRegularFile(file)) {
                    bytes[0] +=Files.size(file);
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return bytes[0];
    }
}
