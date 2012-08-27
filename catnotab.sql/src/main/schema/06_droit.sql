CREATE TABLE catnotab.DROIT (
                code VARCHAR(10) NOT NULL,
                codeLibelle VARCHAR(10) NOT NULL,
                CONSTRAINT codeDroit PRIMARY KEY (code)
);


ALTER TABLE catnotab.TYPE_UTILISATEUR ADD CONSTRAINT libelle_droit_fk
FOREIGN KEY (codeLibelle)
REFERENCES catnotab.LIBELLE (code)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
