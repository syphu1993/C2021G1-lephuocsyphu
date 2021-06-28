package book.manager.service;

import book.manager.model.BorowBook;
import book.manager.repository.BorowBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorowBookService implements IBorowBook {
    @Autowired
    BorowBookRepository borowBookRepository;
    @Override
    public Iterable<BorowBook> findAll() {
        return borowBookRepository.findAll();
    }

    @Override
    public Optional<BorowBook> findById(Integer id) {
        return borowBookRepository.findById(id);
    }

    @Override
    public void save(BorowBook borowBook) {
        borowBookRepository.save(borowBook);
    }

    @Override
    public void remove(Integer id) {
        borowBookRepository.deleteById(id);
    }
}
