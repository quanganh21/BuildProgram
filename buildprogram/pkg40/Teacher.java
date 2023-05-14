/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buildprogram.pkg40;

/**
 *
 * @author Quang Anh
 */
public class Teacher {
    private String name;
    private byte age;
    private String address;
    private String subject;

    public Teacher(String name, byte age, String address, String subject) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.subject = subject;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    

    public void teach() {
        System.out.println("Day mon: " + subject);
    }
}
