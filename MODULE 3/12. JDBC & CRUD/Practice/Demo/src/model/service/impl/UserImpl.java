package model.service.impl;

import model.bean.User;
import model.repository.UserRepository;
import model.service.IUser;

import java.sql.SQLException;
import java.util.List;

public class UserImpl implements IUser {
    UserRepository userRepository = new UserRepository();
    @Override
    public void insertUser(User user) throws SQLException {
      userRepository.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return userRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return userRepository.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return userRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return userRepository.updateUser(user);
    }
}
