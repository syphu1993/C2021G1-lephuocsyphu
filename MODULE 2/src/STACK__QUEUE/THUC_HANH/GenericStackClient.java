package STACK__QUEUE.THUC_HANH;

public class GenericStackClient {
    public static void stackOfIStrings() {
        MyGenericStack<String> stack = new MyGenericStack<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        stack.push("five");
        System.out.println("Size of this stack : " + stack.getSize());
        System.out.println("Elements of this stack :");
        while (!stack.isEmpty()) {
            System.out.printf(" %s", stack.pop());
        }
        System.out.println(" \n Size of this stack after pop : " + stack.getSize());
    }

    public static void stackOfIntegers() {
        MyGenericStack<Integer> stack = new MyGenericStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Size of this stack : " + stack.getSize());
        System.out.println("Elements of this stack :");
        System.out.printf(" %d", stack.pop());
        System.out.printf(" %d", stack.pop());
        System.out.printf(" %d", stack.pop());
        System.out.println(" \n Size of this stack after pop : " + stack.getSize());
    }

    public static void main(String[] args) {
        System.out.println("Result String :");
        stackOfIStrings();
        System.out.println("Result Int :");
        stackOfIntegers();
    }
}
