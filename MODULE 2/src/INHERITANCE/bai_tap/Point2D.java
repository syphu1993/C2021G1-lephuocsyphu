package INHERITANCE.bai_tap;

public class Point2D {
    protected float x;
    protected float y;

    public Point2D() {
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    protected void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }
    protected float[] getXY(){
        float[] array = {x,y};
        return array;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
