package ABSTRACT_INTERFACE.THUC_HANH.test;


import ABSTRACT_INTERFACE.THUC_HANH.hinh.CircleComparator2;
import INHERITANCE.thuc_hanh.Circle;

import java.util.Arrays;

public class TestCircle1 {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(100);
        circles[1] = new Circle(50);
        circles[2]= new Circle(150);
        System.out.println("Circle: ");
        for (Circle circle:circles) {
            System.out.println(circle);
        }
        CircleComparator2 circleComparate = new CircleComparator2();
        Arrays.sort(circles,circleComparate);
        System.out.println("Circle after sort: ");
        for (Circle circle:circles) {
            System.out.println(circle);
        }
    }
}
