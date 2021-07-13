package project.furama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.furama.model.Division;
import project.furama.repository.DivisionRepository;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private DivisionRepository divisionRepository;
    @Override
    public Iterable<Division> findAll() {
        return divisionRepository.findAll();
    }
}
