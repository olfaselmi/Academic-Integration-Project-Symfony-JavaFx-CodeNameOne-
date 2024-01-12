/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import Service.User_service;
import Utils.DataBase;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pidev.Entity.User;

/**
 * FXML Controller class
 *
 * @author u
 */
public class ListuserController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button affichen,delete;
    @FXML
    private TableView<User> Userview;
    @FXML
    private TableColumn<User, String> col_nom;
    @FXML
    private TableColumn<User, String> col_prenom;
    @FXML
    private TableColumn<User, String> col_cin;
    @FXML
    private TableColumn<User, String> col_mail;
    @FXML
    private TableColumn<User, String> col_tel;
    @FXML
    private TableColumn<User, String> col_role;
    @FXML
    public ObservableList<User> oblist = FXCollections.observableArrayList();
    User_service user = new User_service();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        try {
            viewUser();
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(ListuserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void initTable() throws SQLException{
        
    }
    @FXML
    public void viewUser() throws SQLException{
        
        Connection conn = DataBase.getInstance().getCnx(); 
        String req="select cin,nom,prenom,tel,email,role from utilisateur ";
        PreparedStatement pst = conn.prepareStatement(req);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
          oblist.add(new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
        }
        
        col_nom.setCellValueFactory(new PropertyValueFactory<>("col_nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<User,String>("col_prenom"));
        col_cin.setCellValueFactory(new PropertyValueFactory<User,String>("col_cin"));
        col_mail.setCellValueFactory(new PropertyValueFactory<User,String>("col_mail"));
        col_tel.setCellValueFactory(new PropertyValueFactory<User,String>("col_tel"));
        col_role.setCellValueFactory(new PropertyValueFactory<User,String>("col_role"));
        Userview.setItems(oblist);
        System.out.println("aaa");
    }  
    @FXML
    private void delete(ActionEvent event) throws SQLException {
    User c=Userview.getSelectionModel().getSelectedItem();
       if (!c.equals(null)) 
        user.delete(c.getCin());
        //initTable();
    }
         
         
        
   
   
}
