package STACK__QUEUE.THUC_HANH;

import java.util.LinkedList;

public class MyGenericStack<T> {
    private LinkedList<T> stack;

    public MyGenericStack() {
        stack = new LinkedList();
    }

    public void push(T e) {
        stack.addFirst(e);
    }

    public int getSize() {
        return stack.size();
    }

    public boolean isEmpty() {
        if (this.getSize() == 0) {
            return true;
        }
        return false;
    }

    public T pop() {
        if (this.isEmpty()) {
            System.out.println();
        }
            return stack.removeFirst();

    }
}
