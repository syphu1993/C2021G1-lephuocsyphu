package INHERITANCE.bai_tap;

import java.util.Arrays;

public class CheckPoin {
    public static void main(String[] args) {
        Point2D poin2d1 = new Point2D(3,1);
        poin2d1.setXY(2,3);
        System.out.println("Point2D : ");
        for (int i = 0; i <poin2d1.getXY().length ; i++) {
            System.out.print(poin2d1.getXY()[i]+ " ");
        }
        System.out.println();
        Poin3D poi3d1 = new Poin3D(2,3,4);
        System.out.println("Point3D = " + Arrays.toString(poi3d1.getXYZ()));
//        for (int i = 0; i <poi3d1.getXYZ().length ; i++) {
//            System.out.print(poi3d1.getXYZ()[i]+ " ");
//        }
        MoveablePoint newPoint = new MoveablePoint(10,10,1,1);
        System.out.println(newPoint.toString());
        System.out.println("new Point = " + Arrays.toString(newPoint.move()));
    }
}
