/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author u
 */
public class Formateur extends User {

    private int id;
    private int idUser;
    private double salaire;

    public Formateur(int id, int idUser, double salaire, int idu, String nom, String prenom, String country, String mail, String pwd, String tel, String username, String roles, String dateins) {
        super(idu, nom, prenom, country, mail, pwd, tel, username, roles, dateins);
        this.idUser = idUser;
        this.salaire = salaire;
        this.id = id;
    }

    public Formateur(int id, int idUser, double salaire, String nom, String prenom, String country, String mail, String pwd, String tel, String username, String roles, String dateins) {
        super(nom, prenom, country, mail, pwd, tel, username, roles, dateins);
        this.idUser = idUser;
        this.salaire = salaire;
        this.id = id;
    }

    public Formateur(int id, int idUser, double salaire, String nom, String prenom, String country, String mail, String pwd, String tel, String username, String roles) {
        super(nom, prenom, country, mail, pwd, tel, username, roles);
        this.idUser = idUser;
        this.salaire = salaire;
        this.id = id;
    }

    public Formateur(int id, int idUser, double salaire, String nom, String prenom, String country, String mail, String pwd, String tel, String username) {
        super(nom, prenom, country, mail, pwd, tel, username);
        this.idUser = idUser;
        this.salaire = salaire;
        this.id = id;
    }

    public Formateur(int id, int idUser, double salaire, String nom, String prenom, String country, String pwd, String tel) {
        super(nom, prenom, country, pwd, tel);
        this.idUser = idUser;
        this.salaire = salaire;
        this.id = id;
    }

    /*    public Formateur(int idUser, double salaire) {
    this.idUser = idUser;
    this.salaire = salaire;
    }*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

}
