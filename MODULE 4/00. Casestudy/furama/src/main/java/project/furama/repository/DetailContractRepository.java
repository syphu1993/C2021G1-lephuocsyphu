package project.furama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.furama.model.DetailContract;

@Repository
public interface DetailContractRepository extends JpaRepository<DetailContract,Integer> {
}
