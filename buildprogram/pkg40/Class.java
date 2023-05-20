/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buildprogram.pkg40;

import java.util.List;

/**
 *
 * @author Quang Anh
 */
public class Class {
    private String name;
    private List<Student> studentList;
    private Teacher teacher;
    private int numberOfStudents;

    public Class(String name, List<Student> studentList, Teacher teacher, int numberOfStudents) {
        this.name = name;
        this.studentList = studentList;
        this.teacher = teacher;
        this.numberOfStudents = numberOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    // getter và setter cho các thuộc tính

    public void addStudent(Student student) {
        studentList.add(student);
        numberOfStudents++;
    }
    
    
    
    public void removeStudent(Student student) {
        studentList.remove(student);
        numberOfStudents--;
    }

    public void showStudentList() {
        for (Student student : studentList) {
            System.out.format("%d | ", student.getId());
            System.out.format("%s | ", student.getName());
            System.out.format("%d | ", student.getAge());
            System.out.format("%s | ", student.getAddress());
            System.out.format("%.2f\n", student.getdiemTB());
        }
    }
}