package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, byte[]> pathTreeMap = new TreeMap<>();

        String path = args[0];
        String resultFileAbsolutePath = args[1];

        File fileForRename = new File(resultFileAbsolutePath);
        File fOutput = new File(fileForRename.getParent() + "/allFilesContent.txt");
        if (FileUtils.isExist(fOutput)) {
            FileUtils.deleteFile(fOutput);
        }
        FileUtils.renameFile(fileForRename, fOutput);

        Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                File fInput = new File(String.valueOf(file));
                if (fInput.isFile()) {
                    if (fInput.length() <= 50) {
                        pathTreeMap.put(file.getFileName().toString(), Files.readAllBytes(file));
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        });

        try (FileOutputStream fileOutputStream = new FileOutputStream(fOutput, true)) {
            for (byte[] bytes : pathTreeMap.values()) {
                fileOutputStream.write(bytes);
                fileOutputStream.write("\n".getBytes());
            }
        }
    }
}
