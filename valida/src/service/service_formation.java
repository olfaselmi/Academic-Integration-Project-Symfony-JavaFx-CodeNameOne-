/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataBase;
import utils.formation;

/**
 *
 * @author emna ketata
 */
public class service_formation {
    private Connection conn;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public service_formation()
    {
    conn = DataBase.getInstance().getCnx();
    }
    public void ajouter(formation f) throws SQLException {
         String req = "insert into formation (image,contenu,placeDispo,idFormateur,idCollab,emploi) values (?,?,?,?,?,?)";

        try {
            pst = conn.prepareStatement(req);
            pst.setString(1, f.getImage());
            pst.setInt(2, f.getContenu());
            pst.setInt(3, f.getPlaceDispo());
            pst.setInt(4, f.getIdFormateur());
            pst.setInt(5, f.getIdCollab());
            pst.setString(6, f.getEmploi());
            
            
            pst.executeUpdate(); 

        } 
        catch (SQLException ex) {
            Logger.getLogger(service_formation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
