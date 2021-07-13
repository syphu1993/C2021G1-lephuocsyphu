package project.furama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.furama.model.AppUser;
@Repository
public interface UserRepository extends JpaRepository<AppUser,String> {
}
