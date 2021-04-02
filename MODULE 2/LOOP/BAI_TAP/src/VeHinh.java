import java.util.Scanner;

public class VeHinh {
    public static void main(String[] args) {
////        hình 1
//        for (int i = 1; i <=3 ; i++) {
//            for (int j = 1; j <=7 ; j++) {
//                System.out.print("*");
//            }
//            System.out.println("");
//        }
////        hình 2
//        for (int i = 1; i <=5 ; i++) {
//            for (int j = 1; j <=i ; j++) {
//                System.out.print("*");
//            }
//            System.out.println("");
//        }
////        hình 3
//        for (int i = 1; i <=5 ; i++) {
//            for (int j = 5; j >=i ; j--) {
//                System.out.print("*");
//            } System.out.println("");
//        }

        int hight;
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập cao");
        hight = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <=hight ; i++) {
            for (int j = 1; j <=hight-i ; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <=2*i-1 ; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
