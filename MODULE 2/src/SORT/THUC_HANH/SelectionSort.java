package SORT.THUC_HANH;

import java.util.Scanner;

public class SelectionSort {
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
        selectionSort(arrayRanDom);
    }
    public static void selectionSort(int[] array){
        for (int i = 0; i <array.length-1 ; i++) {
            int max = array[i];
            int indexMin = i;
            for (int j = i+1; j <array.length ; j++) {
                if (max<array[j]){
                    max=array[j];
                    indexMin = j;
                }
            }
            array[indexMin] = array[i];
            array[i]= max;
        }
        System.out.println("New array : ");
        for (int x:array) {
            System.out.print(x+" ");
        }
    }
}
