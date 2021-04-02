import java.util.Scanner;

public class TimUcln {
    public static void main(String[] args) {
        int a;
        int b;
        int ucln = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap so a: ");
        a = scanner.nextInt();
        System.out.println("nhap so b: ");
        b = scanner.nextInt();
        if (a == 0 && b == 0) {
            System.out.println("a va b khong có UCLN");
        } else if (a == 0) {
            System.out.println(Math.abs(b) + " là UCLN");
        } else if (b == 0) {
            System.out.println(Math.abs(a) + " là UCLN");
        } else if (a % b == 0) {
            System.out.println(b + " Là UCLN");
        } else if (b % a == 0) {
            System.out.println(a + " là UCLN");
        } else {
            for (int i = 1; i <a ; i++) {
                if (a%i == 0 && b%i == 0){
                    ucln = i;
                }
            }
            System.out.println("UCLN a vs b la: "+ucln);
        }
        }
    }

