package br.com.codenation.centraldeerros.service.implementation;

import br.com.codenation.centraldeerros.entity.User;
import br.com.codenation.centraldeerros.projection.UserEmailAndIdOnly;
import br.com.codenation.centraldeerros.repository.UserRepository;
import br.com.codenation.centraldeerros.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEmailAndIdOnly> findAll() {
        return this.userRepository.findBy();
    }

    @Override
    public Optional<User> findById(Long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public User save(User newUser) {
        return this.userRepository.save(newUser);
    }

    @Override
    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.userRepository.findByEmail(email).get();
    }
}
