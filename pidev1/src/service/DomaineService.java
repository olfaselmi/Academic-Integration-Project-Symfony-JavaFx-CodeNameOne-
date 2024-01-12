/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Domaine;
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
public class DomaineService {
    
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    private Connection connection;
    
    public DomaineService() {
    
        connection=DataBase.getInstance().getCnx();
    
    }
    
    
    public void ajouterDomainePst(Domaine d) throws SQLException{
        String req = "insert into domaine (nom) values (?)";

        try {
            pst = connection.prepareStatement(req);
            pst.setString(1, d.getNom());
           
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CentreService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public List<Domaine> readAll() {
        String req = "select * centre";

        List<Domaine> list=new ArrayList<>();
        try {
            ste = connection.createStatement();
           rs= ste.executeQuery(req);
           while(rs.next()){
               list.add(new Domaine(rs.getInt("id"), rs.getString("nom")));
           }

        } catch (SQLException ex) {
            Logger.getLogger(CentreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public boolean delete(int id) throws SQLException {
    
        PreparedStatement pre=connection.prepareStatement("DELETE FROM domaine WHERE id='"+id+"' ;");
        pre.executeUpdate();
        JOptionPane.showMessageDialog(null,"Domaine supprimé avec succées");
        return true;
    }
    
    public boolean update(Domaine d,int id) throws SQLException {
PreparedStatement pre=connection.prepareStatement("UPDATE domaine SET nom= '" +d.getNom()+"' WHERE id='"+id+"' ;");
JOptionPane.showMessageDialog(null,"domaine modifié avec succées");
            pre.executeUpdate();
       
        return true;    }
}
