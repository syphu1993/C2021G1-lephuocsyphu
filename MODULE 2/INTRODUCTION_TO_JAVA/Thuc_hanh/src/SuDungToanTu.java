import java.util.Scanner;

public class SuDungToanTu {
    public static void main(String[] args) {
        float height;
        float width;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter height: ");
        height = scanner.nextFloat();
        System.out.println("Enter width: ");
        width = scanner.nextFloat();
        float area = height*width;
        System.out.println("Dien tich hinh chu nhat :" + area);
    }
}
