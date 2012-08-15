package fr.gbourquet.catnotab.serveur.metier;

import java.io.Serializable;

/**
 * Classe représentant une personne.
 * @author guillaume
 */
public class Personne implements Serializable {

    /**
    *
    */
    private static final long serialVersionUID = -8597571176819894158L;
    /**
     * id de la Personne.
     */
    private Integer idPersonne;
    /**
     * nom de la Personne.
     */
    private String nom;
    /**
     * prenom de la Personne.
     */
    private String prenom;
    /**
     * url de la photo de la Personne.
     */
    private String photo;
    /**
     * adresse de la Personne.
     */

    /**
     * Constructeur par défaut.
     */
    public Personne() {
    }

    /**
     * Getter.
     * @return idPersonne
     */
    public final Integer getIdPersonne() {
        return idPersonne;
    }

    /**
     * Setter.
     * @param idPersonne
     *            id de la personne
     */
    public final void setIdPersonne(final Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    /**
     * Getter.
     * @return nom
     */
    public final String getNom() {
        return nom;
    }

    /**
     * Setter.
     * @param nom
     *            nom de la personne
     */
    public final void setNom(final String nom) {
        this.nom = nom;
    }

    /**
     * Getter.
     * @return prenom
     */
    public final String getPrenom() {
        return prenom;
    }

    /**
     * Setter.
     * @param prenom
     *            prenom de la personne
     */
    public final void setPrenom(final String prenom) {
        this.prenom = prenom;
    }

    /**
     * Getter.
     * @return photo
     */
    public final String getPhoto() {
        return photo;
    }

    /**
     * Setter.
     * @param photo
     *            url de la photo de la personne
     */
    public final void setPhoto(final String photo) {
        this.photo = photo;
    }

}
