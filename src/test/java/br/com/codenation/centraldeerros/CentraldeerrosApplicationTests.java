package br.com.codenation.centraldeerros;

import br.com.codenation.centraldeerros.entity.Log;
import br.com.codenation.centraldeerros.entity.User;
import br.com.codenation.centraldeerros.entity.enums.Level;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;


@SpringBootTest
class CentraldeerrosApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	void userClassCreationTest() {
		User user = new User(2L,"testing@hotmail.com", "123");
		assertEquals(2L, user.getId());
		assertEquals("testing@hotmail.com", user.getEmail());
		assertEquals("123", user.getPassword());
	}

	@Test
	void userClassModificationTest() {
		User user = new User(2L,"testing@hotmail.com", "123");
		assertEquals(2L, user.getId());
		assertEquals("testing@hotmail.com", user.getEmail());
		assertEquals("123", user.getPassword());

		user.setEmail("modificado@gmail.com");
		user.setPassword("456");

		assertEquals("modificado@gmail.com", user.getEmail());
		assertEquals("456", user.getPassword());
	}

	@Test
	void logClassCreation(){
		LocalDateTime date = LocalDateTime.now();

		Log log = new Log( Level.ERROR, "descricao", "log","origem",date,date, 1L);

		assertEquals(Level.ERROR, log.getLevel());
		assertEquals("descricao", log.getDescription());
		assertEquals("log", log.getEventLog());
		assertEquals("origem", log.getOrigin());
		assertEquals(1L, log.getEventNumber());
		assertEquals(date, log.getCreatedAt());
		assertEquals(date, log.getUpdatedAt());
	}
}
