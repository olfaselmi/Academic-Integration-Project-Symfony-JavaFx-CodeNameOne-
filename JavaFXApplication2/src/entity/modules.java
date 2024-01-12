/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Yasmine Boulares
 */
public class modules {
    private int id;
    private String nom;
    private int coeff; 

    public modules(int id, String nom, int coeff) {
        this.id = id;
        this.nom = nom;
        this.coeff = coeff;
    }

    public modules(String nom, int coeff) {
        this.nom = nom;
        this.coeff = coeff;
    }

    public modules() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getCoeff() {
        return coeff;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCoeff(int coeff) {
        this.coeff = coeff;
    }
    
}
