-- Kunde

INSERT INTO kunde (vorname, nachname, geburtsdatum, email)
VALUES ('Schmidt','Annika','2000-09-23','annika.fhdortmund@gmx.de');

INSERT INTO kunde (vorname, nachname, geburtsdatum, email)
VALUES ('Kuelke','Manfred','1976-04-01','manfred.kuelke0203@aol.com');

INSERT INTO kunde (vorname, nachname, geburtsdatum, email)
VALUES ('Mueller','Laura ','1995-12-23','laura.mueller@gmail.com');

-- Auto

INSERT INTO auto (hersteller, model, sitzplaetzen, anzahl, verfuegbar)
VALUES ('VW','Golf', 5, 20, 14);

INSERT INTO auto (hersteller, model, sitzplaetzen, anzahl, verfuegbar)
VALUES ('Ford','Fiesta', 4, 7, 5);

INSERT INTO auto (hersteller, model, sitzplaetzen, anzahl, verfuegbar)
VALUES ('Peugeot','Boxer', 7, 10, 4);

-- Zahlungsart

INSERT INTO zahlungsart (beschreibung)
VALUES ('Lastschrift');

INSERT INTO zahlungsart (beschreibung)
VALUES ('EC-Karte');

INSERT INTO zahlungsart (beschreibung)
VALUES ('PayPal');

INSERT INTO zahlungsart (beschreibung)
VALUES ('Kreditkarte');

-- Zahlung

INSERT INTO zahlung (betrag, bezahlt, zahlungsart_id)
VALUES (200,true, 3);

INSERT INTO zahlung (betrag, bezahlt, zahlungsart_id)
VALUES (150,false, null);

-- Bestellung

INSERT INTO bestellung (kunde_id, auto_id, zahlung_id, datum, startdatum, dauer)
VALUES (1, 2, 1, '2021-11-23 03:14:07', '2021-11-23', 5);

