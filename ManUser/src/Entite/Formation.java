/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author emna
 */
public class Formation {

    private int id;
    private String titre;
    private String contenu;
    private String image;
    private String placedisponible;
    private int idFormateur;

    private String emploi;

    public Formation(int id, String titre, String image, String contenu, String placedisponible, int idFormateur, String emploi) {

        this.id = id;
        this.contenu = contenu;
        this.titre = titre;
        this.image = image;
        this.placedisponible = placedisponible;
        this.idFormateur = idFormateur;

        this.emploi = emploi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPlacedisponible() {
        return placedisponible;
    }

    public void setPlacedisponible(String placedisponible) {
        this.placedisponible = placedisponible;
    }

    public int getIdFormateur() {
        return idFormateur;
    }

    public void setIdFormateur(int idFormateur) {
        this.idFormateur = idFormateur;
    }

    public String getEmploi() {
        return emploi;
    }

    public void setEmploi(String emploi) {
        this.emploi = emploi;
    }

}
