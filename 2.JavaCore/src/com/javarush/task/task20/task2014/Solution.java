package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream fos = new ObjectOutputStream(new FileOutputStream("/Users/work/Desktop/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2014/test"));
        ObjectInputStream fis = new ObjectInputStream(new FileInputStream("/Users/work/Desktop/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2014/test"));

        Solution savedObject = new Solution(12);
        fos.writeObject(savedObject);

        Solution savedObjectNew = new Solution(21);

        Solution loadedObject= (Solution) fis.readObject();
        System.out.println(savedObject.string.equals(loadedObject.string));

        System.out.println(new Solution(4));
    }

    transient final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }


    @Override
    public String toString() {
        return this.string;
    }
}
