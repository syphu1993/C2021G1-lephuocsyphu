import java.util.Scanner;

public class DaoNguocMang {
    public static void main(String[] args) {
        int size;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Nhập chiều dài mãng: ");
            size = Integer.parseInt(scanner.nextLine());
            if (size > 20) {
                System.out.println("sai độ dài cho phép");
            }
        } while (size > 20);
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("nhập phần tử thứ " + i);
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.print("Mảng vừa nhập :");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.print("\n" + "Mảng vừa đảo : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
