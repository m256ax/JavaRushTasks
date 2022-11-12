package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        Student res = null;
        for (Student stu: students
             ) {
            if (stu.getAverageGrade()==averageGrade) res = stu;
        }
        return res;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student studentWithMaxAverageGrade = students.get(0);
        for (Student stu: students
        ) {
            if (stu.getAverageGrade()> studentWithMaxAverageGrade.getAverageGrade()) {studentWithMaxAverageGrade = stu;}
        }
        return studentWithMaxAverageGrade;
    }

    public Student getStudentWithMinAverageGrade() {
        Student studentWithMinAverageGrade = students.get(0);
        for (Student stu: students
        ) {
            if (stu.getAverageGrade()< studentWithMinAverageGrade.getAverageGrade()) {studentWithMinAverageGrade = stu;}
        }
        return studentWithMinAverageGrade;
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}