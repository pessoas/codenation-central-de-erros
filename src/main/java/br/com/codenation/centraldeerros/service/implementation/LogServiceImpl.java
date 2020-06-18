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
import java.util.List;
import java.util.Optional;

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
    public List<LogNoEventLog> findByCreatedAt(LocalDateTime dateTime, Pageable pageable) {
        return this.logRepository.findByCreatedAt(dateTime, pageable).getContent();
    }

    @Override
    public List<LogNoEventLog> findByUpdatedAt(LocalDateTime dateTime, Pageable pageable) {
        return this.logRepository.findByUpdatedAt(dateTime, pageable).getContent();
    }

    @Override
    public List<LogNoEventLog> findByEventNumber(Long number, Pageable pageable) {
        return this.logRepository.findByEventNumber(number, pageable).getContent();
    }

    @Override
    public Log save(Log newLog) {
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

    public Log update(Log log) {
        return this.logRepository.save(log);
    }
}
