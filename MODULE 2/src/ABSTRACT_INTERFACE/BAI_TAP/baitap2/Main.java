package ABSTRACT_INTERFACE.BAI_TAP.baitap2;

import ABSTRACT_INTERFACE.BAI_TAP.baitap1.Cricle;
import ABSTRACT_INTERFACE.BAI_TAP.baitap1.Rectangcular;
import ABSTRACT_INTERFACE.BAI_TAP.baitap1.Square;
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
        System.out.println(((Square) shape[2]).howToCollor());
    }
}
