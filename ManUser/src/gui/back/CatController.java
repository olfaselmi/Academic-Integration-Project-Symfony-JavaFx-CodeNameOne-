/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.back;

import Entite.Categorie;
import Entite.News;
import Service.ServiceCategorie;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Asus X550V
 */
public class CatController implements Initializable {

    @FXML
    private Button btnOverview;
    @FXML
    private Button btnOrders;
    @FXML
    private Button btnCustomers;
    @FXML
    private Button btnMenus;
    @FXML
    private Button btnPackages;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnSignout;
    @FXML
    private Button btnUser;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;
    @FXML
    private TableView<Categorie> Catview;
    @FXML
    private TableColumn<?, ?> cl_tit;
    ServiceCategorie cat = new ServiceCategorie();
    ObservableList<Categorie> oblist = FXCollections.observableArrayList();
    @FXML
    private TextField catt;
    @FXML
    private Button addbtn;
    @FXML
    private Button btndel;
    @FXML
    private TextField upcat;
    @FXML
    private Button upbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        init();
    }
    public void init()
    {
    try {
            oblist= (ObservableList<Categorie>) cat.affichecat() ;
            
            cl_tit.setCellValueFactory(new PropertyValueFactory<>("nomcat"));
            Catview.setItems(oblist);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserbController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleClicks(ActionEvent event) throws IOException {
       FXMLLoader fxml=new FXMLLoader(getClass().getResource("News.fxml"));
        Parent root=fxml.load();
        btnUser.getScene().setRoot(root);
    }

    @FXML
    private void user(ActionEvent event) throws IOException {
    FXMLLoader fxml=new FXMLLoader(getClass().getResource("Userb.fxml"));
        Parent root=fxml.load();
        btnUser.getScene().setRoot(root);
    }

    @FXML
    private void ajoutcat(ActionEvent event) throws IOException {
    
        try {
             Categorie u = new Categorie(catt.getText());
            cat.ajouter(u);
            init();
            clearAll();
        } catch (SQLException ex) {
            Logger.getLogger(CatController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    @FXML
    private void delete(ActionEvent event) throws SQLException {
     Categorie c=Catview.getSelectionModel().getSelectedItem();
        if (!c.equals(null)) 
        cat.delete(c.getNomcat());
        init();
    }

    @FXML
    private void update(ActionEvent event) throws SQLException {
        Categorie c=Catview.getSelectionModel().getSelectedItem();
        cat.update(c.getNomcat(),upcat.getText());
        
        init();
        clearAll();
    }
    
    private void clear(ActionEvent event) {
        clearAll();
    }
    private void clearAll(){
    
        catt.setText("");
        upcat.setText("");
    }
}
    

