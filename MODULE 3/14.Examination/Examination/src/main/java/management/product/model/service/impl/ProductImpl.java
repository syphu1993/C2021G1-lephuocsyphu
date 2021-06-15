package management.product.model.service.impl;

import management.product.model.bean.Product;
import management.product.model.repository.ProductRepository;

import java.util.List;
import java.util.Map;

public class ProductImpl implements IProduct{
    ProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public Map<String, String> save(Product product) {
        productRepository.save(product);
        return null;
    }

    @Override
    public boolean update(Product customer) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return productRepository.delete(id);
    }

    @Override
    public List<String> findCate() {
        return productRepository.findCate();
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}
