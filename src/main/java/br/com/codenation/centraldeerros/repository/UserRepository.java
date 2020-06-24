package br.com.codenation.centraldeerros.repository;

import br.com.codenation.centraldeerros.entity.User;
import br.com.codenation.centraldeerros.projection.UserEmailAndIdOnly;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    List<UserEmailAndIdOnly> findBy();
    Optional<User> findByEmail(String email);
}
