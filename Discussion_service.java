/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Utils.DataBase;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.Entity.Discussion;
import pidev.Entity.User;

/**
 *
 * @author u
 */
public class Discussion_service {
     private Connection conn;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public Discussion_service()
    {
    conn = DataBase.getInstance().getCnx();
    }
    public void ajouter(Discussion disc) throws SQLException {
         String req = "insert into discussion (id_user,email_login_dest,titre,message,image,autre,date_envoi) values (?,?,?,?,?,?,?)";

        try {
            pst = conn.prepareStatement(req);
            pst.setInt(1, disc.getId_user());
            pst.setString(2, disc.getEmail_login_dest());
            pst.setString(3, disc.getTitre());
            pst.setString(4, disc.getMessage());
            pst.setString(5, disc.getImage());
            pst.setString(6, disc.getAutre());
            pst.setDate(7, disc.getDate_envoi());
            
            
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            Logger.getLogger(User_service.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
