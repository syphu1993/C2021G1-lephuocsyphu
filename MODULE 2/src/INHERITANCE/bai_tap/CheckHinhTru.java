package INHERITANCE.bai_tap;

public class CheckHinhTru {
    public static void main(String[] args) {
        Circle cr1 =new Circle("red",100);
        System.out.println(cr1.getArea());
        HinhTru ht1 = new HinhTru("blue",100,100);
        System.out.println(ht1.tinhTheTich());
        System.out.println(ht1.toString());
    }
}
