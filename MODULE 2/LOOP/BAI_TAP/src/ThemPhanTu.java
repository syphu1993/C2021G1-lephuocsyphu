import java.util.Scanner;

public class ThemPhanTu {
    public static void main(String[] args) {
        int[] array1;
        array1 = new int[10];
        Scanner scanner =new Scanner(System.in);
        for (int i = 0; i <10 ; i++) {
            System.out.println("add element index of "+ i);
            array1[i] =Integer.parseInt(scanner.nextLine());
        }
        System.out.print("Array1 : ");
        for (int i = 0; i <array1.length ; i++) {
            System.out.print(array1[i]+" ");
        }
        int x;
        int index;
        System.out.println("input x: ");
        x =Integer.parseInt(scanner.nextLine());
        System.out.println("input index of x: ");
        index =Integer.parseInt(scanner.nextLine());
        if(index <=1 || index >= array1.length-1){
            System.out.println("no insert x");
            index =Integer.parseInt(scanner.nextLine());
        }
        for (int i = 0; i <array1.length ; i++) {
            if(i == index){
                for (int j = 0; j <array1.length-i ; j++) {
                    array1[array1.length-1-j]=array1[array1.length-2-j];
                }array1[i]=x;
            }
        }
        System.out.print("array new is: ");
        for (int i = 0; i <array1.length ; i++) {
            System.out.print(array1[i]+" ");
        }
    }
}
