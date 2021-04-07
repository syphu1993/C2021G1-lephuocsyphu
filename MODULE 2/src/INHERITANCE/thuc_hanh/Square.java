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
        setWidth(size);
        setHight(size);
    }

    @Override
    public void setWidth(double width) {
        setSize(width);
    }

    @Override
    public void setHight(double hight) {
        setSize(hight);
    }
}
