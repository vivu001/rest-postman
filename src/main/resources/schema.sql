DROP TABLE if EXISTS bestellung;
DROP TABLE if EXISTS kunde;
DROP TABLE if EXISTS auto;
DROP TABLE if EXISTS zahlung;
DROP TABLE if EXISTS zahlungsart;

CREATE TABLE kunde (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nachname VARCHAR(255) NOT NULL,
    vorname VARCHAR(255) NOT NULL,
    geburtsdatum DATE  NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE auto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    hersteller VARCHAR(50) NOT NULL,
    model VARCHAR(50),
    farbe VARCHAR(20),
    sitzplaetzen INT NOT NULL,
    anzahl INT NOT NULL,
    verfuegbar INT NOT NULL
);

CREATE TABLE zahlungsart (
    id INT AUTO_INCREMENT PRIMARY KEY,
    beschreibung VARCHAR(255) NOT NULL
);

CREATE TABLE zahlung (
    id INT AUTO_INCREMENT PRIMARY KEY,
    betrag DECIMAL,
    bezahlt BOOLEAN NOT NULL DEFAULT FALSE,
    zahlungsart_id INT,
    FOREIGN KEY (zahlungsart_id) REFERENCES zahlungsart (id) ON DELETE CASCADE
);

CREATE TABLE bestellung (
    kunde_id INT,
    auto_id INT,
    zahlung_id INT,
    datum DATETIME NOT NULL,
    startdatum DATE NOT NULL,
    dauer INT NOT NULL,
    PRIMARY KEY (kunde_id, auto_id, zahlung_id),
    FOREIGN KEY (kunde_id) REFERENCES kunde (id) ON DELETE CASCADE,
    FOREIGN KEY (auto_id) REFERENCES auto (id) ON DELETE CASCADE,
    FOREIGN KEY (zahlung_id) REFERENCES zahlung (id) ON DELETE CASCADE
);