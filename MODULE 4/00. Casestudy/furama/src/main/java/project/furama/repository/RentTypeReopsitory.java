package project.furama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.furama.model.RentType;

@Repository
public interface RentTypeReopsitory extends JpaRepository<RentType,Integer> {
}
