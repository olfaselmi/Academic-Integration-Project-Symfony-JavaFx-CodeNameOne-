/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entity;

import java.util.Objects;

/**
 *
 * @author u
 */
    
public class User {
    private int id;
    private String cin;
    private String nom;
    private String prenom;
    private int age; 
    private String tel;
    private String email;
    
    private String mdp;
     private String numMaison; 
    private String rue;
   private String ville;
    private String role;
     
      
    private String image;

    public User(int id, String cin, String nom, String prenom, int age, String tel, String email, String mdp, String numMaison, String rue, String ville, String role, String image) {
        this.id = id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.tel = tel;
        this.email = email;
        this.mdp = mdp;
        this.numMaison = numMaison;
        this.rue = rue;
        this.ville = ville;
        this.role = role;
        this.image = image;
    }

    public User(String cin, String nom, String prenom, int age, String tel, String email, String mdp, String numMaison, String rue, String ville, String role, String image) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.tel = tel;
        this.email = email;
        this.mdp = mdp;
        this.numMaison = numMaison;
        this.rue = rue;
        this.ville = ville;
        this.role = role;
        this.image = image;
    }

    public User(String nom, String prenom, String cin, String mail, String role, String tel) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
       
        this.tel = tel;
        this.email = mail;
        
       
        this.role = role;
       
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.cin);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.cin, other.cin)) {
            return false;
        }
        return true;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    

    

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

   
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImage()
    {
        return image;
    }
    public void setImage(String image) {
        this.image=image ;
    }
    
    
    
    
}
