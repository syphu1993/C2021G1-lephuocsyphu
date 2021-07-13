package project.furama.service;

import project.furama.model.Position;

public interface IPositionService {
    Iterable<Position> findAll();
}
