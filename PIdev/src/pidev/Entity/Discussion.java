/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entity;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author u
 */
public class Discussion {
    private int id_disc;
    private int id_user;
    private String email_login_dest;
    private String titre;
    private String message;
    private String image;
    private String autre;
    private Date date_envoi;

    public Discussion(int id_disc, int id_user, String email_login_dest, String titre, String message, String image, String autre, Date date_envoi) {
        this.id_disc = id_disc;
        this.id_user = id_user;
        this.email_login_dest = email_login_dest;
        this.titre = titre;
        this.message = message;
        this.image = image;
        this.autre = autre;
        this.date_envoi = date_envoi;
    }

    public Discussion(int id_user, String email_login_dest, String titre, String message, String image, String autre, Date date_envoi) {
        this.id_user = id_user;
        this.email_login_dest = email_login_dest;
        this.titre = titre;
        this.message = message;
        this.image = image;
        this.autre = autre;
        this.date_envoi = date_envoi;
    }

    public Discussion(String email_login_dest, String titre, String message, String image, String autre, Date date_envoi) {
        this.email_login_dest = email_login_dest;
        this.titre = titre;
        this.message = message;
        this.image = image;
        this.autre = autre;
        this.date_envoi = date_envoi;
    }

    public int getId_disc() {
        return id_disc;
    }

    public void setId_disc(int id_disc) {
        this.id_disc = id_disc;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getEmail_login_dest() {
        return email_login_dest;
    }

    public void setEmail_login_dest(String email_login_dest) {
        this.email_login_dest = email_login_dest;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAutre() {
        return autre;
    }

    public void setAutre(String autre) {
        this.autre = autre;
    }

    public Date getDate_envoi() {
        return date_envoi;
    }

    public void setDate_envoi(Date date_envoi) {
        this.date_envoi = date_envoi;
    }

    @Override
    public String toString() {
        return "Discussion{" + "id_disc=" + id_disc + ", id_user=" + id_user + ", email_login_dest=" + email_login_dest + ", titre=" + titre + ", message=" + message + ", image=" + image + ", autre=" + autre + ", date_envoi=" + date_envoi + '}';
    }
    
    
}
