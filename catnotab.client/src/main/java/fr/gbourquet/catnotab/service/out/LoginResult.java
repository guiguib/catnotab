package fr.gbourquet.catnotab.service.out;

import net.customware.gwt.dispatch.shared.Result;
import fr.gbourquet.catnotab.serveur.metier.Personne;

public class LoginResult implements Result {
    
	private Personne utilisateur;
    
    /** For serialization only. */
    LoginResult() {
    }

    public LoginResult(Personne utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Personne getUtilisateur() {
        return utilisateur;
    }

}