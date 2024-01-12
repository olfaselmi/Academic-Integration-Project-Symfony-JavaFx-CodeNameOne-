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
public class Ecole {
    private int id;
    private String nom;
    private String numMaison;
    private String rue;
    private String ville;

    public Ecole(int id, String nom, String numMaison, String rue, String ville) {
        this.id = id;
        this.nom = nom;
        this.numMaison = numMaison;
        this.rue = rue;
        this.ville = ville;
    }

    public Ecole(String nom, String numMaison, String rue, String ville) {
        this.nom = nom;
        this.numMaison = numMaison;
        this.rue = rue;
        this.ville = ville;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumMaison() {
        return numMaison;
    }

    public void setNumMaison(String numMaison) {
        this.numMaison = numMaison;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Ecole{" + "id=" + id + ", nom=" + nom + ", numMaison=" + numMaison + ", rue=" + rue + ", ville=" + ville + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
