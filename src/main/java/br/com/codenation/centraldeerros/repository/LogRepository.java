package br.com.codenation.centraldeerros.repository;

import br.com.codenation.centraldeerros.entity.Log;
import br.com.codenation.centraldeerros.entity.enums.Level;
import br.com.codenation.centraldeerros.projection.LogNoEventLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LogRepository extends PagingAndSortingRepository<Log, Long> {

    Page<LogNoEventLog> findBy(Pageable pageable);

    Page<LogNoEventLog> findByLevel(Level level, Pageable pageable);

    Page<LogNoEventLog> findByDescriptionContainingIgnoreCase( String description, Pageable pageable);

    Page<LogNoEventLog> findByOriginContainingIgnoreCase( String origin, Pageable pageable);

    Page<LogNoEventLog> findByCreatedAt(LocalDateTime created_at, Pageable pageable);

    Page<LogNoEventLog> findByUpdatedAt(LocalDateTime updated_at, Pageable pageable);

    Page<LogNoEventLog> findByEventNumber(Long number, Pageable pageable);

    Page<LogNoEventLog> findByEventLogContainingIgnoreCase(String log, Pageable pageable);

    List<Log> findAll();

}
