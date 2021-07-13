package project.furama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.furama.model.RentType;
import project.furama.repository.RentTypeReopsitory;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private RentTypeReopsitory rentTypeReopsitory;
    @Override
    public Iterable<RentType> findAll() {
        return rentTypeReopsitory.findAll();
    }
}
