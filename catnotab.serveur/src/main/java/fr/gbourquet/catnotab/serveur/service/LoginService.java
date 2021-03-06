package fr.gbourquet.catnotab.serveur.service;

import java.util.List;

import fr.gbourquet.catnotab.serveur.metier.auto.DroitPersonneKey;
import fr.gbourquet.catnotab.serveur.metier.auto.Personne;
import fr.gbourquet.catnotab.serveur.service.exception.ServiceException;

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
     * @throws ServiceException 
     */
    Personne login(final String email, final String password) throws ServiceException;
    List<DroitPersonneKey> getDroits(Personne personne)  throws ServiceException ;
}
