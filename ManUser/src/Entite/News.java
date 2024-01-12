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
public class News {
    private int idn;
    private String titre;
    private String description;
    private String datepub;
    private String nomcat;
    
    public News(int idn,String titre,String description,String datepub,String nomcat)
        
    {
    this.idn=idn;
    this.titre=titre;
    this.description=description;
    this.datepub=datepub;
    this.nomcat=nomcat;
    }
    
    public News(String titre,String description,String datepub,String nomcat)
        
    {
    this.titre=titre;
    this.description=description;
    this.datepub=datepub;
    this.nomcat=nomcat;
    }
    
    public News(String titre,String description,String nomcat)
        
    {
    this.titre=titre;
    this.description=description;
    this.nomcat=nomcat;
    }
    
    public int getIdn()
    {
    return this.idn;
    }
    public void setIdn(int idn)
    {
    this.idn=idn;
    }
    public String getTitre()
    {
    return this.titre;
    }
    public void setTitre(String titre)
    {
    this.titre=titre;
    }
    public String getDesc()
    {
    return this.description;
    }
    public void setDesc(String description)
    {
    this.description=description;
    }
    public String getDatepub()
    {
    return this.datepub;
    }
    public void setDatepub(String datepub)
    {
    this.datepub=datepub;
    }
    public String getNomcat()
    {
    return this.nomcat;
    }
    public void setNomcat(String nomcat)
    {
    this.nomcat=nomcat;
    }
    public String toString() {
        return "News{" + "idNews=" + idn + ", Titre=" + titre + ", Descirption=" + description + ", Date publication=" + datepub + ",Catégorie:"+nomcat+'}';
    }
}
