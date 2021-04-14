package STACK__QUEUE.BAI_TAP;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        String string = "Able was i er i saw Elba";
        string = string.toLowerCase();
        boolean check = true;
        System.out.println(string.length());
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <string.length() ; i++) {
            stack.push(string.charAt(i));
        }
        System.out.println(stack.size());
        Queue<Character> queue = new LinkedList();
        for (int i = 0; i <string.length() ; i++) {
            queue.add(string.charAt(i));
        }
        for (int i = 1; i <=string.length()/2 ; i++) {
            if (stack.pop()!=queue.remove()){
                check = false;
                break;
            } else {
                check =true;
            }
        }
        if(check){
            System.out.println("String is Palindrome");
        } else {
            System.out.println("String is not Palindrome");
        }
    }
}
