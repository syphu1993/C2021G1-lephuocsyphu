package management.product.model.bean;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quanlity;
    private String collor;
    private String decrip;
    private String catelogy;

    public Product(int id, String name, double price, int quanlity, String collor, String decrip, String catelogy) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quanlity = quanlity;
        this.collor = collor;
        this.decrip = decrip;
        this.catelogy = catelogy;
    }

    public Product(String name, double price, int quanlity, String collor, String decrip, String catelogy) {
        this.name = name;
        this.price = price;
        this.quanlity = quanlity;
        this.collor = collor;
        this.decrip = decrip;
        this.catelogy = catelogy;
    }

    public Product(int id, String name, double price, int quanlity, String collor, String catelogy) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quanlity = quanlity;
        this.collor = collor;
        this.catelogy = catelogy;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }

    public String getCollor() {
        return collor;
    }

    public void setCollor(String collor) {
        this.collor = collor;
    }

    public String getDecrip() {
        return decrip;
    }

    public void setDecrip(String decrip) {
        this.decrip = decrip;
    }

    public String getCatelogy() {
        return catelogy;
    }

    public void setCatelogy(String catelogy) {
        this.catelogy = catelogy;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quanlity=" + quanlity +
                ", collor='" + collor + '\'' +
                ", decrip='" + decrip + '\'' +
                ", catelogy='" + catelogy + '\'' +
                '}';
    }
}
