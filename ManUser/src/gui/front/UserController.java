/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.front;

import Entite.User;
import Service.ServiceUser;
import Service.Servicebcrypt;
import Utils.staticvar;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Asus X550V
 */
public class UserController implements Initializable {

    @FXML
    private ImageView logout;
    @FXML
    private Label nbnotif;
    @FXML
    private TextField nom;
    @FXML
    private TextField pwd;
    @FXML
    private TextField tel;
    @FXML
    private TextField country;
    @FXML
    private TextField prenom;
    @FXML
    private Button btnmod;
    @FXML
    private Button btndel;
    @FXML
    private TextField btnuser;
    @FXML
    private Label userlabel;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
            
       }
    
    public void setLabelUser(String userlabel) {
        this.userlabel.setText(userlabel);
    }
    public void setTNom(String nom) {
        this.nom.setText(nom);
    } 
    public void setTPnom(String prenom) {
        this.prenom.setText(prenom);
    }
    public void setTel(String tel) {
        this.tel.setText(tel);
    }
    public void setCount(String country) {
        this.country.setText(country);
    }
    public void setUser(String btnuser) {
        this.btnuser.setText(btnuser);
    }

    @FXML
    private void logout(MouseEvent event) throws IOException {
    FXMLLoader fxml=new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
        InscriptionController rc=fxml.getController();
    }

    @FXML
    private void modify(ActionEvent event) throws SQLException {
    
            String tell = tel.getText();
            String nomm = nom.getText();
            String prenomm = prenom.getText();
            String pwd1 = pwd.getText();
            String countryy = country.getText();
            ServiceUser user = new ServiceUser();
            String crypted = Servicebcrypt.hashpw(pwd1, staticvar.SALT);
            User u = new User(nomm,prenomm,countryy,crypted,tell);
            user.modify(u,btnuser.getText());
            
    }

    @FXML
    private void delete(ActionEvent event) throws SQLException, IOException {
     
            String name = btnuser.getText();
            ServiceUser user = new ServiceUser();
            user.delete(name);
            FXMLLoader fxml=new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
        InscriptionController rc=fxml.getController();
    }
    
}
