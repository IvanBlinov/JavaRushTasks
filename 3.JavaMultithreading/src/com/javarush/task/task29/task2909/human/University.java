package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University  {

    private String name;
    private int age;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }



    public University(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    public Student getStudentWithAverageGrade( double averageGrade) {
        //TODO:
        Student student = null;
        for(Student s : students){
            if(s.getAverageGrade() == averageGrade) {
                student = s;
            }
        }
        return student;
    }

    public Student getStudentWithMaxAverageGrade() {

        //TODO:
        Student student = null;
        double max = 0;
        for(Student s : students){
            if(s.getAverageGrade() > max) {
                max = s.getAverageGrade();
                student = s;
            }
        }
        return student;
    }


    public  Student getStudentWithMinAverageGrade() {
        Student student = null;
        double min = Double.MAX_VALUE;
        for(Student s : students){
            if(s.getAverageGrade() < min ) {
                min = s.getAverageGrade();
                student = s;
            }
        }
        return student;

    }

    public void expel(Student student){
        students.remove(student);
    }
}