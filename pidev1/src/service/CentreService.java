/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Centre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utils.DataBase;

/**
 *
 * @author AlaKhattat
 */
public class CentreService {
    
     private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    
    
    private Connection connection;
    
    public CentreService() {
    
        connection=DataBase.getInstance().getCnx();
    
    }
    
    
    
    
    public void ajouterCentrePst(Centre c) throws SQLException{
        String req = "insert into centre (nom,numMaison,rue,ville) values (?,?,?,?)";

        try {
            pst = connection.prepareStatement(req);
            pst.setString(1, c.getNom());
            pst.setString(2, c.getNumMaison());
            pst.setString(3, c.getRue());
            pst.setString(4, c.getVille());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CentreService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public List<Centre> readAll() {
        String req = "select * centre";

        List<Centre> list=new ArrayList<>();
        try {
            ste = connection.createStatement();
           rs= ste.executeQuery(req);
           while(rs.next()){
               list.add(new Centre(rs.getInt("id"), rs.getString("nom"), rs.getString("numMaison"), rs.getString("rue"), rs.getString("ville")));
           }

        } catch (SQLException ex) {
            Logger.getLogger(CentreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     
     
     public boolean delete(int id) throws SQLException {
    
        PreparedStatement pre=connection.prepareStatement("DELETE FROM centre WHERE id='"+id+"' ;");
        pre.executeUpdate();
        JOptionPane.showMessageDialog(null,"centre supprimé avec succées");
        return true;
    }
    
    public boolean update(Centre c,int id) throws SQLException {
PreparedStatement pre=connection.prepareStatement("UPDATE centre SET nom= '" +c.getNom()+ "',numMaison='"+c.getNumMaison()+"',rue='"+c.getRue()+"',ville='"+c.getVille()+"' WHERE id='"+id+"' ;");
JOptionPane.showMessageDialog(null,"centre modifié avec succées");
            pre.executeUpdate();
       
        return true;    }
     
     
     
     
    }

     
     
     
     
     
     
     
     


