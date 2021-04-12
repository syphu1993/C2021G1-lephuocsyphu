package ARRAYLIST_LINKEDLIST.thuc_hanh;

public class Node {
    protected Node next;
    protected Object data;

    public Node(Object data) {
        this.data = data;
    }
    public Object getDate(){
       return this.data;
    }
}
