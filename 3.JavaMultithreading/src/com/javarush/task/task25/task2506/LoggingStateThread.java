package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{
    Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
        target.setDaemon(true);
    }

    @Override
    public void run() {
        super.run();
        Thread.State oldState = State.TERMINATED;
        while (true){
            Thread.State state = target.getState();
            if (oldState != state) {
                System.out.println(state);
                oldState = state;
            }
        if(state == State.TERMINATED) return;
        }
    }
}
