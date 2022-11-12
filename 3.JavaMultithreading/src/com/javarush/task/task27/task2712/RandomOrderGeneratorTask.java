package com.javarush.task.task27.task2712;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class RandomOrderGeneratorTask implements Runnable{
    private List<Tablet> tablets;
    private int delay;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int ORDER_CREATING_INTERVAL) {
        this.tablets = tablets;
        this.delay = ORDER_CREATING_INTERVAL;
        }

    @Override
    public void run() {
        Tablet tablet = tablets.get((int) (Math.random()*tablets.size()));
        try{
        while (true) {
            tablet.createTestOrder();
            sleep(delay);
        }
        } catch (InterruptedException e){return;}

    }
}
