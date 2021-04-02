import java.util.Scanner;

public class TongCot {
    public static void main(String[] args) {
        int[][] arr;
        Scanner scanner = new Scanner(System.in);
        System.out.println(" input row: ");
        int row = scanner.nextInt();
        System.out.println(" input col: ");
        int col = scanner.nextInt();
        arr = new int[row][col];
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                System.out.println(" input element :" + i);
               arr[i][j] = scanner.nextInt();
            }
        }
        System.out.print("arr :");
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
        int numberCol =scanner.nextInt();
        int sum =0;
        if(numberCol>=0 && numberCol<=col){
            for (int i = 0; i <row ; i++) {
                for (int j = 0; j <row ; j++) {
                    if(j==numberCol){
                     sum += arr[i][j];
                    }
                }

            }
        }
        System.out.println("Tổng cột :" + numberCol + "là :" +sum);
    }
}
