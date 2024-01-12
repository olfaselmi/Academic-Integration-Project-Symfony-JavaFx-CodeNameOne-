/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author Asus X550V
 */
public class Categorie {
    private int idc;
    private String nomcat;
    
    public Categorie(int idc,String nomcat)
    {
    this.idc=idc;
    this.nomcat=nomcat;
    }
    
    public Categorie(String nomcat)
    {
    this.nomcat=nomcat;
    }
    
    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getNomcat() {
        return nomcat;
    }

    public void setNomcat(String nomcat) {
        this.nomcat = nomcat;
    }
    
    @Override
    public String toString() {
        return  nomcat;
    }
    
}
