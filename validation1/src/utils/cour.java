/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Date;

/**
 *
 * @author emna ketata
 */
public class cour {
    private int id;
    private String contenu;
    private String dateD;
        private String DateF;
    private int placeDispo; 
    private int idEnseig;
    private int emploi;

    public cour(int id, String contenu, String dateD, String DateF, int placeDispo, int idEnseig, int emploi) {
        this.id = id;
        this.contenu = contenu;
        this.dateD = dateD;
        this.DateF = DateF;
        this.placeDispo = placeDispo;
        this.idEnseig = idEnseig;
        this.emploi = emploi;
    }

    public cour(String contenu, String dateD, String DateF, int placeDispo, int idEnseig, int emploi) {
        this.contenu = contenu;
        this.dateD = dateD;
        this.DateF = DateF;
        this.placeDispo = placeDispo;
        this.idEnseig = idEnseig;
        this.emploi = emploi;
    }

    public cour(String math, java.util.Date d3, java.util.Date d4, int i, int i0, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public String getContenu() {
        return contenu;
    }

    public String getDateD() {
        return dateD;
    }

    public String getDateF() {
        return DateF;
    }

    public int getPlaceDispo() {
        return placeDispo;
    }

    public int getIdEnseig() {
        return idEnseig;
    }

    public int getEmploi() {
        return emploi;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setDateD(String dateD) {
        this.dateD = dateD;
    }

    public void setDateF(String DateF) {
        this.DateF = DateF;
    }

    public void setPlaceDispo(int placeDispo) {
        this.placeDispo = placeDispo;
    }

    public void setIdEnseig(int idEnseig) {
        this.idEnseig = idEnseig;
    }

    public void setEmploi(int emploi) {
        this.emploi = emploi;
    }

    @Override
    public String toString() {
        return "cour{" + "id=" + id + ", contenu=" + contenu + ", dateD=" + dateD + ", DateF=" + DateF + ", placeDispo=" + placeDispo + ", idEnseig=" + idEnseig + ", emploi=" + emploi + '}';
    }
    
    
}
