package br.com.codenation.centraldeerros.service.implementation;

import br.com.codenation.centraldeerros.entity.enums.Level;
import br.com.codenation.centraldeerros.entity.Log;
import br.com.codenation.centraldeerros.projection.LogNoEventLog;
import br.com.codenation.centraldeerros.repository.LogRepository;
import br.com.codenation.centraldeerros.service.interfaces.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public List<LogNoEventLog> findAll(Pageable pageable) {
        return this.logRepository.findBy(pageable).getContent();
    }

    @Override
    public Optional<Log> findById(Long id) {
        return this.logRepository.findById(id);
    }

    @Override
    public List<LogNoEventLog> findByLevel(Level level, Pageable pageable) {
        return this.logRepository.findByLevel(level, pageable).getContent();
    }

    @Override
    public List<LogNoEventLog> findByDescription(String description, Pageable pageable) {
        return this.logRepository.findByDescriptionContainingIgnoreCase(description, pageable).getContent();
    }

    @Override
    public List<LogNoEventLog> findByOrigin(String origin, Pageable pageable) {
        return this.logRepository.findByOriginContainingIgnoreCase(origin, pageable).getContent();
    }

    @Override
    public List<LogNoEventLog> findByCreatedAt(String createdAt, Pageable pageable) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime createdAtDateTime = LocalDateTime.parse(createdAt, formatter);

        return this.logRepository.findByCreatedAt(createdAtDateTime, pageable).getContent();
    }

    @Override
    public List<LogNoEventLog> findByUpdatedAt(String updatedAt, Pageable pageable) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime updatedAtDateTime = LocalDateTime.parse(updatedAt, formatter);

        return this.logRepository.findByUpdatedAt(updatedAtDateTime, pageable).getContent();
    }

    @Override
    public List<LogNoEventLog> findByEventNumber(Long number, Pageable pageable) {
        return this.logRepository.findByEventNumber(number, pageable).getContent();
    }

    @Override
    public Log save(Log newLog) {
        Stream<Log> logStream = this.logRepository.findAll().stream();

        Log equal = logStream.filter(element -> {
            return element.getLevel().equals(newLog.getLevel()) &&
                    element.getDescription().toLowerCase().equals(newLog.getDescription().toLowerCase()) &&
                    element.getOrigin().toLowerCase().equals(newLog.getOrigin().toLowerCase()) &&
                    element.getEventLog().toLowerCase().equals(newLog.getEventLog().toLowerCase());
        }).findFirst().orElse(null);

        if(equal != null) {
            return this.update(equal.getId());
        }

        return this.logRepository.save(newLog);
    }

    @Override
    public void deleteById(Long id) {
        this.logRepository.deleteById(id);
    }

    @Override
    public List<Log> findAll() {
        return this.logRepository.findAll();
    }

    @Override
    public Log update(Long id) {

        Log logToUpdate = this.logRepository.findById(id).get();
        logToUpdate.update();

        return this.logRepository.save(logToUpdate);
    }
}
