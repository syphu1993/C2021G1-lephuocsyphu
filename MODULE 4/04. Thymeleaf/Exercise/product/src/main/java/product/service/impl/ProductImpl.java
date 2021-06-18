package product.service.impl;

import org.springframework.stereotype.Service;
import product.model.Product;
import product.service.Iproduct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductImpl implements Iproduct {
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Nokiax", "abc", 11));
        products.put(2, new Product(2, "Iphonex", "xyz", 14));
        products.put(3, new Product(3, "LGx", "fff", 15));
        products.put(4, new Product(4, "Xiaomix", "ggg", 14));
        products.put(5, new Product(5, "Motorolax", "kkk", 13));
        products.put(6, new Product(6, "Oppo", "rrr", 12));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product customer) {
        products.put(customer.getId(), customer);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product customer) {
        products.put(id, customer);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
