package ABSTRACT_INTERFACE.BAI_TAP.baitap1;

import INHERITANCE.thuc_hanh.Circle;

public class Cricle extends Circle implements Resizeable {
    public Cricle() {
    }

    public Cricle(double radius) {
        super(radius);
    }

    public Cricle(String collor, boolean filled, double radius) {
        super(collor, filled, radius);
    }

    @Override
    public void reside(double percent) {
        radius = radius*percent;
    }
}
