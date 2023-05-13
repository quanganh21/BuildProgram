/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buildprogram.pkg40;
import java.util.Scanner;
/**
 *
 * @author Quang Anh
 */
public class Application {
    public static Scanner scanner = new Scanner(System.in);
     public static void showMenu() {
        System.out.println("============== MENU ==============");
        System.out.println("    Ban chon lam gi? ");
        System.out.println("1. Them Sinh Vien.");
        System.out.println("2. Chinh sua sinh vien.");
        System.out.println("3. Xoa sinh vien.");
        System.out.println("4. Thong ke diem TB.");
        System.out.println("5. Sap xep ten SV.");
        System.out.println("6. Xem sinh vien.");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Chon : ");
    }
 
    public static void main(String[] args) {
        String choose = null;
        boolean exit = false;
        Manager studentManager = new Manager();
        int studentId;
        
        showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
            case "1" -> studentManager.add();
            case "2" -> {
                studentId = studentManager.inputId();
                studentManager.edit(studentId);
                }
            case "3" -> {
                studentId = studentManager.inputId();
                studentManager.delete(studentId);
                }
            case "4" -> studentManager.diemTrungBinhSV();
            case "5" -> studentManager.sapXepTenSV();
            case "6" -> studentManager.Show();
            case "0" -> {
                System.out.println("Thoat.");
                exit = true;
                }
            default -> System.out.println("Khong hop le ! Vui long chon lai Menu : ");
            }
            if (exit) {
                break;
            }
            // show menu
            showMenu();
        }
    }
 
    /**
     * create menu
     */
   
}
