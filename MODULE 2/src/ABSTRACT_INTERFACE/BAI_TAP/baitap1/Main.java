package ABSTRACT_INTERFACE.BAI_TAP.baitap1;


import INHERITANCE.thuc_hanh.Shape;

public class Main {
    public static void main(String[] args) {
        Shape[] shape = new Shape[3];
        shape[0] = new Cricle(100);
        shape[1] =new Rectangcular(10,100);
        shape[2] = new Square(10);
        System.out.println(((Cricle) shape[0]).getArea());
        System.out.println(((Rectangcular) shape[1]).getArea());
        System.out.println(((Square) shape[2]).getArea());
        double percent = Math.random();
        ((Cricle) shape[0]).reside(percent);
        ((Rectangcular) shape[1]).reside(percent);
        ((Square) shape[2]).reside(percent);
        System.out.println("new area : ");
        System.out.println(((Cricle) shape[0]).getArea());
        System.out.println(((Rectangcular) shape[1]).getArea());
        System.out.println(((Square) shape[2]).getArea());
    }
}
