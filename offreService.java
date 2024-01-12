/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entite.demande;
import entite.offre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author user
 */
public class offreService {
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection conn;

    public offreService() {
        conn = DataSource.getInstance().getCnx();
    }
    public void ajouterOffre(offre o) {
        String req = "insert into offre (prixPropose,certifie,idCentre,idDemande) values (?,?,?,?)";

        try {
            pst = conn.prepareStatement(req);
            pst.setInt(1, o.getPrixPropose());
            if (o.isCertifie())
            pst.setInt(2, 1);
            else
              pst.setInt(2, 0);  
            pst.setInt(3,o.getIdCentre());
            pst.setInt(4,o.getIdDemande());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(offreService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void modifierOffre(offre o,int id) {
        String req = "update offre set prixPropose=?, certifie=?,idCentre=?, idDemande=? where id=? ";

        try {
            pst = conn.prepareStatement(req);
            pst.setInt(1, o.getPrixPropose());
            if(o.isCertifie())
            pst.setInt(2, 1);
            else
             pst.setInt(2, 0);   
            pst.setInt(3, o.getIdCentre());
            pst.setInt(4, o.getIdDemande());
            pst.setInt(5, id);
            pst.executeUpdate();
            

        } catch (SQLException ex) {
            Logger.getLogger(offreService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        public void supprimerOffre(int id) {
        String req = "delete from offre where id=? ";

        try {
            pst = conn.prepareStatement(req);
            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(offreService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        public List<offre> readAll() {
        String req = "select * from offre";

        List<offre> list=new ArrayList<>();
        try {
            ste = conn.createStatement();
           rs= ste.executeQuery(req);
           while(rs.next()){
               boolean b=true;
               if(rs.getInt(3)==0)
                 b=false ; 
               list.add(new offre(rs.getInt(1),rs.getInt(2),b,rs.getInt(4),rs.getInt(5)));
           }

        } catch (SQLException ex) {
            Logger.getLogger(offreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }    
}
