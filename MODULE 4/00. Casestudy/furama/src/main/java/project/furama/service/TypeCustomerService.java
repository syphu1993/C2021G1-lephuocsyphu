package project.furama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.furama.model.TypeCustomer;
import project.furama.repository.TypeCustomerRepository;

@Service
public class TypeCustomerService implements ITypeCustomerService {

    @Autowired
    private TypeCustomerRepository typeCustomerRepository;
    @Override
    public Iterable<TypeCustomer> findAll() {
        return typeCustomerRepository.findAll();
    }
}
