import java.util.Scanner;

public class TinhTongCheoMang {
    public static void main(String[] args) {
        float[][] arr;
        Scanner scanner = new Scanner(System.in);
        System.out.println(" input a: ");
        int a = scanner.nextInt();
        arr = new float[a][a];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                System.out.println(" input element arr[" + i + "]");
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println("arr :");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        float sum = 0.0f;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i==j) {
                    sum += arr[i][j];
                }
            }
        }
        System.out.println("Tổng chéo : " + sum);
    }
}
