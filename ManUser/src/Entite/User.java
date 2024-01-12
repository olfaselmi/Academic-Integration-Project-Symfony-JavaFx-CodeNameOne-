/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author Asus X550V
 */
public class User {
    private int idu;
    private String nom;
    private String prenom;
    private String username;
    private String roles;
    private String dateins;
    private String country;
    private String mail;
    private String pwd;
    private String tel;

    public User(int idu, String nom, String prenom, String country, String mail, String pwd, String tel,String username,String roles,String dateins) {
        this.idu = idu;
        this.nom = nom;
        this.prenom = prenom;
        this.country = country;
        this.mail = mail;
        this.pwd = pwd;
        this.tel = tel;
        this.username = username;
        this.roles = roles;
        this.dateins = dateins;
    }
    public User(String nom, String prenom, String country, String mail, String pwd, String tel,String username,String roles,String dateins) {
        this.idu = idu;
        this.nom = nom;
        this.prenom = prenom;
        this.country = country;
        this.mail = mail;
        this.pwd = pwd;
        this.tel = tel;
        this.username = username;
        this.roles = roles;
        this.dateins = dateins;
    }
    public User(String nom, String prenom, String country, String mail, String pwd, String tel,String username,String roles) {
        this.idu = idu;
        this.nom = nom;
        this.prenom = prenom;
        this.country = country;
        this.mail = mail;
        this.pwd = pwd;
        this.tel = tel;
        this.username = username;
        this.roles = roles;
        
    }
    public User(String nom, String prenom, String country, String mail, String pwd, String tel,String username) {
        this.idu = idu;
        this.nom = nom;
        this.prenom = prenom;
        this.country = country;
        this.mail = mail;
        this.pwd = pwd;
        this.tel = tel;
        this.username = username;
        
        
    }
    public User(String nom, String prenom, String country,String pwd, String tel) {
        this.idu = idu;
        this.nom = nom;
        this.prenom = prenom;
        this.country = country;
        this.pwd = pwd;
        this.tel = tel;
        
        
        
    }


    

    public int getIdu() {
        return idu;
    }

    public void setId(int idu) {
        this.idu = idu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getRoles() {
        return roles;
    }
    
    public String getDateins() {
        return dateins;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCountry() {
        return country;
    }
    public String getMail() {
        return mail;
    }
    public String getPwd() {
        return pwd;
    }
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idu + ", nom=" + nom + ", prenom=" + prenom + ", Country=" + country + ",Mail:"+mail+",Username:"+username+",Role:"+roles+",Date inscription:"+dateins+ '}';
    }
    
}
