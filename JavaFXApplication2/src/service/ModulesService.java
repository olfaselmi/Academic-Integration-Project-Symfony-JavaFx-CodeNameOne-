/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.modules;
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
public class ModulesService {
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    private final Connection conn;

    public ModulesService() {
        conn = DataBase.getInstance().getCnx();
    }

   public void ajouterModulesPst(modules m ) throws SQLException{
        String req = "insert into ecole (nom,coeff) values (?,?)";

        try {
            pst = conn.prepareStatement(req);
            pst.setString(1, m.getNom());
            pst.setInt(2, m.getCoeff());
          

        } catch (SQLException ex) {
            Logger.getLogger(ModulesService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    

public List <modules> readAll() {
        String req = "select * modules ";

        List <modules> list=new ArrayList<>();
        try {
            ste = conn.createStatement();
           rs= ste.executeQuery(req);
           while(rs.next()){
               list.add(new modules(rs.getInt("id"), rs.getString("nom"), rs.getInt("coeff")));
           }

        } catch (SQLException ex) {
            Logger.getLogger(EcoleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
public boolean delete(String nom) throws SQLException {
    
        PreparedStatement pre=conn.prepareStatement("DELETE FROM user WHERE username='"+nom+"' ;");
        pre.executeUpdate();
        JOptionPane.showMessageDialog(null,"module supprimé avec succées");
        return true;
    }
    
    public boolean update(modules m ,String id) throws SQLException {
PreparedStatement pre=conn.prepareStatement("UPDATE ecole SET nom= '" +m.getNom()+ "',coeff='"+m.getCoeff()+"' WHERE id='"+id+"' ;");
JOptionPane.showMessageDialog(null,"module modifié avec succées");
            pre.executeUpdate();
       
        return true;    }

}