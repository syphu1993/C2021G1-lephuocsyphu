package ABSTRACT_INTERFACE.THUC_HANH.test;

import ABSTRACT_INTERFACE.THUC_HANH.hinh.ComparableCircle;

import java.util.Arrays;

public class TestCircle {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle("blue",true,10);
        circles[1] = new ComparableCircle();
        circles[2]= new ComparableCircle(100);
        System.out.println("Circle: ");
        for (ComparableCircle circle:circles) {
            System.out.println(circle);
        }
        Arrays.sort(circles);
        System.out.println("Circle: ");
        for (ComparableCircle circle:circles) {
            System.out.println(circle);
        }
    }
}
