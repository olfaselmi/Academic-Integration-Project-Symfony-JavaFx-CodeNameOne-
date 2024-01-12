/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Entite.Enseignant;
import Entite.Formateur;
import Entite.Respcentre;
import Entite.Respecole;
import Entite.User;
import IService.IService;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import Utils.DataBase;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
/**
 *
 * @author Asus X550V
 */
public class ServiceUser implements IService<User> {
    private Connection con;
    private Statement ste;
    
    public ServiceUser()
    {
    con = DataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(User u) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `pidevv`.`user` (`idu`, `nom`, `prenom`, `country`, `email`, `password`, `tel`, `username`, `roles`, `dateins`) VALUES (NULL, '" + u.getNom() + "', '" + u.getPrenom() + "', '" + u.getCountry() + "', '" + u.getMail() + "', '" + u.getPwd() + "', '" + u.getTel() + "', '" + u.getUsername() + "', '" + u.getRoles() +"',sysdate());";
        ste.executeUpdate(requeteInsert);
        JOptionPane.showMessageDialog(null,"User ajouté avec succées");
    }
    public void ajouter_respec(Respecole resp) throws SQLException {
          ste = con.createStatement();
                //String requeteInsert1 = "INSERT INTO `pidevv`.`user` (`idu`, `nom`, `prenom`, `country`, `email`, `password`, `tel`, `username`, `roles`, `dateins`) VALUES (NULL, '" + resp.getNom() + "', '" + resp.getPrenom() + "', '" + resp.getCountry() + "', '" + resp.getMail() + "', '" + resp.getPwd() + "', '" + resp.getTel() + "', '" + resp.getUsername() + "', '" + resp.getRoles() +"',sysdate());";
                //ste.executeUpdate(requeteInsert1);
          String requeteInsert = "INSERT INTO `pidevv`.`respecole` (`id`, `idUser`, `idEcole`) VALUES (NULL, '" + resp.getIduser()+ "', '" + resp.getIdEcole()+ "');";
        ste.executeUpdate(requeteInsert);
        JOptionPane.showMessageDialog(null,"User ajouté avec succées");
        }
    public void ajouter_respcentre(Respcentre resp) throws SQLException {
          ste = con.createStatement();
                String requeteInsert1 = "INSERT INTO `pidevv`.`user` (`idu`, `nom`, `prenom`, `country`, `email`, `password`, `tel`, `username`, `roles`, `dateins`) VALUES (NULL, '" + resp.getNom() + "', '" + resp.getPrenom() + "', '" + resp.getCountry() + "', '" + resp.getMail() + "', '" + resp.getPwd() + "', '" + resp.getTel() + "', '" + resp.getUsername() + "', '" + resp.getRoles() +"',sysdate());";
                ste.executeUpdate(requeteInsert1);
          String requeteInsert = "INSERT INTO `pidevv`.`respcentre` (`id`, `idUser`, `idEcole`) VALUES (NULL, '" + resp.getIduser()+ "', '" + resp.getIdCentre()+ "');";
        ste.executeUpdate(requeteInsert);
        JOptionPane.showMessageDialog(null,"User ajouté avec succées");
        }
    public void ajouter_formateur(Formateur form) throws SQLException {
          ste = con.createStatement();
                String requeteInsert1 = "INSERT INTO `pidevv`.`user` (`idu`, `nom`, `prenom`, `country`, `email`, `password`, `tel`, `username`, `roles`, `dateins`) VALUES (NULL, '" +form.getNom() + "', '" + form.getPrenom() + "', '" + form.getCountry() + "', '" + form.getMail() + "', '" + form.getPwd() + "', '" + form.getTel() + "', '" + form.getUsername() + "', '" + form.getRoles() +"',sysdate());";
                ste.executeUpdate(requeteInsert1);
          String requeteInsert = "INSERT INTO `pidevv`.`formateur` (`id`, `idUser`, `idEcole`) VALUES (NULL, '" + form.getIdUser()+ "', '" + form.getSalaire()+ "');";
        ste.executeUpdate(requeteInsert);
        JOptionPane.showMessageDialog(null,"User ajouté avec succées");
        }
    public void ajouter_enseignant(Enseignant Ens) throws SQLException {
          ste = con.createStatement();
                String requeteInsert1 = "INSERT INTO `pidevv`.`user` (`idu`, `nom`, `prenom`, `country`, `email`, `password`, `tel`, `username`, `roles`, `dateins`) VALUES (NULL, '" + Ens.getNom() + "', '" + Ens.getPrenom() + "', '" + Ens.getCountry() + "', '" + Ens.getMail() + "', '" + Ens.getPwd() + "', '" + Ens.getTel() + "', '" + Ens.getUsername() + "', '" + Ens.getRoles() +"',sysdate());";
                ste.executeUpdate(requeteInsert1);
          String requeteInsert = "INSERT INTO `pidevv`.`enseignant` (`id`, `idUser`, `idEcole`) VALUES (NULL, '" + Ens.getIdUser()+ "', '" + Ens.getSalaire()+ "');";
        ste.executeUpdate(requeteInsert);
        JOptionPane.showMessageDialog(null,"Formateur ajouté avec succées");
        }
    @Override
    public boolean delete(String nom) throws SQLException {
    
        PreparedStatement pre=con.prepareStatement("DELETE FROM user WHERE username='"+nom+"' ;");
        pre.executeUpdate();
        JOptionPane.showMessageDialog(null,"User supprimé avec succées");
        return true;
    }
    
