package com.javarush.task.task20.task2009;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
Как сериализовать static?
*/

public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;

        private void writeObject(ObjectOutputStream oos) throws IOException
        {
            oos.defaultWriteObject();
            oos.writeObject(new String (staticString));
        }

        private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException
        {
            ois.defaultReadObject();
            staticString = (String) ois.readObject();
        }
    }

    public static void main(String[] args) {

    }
}