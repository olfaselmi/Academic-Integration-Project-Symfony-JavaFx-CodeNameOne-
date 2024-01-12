/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import Service.User_service;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.Entity.User;

/**
 * FXML Controller class
 *
 * @author u
 */
public class InscriptionController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private TextField u_nom;
    @FXML
    private Button u_ajouter;
    @FXML
    private PasswordField u_mdp;
    @FXML
    private TextField u_tel;
    @FXML
    private TextField u_rue;
    @FXML
    private TextField u_nM;
    @FXML
    private TextField u_prenom;
    @FXML
    private TextField u_ville;
    @FXML
    private TextField u_cin;
    @FXML
    private TextField u_mail;
    @FXML
    private TextField u_image;
    @FXML
    private TextField u_role;
    @FXML
    private TextField u_age;
    @FXML
    private Button u_list;
    @FXML
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
   
    
     @FXML
    private void ajouteruser(ActionEvent event) {
    try {
            String mai = u_mail.getText();
            String tell = u_tel.getText();
            String cinn = u_cin.getText();
            String nomm = u_nom.getText();
            String prenomm = u_prenom.getText();
            String pwd = u_mdp.getText();
            String numM = u_nM.getText();
            String ruee = u_rue.getText();
            String villee = u_ville.getText();
            String agee = u_age.getText();
            String rolee = u_role.getText();
            String imagee = u_image.getText();
            int age=Integer.parseInt(agee);
            ;
            User_service user = new User_service();
            //String crypted = Servicebcrypt.hashpw(pwd, staticvar.SALT);
            User u=new  User( cinn,  nomm, prenomm, age, tell,  mai , pwd,  numM,  ruee, villee, rolee, imagee);
            user.ajouter(u);
            
            /*FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("login.fxml"));
            try {
                Parent root = loader.load();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }*/
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
