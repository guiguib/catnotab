CREATE TABLE catnotab.DROIT_UTILISATEUR (
                codeDroit VARCHAR(10) NOT NULL,
                idUtilisateur INTEGER NOT NULL,
                CONSTRAINT codeDroit_idUtilisateur PRIMARY KEY (codeDroit,idUtilisateur)
);


ALTER TABLE catnotab.DROIT_UTILISATEUR ADD CONSTRAINT droit_droit_utilisateur_fk
FOREIGN KEY (codeDroit)
REFERENCES catnotab.DROIT (code)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
ALTER TABLE catnotab.DROIT_UTILISATEUR ADD CONSTRAINT utilisateur_droit_utilisateur_fk
FOREIGN KEY (idUtilisateur)
REFERENCES catnotab.UTILISATEUR (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
