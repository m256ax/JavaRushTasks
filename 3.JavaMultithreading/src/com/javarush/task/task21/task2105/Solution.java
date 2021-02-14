package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(final String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(!(o instanceof Solution)) return false;
        if(this==o) return true;

        final Solution other = (Solution) o;
        if (this.first==null? other.first!=null: !this.first.equals(other.first)) return false;
        if (this.last==null? other.last!=null: !this.last.equals(other.last)) return false;

    return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = result*prime+((first==null)? 0: first.hashCode()) + ((last==null)? 0: last.hashCode());
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }


}
