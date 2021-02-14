package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;
    private List <Horse> horses;

    public List<Horse> getHorses(){
        return this.horses;
    }

    public Hippodrome(List<Horse> horses){
        this.horses=horses;
    }

    public static void main(String[] args) {
        game= new Hippodrome (new ArrayList<>());

        game.horses.add(new Horse("Фадеев", 3, 0));
        game.horses.add(new Horse("Сапов", 3, 0));
        game.horses.add(new Horse("Денисенко", 3, 0));
        game.run();
        game.printWinner();
    }

    public void run() {
        for(int i=0; i<100; i++){
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void move(){
    for(Horse horse:horses){
        horse.move();
    }
    }

    public void print(){
        for(Horse horse:horses){
            horse.print();
        }
        for (int i=0; i<10; i++){
            System.out.println();
        }
    }
    public Horse getWinner() {
        Horse horse=new Horse("",0,0);
        for (int i = 0, n = horses.size(); i < n; i++) {
            if (horse.getDistance() < horses.get(i).getDistance()) {
                horse = horses.get(i);
            }
        }
        return horse;
    }

    public void printWinner(){
        System.out.printf("Winner is %s!%n", getWinner().getName());
    }
}
