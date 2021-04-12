package ARRAYLIST_LINKEDLIST.bai_tap;

public class MyLinkedList {
    protected Node head;
    protected int numNodes;

    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    public void add(int index, Object data) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public void addLast(Object data) {
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = new Node(data);
        tail = tail.next;
        numNodes++;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-");
            temp = temp.next;
        }
    }
    public void remove(int index){
        Node temp = head;
        for (int i = 0; i < index-1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        numNodes--;
    }
    public void removeObj(Object data){
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            if (temp.data == data){
                
            }
        }
    }
}
