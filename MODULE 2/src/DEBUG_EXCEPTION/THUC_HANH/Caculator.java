package DEBUG_EXCEPTION.THUC_HANH;

import java.util.Scanner;

public class Caculator {

    public static void caculator(int x, int y){
        int tong = x+y;
        System.out.println(tong);
        int hieu = x-y;
        System.out.println(hieu);
        int tich = x*y;
        System.out.println(tich);
        int thuong = x/y;
        System.out.println(thuong);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int x = scanner.nextInt();
            int y =scanner.nextInt();
            caculator(x,y);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
