import java.util.Scanner;

public class gopMang {
    public static void main(String[] args) {
        int size;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("input size: ");
            size = Integer.parseInt(scanner.nextLine());
            if(size>20){
                System.out.println("size out of array");
                System.out.println("input size: ");
                size = Integer.parseInt(scanner.nextLine());
            }
        } while (size>20);
        Scanner input = new Scanner(System.in);
        int[] array1 = new int[size];
        for (int i = 0; i <size ; i++) {
            System.out.println("input element array 1 : "+i);
            array1[i]=Integer.parseInt(input.nextLine());
        }
        int[] array2 = new int[size];
        for (int i = 0; i <size ; i++) {
            System.out.println("input element array 2 : "+i);
            array2[i]=Integer.parseInt(input.nextLine());
        }
        int[] array3 = new int[2*size];
        for (int i = 0; i <size ; i++) {
            array3[i]=array1[i];
        }
        for (int i = size; i <2*size ; i++) {
            array3[i]=array2[i-size];
        }
        System.out.print("array3 : ");
        for (int i = 0; i <array3.length ; i++) {
            System.out.println(array3[i]+" ");
        }
    }
}
