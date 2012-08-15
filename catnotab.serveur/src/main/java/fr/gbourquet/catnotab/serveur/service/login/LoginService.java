package fr.gbourquet.catnotab.serveur.service.login;

import fr.gbourquet.catnotab.serveur.metier.Personne;
import fr.gbourquet.catnotab.serveur.service.Service;

/**
 * Interface pour les services Login.
 * @author guillaume
 */
public interface LoginService extends Service {

    /**
     * service pour se logguer.
     * @param email
     *            email de l'utilisateur
     * @param password
     *            mot de passe de l'utilisateur
     * @return Utilisateur
     */
    Personne login(final String email, final String password);

}
