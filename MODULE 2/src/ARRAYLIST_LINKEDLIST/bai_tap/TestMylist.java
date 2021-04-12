package ARRAYLIST_LINKEDLIST.bai_tap;

import java.util.Arrays;

public class TestMylist {
    public static void main(String[] args) {
        Mylist<Integer> mylist = new Mylist<Integer>();
        mylist.add(9);
        mylist.add(4);
        mylist.add(3);
        mylist.add(2);
        mylist.add(8);
        mylist.add(8);
        mylist.add(-8);
        mylist.add(-5);
        System.out.println(mylist.getElement(1));
        System.out.println("mylist"+Arrays.toString(mylist.element));
        mylist.addindex(3, 9);
        System.out.println("newlist after add object"+Arrays.toString(mylist.element));
        mylist.remove(0);
        System.out.println("newlist after remove object"+Arrays.toString(mylist.element));
        System.out.println("size of mylist :"+mylist.getSize());
        System.out.println(mylist.contains(3));
        System.out.println("newlist after clone"+Arrays.toString(mylist.clone().element));
        System.out.println("idexof of 3 :"+mylist.indexOf(3));
        mylist.clear();
        System.out.println("newlist after clear"+Arrays.toString(mylist.element));
    }
}
