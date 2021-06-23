package block.blockapp.service;

import java.util.Optional;

public interface IGeneralBlog<T> {
    Iterable<T> findAll();

    Optional<T> findById(Integer id);

    void save(T t);

    void remove(Integer id);
}
