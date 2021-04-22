package DEBUG_EXCEPTION.BAI_TAP;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Triangle {
    public static void checkTri(int a,int b,int c) throws ExceptionTamGiac {
        if (a<=0||b<=0||c<=0||(a+b)<=c||(b+c)<=a||(a+c)<=b) {
            throw new ExceptionTamGiac();
        } else {
            System.out.println("a,b,c la 3 canh cua tam giac");
        }
    }
    public static void main(String[] args) {
        while (true){
            try {
                Scanner scanner =new Scanner(System.in);
                System.out.println("input a:");
                int a = scanner.nextInt();
                System.out.println("input b:");
                int b = scanner.nextInt();
                System.out.println("input c:");
                int c = scanner.nextInt();
                checkTri(a,b,c);
                break;
            }
            catch (InputMismatchException e){
                System.out.println("a,b,c is Char");
            }
            catch (ExceptionTamGiac e){
            }
        }
    }
}
