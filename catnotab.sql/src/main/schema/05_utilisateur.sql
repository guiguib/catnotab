CREATE SEQUENCE catnotab.utl_id_seq;

CREATE TABLE catnotab.UTILISATEUR (
                id INTEGER NOT NULL DEFAULT nextval('catnotab.utl_id_seq'),
                login VARCHAR(80) NOT NULL,
                passwd VARCHAR(80) NOT NULL,
                nom VARCHAR(80) NOT NULL,
                prenom VARCHAR(80) NOT NULL,
                codeTypeUtilisateur VARCHAR(10) NOT NULL,
                CONSTRAINT idUtilisateur PRIMARY KEY (id)
);


ALTER SEQUENCE catnotab.utl_id_seq OWNED BY catnotab.UTILISATEUR.id;

ALTER TABLE catnotab.UTILISATEUR ADD CONSTRAINT type_utilisateur_utilisateur_fk
FOREIGN KEY (codeTypeUtilisateur)
REFERENCES catnotab.TYPE_UTILISATEUR (code)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
