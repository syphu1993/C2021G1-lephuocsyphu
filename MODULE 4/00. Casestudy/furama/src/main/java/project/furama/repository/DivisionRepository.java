package project.furama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.furama.model.Division;

@Repository
public interface DivisionRepository extends JpaRepository<Division,Integer> {
}
