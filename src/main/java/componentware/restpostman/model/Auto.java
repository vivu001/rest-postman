package componentware.restpostman.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String hersteller;
    private String model;

    @Min(1)
    private int sitzplaetzen;

    @Min(1)
    private int anzahl;

    @Min(1)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int verfuegbar;

    public Auto(String hersteller, String model, int sitzplaetzen, int anzahl) {
        this.hersteller = hersteller;
        this.model = model;
        this.sitzplaetzen = sitzplaetzen;
        this.anzahl = anzahl;
        verfuegbar = anzahl;
    }
}
