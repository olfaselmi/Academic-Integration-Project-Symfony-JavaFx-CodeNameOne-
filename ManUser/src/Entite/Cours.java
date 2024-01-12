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
 * @author anest
 */
public class Cours {
     private int id;
    private String titre;
    private String contenu;
    private java.sql.Date  date_debut;
    private java.sql.Date  date_fin;
    private String placedisponible;
    private int idEnseignant;
    private String emploi; 

    public Cours(int id,String titre, String contenu, java.sql.Date  date_debut, java.sql.Date  date_fin, String placedisponible, int idEnseignant, String emploi) {
        this.id = id;
        this.titre=titre;
        this.contenu = contenu;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.placedisponible = placedisponible;
        this.idEnseignant = idEnseignant;
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

    public java.sql.Date  getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(java.sql.Date  date_debut) {
        this.date_debut = date_debut;
    }

    public java.sql.Date  getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(java.sql.Date  date_fin) {
        this.date_fin = date_fin;
    }

    public String getPlacedisponible() {
        return placedisponible;
    }

    public void setPlacedisponible(String placedisponible) {
        this.placedisponible = placedisponible;
    }

    public int getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public String getEmploi() {
        return emploi;
    }

    public void setEmploi(String emploi) {
        this.emploi = emploi;
    }
    
    
}
