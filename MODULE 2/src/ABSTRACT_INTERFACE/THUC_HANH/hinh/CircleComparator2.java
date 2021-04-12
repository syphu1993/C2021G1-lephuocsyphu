package ABSTRACT_INTERFACE.THUC_HANH.hinh;


import INHERITANCE.thuc_hanh.Circle;

import java.util.Comparator;

public class CircleComparator2  implements Comparator<Circle> {
    public CircleComparator2() {
    }
    @Override
    public int compare(Circle o1, Circle o2) {
        if (o1.getRadius() > o2.getRadius()) return 1;
        else if (o1.getRadius() < o2.getRadius()) return -1;
        else return 0;
    }
}
