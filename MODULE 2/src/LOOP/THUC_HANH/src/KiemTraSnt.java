import java.util.Scanner;

public class KiemTraSnt {
    public static void main(String[] args) {
        int n;
        boolean check = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println(" input number :");
        n = scanner.nextInt();
        if(n<2){
            System.out.println(n+ " Không phải số nguyên tô");
        } else if(n>=2){
            check = true;
            for (int i = 2; i <=Math.sqrt(n) ; i++) {
                if(n%i == 0){
                    check =false;
                    break;
                }
            }
            if(check){
                System.out.println(n+" là số nguyên tố");
            } else {
                System.out.println(n+" không phải số nguyên tố");
            }
        }
    }
}
