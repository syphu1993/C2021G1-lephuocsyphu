package management.product.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "types")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameType;

    @OneToMany(mappedBy = "type")
    private List<Product> productList;

    public Type() {
    }

    public Type(Integer id, String nameType) {
        this.id = id;
        this.nameType = nameType;
    }

    public Type(String nameType) {
        this.nameType = nameType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
