/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entity;

/**
 *
 * @author u
 */
public class admin extends User{
    
    private int idad;
    private int idUser;

    public admin( String cin, String nom, String prenom, int age, String tel, String email, String mdp, String numMaison, String rue, String ville, String role, String image) {
        super( cin, nom, prenom, age, tel, email, mdp, numMaison, rue, ville, role, image);
    }

    public admin(int idUser,String cin, String nom, String prenom, int age, String tel, String email, String mdp, String numMaison, String rue, String ville, String role, String image) {
        
        super(cin, nom, prenom, age, tel, email, mdp, numMaison, rue, ville, role, image);
        this.idUser=idUser;
    }
    
   

    public int getIdad() {
        return idad;
    }

    public void setIdad(int idad) {
        this.idad = idad;
               
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    

    
        
    
    
    
}
