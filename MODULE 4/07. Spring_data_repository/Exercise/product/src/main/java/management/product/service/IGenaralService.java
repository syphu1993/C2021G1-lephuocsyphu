package management.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGenaralService<T> {
    Page<T> findAll(Pageable pageable);

    Optional<T> findById(Integer id);

    void save(T t);

    void remove(Integer id);
}
