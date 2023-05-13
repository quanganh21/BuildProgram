/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package buildprogram.pkg40;
import java.io.Serializable;
/**
 *
 * @author Quang Anh
 */
public class Student implements Serializable {
    private int id;
    private String name;
    private byte age;
    private String address;
    private float diemTB;
 
    public Student() {
    }
 
    public Student(int id, String name, byte age, 
            String address, float diemTB) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.diemTB = diemTB;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public byte getAge() {
        return age;
    }
 
    public void setAge(byte age) {
        this.age = age;
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }
 
    public float getdiemTB() {
        return diemTB;
    }
 
    public void setdiemTB(float diemTB) {
        this.diemTB = diemTB;
    }


}
