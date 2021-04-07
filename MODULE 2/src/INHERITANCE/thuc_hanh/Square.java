package INHERITANCE.thuc_hanh;

public class Square extends RecTangle {
    public Square() {
    }
    public Square(double side) {
        super(side, side);
    }

    public Square(String collor, boolean filled, double size) {
        super(collor, filled, size, size);
    }
    protected double getSize(){
        return getWidth();
    }
    protected  void setSize(double size){
        super.setWidth(size);
        super.setHight(size);
    }

    @Override
    public void setWidth(double width) {
        setSize(width);
    }

    @Override
    public void setHight(double hight) {
        setSize(hight);
    }

    @Override
    public String toString() {
        return "Square with size ="+ getSize() + " and which is subclass of " + super.toString();
    }
}
