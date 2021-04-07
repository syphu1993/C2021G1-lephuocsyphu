import java.util.Scanner;

public class MaxMang2chieu {
    public static String timIndexMang(int[][] arr) {
        String reSult = "";
        int max = arr[0][0];
        int x = 0;
        int y = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] >= max) {
                    max = arr[i][j];
                    x = i;
                    y = j;
                }
            }
            reSult = "max element in x = " + x + "; y = " + y;
        }
        return reSult;
    }

    public static void main(String[] args) {
        int row;
        Scanner scanner = new Scanner(System.in);
        System.out.println("input row : ");
        row = Integer.parseInt(scanner.nextLine());
        int[][] array = new int[row][];
        for (int i = 0; i < row; i++) {
            System.out.println("input length array[" + i + "]");
            int n = scanner.nextInt();
            array[i] = new int[n];
            for (int j = 0; j < array[i].length; j++) {
                System.out.println("input element of array[" + i + "]");
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("array : ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println(timIndexMang(array));
    }
}
