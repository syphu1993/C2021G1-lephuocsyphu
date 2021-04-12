package ARRAYLIST_LINKEDLIST.thuc_hanh;

import java.util.Arrays;

public class MylistTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<Integer>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);
        myList.add(8);
        myList.add(9);
        myList.add(10);
        myList.add(11);
        myList.add(12);
        System.out.println(Arrays.toString(myList.element));
        System.out.println(myList.getElement(5));
        System.out.println("size: "+myList.size);
        System.out.println("capacity: "+myList.capacity);


    }
}
