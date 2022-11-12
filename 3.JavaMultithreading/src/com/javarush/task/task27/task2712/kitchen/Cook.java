package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Restaurant;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable{
    private String name;
    private boolean busy;
    private LinkedBlockingQueue queue;

    public void setQueue(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    public Cook(String  name) {
        this.name = name;
        this.busy = false;
        setQueue(Restaurant.getOrderQueue());
    }

    public boolean isBusy() {
        return busy;
    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order)   {
        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order);
        try {
            Thread.currentThread().sleep(order.getTotalCookingTime()*10);
        } catch (InterruptedException e) {
            return;
        }
        setChanged();
        notifyObservers(order);
        CookedOrderEventDataRow row = new CookedOrderEventDataRow(
                order.getTablet().toString(),
                name,
                order.getTotalCookingTime()*60,
                order.getDishes());
        StatisticManager.getInstance().register(row);
        busy = false;
    }


    @Override
    public void run() {
        while (true) {
            try {
                if (!Restaurant.getOrderQueue().isEmpty()) {
                    if (!this.isBusy()) {
                        Order order = Restaurant.getOrderQueue().take();
                        this.startCookingOrder(order);
                    }
                }
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                return;
            }
        }

    }
}
