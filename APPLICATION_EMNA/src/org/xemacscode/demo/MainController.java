/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xemacscode.demo;

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
 * @author emna ketata
 */
public class MainController implements Initializable {
    
   
    @FXML
    private TextField tfid;
    @FXML
    private TextField tfcontenu;
    @FXML
    private TextField tfdateD;
    @FXML
    private TextField tfdateF;
    @FXML
    private TextField tfplaceDispo;
    @FXML
    private TextField tfidEnseig;
    @FXML
    private TextField tfemploi;
    @FXML
    private TableView<cours> tvCours;
    @FXML
    private TableColumn<cours, Integer> colid;
    @FXML
    private TableColumn<cours, String> colontenu;
    @FXML
    private TableColumn<cours, String> coldateD;
    @FXML
    private TableColumn<cours, String> coldateF;
    @FXML
    private TableColumn<cours, Integer> colplaceDispo;
    @FXML
    private TableColumn<cours, Integer> colidEnseig;
    @FXML
    private TableColumn<cours, Integer> colemploi;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource()== btnAjouter){
            insertRecord();
        }else if (event.getSource()== btnModifier) {
        updateRecord();
        }else if (event.getSource()== btnSupprimer){
        deleteButton();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showCours();
    }  
    
    public Connection getConnection(){
        Connection conn;
        try{
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/application_pidev","root","");
             return conn;
             
        } catch (Exception ex)
        {
            System.out.println("Error : " + ex.getMessage());
            return null;
        }
    }
    
    public ObservableList<cours> getCoursList(){
    ObservableList<cours> coursList = FXCollections.observableArrayList();
    Connection conn = getConnection();
    String Query = "SELECT * FROM cours ";
    Statement st;
    ResultSet rs;
    
    try{
        
        st= conn.createStatement();
        rs = st.executeQuery(Query);
        cours cours;
        while(rs.next())
        {
        cours = new cours(rs.getInt("id"),rs.getString("contenu"),rs.getString("dateD"),rs.getString("dateF"),rs.getInt("placeDispo"),rs.getInt("idEnseig"),rs.getInt("emploi"));
       coursList.add(cours);
        }
    } catch (Exception ex) {
    ex.printStackTrace();
    }
    return coursList;
    }
    
   public void showCours(){
       ObservableList<cours> list = getCoursList();
       
       colid.setCellValueFactory((new PropertyValueFactory <cours,Integer>("id") ));
       colontenu.setCellValueFactory((new PropertyValueFactory <cours,String>("contenu") ));
       coldateD.setCellValueFactory((new PropertyValueFactory <cours,String>("dateD") ));
       coldateF.setCellValueFactory((new PropertyValueFactory <cours,String>("dateF") ));
       colplaceDispo.setCellValueFactory((new PropertyValueFactory <cours,Integer>("placeDispo") ));
       colidEnseig.setCellValueFactory((new PropertyValueFactory <cours,Integer>("idEnseig") ));
       colemploi.setCellValueFactory((new PropertyValueFactory <cours,Integer>("emploi") ));
       
       tvCours.setItems(list);
   } 
   
   
   private void insertRecord(){
   String query ="INSERT INTO cours VALUES (" + tfid.getText()+ ",'" +  tfcontenu.getText()+"','"+  tfdateD.getText()+"','"+  tfdateF.getText()+"',"+  tfplaceDispo.getText()+"," + tfidEnseig.getText()+","+  tfemploi.getText() + ")";
   executeQuery(query);
   showCours();
   }
   
   private void updateRecord(){
   String query = "UPDATE cours SET contenu = ' " + tfcontenu.getText() + "', dateD = '" + tfdateD.getText() +"', dateF = ' " + tfdateF.getText() + "', placeDispo = " + tfplaceDispo.getText() + ", idEnseig = " + tfidEnseig.getText() + " , emploi = "+ tfemploi.getText() + " WHERE id = " + tfid.getText() + "";
   
       executeQuery(query);
       showCours();
   }
   
   private void deleteButton(){
   String query = "DELETE FROM cours WHERE id= " + tfid.getText()+"";
          executeQuery(query);
 showCours();
   }

    private void executeQuery(String query) {
Connection conn = getConnection();
Statement st;
try{
st = conn.createStatement();
st.executeUpdate(query);
} catch (Exception ex){
    ex.printStackTrace();
    }
    }
   

}
