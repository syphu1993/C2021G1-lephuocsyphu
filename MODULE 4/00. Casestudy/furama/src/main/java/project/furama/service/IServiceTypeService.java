package project.furama.service;

import project.furama.model.ServiceType;

public interface IServiceTypeService {
    Iterable<ServiceType> findAll();
}
