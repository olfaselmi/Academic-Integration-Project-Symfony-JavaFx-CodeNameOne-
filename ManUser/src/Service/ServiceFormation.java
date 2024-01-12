/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Formateur;
import Entite.Cours;
import Entite.Formation;
import Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emna
 */
public class ServiceFormation {

    private Connection cnx;
    private Statement ste;
    private PreparedStatement pre;

    public ServiceFormation() {
        cnx = DataBase.getInstance().getConnection();
    }

    public ArrayList<Formation> DisplayAll() throws SQLException {
        ArrayList<Formation> TabF = new ArrayList<>();
        String req = "SELECT * FROM formation";
        PreparedStatement p;
        p = cnx.prepareStatement(req);
        ResultSet rs = p.executeQuery();
        while (rs.next()) {
            TabF.add(new Formation(rs.getInt("id"), rs.getString("titre"), rs.getString("image"), rs.getString("contenu"), rs.getString("placeDispo"), rs.getInt("idFormateur"), rs.getString("emploi")));
        }
        return TabF;
    }

    public void ajouter(Formation f) throws SQLException {
        if (controlede_saisie(f)) {
            pre = cnx.prepareStatement("INSERT INTO formation ( `titre`, `image`, `contenu`,  `placeDispo`,`idFormateur`) VALUES ( ?, ?, ?, ?,?);");
            pre.setString(1, f.getTitre());
            pre.setString(2, f.getImage());
            pre.setString(3, f.getContenu());
            pre.setString(4, f.getPlacedisponible());
            pre.setInt(5, f.getIdFormateur());
            pre.executeUpdate();
        } else {
            System.out.println("erreur ajout");
        }
    }

    public void modifier(Formation t) throws SQLException {
        pre = cnx.prepareStatement("UPDATE formation SET titre=?, image = ? , contenu = ?  , placeDispo = ? , idFormateur = ? WHERE id = ?");

        pre.setString(1, t.getTitre());
        pre.setString(2, t.getImage());
        pre.setString(3, t.getContenu());
        pre.setString(4, t.getPlacedisponible());
        pre.setInt(5, t.getIdFormateur());
        pre.setInt(6, t.getId());
        pre.executeUpdate();

    }

    public boolean delete(int id) throws SQLException {

        pre = cnx.prepareStatement("delete from formation where id = '" + id + "'");
        pre.execute();
        return true;
    }

    public boolean controlede_saisie(Formation t) throws SQLException {

        if (t.getTitre().length() == 0 || t.getImage().length() == 0 || t.getContenu().length() == 0) {
            return false;
        } else if (t.getTitre().length() > 255 && t.getImage().length() > 255 && t.getContenu().length() > 800) {
            return false;
        }

        return true;

    }

    public Formation details(int id) throws SQLException {

        String req = "select * from formation where id ='" + id + "'";

        Formation F = null;

        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while (rs.next()) {

                F = new Formation(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFormation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return F;
    }

    public int count() {
        try {
            String req = "select count(*) AS total from formation ";
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            rs.next();
            int count = rs.getInt(1);
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFormation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ArrayList findFormateurs() throws SQLException {
        ArrayList arr = new ArrayList();
        ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery("select f.id,f.salaire,f.idUser,nom,prenom  from formateur as f INNER JOIN utilisateur ON f.idUser=utilisateur.id   ");
        while (rs.next()) {

            double salaire = rs.getInt("salaire");
            int idUser = rs.getInt("idUser");
            int id = rs.getInt("id");
            String prenom = rs.getString("prenom");
            String nom = rs.getString("nom");
            Formateur f = new Formateur(id, idUser, salaire, nom, prenom, "", "", "", "", "", "", "");
            arr.add(f);
        }
        return arr;

    }

    public Formateur detailsFormateur(int id) throws SQLException {

        Formateur F = null;
        ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery("select salaire,idUser,nom,prenom  from formateur INNER JOIN utilisateur ON formateur.idUser=utilisateur.id   where formateur.id = '" + id + "'");
        while (rs.next()) {

            double salaire = rs.getInt("salaire");
            int idUser = rs.getInt("idUser");
            String prenom = rs.getString("prenom");
            String nom = rs.getString("nom");
            F = new Formateur(0, idUser, salaire, nom, prenom, "", "", "", "", "", "", "");

        }
        return F;

    }

    public ArrayList<Formation> triParNombre() throws SQLException {
        ArrayList<Formation> TabF = new ArrayList<>();
        String req = "SELECT * FROM formation order by placeDispo ";
        PreparedStatement p;
        p = cnx.prepareStatement(req);
        ResultSet rs = p.executeQuery();
        while (rs.next()) {
            TabF.add(new Formation(rs.getInt("id"), rs.getString("titre"), rs.getString("image"), rs.getString("contenu"), rs.getString("placeDispo"), rs.getInt("idFormateur"), rs.getString("emploi")));
        }
        return TabF;
    }

    public ArrayList<Formation> triParTitre() throws SQLException {
        ArrayList<Formation> TabF = new ArrayList<>();
        String req = "SELECT * FROM formation order by titre";
        PreparedStatement p;
        p = cnx.prepareStatement(req);
        ResultSet rs = p.executeQuery();
        while (rs.next()) {
            TabF.add(new Formation(rs.getInt("id"), rs.getString("titre"), rs.getString("image"), rs.getString("contenu"), rs.getString("placeDispo"), rs.getInt("idFormateur"), rs.getString("emploi")));
        }
        return TabF;
    }
}
