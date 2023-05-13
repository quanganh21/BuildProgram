/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buildprogram.pkg40;
import java.util.Comparator;
/**
 *
 * @author Quang Anh
 */
public class DiemTrungBinhSV implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getdiemTB()> student2.getdiemTB()) {
            return 1;
        }
        return -1;
    }
}
