package com.javarush.task.task13.task1328;

public class Robot extends AbstractRobot implements Attackable, Defensable {
    private static int hitCount;
    private String name;

    public Robot(String name) {
        this.name = name;
    }

    @Override
    public String getName(){
        return name;
    }
}
