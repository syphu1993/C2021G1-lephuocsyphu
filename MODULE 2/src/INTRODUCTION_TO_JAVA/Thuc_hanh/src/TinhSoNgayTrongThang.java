import java.util.Scanner;

public class TinhSoNgayTrongThang {
    public static void main(String[] args) {
        int nameMonth;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input name month:");
        nameMonth = scanner.nextInt();
            switch (nameMonth){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    System.out.println(nameMonth+"là tháng có 31 ngày.");
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    System.out.println(nameMonth+"là tháng có 30 ngày.");
                    break;
                case 2:
                    System.out.println(nameMonth+"là tháng có 28 hoặc 29 ngày.");
                    break;
                default:{
                    System.out.println("không phải tháng trong năm");
                }
            }
    }
}
