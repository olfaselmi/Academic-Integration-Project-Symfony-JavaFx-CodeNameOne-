/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author user
 */
public class demande {
    private int id;
    private Date dateDebut;
    private Date DateFin;
    private int montantPropose;
    private int idEcole;
    private int idDomaine;

    public demande(String dateDebut, String DateFin, int montantPropose, int idEcole, int idDomaine) throws ParseException {
        Date dd=Date.valueOf(dateDebut);
        Date df=Date.valueOf(DateFin);
        this.dateDebut = dd;
        this.DateFin = df;
        this.montantPropose = montantPropose;
        this.idEcole = idEcole;
        this.idDomaine = idDomaine;
    }

    public demande(int id, Date dateDebut, Date DateFin, int montantPropose, int idEcole, int idDomaine) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.DateFin = DateFin;
        this.montantPropose = montantPropose;
        this.idEcole = idEcole;
        this.idDomaine = idDomaine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return DateFin;
    }

    public void setDateFin(Date DateFin) {
        this.DateFin = DateFin;
    }

    public int getMontantPropose() {
        return montantPropose;
    }

    public void setMontantPropose(int montantPropose) {
        this.montantPropose = montantPropose;
    }

    public int getIdEcole() {
        return idEcole;
    }

    public void setIdEcole(int idEcole) {
        this.idEcole = idEcole;
    }

    public int getIdDomaine() {
        return idDomaine;
    }

    public void setIdDomaine(int idDomaine) {
        this.idDomaine = idDomaine;
    }

    @Override
    public String toString() {
        return "demande{" + "id=" + id + ", dateDebut=" + dateDebut + ", DateFin=" + DateFin + ", montantPropose=" + montantPropose + ", idEcole=" + idEcole + ", idDomaine=" + idDomaine + '}';
    }
    
    
}
