package STACK__QUEUE.BAI_TAP;

import java.util.Stack;

public class KiemTraNgoac {
    public static void main(String[] args) {
        String string = "s * ((s – a) * (s – b) * (s – c)(";
        System.out.println(check(string));
    }
    public static boolean check(String string) {
        boolean check = false;
        Stack<Character> stack = new Stack<>();
        System.out.println(stack.size());
        for (int i = 0; i <string.length() ; i++) {
            if (string.charAt(i)=='('){
                stack.push(string.charAt(i));
            }
            if(string.charAt(i) == ')'){
                if (stack.isEmpty()){
                    return false;
                } else {
                    stack.pop();
                    }
                }
            }
        if(stack.isEmpty()){
            check = true;
        }
        return check;
    }
    }

