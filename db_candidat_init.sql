-- Création des tables pour le microservice Candidat

--- Suppression des tables si elles existent déjà
DROP TABLE IF EXISTS avis;
DROP TABLE IF EXISTS emploi;
DROP TABLE IF EXISTS favoris;

--- TODO: Remplacer période par date de debut et de fin
--- Création des tables
CREATE TABLE emploi (
    idEmploi SERIAL PRIMARY KEY,
    titre varchar(255),
    descr varchar(255),
    dateDebut DATE,
    dateFin DATE,
    idEtablissement INT
);

CREATE TABLE avis (
    idAvis SERIAL PRIMARY KEY,
    note INT,
    commentaire varchar(255),
    idCandidat INT,
    idRecruteur INT,
    idEmploi INT,
    FOREIGN KEY (idEmploi) REFERENCES emploi(idEmploi)
);

CREATE TABLE favoris (
    idRecruteur INT,
    idCandidat INT,
    PRIMARY KEY (idRecruteur, idCandidat)
);

-- Insertion de données dans les tables

INSERT INTO emploi (titre, descr, dateDebut, dateFin, idEtablissement)
VALUES
    ('Employé polyvalent', 'Accueillir client, encaisser, produire des burgers', TO_DATE('17-11-2023', 'DD-MM-YYYY'), TO_DATE('20-05-2024', 'DD-MM-YYYY'), 1),
    ('Caissier', 'Encaisser produits du client', TO_DATE('22-12-2023', 'DD-MM-YYYY'), TO_DATE('14-01-2024', 'DD-MM-YYYY'), 2),
    ('Poste 3', 'Description du poste 3', TO_DATE('07-04-2024', 'DD-MM-YYYY'), TO_DATE('29-10-2024', 'DD-MM-YYYY'), 3);

INSERT INTO avis (note, commentaire, idCandidat, idRecruteur, idEmploi)
VALUES
    (5, 'Excellent candidat', 2, 1, 1),
    (4, 'Très bon candidat', 2, 1, 2),
    (3, 'Candidat moyen', 3, 1, 3);

INSERT INTO favoris (idRecruteur, idCandidat)
VALUES
    (2,1),
    (3,1);