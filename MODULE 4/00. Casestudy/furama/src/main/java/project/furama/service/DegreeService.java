package project.furama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.furama.model.Degree;
import project.furama.repository.DegreeRepository;

@Service
public class DegreeService implements IDegreeService{
    @Autowired
    private DegreeRepository degreeRepository;
    @Override
    public Iterable<Degree> findAll() {
        return degreeRepository.findAll();
    }
}
