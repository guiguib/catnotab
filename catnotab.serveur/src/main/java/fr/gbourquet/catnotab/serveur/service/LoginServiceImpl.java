package fr.gbourquet.catnotab.serveur.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

import fr.gbourquet.catnotab.dao.DaoFactory;
import fr.gbourquet.catnotab.serveur.metier.auto.DroitPersonneExample;
import fr.gbourquet.catnotab.serveur.metier.auto.DroitPersonneKey;
import fr.gbourquet.catnotab.serveur.metier.auto.Personne;
import fr.gbourquet.catnotab.serveur.metier.auto.PersonneExample;
import fr.gbourquet.catnotab.serveur.service.exception.ServiceException;

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
	@Override
	public final Personne login(final String ident, final String password)
			throws ServiceException {

		PersonneExample requetePersonne = new PersonneExample();
		fr.gbourquet.catnotab.serveur.metier.auto.PersonneExample.Criteria critere = requetePersonne
				.createCriteria();
		critere.andLoginEqualTo(ident);
		critere.andPasswdEqualTo(encrypt(password));

		List<Personne> util = daoFactory.getPersonneDAO().selectByExample(
				requetePersonne);

		if (util == null || util.size() == 0) {
			throw new ServiceException("Utilisateur inconnu");
		}

		Date aujourdui = new Date();
		boolean actif = false;
		for (Personne utilisateur : util)
		{
			actif = aujourdui.after(utilisateur.getDateactivation())
					&& (utilisateur.getDatedesactivation() == null || aujourdui.before(utilisateur.getDatedesactivation()));
			if (actif)
				return utilisateur;
		}
		
		throw new ServiceException("Utilisateur désactivé");
	}

	@Override
	/**
	 * Methode exécutant le service.
	 * 
	 * @param personne
	 *            personne dont on veut récupérer les droits
	 * @return La liste des droits de l a personne
	 * @throws ServiceException 
	 */
	public List<DroitPersonneKey> getDroits(Personne personne)
			throws ServiceException {
		DroitPersonneExample requeteDroit = new DroitPersonneExample();
		fr.gbourquet.catnotab.serveur.metier.auto.DroitPersonneExample.Criteria critere = requeteDroit
				.createCriteria();
		critere.andIdutilisateurEqualTo(personne.getId());

		return daoFactory.getDroitPersonneDAO().selectByExample(requeteDroit);
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
