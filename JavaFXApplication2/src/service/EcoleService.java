/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Ecole;
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
import utile.DataBase;

/**
 *
 * @author Yasmine Boulares
 */
public class EcoleService {
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    private Connection conn;

    public EcoleService() {
        conn = DataBase.getInstance().getCnx();
    }

   public void ajouterEcolePst(Ecole e) throws SQLException{
        String req = "insert into ecole (nom,numMaison,rue,ville) values (?,?,?,?)";

        try {
            pst = conn.prepareStatement(req);
            pst.setString(1, e.getNom());
            pst.setString(2, e.getNumMaison());
            pst.setString(3, e.getRue());
            pst.setString(4, e.getVille());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EcoleService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    

public List <Ecole> readAll() {
        String req = "select * ecole ";

        List <Ecole> list=new ArrayList<>();
        try {
            ste = conn.createStatement();
           rs= ste.executeQuery(req);
           while(rs.next()){
               list.add(new Ecole(rs.getInt("id"), rs.getString("nom"), rs.getString("numMaison"), rs.getString("rue"), rs.getString("ville")));
           }

        } catch (SQLException ex) {
            Logger.getLogger(EcoleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
public boolean delete(String nom) throws SQLException {
    
        PreparedStatement pre=conn.prepareStatement("DELETE FROM user WHERE username='"+nom+"' ;");
        pre.executeUpdate();
        JOptionPane.showMessageDialog(null," ecole supprimé avec succées");
        return true;
    }
    
    public boolean update(Ecole e,String id) throws SQLException {
PreparedStatement pre=conn.prepareStatement("UPDATE ecole SET nom= '" +e.getNom()+ "',adresse='"+e.getNumMaison()+"',rue='"+e.getRue()+"',ville='"+e.getVille()+"' WHERE id='"+id+"' ;");
JOptionPane.showMessageDialog(null,"Ecole modifié avec succées");
            pre.executeUpdate();
       
        return true;    }

}