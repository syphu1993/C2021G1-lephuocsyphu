import java.util.Scanner;

public class PhuongTrinhBacNhat {
    public static void main(String[] args) {
        double a;
        double b;
        double x;
        Scanner scanner = new Scanner(System.in);
//        ax+b = 0;
        System.out.println("nhập a: ");
        a = scanner.nextFloat();
        System.out.println("nhập b: ");
        b = scanner.nextFloat();
        if (a==0){
          if(b==0){
              System.out.println("Phương trình có vô số nghiệm.");
          }else {
              System.out.println("Phương trình vô nghiệm.");
          }
        } else if(a!=0){
            x = -b/a;
            System.out.println("Phương có nghiệm: "+ x);
        }
    }
}
