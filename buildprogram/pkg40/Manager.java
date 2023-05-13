/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buildprogram.pkg40;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Quang Anh
 */
public class Manager {
    public static Scanner scanner = new Scanner(System.in);
    private List<Student> studentList;
    private StudentList studentDao;
     
    /**
     * init StudentDao object and
     * read list student when init StudentManager object
     */   
    public Manager() {
        studentDao = new StudentList();
        studentList = studentDao.read();
    }
 
    public void add() {
        int id = (studentList.size() > 0) ? (studentList.size() + 1) : 1;
        System.out.println("student id = " + id);
        String name = inputName();
        byte age = inputAge();
        String address = inputAddress();
        float gpa = inputGpa();
        Student student = new Student(id, name, age, address, gpa);
        studentList.add(student);
        studentDao.write(studentList);
    }
 
    /**
     * edit student by id
     * 
     * @param id
     */
    public void edit(int id) {
        boolean isExisted = false;
        int size = studentList.size();
        for (int i = 0; i < size; i++) {
            if (studentList.get(i).getId() == id) {
                isExisted = true;
                studentList.get(i).setName(inputName());
                studentList.get(i).setAge(inputAge());
                studentList.get(i).setAddress(inputAddress());
                studentList.get(i).setdiemTB(inputGpa());
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("id = %d Khong ton tai.\n", id);
        } else {
            studentDao.write(studentList);
        }
    }
 
    /**
     * delete student by id
     * 
     * @param id: student id
     */
    public void delete(int id) {
        Student student = null;
        int size = studentList.size();
        for (int i = 0; i < size; i++) {
            if (studentList.get(i).getId() == id) {
                student = studentList.get(i);
                break;
            }
        }
        if (student != null) {
            studentList.remove(student);
            studentDao.write(studentList);
        } else {
            System.out.printf("id = %d Khong ton tai.\n", id);
        }
    }
 
    /**
     * sort student by name
     */
    public void sapXepTenSV() {
        Collections.sort(studentList, new SapXepTenSV());
    }
 
    /**
     * sort student by id
     */
    public void diemTrungBinhSV() {
        Collections.sort(studentList, new DiemTrungBinhSV());
    }
 
    /**
     * show list student to screen
     */
    public void Show() {
        for (Student student : studentList) {
            System.out.format("%5d | ", student.getId());
            System.out.format("%20s | ", student.getName());
            System.out.format("%5d | ", student.getAge());
            System.out.format("%20s | ", student.getAddress());
            System.out.format("%10.1f%n", student.getdiemTB());
        }
    }
 
    /**
     * input student id
     * 
     * @return student id
     */
    public int inputId() {
        System.out.print("Nhap id sinh vien : ");
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("Khong hop le! Nhap lai id sinh vien : "); 
            }
        }
    }
     
    /**
     * input student name
     * 
     * @return student name
     */
    private String inputName() {
        System.out.print("Nhap ten sinh vien : ");
        return scanner.nextLine();
    }
 
    /**
     * input student address
     * 
     * @return student address
     */
    private String inputAddress() {
        System.out.print("Nhap dia chi : ");
        return scanner.nextLine();
    }
 
    /**
     * input student age
     * 
     * @return student age
     */
    private byte inputAge() {
        System.out.print("Nhap so tuoi : ");
        while (true) {
            try {
                byte age = Byte.parseByte((scanner.nextLine()));
                if (age < 0 && age > 100) {
                    throw new NumberFormatException();
                }
                return age;
            } catch (NumberFormatException ex) {
                System.out.print("Khong hop le! Nhap lai so tuoi : ");
            }
        }
    }
 
 
    private float inputGpa() {
        System.out.print("Nhap diem trung binh : ");
        while (true) {
            try {
                float gpa = Float.parseFloat((scanner.nextLine()));
                if (gpa < 0.0 && gpa > 10.0) {
                    throw new NumberFormatException();
                }
                return gpa;
            } catch (NumberFormatException ex) {
                System.out.print("Khong hop le! Nhap lai diem trung binh : ");
            }
        }
    }
 
    // getter && setter
    public List<Student> getStudentList() {
        return studentList;
    }
 
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

  
}