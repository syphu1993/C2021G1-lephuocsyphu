package project.furama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.furama.model.ServiceType;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
}
