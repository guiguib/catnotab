CREATE SEQUENCE catnotab.elv_id_seq;

CREATE TABLE catnotab.ELEVE (
                id INTEGER NOT NULL DEFAULT nextval('catnotab.elv_id_seq'),
                nom VARCHAR(80) NOT NULL,
                prenom VARCHAR(80) NOT NULL,
                sexe CHAR(1) NOT NULL,
                dateNaissance DATE NOT NULL,
                rue VARCHAR(100),
                codePostal VARCHAR(5),
                ville VARCHAR(100),
                email VARCHAR(100),
                idUtilisateur INTEGER NOT NULL,
                CONSTRAINT idEleve PRIMARY KEY (id)
);


ALTER SEQUENCE catnotab.elv_id_seq OWNED BY catnotab.ELEVE.id;

ALTER TABLE catnotab.ELEVE ADD CONSTRAINT utilisateur_eleve_fk
FOREIGN KEY (idUtilisateur)
REFERENCES catnotab.UTILISATEUR (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
