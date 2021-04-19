package THUAT_TOAN_TIM_KIEM.THUC_HANH;

import java.util.Scanner;

public class DoPhucTap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String string = input.nextLine();
        int[] array = new int[255];
        for (int i = 0; i <string.length() ; i++) {
            int a =(int)string.charAt(i);
            array[a]+=1;
        }
        int max = 0;
        Character character=(char)255;
        for (int i = 0; i <255 ; i++) {
            if(array[i]>max){
                max =array[i];
                character = (char)i;
            }
        }
        System.out.println("Character " + character + " appear " + max + " times");
    }
}
