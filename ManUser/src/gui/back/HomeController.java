/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.back;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Asus X550V
 */
public class HomeController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleClicks(ActionEvent event) throws IOException {
        FXMLLoader fxml=new FXMLLoader(getClass().getResource("News.fxml"));
        Parent root=fxml.load();
        btnUser.getScene().setRoot(root);
        NewsController rc=fxml.getController();
    }

    @FXML
    private void user(ActionEvent event) throws IOException {
    FXMLLoader fxml=new FXMLLoader(getClass().getResource("Userb.fxml"));
        Parent root=fxml.load();
        btnUser.getScene().setRoot(root);
        //HomeController rc=fxml.getController();
    }

   /* @FXML
    private void news(ActionEvent event) throws IOException {
    FXMLLoader fxml=new FXMLLoader(getClass().getResource("News.fxml"));
        Parent root=fxml.load();
        btnUser.getScene().setRoot(root);
        NewsController rc=fxml.getController();
    }*/
    
}
