/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buildprogram.pkg40;

import java.util.ArrayList;
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
    private List<Class> classList;
     
    /**
     * Khởi tạo đối tượng StudentDao
     * Đọc danh sách sinh viên khi khởi tạo đối tượng StudentManager
     */   
    public Manager() {
        studentDao = new StudentList();
        studentList = studentDao.read();
        classList = new ArrayList<Class>();
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
     * Chỉnh sửa sinh viên theo ID
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
     * Xóa sinh viên theo ID

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
     * Sắp xếp sinh viên theo tên
     */
    public void sapXepTenSV() {
        Collections.sort(studentList, new SapXepTenSV());
    }
 
    /**
     * Sắp xếp điểm TB
     */
    public void diemTrungBinhSV() {
        Collections.sort(studentList, new DiemTrungBinhSV());
    }
 
    /**
     * Show danh sách sinh viên 
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
     * Nhập vào sinh viên ID
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
     * Nhập vào tên

     */
    private String inputName() {
        System.out.print("Nhap ten sinh vien : ");
        return scanner.nextLine();
    }
 
    /**
     * Nhập vào địa chỉ

     */
    private String inputAddress() {
        System.out.print("Nhap dia chi : ");
        return scanner.nextLine();
    }
 
    /**
     * Nhập tuổi
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

     public void addClass() {
        String name = inputClassName();
        Teacher teacher = inputTeacher();
        Class newClass = new Class(name, new ArrayList<>(), teacher, 0);
        classList.add(newClass);
    }

    public void editClass(String name) {
        boolean isExisted = false;
        for (Class c : classList) {
            if (c.getName().equals(name)) {
                isExisted = true;
                String newName = inputClassName();
                Teacher newTeacher = inputTeacher();
                c.setName(newName);
                c.setTeacher(newTeacher);
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("Lop %s khong ton tai.\n", name);
        }
    }

    public void deleteClass(String name) {
        Class classToDelete = null;
        for (Class c : classList) {
            if (c.getName().equals(name)) {
                classToDelete = c;
                break;
            }
        }
        if (classToDelete != null) {
            classList.remove(classToDelete);
        } else {
            System.out.printf("Lop %s khong ton tai.\n", name);
        }
    }

    public void showClassList() {
        for (Class c : classList) {
            System.out.format("%s | ", c.getName());
            System.out.format("%s | ", c.getTeacher().getName());
            System.out.format("%d | ", c.getNumberOfStudents());
            System.out.println();
        }
    }

    public String inputClassName() {
        System.out.print("Nhap ten lop : ");
        return scanner.nextLine();
    }

    public Teacher inputTeacher() {
        System.out.print("Nhap ten giao vien : ");
        String name = scanner.nextLine();
        byte age = inputAge();
        System.out.print("Nhap dia chi : ");
        String address = scanner.nextLine();
        System.out.println("Nhap sub");
        String subject = scanner.nextLine();
        return new Teacher(name, age, address,subject);
    }
    
//    public void addStudentToClassById(String studentId, String classId) {
//  // Lấy thông tin student và class từ database hoặc bất kỳ nguồn dữ liệu nào khác
//        Student student = ge(studentId);
//        Class myClass = getClassById(classId);
//
//        // Thêm student vào class
//        myClass.addStudent(student);
//      }
      //    public void addClass() {
//        String name = inputClassName();
//        Teacher teacher = inputTeacher();
//        Class newClass = new Class(name, new ArrayList<>(), teacher, 0);
//        classList.add(newClass);
//    }
//
//    public void editClass(String name) {
//        boolean isExisted = false;
//        for (Class c : classList) {
//            if (c.getName().equals(name)) {
//                isExisted = true;
//                String newName = inputClassName();
//                Teacher newTeacher = inputTeacher();
//                c.setName(newName);
//                c.setTeacher(newTeacher);
//                break;
//            }
//        }
//        if (!isExisted) {
//            System.out.printf("Lop %s khong ton tai.\n", name);
//        }
//    }
//
//    public void deleteClass(String name) {
//        Class classToDelete = null;
//        for (Class c : classList) {
//            if (c.getName().equals(name)) {
//                classToDelete = c;
//                break;
//            }
//        }
//        if (classToDelete != null) {
//            classList.remove(classToDelete);
//        } else {
//            System.out.printf("Lop %s khong ton tai.\n", name);
//        }
//    }
//
//    public void showClassList() {
//        for (Class c : classList) {
//            System.out.format("%s | ", c.getName());
//            System.out.format("%s | ", c.getTeacher().getName());
//            System.out.format("%d | ", c.getNumberOfStudents());
//            System.out.println();
//        }
//    }
//
//    private String inputClassName() {
//        System.out.print("Nhap ten lop : ");
//        return scanner.nextLine();
//    }
//
//    private Teacher inputTeacher() {
//        System.out.print("Nhap ten giao vien : ");
//        String name = scanner.nextLine();
//        System.out.print("Nhap tuoi : ");
//        byte age = inputAge();
//        System.out.print("Nhap dia chi : ");
//        String address = scanner.nextLine();
//        return new Teacher(name, age, address);
//    }
  
}