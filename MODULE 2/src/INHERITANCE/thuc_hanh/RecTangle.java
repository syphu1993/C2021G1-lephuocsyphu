package INHERITANCE.thuc_hanh;

public class RecTangle extends Shape {
    private double width = 1.0;
    private double hight = 1.0;

    public RecTangle() {
    }

    public RecTangle(double width, double hight) {
        this.width = width;
        this.hight = hight;
    }

    public RecTangle(String collor, boolean filled, double width, double hight) {
        super(collor, filled);
        this.width = width;
        this.hight = hight;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }
    protected double getaArea(){
        return width*hight;
    }
    protected double getaPerimeter(){
        return (width+hight)*2;
    }

    @Override
    public String toString() {
        return "RecTangle with width = " + width + " ,hight :" + hight + " anh which is subclass of " + super.toString();
    }
}
