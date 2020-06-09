package br.com.codenation.centraldeerros.service.interfaces;

import br.com.codenation.centraldeerros.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    User save(User newUser);
    void deleteById(Long id);
}
