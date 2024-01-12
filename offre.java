/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author user
 */
public class offre {
    private int id;
    private int prixPropose;
    private boolean certifie;
    private int idCentre;
    private int idDemande;

    public offre(int prixPropose, boolean certifie, int idCentre, int idDemande) {
        this.prixPropose = prixPropose;
        this.certifie = certifie;
        this.idCentre = idCentre;
        this.idDemande = idDemande;
    }

    public offre(int id, int prixPropose, boolean certifie, int idCentre, int idDemande) {
        this.id = id;
        this.prixPropose = prixPropose;
        this.certifie = certifie;
        this.idCentre = idCentre;
        this.idDemande = idDemande;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrixPropose() {
        return prixPropose;
    }

    public void setPrixPropose(int prixPropose) {
        this.prixPropose = prixPropose;
    }

    public boolean isCertifie() {
        return certifie;
    }

    public void setCertifie(boolean certifie) {
        this.certifie = certifie;
    }

    public int getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(int idCentre) {
        this.idCentre = idCentre;
    }

    public int getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(int idDemande) {
        this.idDemande = idDemande;
    }

    @Override
    public String toString() {
        return "offre{" + "id=" + id + ", prixPropose=" + prixPropose + ", certifie=" + certifie + ", idCentre=" + idCentre + ", idDemande=" + idDemande + '}';
    }
    
}
