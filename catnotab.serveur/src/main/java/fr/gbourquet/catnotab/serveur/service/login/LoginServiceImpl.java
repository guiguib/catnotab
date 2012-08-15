package fr.gbourquet.catnotab.serveur.service.login;

import fr.gbourquet.catnotab.serveur.metier.Personne;
import fr.gbourquet.catnotab.serveur.util.BeanFactory;

/**
 * Classe de service pour se logguer à l'application.
 * 
 * @author guillaume
 */
public class LoginServiceImpl implements LoginService {

	/**
	 * Methode exécutant le service.
	 * 
	 * @param email
	 *            email de log
	 * @param password
	 *            mot de passe
	 * @return L'utilisateur qui s'est loggué
	 */
	public final Personne login(final String ident, final String password) {

		/*
		 * � titre d'exemple ! Dans la vrai vie, il faut instancier (avec
		 * Spring) un DAO qui va faire une requ�te en base pour voir si la
		 * personne existe � partir de son identifiant et mot de passe
		 */
	    Personne util = (Personne) BeanFactory.getInstance().getMetier("utilTest");
	    
		return util;
	}
}
