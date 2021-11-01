package componentware.restpostman.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Bestellung {

    @EmbeddedId
    private BestellungId bestellungId;

    @CreationTimestamp
    private LocalDateTime datum;

    private LocalDate startdatum;
    private int dauer;

}
