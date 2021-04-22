package SORT.BAI_TAP;

import java.util.Scanner;

public class InsertSort {
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
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j;
            for (j = i - 1; j >= 0 && array[j] > key; j--) {
                array[j+1] = array[j];
            } array[j+1] = key;
        }
        System.out.println("New array:");
        for (int x:array) {
            System.out.print(x+" ");
        }
    }
}
