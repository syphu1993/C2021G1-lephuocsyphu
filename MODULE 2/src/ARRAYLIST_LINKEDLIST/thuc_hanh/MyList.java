package ARRAYLIST_LINKEDLIST.thuc_hanh;

import java.util.Arrays;

public class MyList<E> {
    protected int size=0;
    protected int capacity=10;
    protected Object element[];

    public MyList() {
        element = new Object[capacity];
    }
    private void ensureCapa() {
        int newSize = element.length * 2;
        element = Arrays.copyOf(element, newSize);
    }
    public void add(E e){
    if (size == element.length){
        ensureCapa();
    }else {
        element[size++]=e;
    }
    }
    public E getElement(int i){
        if (i>= size|| i<0){
            throw new IndexOutOfBoundsException("Index :" +i+", size "+i);
        }return (E) element[i];
    }
}
