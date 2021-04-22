package SORT.BAI_TAP;

import java.util.Scanner;

public class BubbleSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input size of arrayrandom: ");
        int size = scanner.nextInt();
        int[] arrayRanDom = new int[size];
        for (int i = 0; i < size; i++) {
            arrayRanDom[i] = (int) (Math.random() * 100);
        }
        System.out.println("Arrayrandom :");
        for (int i = 0; i < size; i++) {
            System.out.print(arrayRanDom[i] + " ");
        }
        sort(arrayRanDom);
    }

    public static void sort(int[] array) {
        boolean check = true;
        for (int i = 0; i < array.length - 1 && check; i++) {
            check = false;
            for (int j = 0; j <array.length-i-1 ; j++) {
               if (array[j]>array[j+1]){
                   int temp = array[j];
                   array[j]=array[j+1];
                   array[j+1] = temp;
                   check =true;
               }
            }
        }
        System.out.println("\n Array after sort :");
        for (int x:array) {
            System.out.print(x+" ");
        }
    }
}
