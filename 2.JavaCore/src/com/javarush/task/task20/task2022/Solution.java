package com.javarush.task.task20.task2022;

import java.io.*;

/*
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName=fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write(System.lineSeparator().getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        stream.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName,true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {

        Solution sol = new Solution("/Users/work/Desktop/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2022/test");
        sol.writeObject("Записываем данные");
        sol.writeObject("Дозапишем данные - у нас же метод flush а не close в writeObject");


        String filePath = "/Users/work/Desktop/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2022/test1";
        ObjectOutputStream streamOut = new ObjectOutputStream(new FileOutputStream(filePath));
        //если попытаться тут у объекта запустить метод writeObject(ObjectOutputStream out) и
        //передать туда наш стрим - получим ошибку NotActiveException - это не правильно.
        streamOut.writeObject(sol);
        //закрываем поток вывода в файл
        sol.close();
        //закрываем поток сериализации
        streamOut.close();

        ObjectInputStream streamIn = new ObjectInputStream(new FileInputStream(filePath));
        Solution sol2 = (Solution) streamIn.readObject();
        sol2.writeObject("Данные нового потока.");
        //закрываем поток вывода в файл
        sol2.close();
        //закрываем поток десериализации
        streamIn.close();


    }
}
