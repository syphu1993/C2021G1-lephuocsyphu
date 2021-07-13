package project.furama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.furama.model.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Integer> {
}
