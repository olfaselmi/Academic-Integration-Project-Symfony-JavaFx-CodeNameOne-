/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xemacscode.demo;

/**
 *
 * @author emna ketata
 */
public class cours {
    private int id;
    private String contenu; 
     private  String dateD;
     private String dateF;
     private int placeDispo;
     private  int  idEnseig;
     private   int emploi;

    public cours(int id, String contenu, String dateD, String dateF, int placeDispo, int idEnseig, int emploi) {
        this.id = id;
        this.contenu = contenu;
        this.dateD = dateD;
        this.dateF = dateF;
        this.placeDispo = placeDispo;
        this.idEnseig = idEnseig;
        this.emploi = emploi;
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
        return dateF;
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
            
     
}
