package br.com.codenation.centraldeerros;

import br.com.codenation.centraldeerros.entity.Log;
import br.com.codenation.centraldeerros.entity.enums.Level;
import br.com.codenation.centraldeerros.projection.LogNoEventLog;
import br.com.codenation.centraldeerros.repository.LogRepository;
import br.com.codenation.centraldeerros.service.implementation.LogServiceImpl;
import br.com.codenation.centraldeerros.service.interfaces.LogService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class LogServiceTest {

    @TestConfiguration
    static class LogServiceImplTestContextConfiguration {

        @Bean
        public LogServiceImpl logService() {
            return new LogServiceImpl();
        }
    }

    @Autowired
    private LogService logService;

    @Autowired
    private LogRepository logRepository;

    @Test
    public void createShouldPersistData(){

        Log log = new Log(Level.ERROR, "descricao", "evento", "origin",
                LocalDateTime.now(), LocalDateTime.now(), 1L);

        this.logService.save(log);

        assertNotNull(log.getId());
        assertEquals(Level.ERROR, log.getLevel());
        assertEquals("descricao", log.getDescription());
        assertEquals("evento", log.getEventLog());
        assertEquals("origin", log.getOrigin());
        assertEquals(1L, log.getEventNumber());
    }

    @Test
    public void deleteShouldRemoveData() {
        Log log = new Log(Level.ERROR, "descricao", "evento", "origin",
                LocalDateTime.now(), LocalDateTime.now(), 1L);

        this.logService.save(log);

        this.logService.deleteById(log.getId());

        assertEquals(Optional.empty(), this.logService.findById(log.getId()));
    }

    @Test
    public void updateShouldAddNumberOfEventsToEventNumberAndPersistData() {
        Log log = new Log(Level.ERROR, "descricao", "evento", "origin",
                LocalDateTime.now(), LocalDateTime.now(), 1L);

        this.logService.save(log);

        this.logService.update(log.getId(), 1L);

        log = this.logService.findById(log.getId()).get();

        assertEquals(2L, log.getEventNumber());
    }

    @Test
    public void savingEqualLogShouldUpdateEventNumber() {
        Log log = new Log(Level.ERROR, "descricao", "evento", "origin",
                LocalDateTime.now(), LocalDateTime.now(), 1L);

        Log log2 = new Log(Level.ERROR, "descricao", "evento", "origin",
                LocalDateTime.now(), LocalDateTime.now(), 5L);

        this.logService.save(log);
        this.logService.save(log2);

        log = this.logService.findById(log.getId()).get();

        assertEquals(6L, log.getEventNumber());
    }

    @Test
    public void searchingByIdShouldReturnLog(){
        Log log = new Log(Level.ERROR, "descricao", "evento", "origin",
                LocalDateTime.now(), LocalDateTime.now(), 1L);

        Log log2 = new Log(Level.WARNING, "descricao2", "evento2", "origin2",
                LocalDateTime.now(), LocalDateTime.now(), 2L);

        this.logService.save(log);
        this.logService.save(log2);

        Log dbLog = this.logService.findById(log.getId()).get();

        assertEquals(log, dbLog);
    }

    @Test
    public void searchingByDescriptionShouldReturnListOfLogNoEventLog(){
        Log log = new Log(Level.ERROR, "descricao", "evento", "origin",
                LocalDateTime.now(), LocalDateTime.now(), 1L);

        Log log2 = new Log(Level.WARNING, "description", "logging", "system",
                LocalDateTime.now(), LocalDateTime.now(), 2L);

        this.logService.save(log);
        this.logService.save(log2);

        List<LogNoEventLog> dbLog = this.logService.findByDescription(log.getDescription(), null);

        assertEquals(1, dbLog.size());
    }

    @Test
    public void searchingByOriginShouldReturnListOfLogNoEventLog(){
        Log log = new Log(Level.ERROR, "descricao", "evento", "origin",
                LocalDateTime.now(), LocalDateTime.now(), 1L);

        Log log2 = new Log(Level.WARNING, "description", "logging", "system",
                LocalDateTime.now(), LocalDateTime.now(), 2L);

        this.logService.save(log);
        this.logService.save(log2);

        List<LogNoEventLog> dbLog = this.logService.findByOrigin(log.getOrigin(), null);

        assertEquals(1, dbLog.size());
    }

    @Test
    public void searchingByEventLogShouldReturnListOfLogNoEventLog(){
        Log log = new Log(Level.ERROR, "descricao", "evento", "origin",
                LocalDateTime.now(), LocalDateTime.now(), 1L);

        Log log2 = new Log(Level.WARNING, "description", "evento", "system",
                LocalDateTime.now(), LocalDateTime.now(), 2L);

        this.logService.save(log);
        this.logService.save(log2);

        List<LogNoEventLog> dbLog = this.logService.findByEventLog(log.getEventLog(), null);

        assertEquals(2, dbLog.size());
    }

    @Test
    public void searchingByLevelShouldReturnListOfLogNoEventLog(){
        Log log = new Log(Level.ERROR, "descricao", "evento", "origin",
                LocalDateTime.now(), LocalDateTime.now(), 1L);

        Log log2 = new Log(Level.WARNING, "description", "evento", "system",
                LocalDateTime.now(), LocalDateTime.now(), 2L);

        this.logService.save(log);
        this.logService.save(log2);

        List<LogNoEventLog> dbLog = this.logService.findByLevel(log.getLevel(), null);

        assertEquals(1, dbLog.size());
    }

}
