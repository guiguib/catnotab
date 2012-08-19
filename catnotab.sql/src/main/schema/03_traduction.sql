CREATE SEQUENCE catnotab.id_trd_seq;

CREATE TABLE catnotab.TRADUCTION (
                id INTEGER NOT NULL DEFAULT nextval('catnotab.id_trd_seq'),
                codeLibelle VARCHAR(10) NOT NULL,
                codeLangue VARCHAR(10) NOT NULL,
                valeur VARCHAR NOT NULL,
                CONSTRAINT idTraduction PRIMARY KEY (id)
);


ALTER SEQUENCE catnotab.id_trd_seq OWNED BY catnotab.TRADUCTION.id;

ALTER TABLE catnotab.TRADUCTION ADD CONSTRAINT langue_traduction_fk
FOREIGN KEY (codeLangue)
REFERENCES catnotab.LANGUE (code)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE catnotab.TRADUCTION ADD CONSTRAINT libelle_traduction_fk
FOREIGN KEY (codeLibelle)
REFERENCES catnotab.LIBELLE (code)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
