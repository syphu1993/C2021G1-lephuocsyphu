package DEBUG_EXCEPTION.THUC_HANH;

import java.util.Scanner;

public class ExceotionArray {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i <100 ; i++) {
            array[i]= (int)(Math.random()*100);
        }
        for (int x:array) {
            System.out.print(x+",");
        }
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.println("\n" + "input x:");
                int x = Integer.parseInt(scanner.nextLine());
                System.out.println("Element at index "+x+" is "+array[x]);
                break;
            }
            catch (Exception e){
                System.out.println("not index of array!");
            }
        }
    }
}
