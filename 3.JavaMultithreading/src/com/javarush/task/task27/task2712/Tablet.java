package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue queue;

    public void setQueue(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    public Tablet(int number) {
        this.number = number;
        setQueue(Restaurant.getOrderQueue());
    }

    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            chekOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        return order;
    }

    public void createTestOrder() {
        try {
            Order order = new TestOrder(this);
            chekOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    public void chekOrder(Order order) {
        try {
            if (!order.isEmpty()) {
                AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
                advertisementManager.processVideos();
                this.queue.add(order);
            }
        } catch(NoVideoAvailableException nV){
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
