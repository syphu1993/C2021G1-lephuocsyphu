package product.service;

import product.model.Product;

import java.util.List;

public interface Iproduct {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);
}
