import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        int vnd;
        int usd;
        Scanner scanner = new Scanner(System.in);
        System.out.println(" input vnd");
        vnd = scanner.nextInt();
        usd = vnd/24000;
        System.out.println("USD = "+usd);
    }
}