    public boolean update(User u,String id) throws SQLException {
PreparedStatement pre=con.prepareStatement("UPDATE user SET nom= '" +u.getNom()+ "',prenom='"+u.getPrenom()+"',country='"+u.getCountry()+"',email='"+u.getMail()+"',password='"+u.getPwd()+"',tel='"+u.getTel()+"',username='"+u.getUsername()+"' WHERE id='"+id+"' ;");
JOptionPane.showMessageDialog(null,"User modifié avec succées");
            pre.executeUpdate();
       
        return true;    }

    @Override
    public ObservableList<User> readAll() throws SQLException {
    ObservableList oblist = FXCollections.observableArrayList();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from user");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
               String prenom=rs.getString(3);
               String country=rs.getString("country");
               String mail=rs.getString("email");
               String pwd=rs.getString("password");
               String tel=rs.getString(7);
               String username=rs.getString("username");
               String roles=rs.getString("roles");
               String dateins=rs.getString("dateins");
               User u=new User(nom, prenom, country,mail,pwd,tel,username,roles,dateins);
     oblist.add(u);
     }
    return oblist;
    }
     public ObservableList<User> readAllre() throws SQLException {
    ObservableList oblistre = FXCollections.observableArrayList();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from user where roles like 'Responsable Ecole' ;");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
               String prenom=rs.getString(3);
               String country=rs.getString("country");
               String mail=rs.getString("email");
               String pwd=rs.getString("password");
               String tel=rs.getString(7);
               String username=rs.getString("username");
               String roles=rs.getString("roles");
               String dateins=rs.getString("dateins");
               User u=new User(nom, prenom, country,mail,pwd,tel,username,roles,dateins);
     oblistre.add(u);
     }
    return oblistre;
    }
     public ObservableList<User> readAllrc() throws SQLException {
    ObservableList oblistrc = FXCollections.observableArrayList();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from user where roles like 'Responsable Centre' ;");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
               String prenom=rs.getString(3);
               String country=rs.getString("country");
               String mail=rs.getString("email");
               String pwd=rs.getString("password");
               String tel=rs.getString(7);
               String username=rs.getString("username");
               String roles=rs.getString("roles");
               String dateins=rs.getString("dateins");
               User u=new User(nom, prenom, country,mail,pwd,tel,username,roles,dateins);
     oblistrc.add(u);
     }
    return oblistrc;
    }
     public ObservableList<User> readAllens() throws SQLException {
    ObservableList oblistens = FXCollections.observableArrayList();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from user where roles like 'Enseignant' ;");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
               String prenom=rs.getString(3);
               String country=rs.getString("country");
               String mail=rs.getString("email");
               String pwd=rs.getString("password");
               String tel=rs.getString(7);
               String username=rs.getString("username");
               String roles=rs.getString("roles");
               String dateins=rs.getString("dateins");
               User u=new User(nom, prenom, country,mail,pwd,tel,username,roles,dateins);
     oblistens.add(u);
     }
    return oblistens;
    }
    
    @Override
    public List<User> rechercheavance(String n) throws SQLException
    {
    List<User> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from user where username like '%" + n + "%' ;");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
               String prenom=rs.getString(3);
               String country=rs.getString("country");
               String mail=rs.getString("email");
               String pwd=rs.getString("password");
               String tel=rs.getString(7);
               String username=rs.getString("username");
               String roles=rs.getString("roles");
               String dateins=rs.getString("dateins");
               User u=new User(id, nom, prenom, country,mail,pwd,tel,username,roles,dateins);
     arr.add(u);
     }
    return arr;
    }

    @Override
    public List<User> tri() throws SQLException {
     List<User> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from user ORDER BY country asc");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
               String prenom=rs.getString(3);
               String country=rs.getString("country");
               String mail=rs.getString("email");
               String pwd=rs.getString("password");
               String tel=rs.getString(7);
               String username=rs.getString("username");
               String roles=rs.getString("roles");
               String dateins=rs.getString("dateins");
               User u=new User(id, nom, prenom, country,mail,pwd,tel,username,roles,dateins);
     arr.add(u);
     }
    return arr;
    }

    @Override
    public ObservableList<User> rechercheentredate(String d1, String d2) throws SQLException {
    ObservableList<User> arr=FXCollections.observableArrayList();
    ste=con.createStatement();
    String sql="select * from user";
    if((!d1.isEmpty())&&(!d2.isEmpty()))
    {
        sql="select * from user where dateins between '" + d1 + "' AND '" + d2 + "'";
    }
   
    ResultSet rs=ste.executeQuery(sql);
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
               String prenom=rs.getString(3);
               String country=rs.getString("country");
               String mail=rs.getString("email");
               String pwd=rs.getString("password");
               String tel=rs.getString(7);
               String username=rs.getString("username");
               String roles=rs.getString("roles");
               String dateins=rs.getString("dateins");
               User u=new User(id, nom, prenom, country,mail,pwd,tel,username,roles,dateins);
     arr.add(u);
     }
    return arr;
    }

    @Override
    public int moyenne() throws SQLException {
    ste=con.createStatement();
    int i=0;
    ResultSet rs=ste.executeQuery("SELECT * FROM `user` WHERE DATEDIFF(dateins,sysdate())=0");
     while (rs.next()) { 
         i++;
     }
    return i;
    }

    @Override
    public int auth(String mail, String pwd) throws SQLException {
        int i=0,k=0;
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("SELECT * FROM user WHERE email='"+mail+"' ;");
        while (rs.next()) {
            String crypted = rs.getString("password");
                if (Servicebcrypt.checkpw(pwd, crypted)) {
                i++;    
                }
            
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
               String prenom=rs.getString(3);
               String country=rs.getString("country");
               String tel=rs.getString(7);
               String username=rs.getString("username");
               String roles=rs.getString("roles");
               if("Etudiant".equals(roles))
               {k++;}
               else if("Responsable Ecole".equals(roles))
               {k++;}
               else if("Responsable Centre".equals(roles))
               {k++;}
                else if("Formateur".equals(roles))
               {k++;}
               else if("Enseignant".equals(roles))
               {k++;}
     }
        if(i==1 && k==1)
        {
        return 1;
        }
        else if(i==1 && k==0)
        {
        return 2;
        }
        else{
        return 0;
        }
    }

    @Override
    public String forgotpasss(String mail) throws SQLException {
    String a="";
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("SELECT * FROM `user` WHERE email='"+mail+"' ;");
    while (rs.next()) { 
    a=rs.getString("password");
    }
    return a;
    }

    public boolean update(User t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modify(User u, String id) throws SQLException {
    PreparedStatement pre=con.prepareStatement("UPDATE user SET nom= '" +u.getNom()+ "',prenom='"+u.getPrenom()+"',country='"+u.getCountry()+"',password='"+u.getPwd()+"',tel='"+u.getTel()+"' WHERE username='"+id+"' ;");
    JOptionPane.showMessageDialog(null,"User modifié avec succées");
    pre.executeUpdate();
       
        return true;      }

    @Override
    public String getUser(String mail) throws SQLException {
    String a="";
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("SELECT * FROM `user` WHERE email='"+mail+"' ;");
    while (rs.next()) { 
    a=rs.getString("username");
    }
    return a;
    }
    public String getUserrole(String mail) throws SQLException {
    String a="";
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("SELECT roles FROM `user` WHERE email='"+mail+"' ;");
    while (rs.next()) { 
    a=rs.getString("roles");
    }
    return a;
    }

    @Override
    public User SerachUser(String username) throws SQLException {
    
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("SELECT * FROM `user` WHERE username='"+username+"' ;");
    while (rs.next()) { 
    String a=rs.getString("username");
    String nom=rs.getString("nom");
    String prenom=rs.getString(3);
    String country=rs.getString("country");
    String tel=rs.getString(7);
    String pwd=rs.getString("password");
    User u= new User(nom,prenom,country,pwd,tel);
    return u;
    }
    return null;
    }

    @Override
    public int preauth(String mail, String pwd) throws SQLException {
int i=0;
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("SELECT * FROM user WHERE email='"+mail+"'AND password='"+pwd+"' ;");
        while (rs.next()) {
              int id=rs.getInt(1);
               String nom=rs.getString("nom");
               String prenom=rs.getString(3);
               String country=rs.getString("country");
               String tel=rs.getString(7);
               String username=rs.getString("username");
               String roles=rs.getString("roles");
               if("Etudiant".equals(roles))
               {i++;}
               else if("Enseignant".equals(roles))
               {i++;}
                else if("Responsable Ecole".equals(roles))
               {i++;}
               else if("Formateur".equals(roles))
               {i++;}
               else if("Enseignant".equals(roles))
               {i++;}
               else if("Responsable Centre".equals(roles))
               {i++;}
               
     }
        if(i==1)
        {
        return 1;
        }
        else{
        return 0;
        }
    }

    @Override
    public void ajouter_respec(User t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  


   

    
    
    
}
