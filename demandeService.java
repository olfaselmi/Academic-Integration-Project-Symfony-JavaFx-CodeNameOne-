/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entite.demande;
import java.sql.Connection;
import java.sql.Date;
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
public class demandeService {
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection conn;

    public demandeService() {
        conn = DataSource.getInstance().getCnx();
    }
    public void ajouterDemande(demande d) {
        String req = "insert into demande (dateDebut,dateFin,montantPropose) values (?,?,?)";

        try {
            pst = conn.prepareStatement(req);
            pst.setDate(1, d.getDateDebut());
            pst.setDate(2, d.getDateFin());
            pst.setFloat(3, d.getMontantPropose());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(demandeService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void modifierDemande(demande d,int id) {
        String req = "update demande set dateDebut=?, DateFin=?,montantPropose=? where id=? ";

        try {
            pst = conn.prepareStatement(req);
            pst.setDate(1, d.getDateDebut());
            pst.setDate(2, d.getDateFin());
            pst.setFloat(3, d.getMontantPropose());
            pst.setInt(4, id);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(demandeService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        public void supprimerDemande(int id) {
        String req = "delete from demande where id=? ";

        try {
            pst = conn.prepareStatement(req);
            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(demandeService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        public List<demande> readAll() {
        String req = "select * from demande";

        List<demande> list=new ArrayList<>();
        try {
            ste = conn.createStatement();
           rs= ste.executeQuery(req);
           while(rs.next()){
               list.add(new demande(rs.getInt(1),rs.getDate(2),rs.getDate(3),rs.getInt(5),rs.getInt(4),rs.getInt(6)));
           }

        } catch (SQLException ex) {
            Logger.getLogger(demandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
