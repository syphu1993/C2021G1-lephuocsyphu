package STACK__QUEUE.BAI_TAP;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DaoNguocMang {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(5);
        System.out.println(list.size());
        Stack<Integer> stack = new Stack<>();
        while (list.size()>0){
            stack.push(list.remove(0));
        }
        System.out.println(stack.peek());
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        System.out.println(list);
    }
}
