package model.service.lmpl;

import model.bean.Product;
import model.reponsitory.ProductReponsitory;
import model.service.IProductManager;

import java.util.List;

public class ProductManagerlmpl implements IProductManager {
    ProductReponsitory productReponsitory = new ProductReponsitory();

    @Override
    public List<Product> findByAll() {
        return productReponsitory.findByAll();
    }

    @Override
    public Product findById(String id) {
        return productReponsitory.findById(id);
    }

    @Override
    public void update(String id, Product product) {
        productReponsitory.update(id, product);
    }

    @Override
    public void add(Product product) {
        productReponsitory.add(product);
    }

    @Override
    public void remove(String id) {
        productReponsitory.remove(id);
    }


}
