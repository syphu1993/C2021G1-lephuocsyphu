package project.furama.service;

import project.furama.model.RentType;

public interface IRentTypeService {
    Iterable<RentType> findAll();
}
