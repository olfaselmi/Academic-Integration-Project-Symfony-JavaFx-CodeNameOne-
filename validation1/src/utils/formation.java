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

    private int emploi;

    public formation(int id, String image, int contenu, int placeDispo, int idFormateur, int idCollab, int emploi) {
        this.id = id;
        this.image = image;
        this.contenu = contenu;
        this.placeDispo = placeDispo;
        this.idFormateur = idFormateur;
        this.idCollab = idCollab;
        this.emploi = emploi;
    }

    public formation(String image, int contenu, int placeDispo, int idFormateur, int idCollab, int emploi) {
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

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getContenu() {
        return contenu;
    }

    public void setContenu(int contenu) {
        this.contenu = contenu;
    }

    public int getPlaceDispo() {
        return placeDispo;
    }

    public void setPlaceDispo(int placeDispo) {
        this.placeDispo = placeDispo;
    }

    public int getIdFormateur() {
        return idFormateur;
    }

    public void setIdFormateur(int idFormateur) {
        this.idFormateur = idFormateur;
    }

    public int getIdCollab() {
        return idCollab;
    }

    public void setIdCollab(int idCollab) {
        this.idCollab = idCollab;
    }

    public int getEmploi() {
        return emploi;
    }

    public void setEmploi(int emploi) {
        this.emploi = emploi;
    }
    

}
