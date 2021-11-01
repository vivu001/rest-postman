package componentware.restpostman.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class BestellungId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "kunde_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = "hibernateLazyInitializer")
    private Kunde kunde;

    @OneToOne
    @JoinColumn(name = "auto_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = "hibernateLazyInitializer")
    private Auto auto;

    @OneToOne
    @JoinColumn(name = "zahlung_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = "hibernateLazyInitializer")
    private Zahlung zahlung;

}
