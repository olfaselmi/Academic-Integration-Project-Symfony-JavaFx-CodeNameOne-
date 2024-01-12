/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.front;

import Entite.User;
import Service.ServiceUser;
import gui.back.UserbController;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Asus X550V
 */
public class HomepageREController implements Initializable {

    @FXML
    private Label nbnotif;
    @FXML
    private ImageView logout;
    @FXML
    private ImageView btnprofile;
    @FXML
    private Button profile;
    @FXML
    private Label userlabel;
    @FXML
    private TableView<User> Ensview;
    @FXML
    private TableColumn<?, ?> col_nom;
    @FXML
    private TableColumn<?, ?> col_prenom;
    @FXML
    private TableColumn<?, ?> col_count;
    @FXML
    private TableColumn<?, ?> col_mail;
    @FXML
    private TableColumn<?, ?> col_tel;
    @FXML
    private TableColumn<?, ?> col_us;
    @FXML
    private TableColumn<?, ?> col_role;
    @FXML
    private TableColumn<?, ?> col_date;
    ObservableList<User> oblistens = FXCollections.observableArrayList();
    ServiceUser user = new ServiceUser();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initTable();
    }    

    @FXML
    private void logout(MouseEvent event) throws IOException {
    FXMLLoader fxml=new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
        InscriptionController rc=fxml.getController();
    }
    public void setLabelUser(String userlabel) {
        this.userlabel.setText(userlabel);
    }

    @FXML
    private void account(ActionEvent event) throws IOException {
    FXMLLoader fxml=new FXMLLoader(getClass().getResource("User.fxml"));
        Parent root=fxml.load();
        logout.getScene().setRoot(root);
        UserController rc=fxml.getController();
        rc.setLabelUser(userlabel.getText());
         try {
            ServiceUser user = new ServiceUser();
            User u = user.SerachUser(userlabel.getText());
            rc.setTNom(u.getNom());
            rc.setTPnom(u.getPrenom());
            rc.setTel(u.getTel());
            rc.setCount(u.getCountry());
            rc.setUser(userlabel.getText());
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    private void initTable() {
        
        try {
            oblistens= (ObservableList<User>) user.readAllens() ;
            col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            col_count.setCellValueFactory(new PropertyValueFactory<>("country"));
            col_mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
            col_tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
            col_us.setCellValueFactory(new PropertyValueFactory<>("username"));
            col_role.setCellValueFactory(new PropertyValueFactory<>("roles"));
            col_date.setCellValueFactory(new PropertyValueFactory<>("dateins"));
            Ensview.setItems(oblistens);
            
        } catch (SQLException ex) {
            Logger.getLogger(HomepageREController.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
    
    
}
