package STACK__QUEUE.BAI_TAP;

public class Student {
    private String name;
    private String genger;
    private int year;

    public Student() {
    }

    public Student(String name, String genger, int year) {
        this.name = name;
        this.genger = genger;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenger() {
        return genger;
    }

    public void setGenger(String genger) {
        this.genger = genger;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", genger='" + genger + '\'' +
                ", year=" + year +
                '}';
    }
}
