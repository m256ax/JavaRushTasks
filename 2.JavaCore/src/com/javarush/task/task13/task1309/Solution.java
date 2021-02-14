package com.javarush.task.task13.task1309;

/* 
Всё, что движется
*/

public class Solution {
    
    interface CanMove {
        Double speed();
    }
    
    interface CanFly extends CanMove {
        Double speed(CanFly f);
    }
    
    public static void main(String[] args) throws Exception {
    }
}