package CLASS_OBJECT.BAI_TAP;

import java.util.Scanner;

public class KetQuaPhuongTrinh {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        QuadraticEquation phuongtrinh1 = new QuadraticEquation(a,b,c);
        phuongtrinh1.getResult();
    }
}
