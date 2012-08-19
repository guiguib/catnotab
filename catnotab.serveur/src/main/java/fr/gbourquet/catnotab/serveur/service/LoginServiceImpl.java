package fr.gbourquet.catnotab.serveur.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

import fr.gbourquet.catnotab.dao.DaoFactory;
import fr.gbourquet.catnotab.serveur.metier.Personne;
import fr.gbourquet.catnotab.serveur.metier.PersonneExample;
import fr.gbourquet.catnotab.serveur.metier.PersonneExample.Criteria;
import fr.gbourquet.catnotab.serveur.service.Exception.ServiceException;

/**
 * Classe de service pour se logguer à l'application.
 * 
 * @author guillaume
 */
public class LoginServiceImpl implements LoginService {

	DaoFactory daoFactory = null;

	/**
	 * Methode exécutant le service.
	 * 
	 * @param email
	 *            email de log
	 * @param password
	 *            mot de passe
	 * @return L'utilisateur qui s'est loggué
	 * @throws ServiceException 
	 */
	public final Personne login(final String ident, final String password) throws ServiceException {

		PersonneExample requetePersonne = new PersonneExample();
		Criteria critere = requetePersonne.createCriteria();
		critere.andLoginEqualTo(ident);
		critere.andPasswdEqualTo(encrypt(password));
		List<Personne> util =daoFactory.getPersonneDAO().selectByExample(requetePersonne);
	    
		if (util == null || util.size() == 0)
		{
			System.out.println("Util=" + util+" "+util.size());
			throw new ServiceException("Utilisateur inconnu");
		}
		return util.get(0);
	}

	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	private final String encrypt(String plaintext) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA"); // step 2
		} catch (NoSuchAlgorithmException e) {
			return "cryptage impossible";
		}
		try {
			md.update(plaintext.getBytes("UTF-8")); // step 3
		} catch (UnsupportedEncodingException e) {
			return "cryptage impossible";
		}
		byte raw[] = md.digest(); // step 4
		byte[] hash = (new Base64()).encode(raw); // step 5
		return new String(hash); // step 6
	}

}
