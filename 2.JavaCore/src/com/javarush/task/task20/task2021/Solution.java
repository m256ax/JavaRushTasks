package com.javarush.task.task20.task2021;

import java.io.*;

/*
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {

        private void writeObject (ObjectOutputStream outputStream) throws IOException {
                throw new NotSerializableException ("Stop");
        }

        private void readObject (ObjectInputStream inputStream) throws IOException {
                throw new NotSerializableException ("ddd");
        }
    }

    public static void main(String[] args) {

    }
}
