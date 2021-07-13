package project.furama.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import project.furama.model.AppUser;
import project.furama.model.UserRole;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
