package project.furama.service;

import project.furama.model.Customer;
import project.furama.model.Service;

import java.util.Optional;

public interface IServiceService {
    Iterable<Service> findAll();
    void save(Service service);
}
