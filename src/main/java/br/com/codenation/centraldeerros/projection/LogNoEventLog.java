package br.com.codenation.centraldeerros.projection;

import br.com.codenation.centraldeerros.entity.enums.Level;

import java.time.LocalDateTime;


public interface LogNoEventLog {
    Long getId();
    Level getLevel();
    String getDescription();
    String getOrigin();
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
    Long getEventNumber();
}
