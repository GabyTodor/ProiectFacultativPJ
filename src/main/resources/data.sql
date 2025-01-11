CREATE TABLE IF NOT EXISTS useri (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    rol VARCHAR(20) NOT NULL
);
CREATE TABLE IF NOT EXISTS masini (
    nr_inmatriculare VARCHAR(10) PRIMARY KEY,
    id_utilizator BIGINT,
    marca VARCHAR(50),
    model VARCHAR(50),
    culoare VARCHAR(20),
    an_fabricatie INT,
    capacitate_cilindrica INT,
    combustibil VARCHAR(20),
    putere INT,
    cuplu INT,
    volum_portbagaj INT,
    pret DECIMAL(10,2),
    FOREIGN KEY (id_utilizator) REFERENCES useri(id)
);

INSERT INTO useri (id, username, password, rol) VALUES
    (1, 'admin', '$2a$10$KiHHB2EGCEyzVYaYzH7Wtui5pWwthVrddZzeBbdyztPY9sPe0vPcu', 'ADMIN'), -- Parola: admin
    (2, 'user1', '$2a$10$DfFz0DMxaKPzTUv76H1hUOvI7iC34SZTK4eLs5SFqHpwXUsXvStCW', 'USER'),   -- Parola: password123
    (3, 'user2', '$2a$10$zt5TTVO1hle2PhW1jZDUUebcWSzGsFVH3K4ZXG2AcwUep7a0K7poC', 'USER');   -- Parola: secret123

INSERT INTO masini (
    nr_inmatriculare, id_utilizator, marca, model, culoare, an_fabricatie, capacitate_cilindrica, combustibil, putere, cuplu, volum_portbagaj, pret)
VALUES
      ('TM12AAA', 1, 'ford', 'mondeo', 'albastru', 2014, 2000, 'electric', 140, 180, 600, 9000),
      ('TM14CSS', 1, 'seat', 'leon', 'galben', 2015, 1800, 'benzina', 150, 120, 350, 10500),
      ('TM14ZYA', 1, 'seat', 'leon', 'negru', 2010, 2000, 'motorina', 150, 120, 350, 11000),
      ('TM20RRR', 1, 'ford', 'focus', 'negru', 2010, 1997, 'motorina', 170, 136, 400, 8888),
      ('TM30XZY', 1, 'ford', 'mondeo', 'negru', 2014, 2000, 'electric', 140, 180, 600, 9000),
      ('TM99JKW', 1, 'ford', 'focus', 'albastru', 2010, 1997, 'benzina', 170, 136, 400, 9999);
