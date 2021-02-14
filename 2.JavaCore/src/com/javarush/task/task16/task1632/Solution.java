package com.javarush.task.task16.task1632;

import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Infinity());
        threads.add(new Interrupt());
        threads.add(new Ura());
        threads.add(new Massage());
        threads.add(new N());
    }

    public static void main(String[] args) {
    }

    public static class Infinity extends Thread {

        public void run() {
            try {
                while (true) {
                    Thread.sleep(100500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().start();
            }
            }
        }

    public static class Interrupt extends Thread {
       int q =0;
        public void run() {
            try {
                while (true) {
                    Thread.sleep(100500);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
            }
        }

    private static class Ura extends Thread {
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    this.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Massage extends Thread implements Message{
        private boolean state = true;
        @Override
        public void showWarning() {
            state = false;
        }

        public void run(){
            try {
                while (state) Thread.sleep(100500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class N extends Thread {
        int sum=0;

        public void run(){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String n = "";
            try {
            while (true) {
                    if ((n=reader.readLine()).equals("N")) break;
                    sum = sum + Integer.parseInt(n);
                }
            System.out.println(sum);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}