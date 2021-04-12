package ARRAYLIST_LINKEDLIST.bai_tap;

public class TestLinked {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList(10);
        linkedList.addFirst(11);
        linkedList.addFirst(13);
        linkedList.addFirst(12);
        System.out.print(" LinkedList :");
        linkedList.printList();
        linkedList.add(1,3);
        System.out.print(" \n LinkedList after add first :");
        linkedList.printList();
        linkedList.addLast(15);
        linkedList.addLast(14);
        linkedList.addLast(10);
        System.out.print(" \n LinkedList after add last :");
        linkedList.printList();
        linkedList.remove(3);
        System.out.print(" \n LinkedList after remove :");
        linkedList.printList();
    }
}
