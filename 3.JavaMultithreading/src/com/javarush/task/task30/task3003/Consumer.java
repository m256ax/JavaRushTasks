package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            Thread.currentThread().sleep(450);
            while (true){
                ShareItem item = this.queue.take();
                System.out.format("Processing %s\n",item.toString());
            }
        }catch (InterruptedException iE){
            return;
        }
    }
}
