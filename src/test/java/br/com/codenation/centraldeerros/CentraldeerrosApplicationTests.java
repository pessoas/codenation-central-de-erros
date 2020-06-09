package br.com.codenation.centraldeerros;

import br.com.codenation.centraldeerros.entity.Log;
import br.com.codenation.centraldeerros.entity.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
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

		Log log = new Log(1L, "level", "descricao", "log","origem",date, 1L);

		assertEquals(1L, log.getId());
		assertEquals("level", log.getLevel());
		assertEquals("descricao", log.getDescription());
		assertEquals("log", log.getEventLog());
		assertEquals("origem", log.getOrigin());
		assertEquals(1L, log.getEventNumber());
		assertEquals(date, log.getCreatedAt());

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

		assertEquals("level2", log.getLevel());
		assertEquals("descricao2", log.getDescription());
		assertEquals("log2", log.getEventLog());
		assertEquals("origem2", log.getOrigin());
		assertEquals(2L, log.getEventNumber());
		assertEquals(date, log.getCreatedAt());
	}

}
