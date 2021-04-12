package ABSTRACT_INTERFACE.BAI_TAP.baitap1;

import INHERITANCE.thuc_hanh.RecTangle;

public class Rectangcular extends RecTangle implements Resizeable {
    public Rectangcular() {
    }

    public Rectangcular(double width, double hight) {
        super(width, hight);
    }

    public Rectangcular(String collor, boolean filled, double width, double hight) {
        super(collor, filled, width, hight);
    }

    @Override
    public void reside(double percent) {
        width = width*percent;
    }
}
