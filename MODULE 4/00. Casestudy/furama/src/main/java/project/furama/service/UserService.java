package project.furama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.furama.model.AppUser;
import project.furama.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Iterable<AppUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<AppUser> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(AppUser user) {
        userRepository.save(user);
    }

    @Override
    public void delete(String useName) {
        userRepository.deleteById(useName);
    }
}
