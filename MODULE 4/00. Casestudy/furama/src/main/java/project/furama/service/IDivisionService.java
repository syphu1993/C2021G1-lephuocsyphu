package project.furama.service;

import project.furama.model.Division;
import project.furama.model.Position;

public interface IDivisionService {
    Iterable<Division> findAll();
}
