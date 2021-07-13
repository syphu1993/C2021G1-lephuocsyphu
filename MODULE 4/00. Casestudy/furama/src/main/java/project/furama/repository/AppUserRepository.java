package project.furama.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import project.furama.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findByUserName(String userName);
}
