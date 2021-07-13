package project.furama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.furama.model.AttachService;

@Repository
public interface AttachServiceRepository extends JpaRepository<AttachService,Integer> {
}
