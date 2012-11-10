package fr.gbourquet.catnotab.serveur.metier.auto;

import java.io.Serializable;

public class Droit implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column catnotab.droit.code
     *
     * @mbggenerated Wed Aug 29 10:14:35 CEST 2012
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column catnotab.droit.codelibelle
     *
     * @mbggenerated Wed Aug 29 10:14:35 CEST 2012
     */
    private String codelibelle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table catnotab.droit
     *
     * @mbggenerated Wed Aug 29 10:14:35 CEST 2012
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column catnotab.droit.code
     *
     * @return the value of catnotab.droit.code
     *
     * @mbggenerated Wed Aug 29 10:14:35 CEST 2012
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column catnotab.droit.code
     *
     * @param code the value for catnotab.droit.code
     *
     * @mbggenerated Wed Aug 29 10:14:35 CEST 2012
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column catnotab.droit.codelibelle
     *
     * @return the value of catnotab.droit.codelibelle
     *
     * @mbggenerated Wed Aug 29 10:14:35 CEST 2012
     */
    public String getCodelibelle() {
        return codelibelle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column catnotab.droit.codelibelle
     *
     * @param codelibelle the value for catnotab.droit.codelibelle
     *
     * @mbggenerated Wed Aug 29 10:14:35 CEST 2012
     */
    public void setCodelibelle(String codelibelle) {
        this.codelibelle = codelibelle == null ? null : codelibelle.trim();
    }
}