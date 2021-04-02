import java.util.Scanner;

public class timMinMang2 {
    public static void main(String[] args) {
        int[] arr;
        int size;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("input side : ");
            size = scanner.nextInt();
            if (size>=20){
                System.out.println("faulse size");
                System.out.println("input side : ");
                size = scanner.nextInt();
            }
        }while (size>20);
        arr = new int[size];
        for (int i = 0; i <size ; i++) {
            System.out.println("input element "+i+" :");
            arr[i] = scanner.nextInt();
        }
        System.out.print("arr : ");
        for (int i = 0; i <size ; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
        int min =arr[0];
        for (int i = 0; i <size ; i++) {
            if (arr[i]<min){
                min =arr[i];
            }
        }
        System.out.println("min arr: "+ min);
    }
}
