package project.furama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.furama.model.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position,Integer> {
}
