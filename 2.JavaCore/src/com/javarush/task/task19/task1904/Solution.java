package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    }

    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {

            String foo = fileScanner.nextLine();
            String[] arr = foo.split(" ");
            String firstName = arr[1];
            String middleName = arr[2];
            String lastName = arr[0];
            SimpleDateFormat formater = new SimpleDateFormat("dd MM yyyy");
            Date birthDate = null;
            try {
                birthDate = formater.parse(arr[3] + " " + arr[4] + " " + arr[5]);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return new Person(firstName, middleName, lastName, birthDate);
        }

        @Override
        public void close() throws IOException {

            this.fileScanner.close();
        }
    }
}
