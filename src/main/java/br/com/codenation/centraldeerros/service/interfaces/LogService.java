package br.com.codenation.centraldeerros.service.interfaces;

import br.com.codenation.centraldeerros.entity.enums.Level;
import br.com.codenation.centraldeerros.entity.Log;
import br.com.codenation.centraldeerros.projection.LogNoEventLog;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface LogService {
    List<LogNoEventLog> findAll(Pageable pageable);
    Optional<Log> findById(Long id);
    List<LogNoEventLog> findByLevel(Level level, Pageable pageable);
    List<LogNoEventLog> findByDescription(String description, Pageable pageable);

    List<LogNoEventLog> findByOrigin(String origin, Pageable pageable);
    List<LogNoEventLog> findByCreatedAt(String createdAt, Pageable pageable);
    List<LogNoEventLog> findByUpdatedAt(String createdAt, Pageable pageable);
    List<LogNoEventLog> findByEventNumber(Long number, Pageable pageable);
    Log save(Log newLog);
    Log update(Long id);
    void deleteById(Long id);
    List<Log> findAll();
}
