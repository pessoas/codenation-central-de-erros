package br.com.codenation.centraldeerros.entity;

import br.com.codenation.centraldeerros.entity.enums.Level;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "logs")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @NonNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "log_level")
    private Level level;

    @Getter
    @NonNull
    private String description;

    @Getter
    @NonNull
    @Column(name = "log_event")
    private String eventLog;

    @Getter
    @NonNull
    private String origin;

    @Getter
    @CreationTimestamp
    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "created_at")
    private LocalDateTime createdAt;


    @Getter
    @Setter
    @UpdateTimestamp
    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @Getter
    @Setter
    @NonNull
    @Column(name = "event_number")
    private Long eventNumber;

    public void update() {
        this.eventNumber++;
    }
}
