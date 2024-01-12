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
import utils.cour;


/**
 *
 * @author emna ketata
 */
public class service_cour {
    private final Connection conn;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public service_cour()
    {
    conn = DataBase.getInstance().getCnx();
    }
    public void ajouter(cour c) throws SQLException {
         String req = "insert into cours (contenu,dateD,dateF,placeDispo,idEnseig,emploi) values (?,?,?,?,?,?)";

        try {
            pst = conn.prepareStatement(req);
           
            pst.setString(1, c.getContenu());
            pst.setString(2, c.getDateD());
            pst.setString(3, c.getDateF());
            pst.setInt(4, c.getPlaceDispo());
            pst.setInt(5, c.getIdEnseig());
            pst.setInt(6, c.getEmploi());
            
            
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            Logger.getLogger(service_cour.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /*
    public List<cour> readAll() {   //Affiche
        String req = "select * cour";

        List<cour> list=new ArrayList<>();
        try {
            ste = conn.createStatement();
           rs= ste.executeQuery(req);
           while(rs.next()){
               list.add(new cour(rs.getInt("id"), rs.getString("contenu"), rs.getString("dateD"), rs.getString("dateF"), rs.getInt("placeDispo"), rs.getInt("idEnseig"), rs.getInt("emploi")));
           }

        } catch (SQLException ex) {
            Logger.getLogger(service_cour.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
   
    
    private void deleteRecord(cour c) {
       // Connection conn = getConnection();
     

       try {
           pst=conn.prepareStatement("delete from books where id=?");
           pst.setInt(1,c.getId());

           int i=pst.executeUpdate();
           System.out.println(i+" records deleted");
       }catch (SQLException ex){
           Logger.getLogger(service_cour.class.getName()).log(Level.SEVERE, null, ex);
       }
       //showBooks();
    }
    
    
    private void updateRecord(cour c) {
        //Connection conn = getConnection();
        PreparedStatement pst;

        try {
            pst = conn.prepareStatement("UPDATE cour SET  contenu=?, dateD=?, dateF=? placeDispo=?, idEnseig=? emploi=? WHERE id=?");
            
            int i = pst.executeUpdate();
            
             pst.setString(1, c.getContenu());
            pst.setString(2, c.getDateD());
            pst.setString(3, c.getDateF());
            pst.setInt(4, c.getPlaceDispo());
            pst.setInt(5, c.getIdEnseig());
            pst.setInt(6, c.getEmploi());

            System.out.println(i);
            //connection.close();

        }catch (SQLException ex){
           Logger.getLogger(service_cour.class.getName()).log(Level.SEVERE, null, ex);
        }
       // showBooks();
    }

*/
    
    
    
}
