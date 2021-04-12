package ARRAYLIST_LINKEDLIST.bai_tap;

import java.util.Arrays;

public class Mylist<E> {
    public int size = 0;
    public int capacity = 5;
    public Object element[];

    public Mylist() {
        element = new Object[capacity];
    }

    private void ensureCapa(int minCapa) {
        int newSize = element.length + minCapa;
        element = Arrays.copyOf(element, newSize);
    }

    public void add(E e) {
        if (size == element.length) {
            ensureCapa(5);
        } else {
            element[size++] = e;
        }
    }
    public void addindex(int index, E o){
        if (size == element.length) {
            ensureCapa(5);
        } else {
            for (int i = size; i >index ; i--) {
                element[i] = element[i-1];
            }element[index] = o;
        }
    }

    public E getElement(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index :" + i + ", size " + i);
        }
        return (E) element[i];
    }

    public void remove(int i) {
        if (i >= 0 || i < size) {
            for (int j = i; j < size; j++) {
                element[j] = element[j + 1];
            }
        }else {
            getElement(i);
        } element[size]=null;
    }
    public int getSize(){
        return size;
    }
    public boolean contains(E o){
        boolean check=false;
        for (int i = 0; i <size ; i++) {
          if (element[i] == o){
              check = true;
              break;
          } else {
              check = false;
          }
        } return check;
    }
    public Mylist<E> clone(){
       Mylist<E> newMylist = new Mylist<E>();
       newMylist.element=new Object[size];
        for (int i = 0; i <size ; i++) {
            newMylist.add((E) element[i]);
        }
        return newMylist;
    }
    public int indexOf(E o){
        int index = 0;
        if (contains(o)) {
            for (int i = 0; i <size ; i++) {
                if(element[i]== o){
                    index=i;
                }
            }
        }
        return index;
    }
    public void clear(){
        for (int i = 0; i <size ; i++) {
            remove(0);
        }
    }
}
