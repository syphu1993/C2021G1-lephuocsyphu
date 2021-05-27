package customer_table;

public class Customer {
    private String name;
    private String birthday;
    private String adress;
    private String picture;

    public Customer() {
    }

    public Customer(String name, String birthday, String adress, String picture) {
        this.name = name;
        this.birthday = birthday;
        this.adress = adress;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", adress='" + adress + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
