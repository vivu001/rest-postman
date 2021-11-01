package componentware.restpostman.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Auto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String hersteller;
        private String model;
        private String farbe;
        private int sitzplaetzen;
        private int anzahl;
        private int verfuegbar;

}
