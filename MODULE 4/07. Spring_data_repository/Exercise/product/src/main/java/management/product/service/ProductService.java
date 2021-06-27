package management.product.service;

import management.product.model.Product;
import management.product.repository.IproductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    IproductRepository iproductRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iproductRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return iproductRepository.findById(id);
    }

    @Override
    public void save(Product product) {
    iproductRepository.save(product);
    }

    @Override
    public void remove(Integer id) {
    iproductRepository.deleteById(id);
    }
}
