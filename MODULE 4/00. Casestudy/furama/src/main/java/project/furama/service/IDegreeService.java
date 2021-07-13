package project.furama.service;

import project.furama.model.Degree;
import project.furama.model.Position;

public interface IDegreeService {
    Iterable<Degree> findAll();
}
