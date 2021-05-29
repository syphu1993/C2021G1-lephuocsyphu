package model.service;

import model.bean.Product;

import java.util.List;

public interface IProductManager {
    List<Product> findByAll();
    Product findById(String id);
    void update(String id, Product product);
    void add(Product product);
    void remove(String id);
}
