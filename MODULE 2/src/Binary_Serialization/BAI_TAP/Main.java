package Binary_Serialization.BAI_TAP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuanLySanPham quanLySanPham = new QuanLySanPham();
        quanLySanPham.readFile(quanLySanPham.path);
        quanLySanPham.menu();
        Scanner scanner = new Scanner(System.in);
        int choose;
        do {
            choose = scanner.nextInt();
            switch (choose){
                case 1:
                    quanLySanPham.addProduct();
                    break;
                case 2:
                    quanLySanPham.findProduct();
                    break;
                case 3:
                    System.out.println("Cancle!");
                    break;
                default:
                    System.out.println("Choose again please!");
            }
        } while (choose!=3);
        System.out.println("View read :");
        quanLySanPham.readFile(quanLySanPham.path);
    }
}
