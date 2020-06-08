package br.com.codenation.centraldeerros;

import br.com.codenation.centraldeerros.entity.Log;
import br.com.codenation.centraldeerros.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;

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

	@Test
	void logClassCreation(){
		LocalDateTime date = LocalDateTime.now();

		Log log = new Log(1L, "level", "descricao", "log","origem",date, 1L);

		assert log.getId().equals(1L);
		assert log.getLevel().equals("level");
		assert log.getDescription().equals("descricao");
		assert log.getEventLog().equals("log");
		assert log.getOrigin().equals("origem");
		assert log.getEventNumber().equals(1L);
		assert log.getCreatedAt().equals(date);
	}

	@Test
	void logClassModification(){
		LocalDateTime date = LocalDateTime.now();

		Log log = new Log(1L, "level", "descricao", "log","origem",date, 1L);

		log.setLevel("level2");
		log.setDescription("descricao2");
		log.setEventLog("log2");
		log.setOrigin("origem2");
		log.setEventNumber(2L);
		date = LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30);
		log.setCreatedAt(date);

		assert log.getId().equals(1L);
		assert log.getLevel().equals("level2");
		assert log.getDescription().equals("descricao2");
		assert log.getEventLog().equals("log2");
		assert log.getOrigin().equals("origem2");
		assert log.getEventNumber().equals(2L);
		assert log.getCreatedAt().equals(date);
	}

}
