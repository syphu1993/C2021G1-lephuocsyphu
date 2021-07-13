package project.furama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.furama.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Integer> {
}
