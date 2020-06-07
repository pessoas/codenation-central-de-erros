package br.com.codenation.centraldeerros;

import br.com.codenation.centraldeerros.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CentraldeerrosApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void userClassCreationTest() {
		User user = new User(2L,"testing@hotmail.com", "123");
		assert user.getId().equals(2L);
		assert user.getEmail().equals("testing@hotmail.com");
		assert user.getPassword().equals("123");
	}

	@Test
	void userClassModificationTest() {
		User user = new User(2L,"testing@hotmail.com", "123");
		assert user.getId().equals(2L);
		assert user.getEmail().equals("testing@hotmail.com");
		assert user.getPassword().equals("123");

		user.setEmail("modificado@gmail.com");
		user.setPassword("456");

		assert user.getEmail().equals("modificado@gmail.com");
		assert user.getPassword().equals("456");
	}

}
