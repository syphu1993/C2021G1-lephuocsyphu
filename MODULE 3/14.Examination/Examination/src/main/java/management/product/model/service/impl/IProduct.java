package management.product.model.service.impl;

import management.product.model.bean.Product;

import java.util.List;
import java.util.Map;

public interface IProduct {
    List<Product> findAll();
    Product findById(int id);
    Map<String,String> save(Product product);
    boolean update(Product customer);
    boolean delete(int id);
    List<String> findCate();
    List<Product> findByName(String  name);
}
