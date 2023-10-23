-- Création des tables pour le microservice Candidat

--- Suppression des tables si elles existent déjà
DROP TABLE IF EXISTS avis_candidat;
DROP TABLE IF EXISTS emploi;

--- Création des tables
CREATE TABLE emploi (
    id_emploi SERIAL PRIMARY KEY,
    titre varchar(255),
    descr varchar(255),
    periode varchar(255),
    id_etablissement INT
);

CREATE TABLE avis_candidat (
    id_avis SERIAL PRIMARY KEY,
    note INT,
    commentaire varchar(255),
    id_utilisateur INT
);

-- Insertion de données dans les tables

INSERT INTO emploi (titre, descr, periode, id_etablissement)
VALUES
    ('Employé polyvalent', 'Accueillir client, encaisser, produire des burgers', 'Novembre 2023 - Mars 2024', 1),
    ('Caissier', 'Encaisser produits du client', 'Février 2024 - Avril 2024', 2),
    ('Poste 3', 'Description du poste 3', 'Décembre 2023 - Mai 2024', 3);

INSERT INTO avis_candidat (note, commentaire, id_utilisateur)
VALUES
    (5, 'Excellent candidat', 2),
    (4, 'Très bon candidat', 2),
    (3, 'Candidat moyen', 3);