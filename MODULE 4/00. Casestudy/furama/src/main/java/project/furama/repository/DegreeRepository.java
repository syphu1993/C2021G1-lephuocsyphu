package project.furama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.furama.model.Degree;

@Repository
public interface DegreeRepository extends JpaRepository<Degree,Integer> {
}
