/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Enseignant;

import Entite.Cours;

import Utils.DataBase;

import Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emna
 */
public class ServiceCours {

    private Connection cnx;
    private Statement ste;
    private PreparedStatement pre;

    public ServiceCours() {
        cnx = DataBase.getInstance().getConnection();
    }

    public ArrayList<Cours> DisplayAll() throws SQLException {
        ArrayList<Cours> TabF = new ArrayList<>();
        String req = "SELECT * FROM cours";
        PreparedStatement p;
        p = cnx.prepareStatement(req);
        ResultSet rs = p.executeQuery();
        while (rs.next()) {

            java.sql.Date sqlDateDebut = java.sql.Date.valueOf(rs.getDate(4).toLocalDate());
            java.sql.Date sqlDateFin = java.sql.Date.valueOf(rs.getDate(5).toLocalDate());

            TabF.add(new Cours(rs.getInt(1), rs.getString(2), rs.getString(3), sqlDateDebut, sqlDateFin, rs.getString(6), rs.getInt(7), rs.getString(8)));
        }
        return TabF;
    }

    public void ajouter(Cours c) throws SQLException {

        java.sql.Date sqldate_debut = java.sql.Date.valueOf(c.getDate_debut().toLocalDate());
        java.sql.Date sqldate_fin = java.sql.Date.valueOf(c.getDate_fin().toLocalDate());
        pre = cnx.prepareStatement("INSERT INTO cours ( `titre`, `contenu`,  `placeDispo`,`idEnseig`,`dateD`,`dateF`) VALUES ( ?, ?, ?, ?,?,?);");
        pre.setString(1, c.getTitre());
        pre.setString(2, c.getContenu());
        pre.setString(3, c.getPlacedisponible());
        pre.setInt(4, c.getIdEnseignant());
        pre.setDate(5, sqldate_debut);
        pre.setDate(6, sqldate_fin);
        pre.executeUpdate();

    }

    public void modifier(Cours c) throws SQLException {
        java.sql.Date sqldate_debut = java.sql.Date.valueOf(c.getDate_debut().toLocalDate());
        java.sql.Date sqldate_fin = java.sql.Date.valueOf(c.getDate_fin().toLocalDate());
        pre = cnx.prepareStatement("UPDATE cours SET titre=?, contenu = ? , placeDispo = ? , idEnseig = ?, dateD = ? , dateF = ? WHERE id = ?");
        pre.setString(1, c.getTitre());
        pre.setString(2, c.getContenu());
        pre.setString(3, c.getPlacedisponible());
        pre.setInt(4, c.getIdEnseignant());
        pre.setDate(5, sqldate_debut);
        pre.setDate(6, sqldate_fin);
        pre.setInt(7, c.getId());
        pre.executeUpdate();

    }

    public boolean delete(int id) throws SQLException {

        pre = cnx.prepareStatement("delete from  cours where id = '" + id + "'");
        pre.execute();
        return true;
    }

    public Cours details(int id) throws SQLException {

        String req = "select * from cours where id ='" + id + "'";

        Cours C = null;

        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while (rs.next()) {
                java.sql.Date sqlDateDebut = java.sql.Date.valueOf(rs.getDate(4).toLocalDate());
                java.sql.Date sqlDateFin = java.sql.Date.valueOf(rs.getDate(5).toLocalDate());
                C = new Cours(rs.getInt(1), rs.getString(2), rs.getString(3), sqlDateDebut, sqlDateFin, rs.getString(6), rs.getInt(7), rs.getString(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCours.class.getName()).log(Level.SEVERE, null, ex);
        }

        return C;
    }

    public int count() {
        try {
            String req = "select count(*) AS total from cours ";
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            rs.next();
            int count = rs.getInt(1);
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCours.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public Enseignant detailsEnseignant(int id) throws SQLException {

        Enseignant E = null;
        ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery("select salaire,idUser,nom,prenom  from enseignant INNER JOIN utilisateur ON enseignant.idUser=utilisateur.id   where enseignant.id = '" + id + "'");
        while (rs.next()) {

            double salaire = rs.getInt("salaire");
            int idUser = rs.getInt("idUser");
            String prenom = rs.getString("prenom");
            String nom = rs.getString("nom");
            E = new Enseignant(0, idUser, salaire, nom, prenom, "", "", "", "", "", "", "");

        }
        return E;

    }

    public ArrayList findEnseignants() throws SQLException {
        ArrayList arr = new ArrayList();
        ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery("select f.id,f.salaire,f.idUser,nom,prenom  from enseignant as f INNER JOIN utilisateur ON f.idUser=utilisateur.id   ");
        while (rs.next()) {

            double salaire = rs.getInt("salaire");
            int idUser = rs.getInt("idUser");
            int id = rs.getInt("id");
            String prenom = rs.getString("prenom");
            String nom = rs.getString("nom");
            Enseignant E = new Enseignant(id, idUser, salaire, nom, prenom, "", "", "", "", "", "", "");
            arr.add(E);
        }
        return arr;

    }

    public ArrayList<Cours> triParNombre() throws SQLException {
        ArrayList<Cours> TabF = new ArrayList<>();
        String req = "SELECT * FROM cours order by placeDispo";
        PreparedStatement p;
        p = cnx.prepareStatement(req);
        ResultSet rs = p.executeQuery();
        while (rs.next()) {
            java.sql.Date sqlDateDebut = java.sql.Date.valueOf(rs.getDate(4).toLocalDate());
            java.sql.Date sqlDateFin = java.sql.Date.valueOf(rs.getDate(5).toLocalDate());

            TabF.add(new Cours(rs.getInt(1), rs.getString(2), rs.getString(3), sqlDateDebut, sqlDateFin, rs.getString(6), rs.getInt(7), rs.getString(8)));
        }
        return TabF;
    }

    public ArrayList<Cours> triParTitre() throws SQLException {
        ArrayList<Cours> TabF = new ArrayList<>();
        String req = "SELECT * FROM cours order by titre";
        PreparedStatement p;
        p = cnx.prepareStatement(req);
        ResultSet rs = p.executeQuery();
        while (rs.next()) {
            java.sql.Date sqlDateDebut = java.sql.Date.valueOf(rs.getDate(4).toLocalDate());
            java.sql.Date sqlDateFin = java.sql.Date.valueOf(rs.getDate(5).toLocalDate());

            TabF.add(new Cours(rs.getInt(1), rs.getString(2), rs.getString(3), sqlDateDebut, sqlDateFin, rs.getString(6), rs.getInt(7), rs.getString(8)));
        }
        return TabF;
    }
}
