package com.javarush.task.task21.task2106;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Ошибка в equals/hashCode
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    public Solution() {
    }

    public static void main(String[] args) throws ParseException {
        Set<Solution> set = new HashSet<>();

        Solution solution = new Solution(5, "Ooops!", 2.5d, new SimpleDateFormat("dd.MM.yyyy").parse("24.03.2020"), new Solution());

        set.add(solution);

        System.out.print(set.contains(new Solution(5, "Ooops!", 2.5d, new SimpleDateFormat("dd.MM.yyyy").parse("24.03.2020"), new Solution())));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null) return false;
        if (!(o instanceof Solution)) return false;
        Solution solution1 = (Solution) o;
        return anInt == solution1.anInt &&
                Double.compare(solution1.aDouble, aDouble) == 0 &&
                Objects.equals(string, solution1.string) &&
                Objects.equals(date, solution1.date) &&
                Objects.equals(solution, solution1.solution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anInt, string, aDouble, date, solution);
    }
}
