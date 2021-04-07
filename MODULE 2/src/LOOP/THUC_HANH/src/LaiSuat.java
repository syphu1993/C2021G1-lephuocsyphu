import java.util.Scanner;

public class LaiSuat {
    public static void main(String[] args) {
        int soThangVay;
        double soTienVay;
        float laiSuat; //lãi suất 1 năm 4%
        float tongTienLai = 0.0f;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tháng vay: ");
        soThangVay = scanner.nextInt();
        System.out.println("Nhập lãi suất: ");
        laiSuat = scanner.nextFloat();
        System.out.println("Nhập số tiền vay: ");
        soTienVay = scanner.nextDouble();
        for (int i = 0; i <soThangVay ; i++) {
             tongTienLai += soTienVay * (laiSuat/12);
        }
        System.out.println("Tổng lãi thu được sau "+soThangVay+"là: " + tongTienLai);
    }
}
