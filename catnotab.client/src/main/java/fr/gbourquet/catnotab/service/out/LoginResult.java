package fr.gbourquet.catnotab.service.out;

import net.customware.gwt.dispatch.shared.Result;
import fr.gbourquet.catnotab.serveur.metier.auto.Personne;

public class LoginResult implements Result {
    
	private Personne utilisateur;
    private String token;
    
    /** For serialization only. */
    LoginResult() {
    }

    public LoginResult(Personne utilisateur, String token) {
        this.utilisateur = utilisateur;
        this.token = token;
    }

    public Personne getUtilisateur() {
        return utilisateur;
    }

	public String getToken() {
		return token;
	}

}