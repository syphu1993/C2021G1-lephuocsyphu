package management.product.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameProduct;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "type_id",referencedColumnName ="id" )
    private Type type;

    public Product() {
    }

    public Product(Integer id, String nameProduct, Integer quantity, Type type) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.type = type;
    }

    public Product(String nameProduct, Integer quantity, Type type) {
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
