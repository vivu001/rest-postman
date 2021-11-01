package componentware.restpostman.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Data
public class Zahlung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Double betrag;
    private boolean bezahlt;

    @OneToOne
    @JoinColumn(name = "zahlungsart_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = "hibernateLazyInitializer")
    @Nullable
    private Zahlungsart zahlungsart;

}
