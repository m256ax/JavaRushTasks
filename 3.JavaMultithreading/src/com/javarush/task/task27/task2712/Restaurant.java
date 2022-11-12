package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> ORDER_QUEUE = new LinkedBlockingQueue<>();

    public static LinkedBlockingQueue<Order> getOrderQueue() {
        return ORDER_QUEUE;
    }

    public static void main(String[] args) {
        Cook cook1 = new Cook("Amigo");
        Cook cook2 = new Cook("Diablo");

        Thread thread1 = new Thread(cook1);
        Thread thread2 = new Thread(cook2);
        thread1.start();
        thread2.start();

        ArrayList<Tablet> tablets = new ArrayList<>();


        for (int i = 0; i < 5; i++){
            Tablet tablet = new Tablet(i);
            tablets.add(tablet);
        }

        RandomOrderGeneratorTask generatorTask = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
        Thread thread = new Thread(generatorTask);
        thread.start();
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();

        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }
}