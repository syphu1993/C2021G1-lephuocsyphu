package ABSTRACT_INTERFACE.BAI_TAP.baitap1;

import ABSTRACT_INTERFACE.BAI_TAP.baitap2.Collorble;

public class Square extends INHERITANCE.thuc_hanh.Square implements Resizeable, Collorble {
    public Square() {
    }

    public Square(double side) {
        super(side);
    }

    public Square(String collor, boolean filled, double size) {
        super(collor, filled, size);
    }

    @Override
    public void reside(double percent) {
        width = width*percent;
        hight =  hight*percent;
    }

    @Override
    public String howToCollor() {
        return "Color all four sides";
    }
}
