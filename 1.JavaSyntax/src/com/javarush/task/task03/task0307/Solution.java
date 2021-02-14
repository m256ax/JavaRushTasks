package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
    Zerg zerg1 = new Zerg ();
    zerg1.name = "Z";
    Zerg zerg2 = new Zerg ();
    zerg2.name = "E";
    Zerg zerg3 = new Zerg ();
    zerg3.name = "R";
    Zerg zerg4 = new Zerg ();
    zerg4.name = "G";
    Zerg zerg5 = new Zerg ();
    zerg5.name = "Zz";
    Protoss protoss1 = new Protoss ();
    protoss1.name = "P";
    Protoss protoss2 = new Protoss();
    protoss2.name = "R";
    Protoss protoss3 = new Protoss();
    protoss3.name = "O";
    Terran terran1 = new Terran();
    terran1.name = "T";
    Terran terran2 = new Terran ();
    terran2.name = "E";
    Terran terran3 = new Terran ();
    terran3.name = "R";
    Terran terran4 = new Terran ();
    terran4.name = "Ra";
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
