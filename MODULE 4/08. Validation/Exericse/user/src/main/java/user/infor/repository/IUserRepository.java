package user.infor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import user.infor.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
}
