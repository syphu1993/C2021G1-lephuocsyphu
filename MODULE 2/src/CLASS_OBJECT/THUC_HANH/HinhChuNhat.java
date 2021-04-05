package CLASS_OBJECT.THUC_HANH;

import java.util.Scanner;

public class HinhChuNhat {
    float width;
    float hight;
    public HinhChuNhat() {
    }
    public HinhChuNhat(float width, float hight) {
        this.width = width;
        this.hight = hight;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public float getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }
    public String disPlay(){
        return "Rectangle { width : "+ width+" ; hight :" + hight + "}";
    }
}
