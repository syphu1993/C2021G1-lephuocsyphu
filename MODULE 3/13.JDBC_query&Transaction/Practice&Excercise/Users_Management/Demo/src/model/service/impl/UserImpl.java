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

    @Override
    public List<User> findByCountry(String country) {
        return userRepository.findByCountry(country);
    }

    @Override
    public List<User> sortByName() {
        return userRepository.sortByName();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        userRepository.insertUserStore(user);
    }

    @Override
    public void addUserTransaction(User user, int[] permision) {
        userRepository.addUserTransaction(user,permision);
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        userRepository.insertUpdateWithoutTransaction();
    }

    @Override
    public void insertUpdateUseTransaction() {
        userRepository.insertUpdateUseTransaction();
    }

    @Override
    public List<User> displayAllUsersbyProceduce() {
        return userRepository.displayAllUsersbyProceduce();
    }

    @Override
    public boolean editUserByProceduce(User user) throws SQLException {
        return userRepository.editUserByProceduce(user);
    }

    @Override
    public boolean delUserByProceduce(int id) throws SQLException {
        return userRepository.delUserByProceduce(id);
    }
}
