package componentware.restpostman.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
@Getter
@NoArgsConstructor
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    private String hersteller;

    @Setter
    private String model;

    @Setter
    @Min(1)
    private int sitzplaetzen;

    @Min(1)
    private int anzahl;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int verfuegbar;

    public Auto(String hersteller, String model, int sitzplaetzen, int anzahl) {
        this.hersteller = hersteller;
        this.model = model;
        this.sitzplaetzen = sitzplaetzen;
        this.anzahl = anzahl;
        verfuegbar += anzahl;
    }

    public void setAnzahl(int anzDesNeuenAutos) {
        this.anzahl += anzDesNeuenAutos;
        this.verfuegbar += anzDesNeuenAutos;
    }

    public void resetAnzahl() {
        this.anzahl = this.verfuegbar = 0;
    }
}
