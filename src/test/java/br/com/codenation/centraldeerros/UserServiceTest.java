package br.com.codenation.centraldeerros;

import br.com.codenation.centraldeerros.entity.User;
import br.com.codenation.centraldeerros.projection.UserEmailAndIdOnly;
import br.com.codenation.centraldeerros.repository.UserRepository;
import br.com.codenation.centraldeerros.service.implementation.UserServiceImpl;
import br.com.codenation.centraldeerros.service.interfaces.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserServiceTest {

    @TestConfiguration
    static class UserServiceTestContextConfiguration {

        @Bean
        public UserServiceImpl userService() {
            return new UserServiceImpl();
        }
    }

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void createShouldPersistData() {
        User user = new User("teste@email.com", "123");

        this.userService.save(user);

        assertNotNull(user.getId());
        assertEquals("teste@email.com", user.getEmail());
        assertEquals("123", user.getPassword());
    }

    @Test
    public void deleteShouldRemoveData() {
        User user = new User("teste@email.com", "123");

        this.userService.save(user);
        this.userService.deleteById(user.getId());

        assertEquals(Optional.empty(), this.userService.findById(user.getId()));
    }

    @Test
    public void updateShouldModifyAndPersistData() {
        User user = new User("teste@email.com", "123");

        this.userService.save(user);

        user.setEmail("testing@email.com");
        this.userService.save(user);

        user = this.userService.findById(user.getId()).get();

        assertEquals("testing@email.com", user.getEmail());
    }

    @Test
    public void findAllShouldReturnListOfUserEmailOnly() {
        User user = new User("teste@email.com", "123");
        User user2 = new User("testing@email.com", "432");

        this.userService.save(user);
        this.userService.save(user2);

        List<UserEmailAndIdOnly> userEmailAndIdOnlyList = this.userService.findAll();

        assertEquals(2, userEmailAndIdOnlyList.size());
    }

    @Test
    public void findByEmailShouldReturnUser() {
        User user = new User("teste@email.com", "123");
        User user2 = new User("testing@email.com", "432");

        this.userService.save(user);
        this.userService.save(user2);

        User dbUser = this.userService.findByEmail(user.getEmail()).get();

        assertEquals(user, dbUser);
    }

    @Test
    public void findByIdShouldReturnUser() {
        User user = new User("teste@email.com", "123");
        User user2 = new User("testing@email.com", "432");

        this.userService.save(user);
        this.userService.save(user2);

        User dbUser = this.userService.findById(user.getId()).get();

        assertEquals(user, dbUser);
    }
}
