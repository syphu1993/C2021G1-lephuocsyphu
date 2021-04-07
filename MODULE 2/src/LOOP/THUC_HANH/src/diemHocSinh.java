import java.util.Scanner;

public class diemHocSinh {
    public static void main(String[] args) {
        int size;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("input side : ");
            size = input.nextInt();
            if (size > 30) {
                System.out.println("wrong size!");
            }
        } while (size > 30);
        int[] listPoint = new int[size];
        for (int i = 0; i < listPoint.length; i++) {
            System.out.println("input point sutdent " + (i + 1) + " :");
            listPoint[i] = input.nextInt();
        }
        System.out.print("liststudent :");
        int count = 0;
        for (int i = 0; i < listPoint.length; i++) {
            System.out.print(listPoint[i] + " ");
            if (listPoint[i] >= 5 && listPoint[i] <= 10) {
                count++;
            }
        }
        System.out.println("\n There are " + count + " passed Exam.");
    }
}
