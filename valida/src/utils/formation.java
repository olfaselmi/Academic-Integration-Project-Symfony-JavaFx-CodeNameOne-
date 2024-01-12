/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author emna ketata
 */
public class formation {
    private int id;
    private String image;
    private int contenu;
    private int placeDispo; 
    private int idFormateur;
     private int idCollab;

    private String emploi;

    public formation(int id, String image, int contenu, int placeDispo, int idFormateur, int idCollab, String emploi) {
        this.id = id;
        this.image = image;
        this.contenu = contenu;
        this.placeDispo = placeDispo;
        this.idFormateur = idFormateur;
        this.idCollab = idCollab;
        this.emploi = emploi;
    }

    public formation(String image, int contenu, int placeDispo, int idFormateur, int idCollab, String emploi) {
        this.image = image;
        this.contenu = contenu;
        this.placeDispo = placeDispo;
        this.idFormateur = idFormateur;
        this.idCollab = idCollab;
        this.emploi = emploi;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public int getContenu() {
        return contenu;
    }

    public int getPlaceDispo() {
        return placeDispo;
    }

    public int getIdFormateur() {
        return idFormateur;
    }

    public int getIdCollab() {
        return idCollab;
    }

    public String getEmploi() {
        return emploi;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setContenu(int contenu) {
        this.contenu = contenu;
    }

    public void setPlaceDispo(int placeDispo) {
        this.placeDispo = placeDispo;
    }

    public void setIdFormateur(int idFormateur) {
        this.idFormateur = idFormateur;
    }

    public void setIdCollab(int idCollab) {
        this.idCollab = idCollab;
    }

    public void setEmploi(String emploi) {
        this.emploi = emploi;
    }

    @Override
    public String toString() {
        return "formation{" + "id=" + id + ", image=" + image + ", contenu=" + contenu + ", placeDispo=" + placeDispo + ", idFormateur=" + idFormateur + ", idCollab=" + idCollab + ", emploi=" + emploi + '}';
    }

    
    

}
