import java.util.Scanner;

public class XoaPhanTu {
    public static void main(String[] args) {
        int[] array1 = {10,4,6,7,7,9,0,0,0,5};
        int x;
        Scanner scanner =new Scanner(System.in);
        System.out.println("input element will be del: ");
        x = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <array1.length ; i++) {
            if(array1[i]==x){
                for (int j = i; j <array1.length-1 ; j++) {
                    array1[j] = array1[j+1];
                } array1[array1.length-1]= 0;
                i--;
            }
        }
        System.out.print("array 1 chuyen thanh array2 : ");
        for (int k = 0; k <array1.length ; k++) {
            System.out.print(array1[k]+" ");
        }
    }
}
