/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Utils.DataBase;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import pidev.Entity.User;
import Utils.DataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javax.swing.JOptionPane;
import pidev.Entity.admin;

/**
 *
 * @author u
 */
public class User_service {
     private Connection conn;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public User_service()
    {
    conn = DataBase.getInstance().getCnx();
    }
    public void ajouter(User u) throws SQLException {
         String req = "insert into utilisateur (cin,nom,prenom,age,tel,email,motDePasse,numMaison,rue,ville,role,image) values (?,?,?,?,?,?,?,?,?,?,?,?)";
         
       
        try {
            pst = conn.prepareStatement(req);
            pst.setString(1, u.getCin());
            pst.setString(2, u.getNom());
            pst.setString(3, u.getPrenom());
            pst.setInt(4, u.getAge());
            pst.setString(5, u.getTel());
            pst.setString(6, u.getMdp());
            pst.setString(7, u.getNumMaison());
            pst.setString(8, u.getRue());
            pst.setString(9, u.getTel());
            pst.setString(10, u.getVille());
             pst.setString(11, u.getRole());
              pst.setString(12, u.getImage());
            
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            Logger.getLogger(User_service.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void ajouter_admin(admin ad) throws SQLException {
         String req = "insert into admin (idUser) values (?)";
         
        try {
            pst = conn.prepareStatement(req);
            pst.setInt(1, ad.getIdUser());
           // pst.setString(2, ad.getId());
           /* pst.setString(3, u.getMail());
            pst.setString(4, u.getUsername());
            pst.setString(5, u.getMdp());
            pst.setString(6, u.getCin());
            pst.setString(7, u.getAddresse());
            pst.setString(8, u.getRole());
            pst.setString(9, u.getTel());
            pst.setString(10, u.getImage());*/
            
            pst.executeUpdate(); 
            JOptionPane.showMessageDialog(null,"User ajouter avec succées");
        } catch (SQLException ex) {
            Logger.getLogger(User_service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean delete(int id) throws SQLException {
    
        PreparedStatement pre=conn.prepareStatement("DELETE FROM utilisateur WHERE id='"+id+"' ;");
        pre.executeUpdate();
        JOptionPane.showMessageDialog(null,"User supprimé avec succées");
        return true;
    }
    public ObservableList<User> readAll() throws SQLException {
    ObservableList oblist = FXCollections.observableArrayList();
    ste= (Statement) conn.createStatement();
    ResultSet rs=pst.executeQuery("SELECT * FROM utilisateur");
    
    
     while (rs.next()) {                
              int id=rs.getInt(1);
               String cin=rs.getString("cin");
               String nom=rs.getString("nom");
               String prenom=rs.getString("prenom");
               int age=rs.getInt(5);
               String tel=rs.getString("tel");
               String email=rs.getString("eamil");
               String mdp=rs.getString("motDePasse");
               String numMaison=rs.getString("numMaison");
               String rue=rs.getString("rue");
               String ville=rs.getString("ville");
               //String username=rs.getString("username");
               String role=rs.getString("role");
               String image=rs.getString("image");
               User u=new  User( cin,  nom, prenom, age, tel,  email , mdp,  numMaison,  rue, ville, role, image);
     oblist.add(u);
     }
    return oblist;
    }
}
