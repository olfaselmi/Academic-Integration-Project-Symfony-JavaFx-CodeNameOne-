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
public class Respecole extends User{
    private int idres;
    private int iduser;
    private int idEcole;

    public Respecole(int idres, int iduser, int idEcole, int idu, String nom, String prenom, String country, String mail, String pwd, String tel, String username, String roles, String dateins) {
        super(idu, nom, prenom, country, mail, pwd, tel, username, roles, dateins);
        this.idres = idres;
        this.iduser = iduser;
        this.idEcole = idEcole;
    }

   
    public Respecole(int iduser, int idEcole, int idu, String nom, String prenom, String country, String mail, String pwd, String tel, String username, String roles, String dateins) {
        super(idu, nom, prenom, country, mail, pwd, tel, username, roles, dateins);
        this.iduser = iduser;
        this.idEcole = idEcole;
    }

    public Respecole(int iduser, int idEcole, String nom, String prenom, String country, String mail, String pwd, String tel, String username, String roles, String dateins) {
        super(nom, prenom, country, mail, pwd, tel, username, roles, dateins);
        this.iduser = iduser;
        this.idEcole = idEcole;
    }

    public Respecole(int iduser, int idEcole, String nom, String prenom, String country, String mail, String pwd, String tel, String username, String roles) {
        super(nom, prenom, country, mail, pwd, tel, username, roles);
        this.iduser = iduser;
        this.idEcole = idEcole;
    }

    public Respecole(int iduser, int idEcole, String nom, String prenom, String country, String mail, String pwd, String tel, String username) {
        super(nom, prenom, country, mail, pwd, tel, username);
        this.iduser = iduser;
        this.idEcole = idEcole;
    }

    public Respecole(int iduser, int idEcole, String nom, String prenom, String country, String pwd, String tel) {
        super(nom, prenom, country, pwd, tel);
        this.iduser = iduser;
        this.idEcole = idEcole;
    }


    public int getIdres() {
        return idres;
    }

    public void setIdres(int idres) {
        this.idres = idres;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdEcole() {
        return idEcole;
    }

    public void setIdEcole(int idEcole) {
        this.idEcole = idEcole;
    }

    
   
}
