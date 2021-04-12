package INHERITANCE.thuc_hanh;

public class Shape {
    protected String collor = "green";
    protected boolean filled = true;

    public Shape() {
    }

    public Shape(String collor, boolean filled) {
        this.collor = collor;
        this.filled = filled;
    }

    public String getCollor() {
        return collor;
    }

    public void setCollor(String collor) {
        this.collor = collor;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "A Shape with color of " + getCollor() +" and"+ (isFilled()? "filled" : "not filled");
    }
}
