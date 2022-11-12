package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket() {

        try {
            path = Files.createTempFile("tmp", null);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize() {
        Long s = null;
        try {
            s = Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;

    }

    public void putEntry(Entry entry) {
        try {
            OutputStream out = Files.newOutputStream(path);
            ObjectOutputStream obj = new ObjectOutputStream(out);
            obj.writeObject(entry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Entry getEntry() {
        Entry en = null;

        if (this.getFileSize() == 0) {
            return null;
        }
        try (InputStream in = Files.newInputStream(path);
             ObjectInputStream inObj = new ObjectInputStream(in)) {
            en = (Entry) inObj.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return en;
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
