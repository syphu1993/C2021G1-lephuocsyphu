package INHERITANCE.bai_tap;

public class HinhTru extends Circle {
    protected double hight;

    public HinhTru() {
    }

    public HinhTru(double hight) {
        this.hight = hight;
    }

    public HinhTru(String collor, double radius, double hight) {
        super(collor, radius);
        this.hight = hight;
    }
    protected double tinhTheTich(){
        return super.getArea()*this.hight;
    }

    @Override
    public String toString() {
        return "HinhTru{" +
                "hight=" + hight +
                '}';
    }
}
