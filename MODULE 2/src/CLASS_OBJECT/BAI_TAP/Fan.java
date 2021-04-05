package CLASS_OBJECT.BAI_TAP;

public class Fan {
    private final int slow =1;
    private final int medium =2;
    public final int fast =3;
    private int speed = 1;
    private boolean on = false;
    private double radius = 5;
    private String collor = "blue";

    public Fan() {
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSlow() {
        return slow;
    }

    public int getMedium() {
        return medium;
    }

    public int getFast() {
        return fast;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getCollor() {
        return collor;
    }

    public void setCollor(String collor) {
        this.collor = collor;
    }

    @Override
    public String toString() {
        if (isOn()==false){
        return "Fan{" +
                " Radius=" + radius +
                ", collor='" + collor + '\'' +
                ", fan is off"+
                '}';
    } else {
            return "Fan{" +
                    "speed = "+ speed +
                    ", radius=" + radius +
                    ", collor='" + collor + '\'' +
                    ", fan is on "+
                    '}';
        }
    }
}
