package STACK__QUEUE.BAI_TAP;

import java.util.Scanner;
import java.util.Stack;

public class ChuyenDoiNhiPhan {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        String string = "";
        int x = 0;
//        a la so thap phan.
        Scanner inputA = new Scanner(System.in);
        System.out.println("nhap so thap phan");
        int a = inputA.nextInt();
        while (a>0){
            x = a%2;
            stack.push(x);
            a= (a-x)/2;
        }
        System.out.println("size of stack :"+stack.size());
        while (!stack.isEmpty()){
            string += stack.pop().toString();
        }
        System.out.println(string);
    }
}
