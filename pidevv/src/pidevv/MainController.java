/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevv;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Zghal Youssef
 */
public class MainController implements Initializable {
    
    
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfEnseignant;
    @FXML
    private TextField tfModule;
    @FXML
    private TableView<modenseig> tvmodenseig;
    @FXML
    private TableColumn<modenseig, Integer> colid;
    @FXML
    private TableColumn<modenseig, Integer> colidEnseig;
    @FXML
    private TableColumn<modenseig, Integer> colidMod;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnModifier;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        if(event.getSource() == btnAjouter){
        insertRecord();
        }else if(event.getSource() == btnModifier){
                updateRecord();
        }else if(event.getSource() == btnSupprimer){
        deleteButton();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showmodenseig();
    }    
    public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pidev","root","");
        return conn;
    }catch(Exception ex){
        System.out.println("Error: " + ex.getMessage());
        return null;
}
    }
    
    public ObservableList<modenseig> getmodenseigList(){
    ObservableList<modenseig> modenseigList = FXCollections.observableArrayList();
    Connection conn = getConnection();
    String query = "SELECT * FROM modenseig";
    Statement st;
    ResultSet rs;
    
    try{
    st = conn.createStatement();
    rs = st.executeQuery(query);
    modenseig Modenseig;
    while(rs.next()){
    Modenseig = new modenseig(rs.getInt("id"),rs.getInt("idEnseig"),rs.getInt("idMod"));
    modenseigList.add(Modenseig);
    }
    }catch(Exception ex){
    ex.printStackTrace();
    }
    return modenseigList;
    }
    
    
    public void showmodenseig(){
    ObservableList<modenseig> list = getmodenseigList();
    colid.setCellValueFactory(new PropertyValueFactory<modenseig, Integer>("id"));
    colidEnseig.setCellValueFactory(new PropertyValueFactory<modenseig, Integer>("idEnseig"));
    colidMod.setCellValueFactory(new PropertyValueFactory<modenseig, Integer>("idMod"));
    
    tvmodenseig.setItems(list);
    }
    private void insertRecord(){
    String query = "INSERT INTO Modenseig VALUES (" + tfId.getText() + "," + tfEnseignant.getText() + "," + tfModule.getText() + ")";
    executeQuery(query);
    showmodenseig();
    }
    
    private void updateRecord(){
    String query = " UPDATE Modenseig SET idEnseig = " + tfEnseignant.getText() + ", idMod = " + tfModule.getText() + " WHERE id = " + tfId.getText() +"";
    executeQuery(query);
    showmodenseig();
    }
    
    private void deleteButton(){
    String query = "DELETE FROM Modenseig WHERE id = " + tfId.getText() + "";
    executeQuery(query);
    showmodenseig();
    }

    private void executeQuery(String query) {
         Connection conn = getConnection();
         Statement st;
         try{
         st = conn.createStatement();
         st.executeUpdate(query);
         }catch(Exception ex){
         ex.printStackTrace();
         }
    }


    @FXML
    private void handleMouseAction(javafx.scene.input.MouseEvent event) {
        modenseig Modenseig = tvmodenseig.getSelectionModel().getSelectedItem();
tfId.setText("" +Modenseig.getId());
tfEnseignant.setText("" +Modenseig.getIdEnseig());
tfModule.setText("" +Modenseig.getIdMod());
    }
    }

    
    

