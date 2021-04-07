import java.util.Scanner;

public class GiaTriMax {
    public static void main(String[] args) {
        int size;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("input size: ");
            size = Integer.parseInt(scanner.nextLine());
            if(size >= 20){
                System.out.println("faulse size");
            }
        }while (size>20);
        int[] array1 = new int[size];
        for (int i = 0; i <size ; i++) {
            System.out.println("input elemment: ");
            array1[i]=Integer.parseInt(scanner.nextLine());
        }
        System.out.print("array1 : ");
        for (int i = 0; i <size ; i++) {
            System.out.print(array1[i]+" ");
        }
        int max = array1[0];
        int index =0;
        for (int i = 0; i <array1.length ; i++) {
            if(array1[i]>=max){
                max = array1[i];
                index = i;
            }
        }
        System.out.println("\n Max element of array1 is : "+ max+"\n index of " + (index+1) +" in array1");
    }
}
