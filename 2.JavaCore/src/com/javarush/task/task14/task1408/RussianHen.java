package com.javarush.task.task14.task1408;


public class RussianHen extends Hen {
    
    int getCountOfEggsPerMonth(){
        return 40;
    }
    public String getDescription() {
        return (super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}