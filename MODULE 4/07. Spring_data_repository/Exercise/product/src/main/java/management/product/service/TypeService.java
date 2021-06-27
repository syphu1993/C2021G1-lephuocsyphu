package management.product.service;

import management.product.model.Type;
import management.product.repository.ITypePrository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeService implements ITypeService {
    @Autowired
    ITypePrository typePrository;
    @Override
    public Page<Type> findAll(Pageable pageable) {
        return typePrository.findAll(pageable);
    }

    @Override
    public Optional<Type> findById(Integer id) {
        return typePrository.findById(id);
    }

    @Override
    public void save(Type type) {
    typePrository.save(type);
    }

    @Override
    public void remove(Integer id) {
    typePrository.deleteById(id);
    }
}
