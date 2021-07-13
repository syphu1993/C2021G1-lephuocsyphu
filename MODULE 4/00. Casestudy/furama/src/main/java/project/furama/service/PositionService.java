package project.furama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.furama.model.Position;
import project.furama.repository.PositionRepository;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private PositionRepository positionRepository;
    @Override
    public Iterable<Position> findAll() {
        return positionRepository.findAll();
    }
}
