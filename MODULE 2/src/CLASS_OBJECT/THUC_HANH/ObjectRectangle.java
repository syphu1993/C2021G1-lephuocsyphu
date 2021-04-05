package CLASS_OBJECT.THUC_HANH;

import java.util.Scanner;

public class ObjectRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input width :");
        float width = scanner.nextFloat();
        System.out.println("input hight :");
        float hight = scanner.nextFloat();
        HinhChuNhat rec1 = new HinhChuNhat(width,hight);
//        System.out.println(rec1.disPlay());
        System.out.println(rec1.getHight());
    }
}
