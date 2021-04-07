package INHERITANCE.bai_tap;

public class MoveablePoint extends Point2D {
    protected float xSpeed;
    protected float ySpeed;

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint() {
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    protected void setSpeed(float xSpeed, float ySpeed){
       this.xSpeed = xSpeed;
       this.ySpeed = ySpeed;
    }
    protected float[] getSpeed(){
        float[] array = {xSpeed,ySpeed};
        return array;
    }

    @Override
    public String toString() {
        return "("+ this.x + ","+this.y + "),speed =("+this.xSpeed + "," +this.ySpeed+")";
    }
    protected float[] move(){
        this.x += this.xSpeed;
        this.y += this.ySpeed;
        return super.getXY();
    }
}
