package user.infor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.infor.model.User;
import user.infor.repository.IUserRepository;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
