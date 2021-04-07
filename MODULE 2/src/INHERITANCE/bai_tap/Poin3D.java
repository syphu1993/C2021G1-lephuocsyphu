package INHERITANCE.bai_tap;

public class Poin3D extends Point2D {
    protected float z;

    public Poin3D() {
    }

    public Poin3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    protected void setXYZ(float x, float y, float z){
       this.x = x;
       this.y = y;
       this.z = z;
    }
    protected float[] getXYZ(){
        float[] array = {x,y,z};
        return array;
    }

    @Override
    public String toString() {
        return "Poin3D{" +
                "z=" + z +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
