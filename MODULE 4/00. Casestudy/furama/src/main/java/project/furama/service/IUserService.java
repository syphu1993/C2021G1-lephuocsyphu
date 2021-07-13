package project.furama.service;

import project.furama.model.AppUser;

import java.util.Optional;

public interface IUserService {
    Iterable<AppUser> findAll();
    Optional<AppUser> findById(String id);
    void save(AppUser user);
    void delete(String useName);
}
