package br.com.codenation.centraldeerros.entity;

import br.com.codenation.centraldeerros.entity.enums.Level;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
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
    @NotEmpty
    private String description;

    @Getter
    @NonNull
    @NotEmpty
    @Column(name = "log_event")
    private String eventLog;

    @Getter
    @NonNull
    @NotEmpty
    private String origin;

    @Getter
    @CreationTimestamp
    @NonNull
    @PastOrPresent
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "created_at")
    private LocalDateTime createdAt;


    @Getter
    @Setter
    @UpdateTimestamp
    @NonNull
    @PastOrPresent
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @Getter
    @Setter
    @NonNull
    @Min(value = 1)
    @Column(name = "event_number")
    private Long eventNumber;

    public void update(Long numberOfEvents) {

        this.eventNumber += numberOfEvents;
    }
}
