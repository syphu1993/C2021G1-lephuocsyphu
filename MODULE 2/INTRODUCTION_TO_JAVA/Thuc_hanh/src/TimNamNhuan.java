import java.util.Scanner;

public class TimNamNhuan {
    public static void main(String[] args) {
        int nameYear;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên năm: ");
        nameYear = scanner.nextInt();
        if(nameYear%4 == 0){
            if(nameYear%100 == 0){
                if(nameYear%400 != 0){
                    System.out.println(nameYear+"là năm không nhuận");
                } else {
                    System.out.println(nameYear+"là năm nhuận");
                }
            }else {
                System.out.println(nameYear +"là năm nhuận");
            }
        }else {
            System.out.println(nameYear+"là năm không nhuận");
        }
    }
}
